lexer grammar tiger;

TIGER_PROGRAM
	:	TYPE_DECLARATION_LIST FUNCT_DECLARATION_LIST MAIN_FUNCTION
	;
	
FUNCT_DECLARATION_LIST
	:	
	|	FUNCT_DECLARATION FUNCT_DECLARATION_LIST
	;

FUNCT_DECLARATION
	:	RET_TYPE FUNCTION_KEY ID LPAREN PARAM_LIST RPAREN BEGIN_KEY BLOCK_LIST END_KEY SEMI
	;

MAIN_FUNCTION 
	:	VOID_KEY MAIN_KEY LPAREN RPAREN BEGIN_KEY BLOCK_LIST END_KEY SEMI
	;

RET_TYPE 
	:	VOID_KEY
	|	TYPE_ID
	;

PARAM_LIST 
	:	
	|	PARAM PARAM_LIST_TAIL
	;

PARAM_LIST_TAIL 
	:	
	|	COMMA PARAM PARAM_LIST_TAIL
	;

PARAM 	:	ID COLON TYPE_ID;

BLOCK_LIST 
	:	BLOCK BLOCK_TAIL
	;

BLOCK_TAIL 
	:	BLOCK BLOCK_TAIL
	|	
	;

BLOCK 	:	BEGIN_KEY DECLARATION_SEGMENT STAT_SEQ END_KEY SEMI;

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
	:	TYPE_KEY ID EQ TYPE SEMI
	;
	
TYPE	:	BASE_TYPE
	|	ARRAY_KEY LBRACK INTLIT RBRACK OF_KEY BASE_TYPE
	|	ARRAY_KEY LBRACK INTLIT RBRACK LBRACK INTLIT RBRACK OF_KEY BASE_TYPE
	;

TYPE_ID :	BASE_TYPE
	|	ID
	;

BASE_TYPE
	:	INT_KEY
	|	FIXEDPT_KEY
	;

VAR_DECLARATION 
	:	VAR_KEY ID_LIST COLON TYPE_ID OPTIONAL_INIT SEMI
	;

ID_LIST :	ID
	|	ID COMMA ID_LIST
	;

OPTIONAL_INIT 
	:	  
	| 	ASSIGN CONST
	;

STAT_SEQ 
	:	STAT STAT_SEQ*
	;

STAT 
	: IF_KEY EXPR THEN_KEY STAT_SEQ (ENDIF_KEY SEMI|ELSE_KEY STAT_SEQ ENDIF_KEY SEMI)
	| WHILE_KEY EXPR DO_KEY STAT_SEQ ENDDO_KEY SEMI
	| FOR_KEY ID ASSIGN INDEX_EXPR TO_KEY INDEX_EXPR DO_KEY STAT_SEQ ENDDO_KEY SEMI
	| OPT_PREFIX LPAREN EXPR_LIST RPAREN SEMI
	| BREAK_KEY SEMI
	| RETURN_KEY EXPR SEMI
	| BLOCK_LIST SEMI
	;

OPT_PREFIX 
	:	VALUE ASSIGN
	|	
	;
		
EXPR 	:	((CONST | VALUE | FACT_EXPR) BINARY_OPERATOR?)* // Token alt 25
	;
	
FACT_EXPR
	:	LPAREN (CONST | VALUE) (BINARY_OPERATOR (CONST | VALUE))* RPAREN
	;
	
CONST 	:	INTLIT
	|	FIXEDPTLIT
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
	|	(EXPR COMMA?)*
	;

VALUE 	:	ID VALUE_TAIL;
VALUE_TAIL 
	:	LBRACK INDEX_EXPR RBRACK (LBRACK INDEX_EXPR RBRACK)?
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
