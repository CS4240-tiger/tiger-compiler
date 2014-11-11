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
}

@members {
	// IR stuff
	private static final String OUTPUT_IR_FILENAME = "ir-output.tigir";
	private List<String> irOutput = new ArrayList<String>();
	private int currentTemporary = 0;
  
	public tigerTreeWalker(CommonTreeNodeStream nodes) {
		super(nodes);
	}
  
  	private String emitCurrentTemporary() {
  		return "t" + currentTemporary;
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
	:	^(ID param_list block_list)
	{
		irOutput.add(IRGenerator.funct_declaration($ID.text));
	}
	|	^(MAIN_KEY block_list)
	{
		irOutput.add(IRGenerator.funct_declaration($MAIN_KEY.text));
	}
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
 	:	^(AST_BLOCK declaration_statement stat_seq)
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
			irOutput.add(IRGenerator.declaration_statement(id, $unsigned_tail.stringVal));
		}
		
	}
	|	^(COLON id_list type_id)
	{
		for (String id : $id_list.idList) {
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
		irOutput.add("\n" + exprReturn.condLabel);
	}
	;

else_tail
	:	^(ELSE_KEY stat_seq)
	;

while_stat
	:	^(WHILE_KEY expr stat_seq)
	{
		BinaryExpression.EvalReturn exprReturn = $expr.binExpr.eval(currentTemporary);
		currentTemporary = exprReturn.nextUnusedTemp;
		irOutput.add(exprReturn.irGen);
		irOutput.add("\n" + exprReturn.condLabel);
	}
	;

for_stat
	:	^(FOR_KEY ^(TO_KEY ^(ASSIGN ID indexExpr1=index_expr) indexExpr2=index_expr) stat_seq)
	{
		BinaryExpression.EvalReturn exprReturn1 = $indexExpr1.binExpr.eval(currentTemporary);
		BinaryExpression.EvalReturn exprReturn2 = $indexExpr2.binExpr.eval(currentTemporary);
		currentTemporary = exprReturn1.nextUnusedTemp;
		irOutput.add(exprReturn1.irGen);
		// Condlabel is expected to be null because no conditional statement is expected here
		currentTemporary = exprReturn2.nextUnusedTemp;
		irOutput.add(exprReturn2.irGen);
	}
	;

assign_stat
	:	^(ASSIGN value assign_tail)
	;

assign_tail
	:	expr
	{
		BinaryExpression.EvalReturn exprReturn = $expr.binExpr.eval(currentTemporary);
		currentTemporary = exprReturn.nextUnusedTemp;
		irOutput.add(exprReturn.irGen);
		irOutput.add("\n" + exprReturn.condLabel);
	}
	|	func_call
	;

func_call
	:	^(AST_FUNC_CALL ID func_param_list)
	;
	
break_stat
	:	BREAK_KEY
	;
	
return_stat
	:	^(AST_RETURN_STAT RETURN_KEY expr)
	{
		BinaryExpression.EvalReturn exprReturn = $expr.binExpr.eval(currentTemporary);
		currentTemporary = exprReturn.nextUnusedTemp;
		irOutput.add(exprReturn.irGen);
		irOutput.add("\n" + exprReturn.condLabel);
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
	:	(MINUS) => MINUS UNSIGNED_INTLIT
	{
		$intStringVal = $MINUS.text + $UNSIGNED_INTLIT.text;
	}
	|	UNSIGNED_INTLIT
	{
		$intStringVal = $UNSIGNED_INTLIT.text;
	}
	;

fixedptlit returns [String fpStringVal]
	:	(MINUS) => MINUS UNSIGNED_FIXEDPTLIT
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
	:	(ID LBRACK index_expr RBRACK LBRACK) => ID LBRACK index_expr RBRACK LBRACK index_expr RBRACK
	|	(ID LBRACK) => ID LBRACK index_expr RBRACK
	|	ID
	{
		$strVal = $ID.text;
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
		List<BinaryExpression> paramList = new ArrayList<BinaryExpression>();
	}
	: ^(AST_PARAM_LIST ((expr {paramList.add($expr.binExpr);})+)?)
	;