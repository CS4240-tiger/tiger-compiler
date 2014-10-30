tree grammar tigerTreeWalker;

options {
	tokenVocab=tiger;
	ASTLabelType=CommonTree;
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
	Scope scope = null;
  
	public tigerTreeWalker(CommonTreeNodeStream nodes) {
		super(nodes);
	}
  
	public tigerTreeWalker(CommonTreeNodeStream nodes, Scope scope) {
		super(nodes);
		this.scope = scope;
	}
}

tiger_program
	:	type_declaration_list funct_declaration_list
	;
	
funct_declaration_list 
	:	funct_declaration+
	;

funct_declaration
	:	^(ID param_list block_list)
	|	^(MAIN_KEY block_list)
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
	|	^(ARRAY_KEY ^(AST_2D_ARRAY UNSIGNED_INTLIT UNSIGNED_INTLIT) base_type)
	|	^(ARRAY_KEY UNSIGNED_INTLIT base_type)
	;

type_id 
  :	base_type
	|	ID
	;

base_type
	:	INT_KEY
	|	FIXEDPT_KEY
	;

var_declaration 
	:	^(ASSIGN ^(COLON id_list type_id) unsigned_tail)
	|	^(COLON id_list type_id)
	;
	
unsigned_tail
	:	UNSIGNED_INTLIT
	|	fixedptlit
	;

id_list 
	:	^(AST_ID_LIST ID+)
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
	:	^(ASSIGN value expr_list)
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
	:	expr_op
	|	func_call 
	|	constval
	|	value
	|	^(AST_EXPR_PAREN expr)
	;
	
expr_op
	:	^(binop_p0 expr_end)
	;

expr_end
	:	constval expr
	|	func_call expr
	|	value expr
	|	^(AST_EXPR_PAREN expr) expr
	;

binop_p0:	(AND | OR | binop_p1);
binop_p1:	(EQ | NEQ | LESSER | GREATER | LESSEREQ | GREATEREQ | binop_p2);     
binop_p2:	(MINUS | PLUS | binop_p3);
binop_p3:	(MULT | DIV);
	
constval
	:	(fixedptlit) => fixedptlit
	|	intlit
	;

intlit :	MINUS? UNSIGNED_INTLIT;

fixedptlit
	:   MINUS? UNSIGNED_FIXEDPTLIT
	;
	
binary_operator
	:	(PLUS|MINUS|MULT|DIV|EQ|NEQ|LESSER|GREATER|LESSEREQ|GREATEREQ|AND|OR)
	;

expr_list
	:	^(AST_EXPR_LIST expr+)
	;

value
	:	(ID LBRACK index_expr RBRACK LBRACK) => ID LBRACK index_expr RBRACK LBRACK index_expr RBRACK
	|	(ID LBRACK) => ID LBRACK index_expr RBRACK
	|	ID
	;

index_expr
	:	^(index_oper intlit index_expr)
	|	intlit
	|	^(index_oper ID index_expr)
	|	ID
	;

index_oper
	:	(PLUS|MINUS|MULT)
	;
  
func_param_list
	: ^(AST_PARAM_LIST (expr+)?)
	;