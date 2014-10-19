tree grammar tigerTreeWalker;

options {
	tokenVocab=tiger;
	ASTLabelType=CommonTree;
}

@header {
	import java.util.Map;
	import java.util.HashMap;
}

@members {
	public Map<String, TigerFunction> functions = null;
	Scope scope = null;
  
	public tigerTreeWalker(CommonTreeNodeStream nodes, Map<String, TigerFunction> functions) {
		this(nodes, new Scope(), functions);
	}
  
	public tigerTreeWalker(CommonTreeNodeStream nodes, Scope scope, Map<String, TigerFunction> functions) {
		super(nodes);
		this.scope = scope;
		this.functions = functions;
	}
}

tiger_program returns [TigerNode node]
	:	type_declaration_list funct_declaration_list
	;
	
funct_declaration_list returns [java.util.List<String> list] 
	:	funct_declaration*
	;
	
funct_declaration returns [TigerNode node]
	:	(ret_type (FUNCTION_KEY ID | MAIN_KEY)) LPAREN param_list RPAREN BEGIN_KEY block_list END_KEY SEMI
	;

ret_type 
	:	VOID_KEY
	|	type_id
	;

param_list returns [java.util.List<String> list] 
	:	(param (COMMA param)*)?
	;

param returns [TigerNode node] 	
	:	ID COLON type_id
	;

block_list returns [java.util.List<String> list] 
	:	block+
	;

block returns [TigerNode node] 	
	:	BEGIN_KEY declaration_statement stat_seq END_KEY SEMI;

declaration_statement 
	:	type_declaration_list var_declaration_list
	;
	
type_declaration_list returns [java.util.List<String> list]  
	:	 type_declaration*
	;
	
var_declaration_list returns [java.util.List<String> list]  
	:	var_declaration*
	;

type_declaration returns [TigerNode node]  
	:	TYPE_KEY ID EQ type SEMI
	;
	
type	:	base_type
	|	ARRAY_KEY LBRACK INTLIT RBRACK (LBRACK INTLIT RBRACK)? OF_KEY base_type
	;

type_id :	base_type
	|	ID
	;

base_type
	:	INT_KEY
	|	FIXEDPT_KEY
	;

var_declaration returns [TigerNode node]  
	:	VAR_KEY id_list COLON type_id optional_init SEMI
	;

id_list returns [java.util.List<String> list] 
	:	ID (COMMA id_list)?
	;

optional_init 
	:	(ASSIGN expr)?
	;

stat_seq returns [java.util.List<String> list] 
	:	stat+
	;

stat returns [TigerNode node] 
	: IF_KEY expr THEN_KEY stat_seq (ENDIF_KEY SEMI|ELSE_KEY stat_seq ENDIF_KEY SEMI)
	| WHILE_KEY expr DO_KEY stat_seq ENDDO_KEY SEMI
	| FOR_KEY ID ASSIGN index_expr TO_KEY index_expr DO_KEY stat_seq ENDDO_KEY SEMI
  	| ID ((value_tail ASSIGN expr_list) | (func_call_tail)) SEMI
	| BREAK_KEY SEMI
	| RETURN_KEY expr SEMI
	| block
	;
		
expr returns [TigerNode node] 	
	:	(constval | ID (value_tail | func_call_tail) | LPAREN expr RPAREN) (binop_p0 expr)?
	;
	
binop_p0:	(AND | OR | binop_p1);
binop_p1:	(EQ | NEQ | LESSER | GREATER | LESSEREQ | GREATEREQ | binop_p2);     
binop_p2:	(MINUS | PLUS | binop_p3);
binop_p3:	(MULT | DIV);
	
constval:	INTLIT
	|	FIXEDPTLIT
	;

binary_operator
	:	(PLUS|MINUS|MULT|DIV|EQ|NEQ|LESSER|GREATER|LESSEREQ|GREATEREQ|AND|OR)
	;

expr_list returns [java.util.List<String> list] 
	:	expr (COMMA expr)*
	;

value 	:	ID value_tail;
value_tail 
	:	(LBRACK index_expr RBRACK (LBRACK index_expr RBRACK)?)?
	;

index_expr returns [TigerNode node]
	:	(INTLIT | ID) (index_oper index_expr)?
	;

index_oper
	:	(PLUS|MINUS|MULT)
	;

func_call_tail
  : LPAREN func_param_list RPAREN
  ;
  
func_param_list returns [java.util.List<String> list] 
  : (expr (COMMA expr)*)?
  ;