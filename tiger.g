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
	import java.util.List;
	import java.util.ArrayList;
	import org.antlr.runtime.tree.CommonTree;
}

@parser::members {
  private String func_name;
  private SymbolTable symbolTable = new SymbolTable(); 
  private List<String> irOutput = new ArrayList<String>();
  private int currentTemp = 0;
  private Scope GLOBAL_SCOPE = new Scope();
  private Scope CURRENT_SCOPE = GLOBAL_SCOPE;

  private static void outln(Object obj) {
    System.out.println(obj);
  }
  
  public String strip(String id) {
    return id.replaceAll("\\s","");
  }

	@Override
	public void reportError(RecognitionException e) {
		displayRecognitionError(this.getTokenNames(), e);
	}
	
	/**
	* makes a 1D array of either an Integer or Double type
	* @param s the string "int" or "fixedpt"
	* @param width the length of the array 
	* @param value the initial value that will be converted to either an integer or double
	* @return either an Integer or Double array initialized
	**/
	public Object[] make1DArray(String s, Integer width, String value) {
	  if (s.equals("int")){
	    //toInteger method defined below
	    Integer val = toInteger(value);
      Integer[] IntArray = new Integer[width];
      for (int i = 0; i < width; i++) {
         IntArray[i] = val;
      }
      return IntArray;
    } else if (s.equals("fixedpt")) {
      Double val = toDouble(value);
      Double[] DoubleArray = new Double[width];
      for (int i = 0; i < width; i++) {
        DoubleArray[i] = val;
      }
      return DoubleArray;
    }
    return null;
	}
	
  /**
  * makes a 2D array of either an Integer or Double type
  * @param s the string "int" or "fixedpt"
  * @param width the width, or x component, of the array 
  * @param height the height, or y component, of the array
  * @param value the initial value that will be converted to either an integer or double
  * @return either an Integer or Double array initialized
  **/
	public Object[][] make2DArray(String s, Integer width, Integer height, String value) {
	  if (s.equals("int")){
	    //toInteger method defined below
	    Integer val = toInteger(value);
	    Integer[][] IntArray = new Integer[width][height];
	    for (int i = 0; i < width; i++) {
	      for (int j = 0; j < height; j++) {
	        IntArray[i][j] = val;
	      }
	    }
	    return IntArray;
	  } else if (s.equals("fixedpt")) {
	    Double val = toDouble(value);
	    Double[][] DoubleArray = new Double[width][height];
	    for (int i = 0; i < width; i++) {
	      for (int j = 0; j < height; j++) {
	        DoubleArray[i][j] = val;
	      }
	    }
	    return DoubleArray;
	  }
	  return null;
	}
	
	public Double toDouble(String s) {
		double value = Double.parseDouble(s);
		return new Double(value);
	}
	
	public Integer toInteger(String s) {
		int value;
		value = Integer.parseInt(s);
		return new Integer(value); 
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
	
	// Checks if 'void main()' was the last signature declared
	private void mainCheck(CommonTree parseTree) {
		if (!parseTree.getChildren().get(parseTree.getChildren().size() - 1).toString().equals("main"))
		{
			// It wasn't found or wasn't the last function
			throw new RuntimeException("Error: main must be in your program, and must be the last function declared");
		}
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
	:	type_id FUNCTION_KEY ID {func_name = $ID.text;} LPAREN param_list RPAREN begin block_list block_end
		{
      	    		symbolTable.put(new FunctionSymbolTableEntry(CURRENT_SCOPE, $ID.text, $type_id.text));	
      	    		irOutput.add(IRGenerator.funct_declaration(func_name));
      	    		
      	    		CURRENT_SCOPE = new Scope(CURRENT_SCOPE, $ID.text);
      		}
	->	^(ID type_id param_list block_list)
	;

void_func
	:	(VOID_KEY FUNCTION_KEY) => VOID_KEY FUNCTION_KEY ID {func_name = $ID.text;} LPAREN param_list RPAREN begin block_list block_end
		{
			symbolTable.put(new FunctionSymbolTableEntry(CURRENT_SCOPE, $ID.text, $VOID_KEY.text));
			irOutput.add(IRGenerator.funct_declaration(func_name));
			
			CURRENT_SCOPE = new Scope(CURRENT_SCOPE, $ID.text);
		}
	->	^(ID VOID_KEY param_list block_list) 
		
	|	VOID_KEY MAIN_KEY {func_name = $MAIN_KEY.text;} LPAREN RPAREN begin block_list block_end
		{
     			symbolTable.put(new FunctionSymbolTableEntry(CURRENT_SCOPE, $MAIN_KEY.text, $VOID_KEY.text));
     			irOutput.add(IRGenerator.funct_declaration(func_name));
     			
			CURRENT_SCOPE = new Scope(CURRENT_SCOPE, $MAIN_KEY.text); 
            	}
	->	^(MAIN_KEY block_list) 
	;

block_end
	:	END_KEY SEMI
		{
			if (CURRENT_SCOPE != GLOBAL_SCOPE) {
				CURRENT_SCOPE = CURRENT_SCOPE.getParent();
			}
		}
	;

ret_type 
	:	VOID_KEY
	|	type_id
	;

param_list 
	:	(param (COMMA param)*)?
	->	^(AST_PARAM_LIST (param+)?)
	;

param 	
  :	ID COLON type_id
	->	^(COLON ID type_id)
	;

block_list
	:	block+
	;

block 	
  	:	begin (declaration_statement stat_seq) block_end
	-> 	^(AST_BLOCK declaration_statement? stat_seq) 
	;

begin
  : BEGIN_KEY {
    CURRENT_SCOPE = new Scope(CURRENT_SCOPE, func_name);
  }
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
	:	TYPE_KEY ID EQ type[$ID.text] SEMI 
	->	^(EQ ID type)
	;
	
type[String id]	
  :	base_type {
    if ($base_type.text.equals("int")) { 
      symbolTable.put(new TypeSymbolTableEntry(CURRENT_SCOPE,strip(id), TigerPrimitive.INT));
    } else if ($base_type.text.equals("fixedpt")) {
      symbolTable.put(new TypeSymbolTableEntry(CURRENT_SCOPE,strip(id), TigerPrimitive.FIXEDPT));
    }
  }
	|	(ARRAY_KEY LBRACK UNSIGNED_INTLIT RBRACK LBRACK UNSIGNED_INTLIT RBRACK) 
	=> 	ARRAY_KEY LBRACK var1=UNSIGNED_INTLIT RBRACK LBRACK var2=UNSIGNED_INTLIT RBRACK OF_KEY type_id {
	  if ($type_id.text.equals("int")) { 
	    symbolTable.put(new TypeSymbolTableEntry(CURRENT_SCOPE,strip(id), TigerPrimitive.INT_2D_ARRAY, toInteger($var1.text),toInteger($var2.text)));
	  } else if ($type_id.text.equals("fixedpt")) {
	    symbolTable.put(new TypeSymbolTableEntry(CURRENT_SCOPE,strip(id), TigerPrimitive.FIXEDPT_2D_ARRAY, toInteger($var1.text),toInteger($var2.text)));
	  }
	}
	->	^(ARRAY_KEY ^(AST_2D_ARRAY UNSIGNED_INTLIT UNSIGNED_INTLIT) type_id)
	|	ARRAY_KEY LBRACK UNSIGNED_INTLIT RBRACK OF_KEY type_id {
	  if ($type_id.text.equals("int")) { 
      symbolTable.put(new TypeSymbolTableEntry(CURRENT_SCOPE,strip(id), TigerPrimitive.INT_ARRAY, toInteger($UNSIGNED_INTLIT.text)));
    } else if ($type_id.text.equals("fixedpt")) {
      symbolTable.put(new TypeSymbolTableEntry(CURRENT_SCOPE,strip(id), TigerPrimitive.FIXEDPT_ARRAY, toInteger($UNSIGNED_INTLIT.text)));
    }
	}
	->	^(ARRAY_KEY UNSIGNED_INTLIT type_id)
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
	:	(VAR_KEY id_list COLON type_id ASSIGN fixedptlit) => VAR_KEY id_list COLON type_id ASSIGN fixedptlit SEMI 
	{   
	  	String idlist = $id_list.text; 
    		String[] ids = idlist.split(",");
    		// Check if it's not a base type
    		if (!strip($type_id.text).equals("int") && !strip($type_id.text).equals("fixedpt")) {
    		  // Gets the type and makes the variables for INT_ARRAY, INT_2D_ARRAY, and INT
    		  SymbolTableEntry type = symbolTable.get($type_id.text, CURRENT_SCOPE);
    		  
    		  if (type != null && type instanceof TypeSymbolTableEntry) {
    		  
    		    switch (((TypeSymbolTableEntry) type).getBackingType()) {
    		    
    		    case FIXEDPT_ARRAY:
    		      // Instantiates the 1D array
    		      Double[] fpArray = (Double[]) make1DArray("fixedpt", 
    		        ((TypeSymbolTableEntry) type).getWidth(), $fixedptlit.text);
          
    		      for (String id: ids) {
    		        // Gets rid of white space and adds to symbol table
    		        symbolTable.put(new TigerVariable(CURRENT_SCOPE, 
    		          strip(id), 
    		          fpArray, $type_id.text));
    		      }
          
    		    break;
    		    
    		    case FIXEDPT_2D_ARRAY:
             // Instantiates the 2D array
             Double[][] fp2DArray = (Double[][]) make2DArray("fixedpt", 
               ((TypeSymbolTableEntry) type).getWidth(), 
               ((TypeSymbolTableEntry) type).getHeight(), $fixedptlit.text);
             for (String id: ids) {
                // Gets rid of white space and adds to symbol table
                symbolTable.put(new TigerVariable(CURRENT_SCOPE, 
                  strip(id), 
                  fp2DArray, $type_id.text));
             }
          
            break;
            
            case FIXEDPT:
              for (String id: ids) {
              // Gets rid of white space and adds to symbol table
              symbolTable.put(new TigerVariable(CURRENT_SCOPE, 
                strip(id), 
                toDouble($fixedptlit.text), $type_id.text));
              }
          
            break;
          
            default:
              System.out.println("The type " + $type_id.text + " on line " + $type_id.start.getLine()
              + " is not of type int");
          
            break;
            
    		    }
    		  } else {
    		    System.out.println("The type " + $type_id.text + 
    		      " does not exist or is not in an accessible scope from " 
    		      + $id_list.text + " on line " + $type_id.start.getLine());
    		  }
    		} else {
    		  for (String id: ids) {
      			symbolTable.put(new TigerVariable(CURRENT_SCOPE, strip(id), toDouble($fixedptlit.text)));
      		}
      	}
      	
	}
	->	^(ASSIGN ^(COLON id_list type_id) fixedptlit)
	|	(VAR_KEY id_list COLON type_id ASSIGN UNSIGNED_INTLIT) => VAR_KEY id_list COLON type_id ASSIGN UNSIGNED_INTLIT SEMI 
	{
		String idlist = $id_list.text; 
		String[] ids = idlist.split(",");
		
		// Check if it's not a base type
		if (!strip($type_id.text).equals("int") && !strip($type_id.text).equals("fixedpt")) {
			// Gets the type and makes the variables for INT_ARRAY, INT_2D_ARRAY, and INT
			SymbolTableEntry type = symbolTable.get($type_id.text, CURRENT_SCOPE);
			// Check existence
			if (type != null && type instanceof TypeSymbolTableEntry) {
				switch (((TypeSymbolTableEntry) type).getBackingType()) {
				
				case INT_ARRAY:
					// Instantiates the 1D array
					Integer[] intArray = (Integer[]) make1DArray("int", 
						((TypeSymbolTableEntry) type).getWidth(), $UNSIGNED_INTLIT.text);
					
					for (String id: ids) {
						// Gets rid of white space and adds to symbol table
						  symbolTable.put(new TigerVariable(CURRENT_SCOPE, 
						    strip(id), 
						    intArray, $type_id.text));
					}
					
					break;
					
				case INT_2D_ARRAY:
					// Instantiates the 2D array
					Integer[][] int2DArray = (Integer[][]) make2DArray("int", 
						((TypeSymbolTableEntry) type).getWidth(), 
						((TypeSymbolTableEntry) type).getHeight(), $UNSIGNED_INTLIT.text);
					for (String id: ids) {
						// Gets rid of white space and adds to symbol table
              symbolTable.put(new TigerVariable(CURRENT_SCOPE, 
                strip(id), 
                int2DArray, $type_id.text));
					}
					
					break;
					
				case INT:
					for (String id: ids) {
						// Gets rid of white space and adds to symbol table
							symbolTable.put(new TigerVariable(CURRENT_SCOPE, 
								strip(id), 
								toInteger($UNSIGNED_INTLIT.text), $type_id.text));
					}
					
					break;
					
				default:
					System.out.println("The type " + $type_id.text + " on line " + $type_id.start.getLine()
						+ " is not of type int");
					
					break;
				}
			} else {
				System.out.println("The type " + $type_id.text + 
					" does not exist or is not in an accessible scope from " 
					+ $id_list.text + " on line " + $type_id.start.getLine());
			}
		} else {
			// Else, it's a primitive already
			for (String id: ids) {
				// Gets rid of white space and adds to symbol table
				symbolTable.put(new TigerVariable(CURRENT_SCOPE, 
				strip(id), toInteger($UNSIGNED_INTLIT.text)));
			}
        }
        	}
	->	^(ASSIGN ^(COLON id_list type_id) UNSIGNED_INTLIT) 
	|	VAR_KEY id_list COLON type_id SEMI
	{
   		String idlist = $id_list.text; 
    		String[] ids = idlist.split(",");
    		for (String id: ids) {
      			symbolTable.put(new TigerVariable(CURRENT_SCOPE, strip(id), new Integer(0)));
    		}
  	}
	->	^(COLON id_list type_id)
	;


id_list 
  :	ID (COMMA id_list)?
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
  | func_call SEMI!
	| break_stat
	| return_stat
	| block
	;

if_stat	
  :	(IF_KEY LPAREN boolExpr1 RPAREN THEN_KEY stat_seq ELSE_KEY) => 	IF_KEY LPAREN boolExpr1 RPAREN THEN_KEY stat_seq ELSE_KEY stat_seq ENDIF_KEY SEMI
	-> 	^(IF_KEY boolExpr1 stat_seq ^(ELSE_KEY stat_seq))
	|	IF_KEY LPAREN boolExpr1 RPAREN THEN_KEY stat_seq ENDIF_KEY SEMI
	->	^(IF_KEY boolExpr1 stat_seq)
	;

while_stat
	:	WHILE_KEY LPAREN boolExpr1 RPAREN DO_KEY stat_seq ENDDO_KEY SEMI
	->	^(WHILE_KEY boolExpr1 stat_seq)
	;

for_stat
  :	FOR_KEY ID ASSIGN index_expr TO_KEY index_expr DO_KEY stat_seq ENDDO_KEY SEMI
	->	^(FOR_KEY ^(TO_KEY ^(ASSIGN ID index_expr) index_expr) stat_seq)
	;

assign_stat
	:	(value ASSIGN func_call) =>value ASSIGN func_call SEMI
  ->  ^(ASSIGN value func_call)
  | (value ASSIGN numExpr1) => value ASSIGN numExpr1 SEMI
  -> ^(ASSIGN value numExpr1)
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
	: (RETURN_KEY numExpr1) => RETURN_KEY numExpr1 SEMI
	-> ^(AST_RETURN_STAT RETURN_KEY numExpr1)
	| RETURN_KEY boolExpr1 SEMI
  ->  ^(AST_RETURN_STAT RETURN_KEY boolExpr1)
	;

numExpr1 
  : (numExpr2 bin_op3) => numExpr2 (bin_op3 numExpr2)+
  | numExpr2
  ;

bin_op3
  : PLUS
  | MINUS
  ;
  
numExpr2 
  : (numExpr3 bin_op4) => numExpr3 (bin_op4 numExpr3)+
  | numExpr3
  ;

bin_op4
  : MULT
  | DIV
  ;
         
numExpr3 
  : (value) => value
  | constval
  | LPAREN numExpr1 RPAREN
  ;

  
boolExpr1 
  : (boolExpr2 bin_op1) => boolExpr2 (bin_op1 boolExpr2)+ 
  | boolExpr2
  ;
  
bin_op1
  : AND
  | OR
  ;
          
boolExpr2 
  : (numExpr1 bin_op2) => numExpr1 (bin_op2 numExpr1)+
  | numExpr1
  ;
bin_op2
  : LESSER
  | GREATER
  | EQ
  | NEQ
  | LESSEREQ
  | GREATEREQ
  ;
	
constval
  :	(fixedptlit) => fixedptlit
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
	: (boolExpr1) => boolExpr1 (COMMA boolExpr1)*
	-> ^(AST_EXPR_LIST boolExpr1+)
	|  numExpr1 (COMMA numExpr1)*
  ->  ^(AST_EXPR_LIST numExpr1+)
	;

value 	
  :	(ID LBRACK index_expr RBRACK LBRACK) => ID LBRACK index_expr RBRACK LBRACK index_expr RBRACK {
  	  SymbolTableEntry entry = symbolTable.get(strip($ID.text),CURRENT_SCOPE);
  	  
  	}
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
	: (numExpr1 (COMMA numExpr1)*)?
	-> ^(AST_PARAM_LIST (numExpr1+)?)
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
