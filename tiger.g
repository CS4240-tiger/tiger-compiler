grammar tiger;

options {
    k = 1;
    backtrack = no;
  }

@parser::members {
  @Override
    public void reportError(RecognitionException e) {
      displayRecognitionError(this.getTokenNames(), e);
  }
  @Override
    public void displayRecognitionError(String[] tokenNames, RecognitionException e) {
        //entire function
        String code = e.input.toString();
        //line index
        int lineIndex = e.line;
        //split into an array by lines
        String lines[] = code.split("\\r?\\n");
        //get the line of code with everything before the first charracter turned into spaces
        String lineCode = lines[lineIndex-1].replaceAll("\t", " ");
        //turned to char array
        if (e.charPositionInLine == 0) {
          lineCode = "' '" + lineCode;
        } else if (e.charPositionInLine == lineCode.length()) {
          lineCode = lineCode + "' '";
        } else {
          lineCode = lineCode.substring(0,e.charPositionInLine) + "'" + lineCode.charAt(e.charPositionInLine) + "'" + lineCode.substring(e.charPositionInLine+1,lineCode.length());
        }
        lineCode = lineCode.replaceFirst(".*?(?=[a-zA-Z0-9\'])", "");
        System.err.println("Error At Line "+String.valueOf(lineIndex)+": "+ lineCode + " ("+getErrorMessage(e, tokenNames)+")");
    }
}

@lexer::members {
  @Override
    public void reportError(RecognitionException e) {
      displayRecognitionError(this.getTokenNames(), e);
  }
  @Override
    public void displayRecognitionError(String[] tokenNames, RecognitionException e) {
      //entire function
        String code = e.input.toString();
        //line index
        int lineIndex = e.line;
        //split into an array by lines
        String lines[] = code.split("\\r?\\n");
        //get the line of code with everything before the first charracter turned into spaces
        String lineCode = lines[lineIndex-1].replaceAll("\t", " ");
        if (e.charPositionInLine == 0) {
          lineCode = "' '" + lineCode;
        } else if (e.charPositionInLine == lineCode.length()) {
          lineCode = lineCode + "' '";
        } else {
          lineCode = lineCode.substring(0,e.charPositionInLine) + "'" + lineCode.charAt(e.charPositionInLine) + "'" + lineCode.substring(e.charPositionInLine+1,lineCode.length());
        }
        lineCode = lineCode.replaceFirst(".*?(?=[a-zA-Z0-9\'])", "");
        System.err.println("Error At Line "+String.valueOf(lineIndex)+": "+ lineCode);
    }
}

tiger_program
	:	type_declaration_list funct_declaration_list
	;
	
funct_declaration_list
	:	funct_declaration*
	;

funct_declaration
	:	((type_id funct_declaration_tail) | (VOID_KEY (funct_declaration_tail | main_function_tail))) BEGIN_KEY block_list END_KEY SEMI
	;

funct_declaration_tail
  : FUNCTION_KEY ID LPAREN param_list RPAREN
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
	:	block block_tail
	;

block_tail 
	:	block block_tail
	|	
	;

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

id_list :	ID (COMMA id_list)?
	;

optional_init 
	:	  
	| 	ASSIGN expr
	;

stat_seq 
	:	stat*
	;

stat 
	: IF_KEY expr THEN_KEY stat_seq (ENDIF_KEY SEMI|ELSE_KEY stat_seq ENDIF_KEY SEMI)
	| WHILE_KEY expr DO_KEY stat_seq ENDDO_KEY SEMI
	| FOR_KEY ID ASSIGN index_expr TO_KEY index_expr DO_KEY stat_seq ENDDO_KEY SEMI
  	| ID ((value_tail ASSIGN expr_list) | (func_call_tail)) SEMI
	| BREAK_KEY SEMI
	| RETURN_KEY expr SEMI
	| block
	;
		
expr 	:	(constval | ID (value_tail | func_call_tail) | LPAREN expr RPAREN) (binop_p0 expr)? // Token alt 25
	;
	
binop_p0:	(AND | OR | binop_p1);
binop_p1:	(EQ | NEQ | LESSER | GREATER | LESSEREQ | GREATEREQ | binop_p2);     
binop_p2:	(MINUS | PLUS | binop_p3);
binop_p3:	(MULT | DIV);
	
constval:	INTLIT
	|	FIXEDPTLIT
	;

INTLIT :	MINUS? '0'..'9'+;

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
    
TAB	:	'\t' {$channel=HIDDEN;};
NEWLINE
	:	'\n' {$channel=HIDDEN;}
	;
CARRAGE_RET
	:	'\r' {$channel=HIDDEN;}
	;

WHITESPACE
	:	' ' {$channel=HIDDEN;}
	;

func_call_tail
  : LPAREN func_param_list RPAREN
  ;
  
func_param_list
  : expr (COMMA expr)*
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
