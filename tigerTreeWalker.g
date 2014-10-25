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
	
funct_declaration_list returns [java.util.List<TigerNode> list] 
	:	funct_declaration+
	;

funct_declaration returns [TigerNode node]
	:	^(ID param_list block_list)
	|	^(MAIN_KEY block_list)
	;
	
ret_type 
	:	VOID_KEY
	|	type_id
	;

param_list returns [java.util.List<TigerNode> list]  
	:	^(AST_PARAM_LIST (param+)?)
	;

param returns [TigerNode node] 	
	:	^(COLON ID type_id)
	;

block_list returns [java.util.List<TigerNode> list]  
	:	block+
	;

block returns [TigerNode node] 	
 	:	^(AST_BLOCK declaration_statement stat_seq)
	;

declaration_statement 
	:	type_declaration_list var_declaration_list
	;
	
type_declaration_list returns [java.util.List<TigerNode> list] 
	:	 type_declaration*
	;
	
var_declaration_list returns [java.util.List<TigerNode> list] 
	:	var_declaration*
	;

type_declaration returns [TigerNode node] 
	:	^(EQ ID type)
	;
	
type returns [TigerNode node]
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

var_declaration returns [TigerNode node] 
	:	^(ASSIGN ^(COLON id_list type_id) expr)
	|	^(COLON id_list type_id)
	;


id_list returns [java.util.List<String> list] 
	:	^(AST_ID_LIST ID+)
	;

stat_seq returns [java.util.List<TigerNode> list]
	:	stat+
	;

stat
	: if_stat
	| while_stat
	| for_stat
  | (value ASSIGN) => assign_stat // assign_stat conflicts with func_call
  | func_call SEMI
	| break_stat
	| return_stat
	| block
	;

if_stat	returns [TigerNode node]
	:	(IF_KEY expr stat_seq ELSE_KEY stat_seq) => ^(IF_KEY expr stat_seq ^(ELSE_KEY stat_seq))
	|	^(IF_KEY expr stat_seq)
	;

while_stat returns [TigerNode node]
	:	^(WHILE_KEY expr stat_seq)
	;

for_stat returns [TigerNode node]
	:	^(FOR_KEY ^(TO_KEY ^(ASSIGN ID index_expr) index_expr) stat_seq)
	;

assign_stat returns [TigerNode node]
	:	^(ASSIGN value expr_list)
	;

func_call returns [TigerNode node]
	:	^(AST_FUNC_CALL ID func_param_list)
	;
	
break_stat returns [TigerNode node]
	:	BREAK_KEY
	;
	
return_stat returns [TigerNode node]
	:	^(AST_RETURN_STAT RETURN_KEY expr)
	;

	
expr returns [TigerNode node]
	:	^(binop_p0 constval expr)
	|	constval
	|	^(binop_p0 func_call expr)
	|	^(binop_p0 value expr)
	|	value
	|	^(binop_p0 ^(AST_EXPR_PAREN expr) ^(AST_EXPR_PAREN expr))
	|	^(AST_EXPR_PAREN expr)
	;

binop_p0:	(AND | OR | binop_p1);
binop_p1:	(EQ | NEQ | LESSER | GREATER | LESSEREQ | GREATEREQ | binop_p2);     
binop_p2:	(MINUS | PLUS | binop_p3);
binop_p3:	(MULT | DIV);
	
constval returns [TigerNode node]
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

expr_list returns [java.util.List<TigerNode> list]
	:	^(AST_EXPR_LIST expr+)
	;

value returns [TigerNode node]
	:	(ID LBRACK index_expr RBRACK LBRACK) => ID LBRACK index_expr RBRACK LBRACK index_expr RBRACK
	|	(ID LBRACK) => ID LBRACK index_expr RBRACK
	|	ID
	;

index_expr returns [TigerNode node]
	:	^(index_oper intlit index_expr)
	|	intlit
	|	^(index_oper ID index_expr)
	|	ID
	;

index_oper
	:	(PLUS|MINUS|MULT)
	;
  
func_param_list returns [java.util.List<TigerNode> list]
	: ^(AST_PARAM_LIST (expr+)?)
	;