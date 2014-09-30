grammar tiger;

tiger_program
	:	TYPE_DECLARATION_LIST FUNCT_DECLARATION_LIST MAIN_FUNCTION
	;
	
funct_declaration_list
	:	
	|	FUNCT_DECLARATION FUNCT_DECLARATION_LIST
	;

funct_declaration
	:	RET_TYPE FUNCTION_KEY ID LPAREN PARAM_LIST RPAREN BEGIN_KEY BLOCK_LIST END_KEY SEMI
	;

main_function 
	:	VOID_KEY MAIN_KEY LPAREN RPAREN BEGIN_KEY BLOCK_LIST END_KEY SEMI
	;

ret_type 
	:	VOID_KEY
	|	TYPE_ID
	;

param_list 
	:	
	|	PARAM PARAM_LIST_TAIL
	;

param_list_tail 
	:	
	|	COMMA PARAM PARAM_LIST_TAIL
	;

param 	:	ID COLON TYPE_ID;

block_list 
	:	BLOCK BLOCK_TAIL
	;

block_tail 
	:	BLOCK BLOCK_TAIL
	|	
	;

block 	:	BEGIN_KEY DECLARATION_SEGMENT STAT_SEQ END_KEY SEMI;

declaration_statement 
	:	TYPE_DECLARATION_LIST VAR_DECLARATION_LIST
	;
	
type_declaration_list 
	:	
	|	TYPE_DECLARATION TYPE_DECLARATION_LIST
	;
	
var_declaration_list 
	:	
	|	VAR_DECLARATION VAR_DECLARATION_LIST
	;

type_declaration 
	:	TYPE_KEY ID EQ TYPE SEMI
	;
	
type	:	BASE_TYPE
	|	ARRAY_KEY LBRACK INTLIT RBRACK OF_KEY BASE_TYPE
	|	ARRAY_KEY LBRACK INTLIT RBRACK LBRACK INTLIT RBRACK OF_KEY BASE_TYPE
	;

type_id :	BASE_TYPE
	|	ID
	;

base_type
	:	INT_KEY
	|	FIXEDPT_KEY
	;

var_declaration 
	:	VAR_KEY ID_LIST COLON TYPE_ID OPTIONAL_INIT SEMI
	;

id_list :	ID
	|	ID COMMA ID_LIST
	;

optional_init 
	:	  
	| 	ASSIGN CONST
	;

stat_seq 
	:	STAT STAT_SEQ*
	;

stat 
	: IF_KEY EXPR THEN_KEY STAT_SEQ (ENDIF_KEY SEMI|ELSE_KEY STAT_SEQ ENDIF_KEY SEMI)
	| WHILE_KEY EXPR DO_KEY STAT_SEQ ENDDO_KEY SEMI
	| FOR_KEY ID ASSIGN INDEX_EXPR TO_KEY INDEX_EXPR DO_KEY STAT_SEQ ENDDO_KEY SEMI
	| OPT_PREFIX ID LPAREN EXPR_LIST RPAREN SEMI
	| BREAK_KEY SEMI
	| RETURN_KEY EXPR SEMI
	| BLOCK_LIST SEMI
	;

opt_prefix 
	:	VALUE ASSIGN
	|	
	;
		
expr 	:	(CONST | VALUE | LPAREN EXPR RPAREN) (BINARY_OPERATOR EXPR)* // Token alt 25
	;
	
const 	:	INTLIT
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
	:	
	|	EXPR EXPR_LIST_TAIL
	;

expr_list_tail
	:	COMMA EXPR EXPR_LIST_TAIL
	|	
	;

value 	:	ID VALUE_TAIL;
value_tail 
	:	LBRACK INDEX_EXPR RBRACK (LBRACK INDEX_EXPR RBRACK)?
	|	 
	;

index_expr 
	:	(INTLIT | ID) (INDEX_OPER INDEX_EXPR)*
	;

index_oper 
	:	(PLUS|MINUS|MULT)
	;
COMMENT
    :	   '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;}
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
	| DO_KEY
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

ID  :	('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'0'..'9'|'_')*
    ;
