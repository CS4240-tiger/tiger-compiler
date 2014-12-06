tree grammar tigerTreeWalker;

options {
	backtrack = no;
	tokenVocab = tiger;
	ASTLabelType = CommonTree;
	output = AST;
}

tokens {
	AST_BLOCK;
	AST_PARAM_LIST;
	AST_RETURN_STAT;
	AST_FUNC_CALL;
	AST_ID_LIST;
	AST_EXPR_LIST;
	AST_EXPR_PAREN;
	AST_2D_ARRAY;
	AST_CONDITIONAL;
}

@header {
	import java.util.Map;
	import java.util.HashMap;
	import java.util.Stack;
}

@members {
	// IR stuff
	private static final String OUTPUT_IR_FILENAME = "ir-output.tigir";
	private List<String> irOutput = new ArrayList<String>();
	private List<String> IR_RESERVED_WORDS = new ArrayList<String>();
	private Stack<String> localVars = new Stack<String>();
	private int currentTemporary = 0;
  	private SymbolTable symTable;
  	private int loopNestNum = 0;
  	private Object passThrough;
  	private String passThroughLabel, passThroughTemporary;
  	private int currentIRindex = 0;
  	
	public tigerTreeWalker(TreeNodeStream input, SymbolTable symTable) {
		this(input);
		this.symTable = symTable;
		IR_RESERVED_WORDS.add("add");
		IR_RESERVED_WORDS.add("and");
		IR_RESERVED_WORDS.add("array_store");
		IR_RESERVED_WORDS.add("assign");
		IR_RESERVED_WORDS.add("breq");
		IR_RESERVED_WORDS.add("brgeq");
		IR_RESERVED_WORDS.add("brgt");
		IR_RESERVED_WORDS.add("brleq");
		IR_RESERVED_WORDS.add("brlt");
		IR_RESERVED_WORDS.add("brneq");
		IR_RESERVED_WORDS.add("call");
		IR_RESERVED_WORDS.add("callr");
		IR_RESERVED_WORDS.add("div");
		IR_RESERVED_WORDS.add("goto");
		IR_RESERVED_WORDS.add("mult");
		IR_RESERVED_WORDS.add("or");
		IR_RESERVED_WORDS.add("return");
		IR_RESERVED_WORDS.add("sub");
	}
  
  	private String emitCurrentTemporary() {
  		return "t" + currentTemporary;
  	}
  	
  	/* Thanks StackOverflow */
  	private String glue(String[] s, String glue) {
	  int k = s.length;
	  if (k == 0) {
	    return null;
	  }
	  StringBuilder out = new StringBuilder();
	  out.append(s[0]);
	  for (int x = 1; x < k; ++x) {
	    out.append(glue).append(s[x]);
	  }
	  return out.toString();
	}
}

tiger_program
	:	type_declaration_list funct_declaration_list
	{
		if (IRGenerator.writeIRToFile(OUTPUT_IR_FILENAME, irOutput)) {
			System.out.println("IR written to " + OUTPUT_IR_FILENAME + "!");
		} else {
			System.out.println("IR write failed!");
		}
	}
	;
	
funct_declaration_list 
	:	funct_declaration+
	;

funct_declaration
	:	^(ID {
			irOutput.add(IRGenerator.funct_declaration($ID.text));
		} param_list block_list)
	
		
	|	^(MAIN_KEY {
			irOutput.add(IRGenerator.funct_declaration($MAIN_KEY.text));
		} block_list)
	;
	
ret_type 
	:	VOID_KEY
	|	type_id
	;

param_list  
	:	^(AST_PARAM_LIST (param+)?)
	;

param 	
	:	^(COLON ID type_id)
	;

block_list  
	:	block+
	;

block 	
 	:	^(AST_BLOCK {currentIRindex = irOutput.size() - 1; } declaration_statement stat_seq)
 	{
 	 while (!localVars.isEmpty()) {
 	   String var = localVars.pop();
 	    if (!var.matches("[t][0-9]+")) {
      // Assign it a temporary, then replace all instances of that value in scope with temporary
      for (int lineIndex = currentIRindex; lineIndex < irOutput.size(); lineIndex++) {
        // Split into components
        String[] tempIRcomponents = irOutput.get(lineIndex).split(" ");
        for (int compIndex = 0; compIndex < tempIRcomponents.length; compIndex++) {
          if (!IR_RESERVED_WORDS.contains(tempIRcomponents[compIndex].replace(",", ""))) {
            tempIRcomponents[compIndex] = tempIRcomponents[compIndex].replace(var, emitCurrentTemporary());
          } 
        
        irOutput.set(lineIndex, glue(tempIRcomponents, " "));
       }
      }
     }
     
     currentTemporary++;
    }
   }
	;

declaration_statement 
	:	type_declaration_list var_declaration_list
	;
	
type_declaration_list 
	:	 type_declaration*
	;
	
var_declaration_list 
	:	var_declaration*
	;

type_declaration 
	:	^(EQ ID type)
	;
	
type
	:	base_type
	|	^(ARRAY_KEY ^(AST_2D_ARRAY UNSIGNED_INTLIT UNSIGNED_INTLIT) type_id)
	|	^(ARRAY_KEY UNSIGNED_INTLIT type_id)
	;

type_id returns [String typeString]
  	:	base_type {$typeString = $base_type.retString;}
	|	ID {$typeString = $ID.text;}
	;

base_type returns [String retString]
	:	INT_KEY {$retString = $INT_KEY.text;}
	|	FIXEDPT_KEY {$retString = $FIXEDPT_KEY.text;}
	;

var_declaration 
	:	^(ASSIGN ^(COLON id_list type_id) (unsigned_tail))
	{	
		for (String id : $id_list.idList) {
			localVars.push(id);
			irOutput.add(IRGenerator.declaration_statement(id, $unsigned_tail.stringVal));
		}
		
	}
	|	^(COLON id_list type_id)
	{
		for (String id : $id_list.idList) {
			localVars.push(id);
			irOutput.add(IRGenerator.declaration_statement(id, "0"));
		}
	}
	;
	
unsigned_tail returns [String stringVal]
	:	UNSIGNED_INTLIT
	{
		$stringVal = $UNSIGNED_INTLIT.text;
	}
	|	fixedptlit
	{
		$stringVal = $fixedptlit.fpStringVal;
	}
	;

id_list returns [List<String> idList]
	@init {
		$idList = new ArrayList<String>();
	}
	:	^(AST_ID_LIST (ID {$idList.add($ID.text);})+)
	;

stat_seq
	:	stat+
	;

stat
	: if_stat
	| while_stat
	| for_stat
  	| assign_stat
  	| func_call
	| break_stat
	| return_stat
	| block
	;

if_stat
	:	^(IF_KEY expr stat_seq else_tail?)
	{
		BinaryExpression.EvalReturn exprReturn = $expr.binExpr.eval(currentTemporary);
		currentTemporary = exprReturn.nextUnusedTemp;
		irOutput.add(exprReturn.irGen);
		irOutput.add(IRGenerator.emitLabel(exprReturn.condLabel));
	}
	;

else_tail
	:	^(ELSE_KEY stat_seq)
	;

while_stat returns [String breakLabel]
	@after {
		// Emit goto label to go back to top for checking
		irOutput.add(IRMap.gotoLabel(passThroughLabel));
		
		// Emit end label
		irOutput.add(IRGenerator.emitLabel(((BinaryExpression.EvalReturn) passThrough).condLabel));
		
		// Now check for break statements
		for (int line = 0; line < irOutput.size(); line++) {
			if (irOutput.get(line).contains("BREAK_LABEL_" + loopNestNum)) {
				irOutput.set(line, irOutput.get(line).replace("BREAK_LABEL_" + loopNestNum, 
					((BinaryExpression.EvalReturn) passThrough).condLabel));
				loopNestNum--;
				break;
			}
		}
	}
	:	^(WHILE_KEY expr {
			// Create an anchor to loop start
			passThroughLabel = IRGenerator.generateCondLabel($expr.binExpr);
			irOutput.add(IRGenerator.emitLabel(passThroughLabel));
			
			BinaryExpression.EvalReturn exprReturn = $expr.binExpr.eval(currentTemporary);
			currentTemporary = exprReturn.nextUnusedTemp;
			
			irOutput.add(exprReturn.irGen);
			passThrough = exprReturn;
			
			} stat_seq)
	;

for_stat returns [String breakLabel]
	@after {
		// Emit goto label to go back to top for checking
		irOutput.add(IRMap.gotoLabel(passThroughLabel));
		
		// Emit end label
		irOutput.add(IRGenerator.emitLabel(((BinaryExpression.EvalReturn) passThrough).condLabel));
		
		// Now check for break statements
		for (int line = 0; line < irOutput.size(); line++) {
			if (irOutput.get(line).contains("BREAK_LABEL_" + loopNestNum)) {
				irOutput.set(line, irOutput.get(line).replace("BREAK_LABEL_" + loopNestNum, 
					((BinaryExpression.EvalReturn) passThrough).condLabel));
				loopNestNum--;
				break;
			}
		}
	}
	:	^(FOR_KEY ^(TO_KEY ^(ASSIGN ID indexExpr1=index_expr) indexExpr2=index_expr) {
			BinaryExpression.EvalReturn exprReturn1 = $indexExpr1.binExpr.eval(currentTemporary);
			currentTemporary = exprReturn1.nextUnusedTemp;
			BinaryExpression.EvalReturn exprReturn2 = $indexExpr2.binExpr.eval(currentTemporary);
			currentTemporary = exprReturn2.nextUnusedTemp;
			
			irOutput.add(exprReturn1.irGen);
			irOutput.add(exprReturn2.irGen);
			
			passThrough = exprReturn1;
			passThroughTemporary = "t" + String.valueOf((exprReturn1.nextUnusedTemp - 1));
			
			// Create an anchor to loop start
			passThroughLabel = IRGenerator.generateCondLabel($indexExpr1.binExpr);
			irOutput.add(IRGenerator.emitLabel(passThroughLabel));
			
			// Generate expr to jump to end if not equal
			irOutput.add(IRMap.brneq(passThroughTemporary, "t" + String.valueOf((exprReturn2.nextUnusedTemp - 1)), exprReturn1.condLabel));
			
		} stat_seq {
			// Generate expr to increment expression by 1 at end
			BinaryExpression.EvalReturn incrementExpr = new BinaryExpression(
				new BinaryExpression(passThroughTemporary), 
				new BinaryExpression("1"), Binop.PLUS).eval(currentTemporary);
			currentTemporary = incrementExpr.nextUnusedTemp;
			irOutput.add(incrementExpr.irGen);
			// And reassign it back to original temp at end
			irOutput.add(IRMap.assign("t" + String.valueOf(((BinaryExpression.EvalReturn) passThrough).nextUnusedTemp - 1), "t" + String.valueOf((incrementExpr.nextUnusedTemp - 1))));
		} )
	;

assign_stat
	:	^(ASSIGN value assign_tail)
	{
		irOutput.add(IRGenerator.assign_stat($value.strVal, $assign_tail.temp));
		localVars.push($value.strVal);
	}
	;

assign_tail returns [String temp]
	:	expr
	{
		BinaryExpression.EvalReturn exprReturn = $expr.binExpr.eval(currentTemporary);
		currentTemporary = exprReturn.nextUnusedTemp;
		irOutput.add(exprReturn.irGen);
		$temp = "t" + (currentTemporary - 1);
	}
	|	func_call
	{
		$temp = $func_call.tempTarget;
	}
	;

func_call returns [String tempTarget]
	:	^(AST_FUNC_CALL ID func_param_list)
	{
		// *NOT* assuming this function is safe in case Tiger programmer does something strange
		FunctionSymbolTableEntry func = null;
		if (symTable.get($ID.text, new Scope()) != null 
			&& symTable.get($ID.text, new Scope()) instanceof FunctionSymbolTableEntry) {
			func = (FunctionSymbolTableEntry) symTable.get($ID.text, new Scope());
		} else {
			System.out.println("ERROR: Reference to a function not found in symbol table!");
		}
		
		if (func != null) {
			if (func.getReturnType() != null) {
				$tempTarget = emitCurrentTemporary();
				currentTemporary++;
			}
			
			String[] paramList = new String[$func_param_list.paramList.size()];
			// Convert binExpr list to String list
			for (int i = 0; i < $func_param_list.paramList.size(); i++) {
				if ($func_param_list.paramList.get(i).isTerminal()) {
					// If it's a variable or value, just add it
					// Hopefully this is the case most of the time
					
					if ($func_param_list.paramList.get(i).value.matches("[0-9]+(.[0-9]+)?")) {
						// If value, assign it to temporary
						irOutput.add(IRGenerator.assign_stat(emitCurrentTemporary(), $func_param_list.paramList.get(i).value));
						paramList[i] = emitCurrentTemporary();
						currentTemporary++;
					} else {
						paramList[i] = $func_param_list.paramList.get(i).value;
					}
				} else {
					// Otherwise, we need to evaluate it and return the temporary
					BinaryExpression.EvalReturn returnPkg = $func_param_list.paramList.get(i).eval(currentTemporary);
					currentTemporary = returnPkg.nextUnusedTemp;
					irOutput.add(returnPkg.irGen);
					paramList[i] = "t" + (currentTemporary - 1);
				}
			}
			
			irOutput.add(IRGenerator.func_call(func, paramList, $tempTarget));
		}
	}
	;
	
break_stat
	:	BREAK_KEY
	{
		// We'll fill this in after loop, when we get condLabel
		irOutput.add(IRGenerator.break_stat("BREAK_LABEL_" + ++loopNestNum));
	}
	;
	
return_stat
	:	^(AST_RETURN_STAT RETURN_KEY expr)
	{
		BinaryExpression.EvalReturn exprReturn = $expr.binExpr.eval(currentTemporary);
		currentTemporary = exprReturn.nextUnusedTemp;
		irOutput.add(exprReturn.irGen);
		irOutput.add(IRMap.returnVal("t" + (currentTemporary - 1)));
	}
	;

expr returns [BinaryExpression binExpr]
  : (boolExpr) => boolExpr
  {
  	$binExpr = $boolExpr.binExpr;
  }
  | (numExpr) => numExpr
  {
  	$binExpr = $numExpr.binExpr;
  }
  | LPAREN! expr2=expr RPAREN!
  {
  	$binExpr = $expr2.binExpr;
  }
  ;
 
boolExpr returns [BinaryExpression binExpr]
  : ^(binop_p0 constval expr)
  {
  	$binExpr = new BinaryExpression(
  		new BinaryExpression($constval.retStr), 
  		$expr.binExpr, $binop_p0.op);
  }
  | ^(binop_p0 value expr)
  {
    	$binExpr = new BinaryExpression(
  		new BinaryExpression($value.strVal), 
  		$expr.binExpr, $binop_p0.op);
  }
  | LPAREN! expr1=expr {
  		$binExpr = $expr1.binExpr;
  	} 
  	
  	RPAREN! binop_p0^ expr2=expr {
    		// Need to shift onto current tree
		BinaryExpression current = $binExpr;
		while (!current.isTerminal()) {
			current = current.right;
		}
		
		// Now transform this terminal into non-terminal, 
		// with terminal value at left and new expression at right
		current.parent.right = new BinaryExpression(
			current,
			$expr2.binExpr, 
			$binop_p0.op);
  	}
  ;
 
numExpr returns [BinaryExpression binExpr]
  : ^(binop_p2 constval expr)
  {
  	$binExpr = new BinaryExpression(
  		new BinaryExpression($constval.retStr), 
  		$expr.binExpr, $binop_p2.op);
  }
  | constval
  {
  	$binExpr = new BinaryExpression($constval.retStr);
  }
  | ^(binop_p2 value expr)
  {
    	$binExpr = new BinaryExpression(
  		new BinaryExpression($value.strVal), 
  		$expr.binExpr, $binop_p2.op);
  }
  | value
  {
  	$binExpr = new BinaryExpression($value.strVal);
  }
  | LPAREN! expr1=expr {
  		$binExpr = $expr1.binExpr;
  	} 
  	
  	RPAREN! binop_p2^ expr2=expr {
    		// Need to shift onto current tree
		BinaryExpression current = $binExpr;
		while (!current.isTerminal()) {
			current = current.right;
		}
		
		// Now transform this terminal into non-terminal, 
		// with terminal value at left and new expression at right
		current.parent.right = new BinaryExpression(
			current,
			$expr2.binExpr, 
			$binop_p2.op);
  	}
  ;

// Conditional ops
binop_p0 returns [Binop op]
	: AND
	{
		$op = Binop.AND;
	} 
	| OR 
	{
		$op = Binop.OR;
	}
	| binop_p1
	{
		$op = $binop_p1.op;
	}
	;
binop_p1 returns [Binop op]
	: EQ 
	{
		$op = Binop.EQUAL;
	}
	| NEQ
	{
		$op = Binop.NOT_EQUAL;
	}
	| LESSER
	{
		$op = Binop.LESS_THAN;
	}
	| GREATER
	{
		$op = Binop.GREATER_THAN;
	}
	| LESSEREQ
	{
		$op = Binop.LESS_THAN_OR_EQUAL;
	}
	| GREATEREQ
	{
		$op = Binop.GREATER_THAN_OR_EQUAL;
	}
	;   
 
// Numerical ops
binop_p2 returns [Binop op]
	: MINUS 
	{
		$op = Binop.MINUS;
	}
	| PLUS 
	{
		$op = Binop.PLUS;
	}
	| binop_p3
	{
		$op = $binop_p3.op;
	}
	;
	
binop_p3 returns [Binop op]
	: MULT
	{
		$op = Binop.MULT;
	}
	| DIV
	{
		$op = Binop.DIV;
	}
	;
	
constval returns [String retStr]
	:	(fixedptlit) => fixedptlit
	{
		$retStr = $fixedptlit.fpStringVal;
	}
	|	intlit
	{
		$retStr = $intlit.intStringVal;
	}
	;

intlit returns [String intStringVal]
	:	MINUS UNSIGNED_INTLIT
	{
		$intStringVal = $MINUS.text + $UNSIGNED_INTLIT.text;
	}
	|	UNSIGNED_INTLIT
	{
		$intStringVal = $UNSIGNED_INTLIT.text;
	}
	;

fixedptlit returns [String fpStringVal]
	:	MINUS UNSIGNED_FIXEDPTLIT
	{
		$fpStringVal = $MINUS.text + $UNSIGNED_FIXEDPTLIT.text;
	}
	|	UNSIGNED_FIXEDPTLIT
	{
		$fpStringVal = $UNSIGNED_FIXEDPTLIT.text;
	}
	;
	
binary_operator returns [Binop op]
	:	PLUS {$op = Binop.PLUS;}
	|	MINUS {$op = Binop.MINUS;}
	|	MULT {$op = Binop.MULT;}
	|	DIV {$op = Binop.DIV;}
	|	EQ {$op = Binop.EQUAL;}
	|	NEQ {$op = Binop.NOT_EQUAL;}
	|	LESSER {$op = Binop.LESS_THAN;}
	|	GREATER {$op = Binop.GREATER_THAN;}
	|	LESSEREQ {$op = Binop.LESS_THAN_OR_EQUAL;}
	|	GREATEREQ {$op = Binop.GREATER_THAN_OR_EQUAL;}
	|	AND {$op = Binop.AND;}
	|	OR {$op = Binop.OR;}
	;

expr_list returns [List<BinaryExpression> binExprList]
	@init {
		List<BinaryExpression> binExprList = new ArrayList<BinaryExpression>();
	}
	:	^(AST_EXPR_LIST (expr {$binExprList.add($expr.binExpr);})+)
	;

value returns [String strVal]
	:	(ID value_array_index value_array_index) => ID arr1=value_array_index arr2=value_array_index
	{
		$strVal = $ID.text + $arr1.tempVarIndex + $arr2.tempVarIndex;
	}
	|	(ID value_array_index) => ID value_array_index
	{
		$strVal = $ID.text + $arr1.tempVarIndex;
	}
	|	ID
	{
		$strVal = $ID.text;
	}
	;

value_array_index returns [String tempVarIndex]
	: LBRACK index_expr RBRACK
	{
		BinaryExpression.EvalReturn exprReturn = $index_expr.binExpr.eval(currentTemporary);
		currentTemporary = exprReturn.nextUnusedTemp;
		irOutput.add(exprReturn.irGen);
		$tempVarIndex = $LBRACK.text + "t" + String.valueOf((currentTemporary - 1)) + $RBRACK.text;
	}
	;

index_expr returns [BinaryExpression binExpr]
	:	^(index_oper intlit expr2=index_expr)
	{
		$binExpr = new BinaryExpression(
			new BinaryExpression($intlit.intStringVal), 
			$expr2.binExpr,
			$index_oper.op);
	}
	|	intlit
	{
		$binExpr = new BinaryExpression($intlit.intStringVal);
	}
	|	^(index_oper ID index_expr)
	{
		$binExpr = new BinaryExpression(
			new BinaryExpression($ID.text), 
			$expr2.binExpr,
			$index_oper.op);
	}
	|	ID
	{
		$binExpr = new BinaryExpression($ID.text);
	}
	;

index_oper returns [Binop op]
	: PLUS {$op = Binop.PLUS;}
	| MINUS {$op = Binop.MINUS;}
	| MULT {$op = Binop.MULT;}
	;
  
func_param_list returns [List<BinaryExpression> paramList]
	@init {
		$paramList = new ArrayList<BinaryExpression>();
	}
	: ^(AST_PARAM_LIST ((expr {$paramList.add($expr.binExpr);})+)?)
	;