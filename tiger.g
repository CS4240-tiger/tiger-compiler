grammar tiger;

options {
    k = 1;
    backtrack = no;
  }
  
tiger_program
	:	type_declaration_list funct_declaration_list
	;
	
funct_declaration_list
	:	funct_declaration*
	;

funct_declaration
	:	((type_id funct_declaration_tail nonvoid_tail) | (VOID_KEY (funct_declaration_tail | main_function_tail)) void_tail)
	;

funct_declaration_tail
  	: 	FUNCTION_KEY ID LPAREN param_list RPAREN
  	;
  
nonvoid_tail
	:	 BEGIN_KEY block_list_return block_list END_KEY SEMI
	;	
	
void_tail
	:	BEGIN_KEY block_list END_KEY SEMI
	;

main_function_tail
	:	MAIN_KEY LPAREN RPAREN
	;

ret_type 
	:	VOID_KEY
	|	type_id
	;

param_list 
	:	(param (COMMA param)*)?
	;

param 	:	ID COLON type_id;

block_list 
	:	block*
	;

block_list_return
	:	BEGIN_KEY declaration_statement stat_seq return_stat stat_seq END_KEY SEMI;

block 	:	BEGIN_KEY declaration_statement stat_seq END_KEY SEMI;

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

var_declaration 
	:	VAR_KEY id_list COLON type_id optional_init SEMI
	;

id_list :	ID ((COMMA | COMMA_SPACE) id_list)?
	;

optional_init 
	:	  
	| 	ASSIGN constval
	;

stat_seq 
	:	stat*
	;

stat 
	: 	IF_KEY expr THEN_KEY stat_seq (ENDIF_KEY SEMI|ELSE_KEY stat_seq ENDIF_KEY SEMI)
	| 	WHILE_KEY expr DO_KEY stat_seq ENDDO_KEY SEMI
	| 	FOR_KEY ID ASSIGN index_expr TO_KEY index_expr DO_KEY stat_seq ENDDO_KEY SEMI
  	| 	ID ((value_tail ASSIGN expr_list) | (func_call_tail)) SEMI
	| 	BREAK_KEY SEMI
	| 	block
	;

return_stat
	:	RETURN_KEY expr SEMI;
		
expr 	:	(constval | ID (value_tail|func_call_tail) | LPAREN expr RPAREN) (binary_operator expr)? // Token alt 25
	;
	
constval:	INTLIT
	|	FIXEDPTLIT
	;

INTLIT :	'0'..'9'+;

FIXEDPTLIT
    :   INTLIT '.' ('0'..'9')* 
    |   '.' ('0'..'9')+
    ;

binary_operator
	:	(PLUS|MINUS|MULT|DIV|EQ|NEQ|LESSER|GREATER|LESSEREQ|GREATEREQ|AND|OR)
	;

expr_list // Token alt 31
	:	expr (COMMA expr)*
	;

value 	:	ID value_tail;
value_tail 
	:	LBRACK index_expr RBRACK (LBRACK index_expr RBRACK)?
	|	 
	;

index_expr 
	:	(INTLIT | ID) (index_oper index_expr)?
	;

index_oper
	:	(PLUS|MINUS|MULT)
	;
	
COMMENT
    :	   '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;}
    ;

func_call_tail
  : LPAREN func_param_list RPAREN
  ;
  
func_param_list
  : expr (COMMA_SPACE expr)*
  | 
  ;

// Keywords
keywords
	: FUNCTION_KEY
	| BEGIN_KEY
	| END_KEY
	| VOID_KEY
	| MAIN_KEY
	| TYPE_KEY
	| ARRAY_KEY
	| OF_KEY
	| INT_KEY
	| FIXEDPT_KEY
	| VAR_KEY
	| IF_KEY
	| THEN_KEY
	| ENDIF_KEY
	| ELSE_KEY
	| WHILE_KEY
	| DO_KEY
	| ENDDO_KEY
	| FOR_KEY
	| ID_KEY
	| TO_KEY
	| BREAK_KEY
	| RETURN_KEY
	;

FUNCTION_KEY
	: 'function'
	;

BEGIN_KEY
	: 'begin'
	;

END_KEY
	: 'end'
	;
	
VOID_KEY
	: 'void'
	;
	
MAIN_KEY
	: 'main'
	;
	
TYPE_KEY
	: 'type'
	;
	
ARRAY_KEY
	: 'array'
	;
	
OF_KEY
	: 'of'
	;
	
INT_KEY
	: 'int'
	;
	
FIXEDPT_KEY
	: 'fixedpt'
	;
	
VAR_KEY
	: 'var'
	;
	
IF_KEY
	: 'if'
	;
	
THEN_KEY
	: 'then'
	;
	
ENDIF_KEY
	: 'endif'
	;
	
ELSE_KEY
	: 'else'
	;
	
WHILE_KEY
	: 'while'
	;
	
ENDDO_KEY
	: 'enddo'
	;
	
FOR_KEY
	: 'for'
	;
	
ID_KEY
	: 'id'
	;
	
TO_KEY
	: 'to'
	;
	
DO_KEY
	: 'do'
	;
	
BREAK_KEY
	: 'break'
	;
	
RETURN_KEY
	: 'return'
	;

// Punctuaion symbols/binary operators
COMMA 	:	',';
COMMA_SPACE
  : ', ';
COLON 	:	':';
SEMI	:	';';
LPAREN	:	'(';
RPAREN	:	')';
LBRACK	:	'[';
RBRACK	:	']';
PLUS	:	'+';
MINUS	:	'-';
MULT	:	'*';
DIV	:	'/';
EQ	:	'=';
NEQ	:	'<>';
LESSER	:	'<';
LESSEREQ:	'<=';
GREATER	:	'>';
GREATEREQ 
	:	'>=';
AND	:	'&';
OR	:	'|';
ASSIGN	:	':=';

ID  :	('a'..'z'|'A'..'Z'|'_')('a'..'z'|'A'..'Z'|'0'..'9'|'_')*
    ;
