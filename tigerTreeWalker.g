tree grammar tigerTreeWalker;

options {
	tokenVocab=tiger;
	ASTLabelType=CommonTree;
	output=AST;
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
	;

else_tail
	:	^(ELSE_KEY stat_seq)
	;

while_stat
	:	^(WHILE_KEY expr stat_seq)
	;

for_stat
	:	^(FOR_KEY ^(TO_KEY ^(ASSIGN ID index_expr) index_expr) stat_seq)
	;

assign_stat
	:	^(ASSIGN value assign_tail)
	;

assign_tail
	:	expr | func_call
	;

func_call
	:	^(AST_FUNC_CALL ID func_param_list)
	;
	
break_stat
	:	BREAK_KEY
	;
	
return_stat
	:	^(AST_RETURN_STAT RETURN_KEY expr)
	;

expr
  : (boolExpr) => boolExpr
  | (numExpr) => numExpr
  | LPAREN expr RPAREN
  ;
 
boolExpr
  : ^(binop_p0 constval expr)
  | ^(binop_p0 value expr)
  | ^(binop_p0 expr+)
  ;
 
numExpr
  : ^(binop_p2 constval expr)
  | ^(binop_p2 value expr)
  | ^(binop_p2 expr+)
  ;

// Conditional ops
binop_p0:	(AND | OR | binop_p1);
binop_p1:	(EQ | NEQ | LESSER | GREATER | LESSEREQ | GREATEREQ);   
 
// Numerical ops
binop_p2:	(MINUS | PLUS | binop_p3);
binop_p3:	(MULT | DIV);
	
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
	
binary_operator
	:	(PLUS|MINUS|MULT|DIV|EQ|NEQ|LESSER|GREATER|LESSEREQ|GREATEREQ|AND|OR)
	;

expr_list
	:	^(AST_EXPR_LIST expr+)
	;

value returns [String strVal]
	:	(ID LBRACK index_expr RBRACK LBRACK) => ID LBRACK index_expr RBRACK LBRACK index_expr RBRACK
	|	(ID LBRACK) => ID LBRACK index_expr RBRACK
	|	ID
	{
		$strVal = $ID.text;
	}
	;

index_expr returns [String expr]
	:	^(index_oper intlit expr2=index_expr)
	{
		$expr += $intlit.text + $index_oper.text + $expr2.expr;
	}
	|	intlit
	{
		$expr += $intlit.text;
	}
	|	^(index_oper ID index_expr)
	{
		$expr += $ID.text + $index_oper.text + $expr2.expr;
	}
	|	ID
	{
		$expr += $ID.text;
	}
	;

index_oper
	:	(PLUS|MINUS|MULT)
	;
  
func_param_list returns [List<String> paramList]
	@init {
		List<String> paramList = new ArrayList<String>();
	}
	: ^(AST_PARAM_LIST ((expr {paramList.add($expr.expr);})+)?)
	;