grammar tiger;

options {
	k = 1;
	backtrack = no;
	output = AST;
	ASTLabelType = CommonTree;
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

@parser::header {
	import java.util.Map;
	import java.util.HashMap;
	import org.antlr.runtime.tree.CommonTree;
}

@parser::members {
	public Map<String, TigerFunction> functions = new HashMap<String, TigerFunction>();
    
	@Override
	public void reportError(RecognitionException e) {
		displayRecognitionError(this.getTokenNames(), e);
	}
	
	@Override
	public void displayRecognitionError(String[] tokenNames, RecognitionException e) {
		/*
		 * Function code
		 */
		String code = e.input.toString();
		/*
		 * Line index
		 */
		int lineIndex = e.line;
		
		// Split into an array by lines
		String lines[] = code.split("\\r?\\n");
		
        // Get the line of code with everything before 
		// the first character turned into spaces
		String lineCode = lines[lineIndex-1].replaceAll("\t", " ");
        // Turn into char array
		if (e.charPositionInLine == 0) {
			lineCode = "' '" + lineCode;
		} else if (e.charPositionInLine == lineCode.length()) {
			lineCode = lineCode + "' '";
		} else {
			lineCode = lineCode.substring(0,e.charPositionInLine) 
			+ "'" + lineCode.charAt(e.charPositionInLine) 
			+ "'" + lineCode.substring(e.charPositionInLine + 1,lineCode.length());
		}
		lineCode = lineCode.replaceFirst(".*?(?=[a-zA-Z0-9\'])", "");
		System.err.println("Error at line " + String.valueOf(lineIndex) + ": " + lineCode + " ("+getErrorMessage(e, tokenNames)+")");
	}
    
	private void defineFunction(String id, Object params, Object block) {
		// Parameters
		CommonTree paramTree = params == null ? new CommonTree() : (CommonTree) params;

		// Code block tree
		CommonTree blockTree = (CommonTree) block;

		// The function name with the number of parameters after it, is the unique key
		String key = id + paramTree.getChildCount();
		functions.put(key, new TigerFunction(id, paramTree, blockTree));
	}
}

@lexer::members {
	@Override
	public void reportError(RecognitionException e) {
		displayRecognitionError(this.getTokenNames(), e);
	}
	
	@Override
	public void displayRecognitionError(String[] tokenNames, RecognitionException e) {
		/*
		 * Function code
		 */
		String code = e.input.toString();
		/*
		 * Line index
		 */
		int lineIndex = e.line;
		
        // Split into an array by lines
		String lines[] = code.split("\\r?\\n");
		
        // Get the line of code with everything before 
		// the first character turned into spaces
		String lineCode = lines[lineIndex-1].replaceAll("\t", " ");
        if (e.charPositionInLine == 0) {
			lineCode = "' '" + lineCode;
		} else if (e.charPositionInLine == lineCode.length()) {
			lineCode = lineCode + "' '";
		} else {
			lineCode = lineCode.substring(0,e.charPositionInLine) 
			+ "'" + lineCode.charAt(e.charPositionInLine) 
			+ "'" + lineCode.substring(e.charPositionInLine + 1,lineCode.length());
		}
		
		lineCode = lineCode.replaceFirst(".*?(?=[a-zA-Z0-9\'])", "");
		System.err.println("Error at line " + String.valueOf(lineIndex) + ": " + lineCode + " ("+getErrorMessage(e, tokenNames)+")");
	}
}

tiger_program
	:	type_declaration_list funct_declaration_list
	;
	
funct_declaration_list
	:	funct_declaration+
	;

funct_declaration
	:	return_func
	|	void_func
	;

return_func
	:	type_id FUNCTION_KEY ID LPAREN param_list RPAREN BEGIN_KEY block_list END_KEY SEMI
	->	^(ID param_list block_list)
	{defineFunction($ID.text, $param_list.tree, $block_list.tree);}
	;

void_func
	:	(VOID_KEY FUNCTION_KEY) => VOID_KEY FUNCTION_KEY ID LPAREN param_list RPAREN BEGIN_KEY block_list END_KEY SEMI
	->	^(ID param_list block_list)
		{defineFunction($VOID_KEY.text, ID, $block_list.tree);}
	|	VOID_KEY MAIN_KEY LPAREN RPAREN BEGIN_KEY block_list END_KEY SEMI
	->	^(MAIN_KEY block_list)
		{defineFunction($MAIN_KEY.text, null, $block_list.tree);}
	;

ret_type 
	:	VOID_KEY
	|	type_id
	;

param_list 
	:	(param (COMMA param)*)?
	->	^(AST_PARAM_LIST (param+)?)
	;

param 	:	ID COLON type_id
	->	^(COLON ID type_id)
	;

block_list 
	:	block+
	;

block 	:	BEGIN_KEY (declaration_statement stat_seq) END_KEY SEMI 
	-> 	^(AST_BLOCK declaration_statement stat_seq)
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
	:	TYPE_KEY ID EQ type SEMI
	->	^(EQ ID type)
	;
	
type	:	base_type
	|	(ARRAY_KEY LBRACK UNSIGNED_INTLIT RBRACK LBRACK UNSIGNED_INTLIT RBRACK) 
	=> 	ARRAY_KEY LBRACK UNSIGNED_INTLIT RBRACK LBRACK UNSIGNED_INTLIT RBRACK OF_KEY base_type
	->	^(ARRAY_KEY ^(AST_2D_ARRAY UNSIGNED_INTLIT UNSIGNED_INTLIT) base_type)
	|	ARRAY_KEY LBRACK UNSIGNED_INTLIT RBRACK OF_KEY base_type
	->	^(ARRAY_KEY UNSIGNED_INTLIT base_type)
	;

type_id :	base_type
	|	ID
	;

base_type
	:	INT_KEY
	|	FIXEDPT_KEY
	;

var_declaration 
	:	(VAR_KEY id_list COLON type_id ASSIGN) => VAR_KEY id_list COLON type_id ASSIGN expr SEMI
	->	^(ASSIGN ^(COLON id_list type_id) expr)
	|	VAR_KEY id_list COLON type_id SEMI
	->	^(COLON id_list type_id)
	;


id_list :	ID (COMMA id_list)?
	->	^(AST_ID_LIST ID+)
	;

stat_seq 
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

if_stat	:	IF_KEY expr THEN_KEY stat_seq (ENDIF_KEY SEMI|ELSE_KEY stat_seq ENDIF_KEY SEMI)
	-> 	^(IF_KEY expr stat_seq ^(ELSE_KEY stat_seq)?)
	;

while_stat
	:	WHILE_KEY expr DO_KEY stat_seq ENDDO_KEY SEMI
	->	^(WHILE_KEY expr stat_seq)
	;

for_stat:	FOR_KEY ID ASSIGN index_expr TO_KEY index_expr DO_KEY stat_seq ENDDO_KEY SEMI
	->	^(FOR_KEY ^(TO_KEY ^(ASSIGN ID index_expr) index_expr) stat_seq)
	;

assign_stat
	:	(value) => value ASSIGN expr_list SEMI
	->	^(ASSIGN value expr_list)
	;

func_call
	:	ID LPAREN func_param_list RPAREN
	->	^(AST_FUNC_CALL ID func_param_list)
	;
	
break_stat
	:	BREAK_KEY SEMI
	->	BREAK_KEY
	;
	
return_stat
	:	RETURN_KEY expr SEMI
	->	^(AST_RETURN_STAT RETURN_KEY expr)
	;

	
expr 	:	(constval binop_p0) => constval binop_p0 expr
	->	^(binop_p0 constval expr)
	|	constval
	|	(ID LPAREN) => func_call // func_call normally conflicts with value
	|	(ID LPAREN binop_p0) => func_call binop_p0 expr
	->	^(binop_p0 func_call expr)
	|	(value binop_p0) => value binop_p0 expr
	->	^(binop_p0 value expr)
	|	value
	|	(LPAREN expr RPAREN binop_p0) => LPAREN expr RPAREN binop_p0 expr
	->	^(binop_p0 ^(AST_EXPR_PAREN expr) ^(AST_EXPR_PAREN expr))
	|	LPAREN expr RPAREN
	->	^(AST_EXPR_PAREN expr)
	;

binop_p0:	(AND | OR | binop_p1);
binop_p1:	(EQ | NEQ | LESSER | GREATER | LESSEREQ | GREATEREQ | binop_p2);     
binop_p2:	(MINUS | PLUS | binop_p3);
binop_p3:	(MULT | DIV);
	
constval:	(fixedptlit) => fixedptlit
	|	intlit
	;

intlit :	MINUS? UNSIGNED_INTLIT;

UNSIGNED_INTLIT	
	:	'0'..'9'+;

fixedptlit
	:   MINUS? UNSIGNED_FIXEDPTLIT
	;

UNSIGNED_FIXEDPTLIT
	:  ('0'..'9')* '.' ('0'..'9')* 
	;
	
binary_operator
	:	(PLUS|MINUS|MULT|DIV|EQ|NEQ|LESSER|GREATER|LESSEREQ|GREATEREQ|AND|OR)
	;

expr_list
	:	expr (COMMA expr)*
	->	^(AST_EXPR_LIST expr+)
	;

value 	
  :	(ID LBRACK index_expr RBRACK LBRACK) => ID LBRACK index_expr RBRACK LBRACK index_expr RBRACK
	|	(ID LBRACK) => ID LBRACK index_expr RBRACK
	|	ID
	;

index_expr 
	:	(intlit index_oper) => intlit index_oper index_expr
	->	^(index_oper intlit index_expr)
	|	intlit
	|	(ID index_oper) => ID index_oper index_expr
	->	^(index_oper ID index_expr)
	|	ID
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
  
func_param_list
	: (expr (COMMA expr)*)?
	-> ^(AST_PARAM_LIST (expr+)?)
	;

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

// Punctuation symbols/binary operators
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
