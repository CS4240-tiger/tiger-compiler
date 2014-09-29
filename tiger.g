lexer grammar tiger;

TIGER_PROGRAM
	:	TYPE_DECLARATION_LIST FUNCT_DECLARATION_LIST MAIN_FUNCTION
	;
	
FUNCT_DECLARATION_LIST
	:	
	|	FUNCT_DECLARATION FUNCT_DECLARATION_LIST
	;

FUNCT_DECLARATION
	:	RET_TYPE 'function' ID '('PARAM_LIST')' 'begin' BLOCK_LIST 'end;'
	;

MAIN_FUNCTION 
	:	'void main() begin' BLOCK_LIST 'end;'
	;

RET_TYPE 
	:	'void'
	|	TYPE_ID
	;

PARAM_LIST 
	:	
	|	PARAM PARAM_LIST_TAIL
	;

PARAM_LIST_TAIL 
	:	
	|	',' PARAM PARAM_LIST_TAIL
	;

PARAM 	:	ID ':' TYPE_ID;

BLOCK_LIST 
	:	BLOCK BLOCK_TAIL
	;

BLOCK_TAIL 
	:	BLOCK BLOCK_TAIL
	|	
	;

BLOCK 	:	'begin' DECLARATION_SEGMENT STAT_SEQ 'end;';

DECLARATION_SEGMENT 
	:	TYPE_DECLARATION_LIST VAR_DECLARATION_LIST
	;
	
TYPE_DECLARATION_LIST 
	:	
	|	TYPE_DECLARATION TYPE_DECLARATION_LIST
	;
	
VAR_DECLARATION_LIST 
	:	
	|	VAR_DECLARATION VAR_DECLARATION_LIST
	;

TYPE_DECLARATION 
	:	'type' ID '=' TYPE ';'
	;
	
TYPE	:	BASE_TYPE
	|	'array[' INTLIT '] of' BASE_TYPE
	|	'array[' INTLIT '][' INTLIT '] of' BASE_TYPE
	;

TYPE_ID :	BASE_TYPE
	|	ID
	;

BASE_TYPE
	:	'int'
	|	'fixedpt'
	;

VAR_DECLARATION 
	:	'var' ID_LIST ':' TYPE_ID OPTIONAL_INIT ';'
	;

ID_LIST :	ID
	|	ID ', ' ID_LIST
	;

OPTIONAL_INIT 
	:	  
	| 	':=' CONST
	;

STAT_SEQ 
	:	STAT STAT_SEQ*
	;

STAT 
	: 'if' EXPR 'then' STAT_SEQ ('endif;'|'else' STAT_SEQ 'endif;')
	| 'while' EXPR 'do' STAT_SEQ 'enddo;'
	| 'for' ID ':=' INDEX_EXPR 'to' INDEX_EXPR 'do' STAT_SEQ 'enddo;'
	| OPT_PREFIX ID '('EXPR_LIST');'
	| 'break;'
	| 'return' EXPR ';'
	| BLOCK_LIST ';'
	;

OPT_PREFIX 
	:	VALUE ':='
	|	
	;
		
EXPR 	:	(CONST | VALUE | '(' EXPR ')') (BINARY_OPERATOR EXPR)* // Token alt 25
	;
	
CONST 	:	INTLIT
	|	FIXEDPTLIT
	;
	
ID  :	('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'0'..'9'|'_')*
    ;

INTLIT :	'0'..'9'+;

FIXEDPTLIT
    :   INTLIT '.' ('0'..'9')* 
    |   '.' ('0'..'9')+
    ;

BINARY_OPERATOR 
	:	(PLUS|MINUS|MULT|DIV|EQ|NEQ|LESSER|GREATER|LESSEREQ|GREATEREQ|AND|OR)
	;

EXPR_LIST // Token alt 31
	:	
	|	EXPR EXPR_LIST_TAIL
	;

EXPR_LIST_TAIL
	:	',' EXPR EXPR_LIST_TAIL
	|	
	;

VALUE 	:	ID VALUE_TAIL;
VALUE_TAIL 
	:	'[' INDEX_EXPR ']'('[' INDEX_EXPR ']')?
	|	 
	;

INDEX_EXPR 
	:	(INTLIT | ID) (INDEX_OPER INDEX_EXPR)*
	;

INDEX_OPER 
	:	(PLUS|MINUS|MULT)
	;
COMMENT
    :	   '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;}
    ;

// Keywords
KEYWORDS
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

// Keywords
KEYWORDS
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
	
DO_KEY
	: 'do'
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
