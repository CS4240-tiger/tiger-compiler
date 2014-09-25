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

BLOCK 	:	'begin' DECLARATION_SEGMENT STATE_SEQ 'end;';

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
	:		
ID  :	('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'0'..'9'|'_')*
    ;

INT :	'0'..'9'+;

FLOAT
    :   ('0'..'9')+ '.' ('0'..'9')* 
    |   '.' ('0'..'9')+
    |   ('0'..'9')+
    ;

COMMENT
    :	   '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;}
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
