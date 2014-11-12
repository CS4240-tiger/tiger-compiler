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
  private Scope GLOBAL_SCOPE = new Scope();
  private Scope CURRENT_SCOPE = GLOBAL_SCOPE;
  private Boolean boolIsValid = true;
  private Boolean boolExprIsValid = true;
  private int numLoops;
  
  private static void outln(Object obj) {
    System.out.println(obj);
  }
  
  public OperationObject getTyping(OperationObject var1, OperationObject var2, int lineNum, String bin_op) {
    if (var1 != null && var2 != null) {
	    boolean newisConst;
	    TypeSymbolTableEntry newType;
	    String newId = var1.getId()+bin_op+var2.getId();
	    if (var1.isConstant() && var2.isConstant()) {
	      newisConst = true;
	      if (!(var1.getType().equals(var2.getType()))) {
	        newType = symbolTable.getFixedPtType();
	      } else {
	        newType = var1.getType();
	      }
	      return new OperationObject(newisConst,newType,newId);
	    } else {
	      newisConst = false;
	      if ((var1.getType().getId().equals("int") && var2.getType().getId().equals("fixedpt"))||(var1.getType().getId().equals("fixedpt") && var2.getType().getId().equals("int"))) {
	        newType = symbolTable.getFixedPtType();
	        return new OperationObject(newisConst,newType, newId);
	      } else {
		      if (!(var1.getType().equals(var2.getType()))) {
		        System.out.println("Typing error between "+ var1.getId() + " and " + var2.getId() + " on line " + String.valueOf(lineNum));
		        return null;
		      } else {
		        newType = var1.getType();
		        return new OperationObject(newisConst,newType, newId);
		      }
	      }
	    }
    } else {
      return null;
    }
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
	:	type_id FUNCTION_KEY ID {
	    func_name = $ID.text;
	    CURRENT_SCOPE = new Scope(CURRENT_SCOPE, $ID.text);
	  } LPAREN param_list[new ArrayList<TypeSymbolTableEntry>()] {
	    SymbolTableEntry type = symbolTable.get($type_id.text, CURRENT_SCOPE);
	    if (type != null && type instanceof TypeSymbolTableEntry) {
	      symbolTable.put(new FunctionSymbolTableEntry(GLOBAL_SCOPE, $ID.text, ((TypeSymbolTableEntry) type),$param_list.outtypeList));
	    } else {
	       System.out.println("The type " + $type_id.text + "on line " + $type_id.start.getLine()+ " does not exist or is not in an accessible scope");
	    }
	  } RPAREN begin block_list block_end
	->	^(ID param_list block_list)
	;

void_func
	:	(VOID_KEY FUNCTION_KEY) => VOID_KEY FUNCTION_KEY ID {
	    func_name = $ID.text;
	    CURRENT_SCOPE = new Scope(CURRENT_SCOPE, $ID.text);
	  } LPAREN param_list[new ArrayList<TypeSymbolTableEntry>()] {
      symbolTable.put(new FunctionSymbolTableEntry(GLOBAL_SCOPE, $ID.text, null, $param_list.outtypeList));     
    }
	  RPAREN begin block_list block_end
	->	^(ID param_list block_list) 
		
	|	VOID_KEY MAIN_KEY {
	    func_name = $MAIN_KEY.text;
	    symbolTable.put(new FunctionSymbolTableEntry(GLOBAL_SCOPE, $MAIN_KEY.text, null, null));
      CURRENT_SCOPE = new Scope(CURRENT_SCOPE, $MAIN_KEY.text); 
	  } LPAREN RPAREN begin block_list block_end
	->	^(MAIN_KEY block_list) 
	;

block_end
	:	END_KEY SEMI
		{
			CURRENT_SCOPE = CURRENT_SCOPE.getParent();
		}
	;

ret_type 
	:	VOID_KEY
	|	type_id
	;

param_list[List<TypeSymbolTableEntry> intypeList] returns [List<TypeSymbolTableEntry> outtypeList] 
	:	(var1=param[intypeList]{
	    $outtypeList = $var1.outtypeList;
	  } (COMMA param[intypeList])*)?
	->	^(AST_PARAM_LIST (param+)?)
	;

param[List<TypeSymbolTableEntry> intypeList] returns [List<TypeSymbolTableEntry> outtypeList] 	
  :	ID COLON type_id {
    if (!$type_id.text.equals("int") && !$type_id.text.equals("fixedpt")) {
    SymbolTableEntry type = symbolTable.get($type_id.text, CURRENT_SCOPE);
    if (type != null && type instanceof TypeSymbolTableEntry) {
      intypeList.add((TypeSymbolTableEntry) type);
      $outtypeList = intypeList;
      symbolTable.put(new TigerVariable(CURRENT_SCOPE, strip($ID.text), null, ((TypeSymbolTableEntry) type), ((TypeSymbolTableEntry) type).getBackingType()));
    } else {
	    System.out.println("The type "+ $type_id.text+" on line "+$type_id.start.getLine()+" was not declared yet");
    }
    } else {
      if ($type_id.text.equals("int")) {
        intypeList.add(symbolTable.getIntType());
        $outtypeList = intypeList;
        symbolTable.put(new TigerVariable(CURRENT_SCOPE, strip($ID.text), null, symbolTable.getIntType(), TigerPrimitive.INT));
      } else if ($type_id.text.equals("fixedpt")) {
        intypeList.add(symbolTable.getFixedPtType());
        $outtypeList = intypeList;
        symbolTable.put(new TigerVariable(CURRENT_SCOPE, strip($ID.text), null, symbolTable.getFixedPtType(), TigerPrimitive.FIXEDPT));
      }
    }
    //System.out.println($ID.text + "added");
  }
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
	=> 	ARRAY_KEY LBRACK var1=UNSIGNED_INTLIT RBRACK LBRACK var2=UNSIGNED_INTLIT RBRACK OF_KEY base_type {
	  if ($base_type.text.equals("int")) { 
	    symbolTable.put(new TypeSymbolTableEntry(CURRENT_SCOPE,strip(id), TigerPrimitive.INT_2D_ARRAY, toInteger($var1.text),toInteger($var2.text)));
	  } else if ($base_type.text.equals("fixedpt")) {
	    symbolTable.put(new TypeSymbolTableEntry(CURRENT_SCOPE,strip(id), TigerPrimitive.FIXEDPT_2D_ARRAY, toInteger($var1.text),toInteger($var2.text)));
	  } 
	}
	->	^(ARRAY_KEY ^(AST_2D_ARRAY UNSIGNED_INTLIT UNSIGNED_INTLIT) base_type)
	|	ARRAY_KEY LBRACK UNSIGNED_INTLIT RBRACK OF_KEY base_type {
	  if ($base_type.text.equals("int")) { 
      symbolTable.put(new TypeSymbolTableEntry(CURRENT_SCOPE,strip(id), TigerPrimitive.INT_ARRAY, toInteger($UNSIGNED_INTLIT.text)));
    } else if ($base_type.text.equals("fixedpt")) {
      symbolTable.put(new TypeSymbolTableEntry(CURRENT_SCOPE,strip(id), TigerPrimitive.FIXEDPT_ARRAY, toInteger($UNSIGNED_INTLIT.text)));
    }
	}
	->	^(ARRAY_KEY UNSIGNED_INTLIT base_type)
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
    		          fpArray, ((TypeSymbolTableEntry) type), ((TypeSymbolTableEntry) type).getBackingType()));
    			 
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
                  fp2DArray, ((TypeSymbolTableEntry) type), ((TypeSymbolTableEntry) type).getBackingType()));
             }
          
            break;
            
            case FIXEDPT:
              for (String id: ids) {
              // Gets rid of white space and adds to symbol table
              symbolTable.put(new TigerVariable(CURRENT_SCOPE, 
                strip(id), 
                toDouble($fixedptlit.text), ((TypeSymbolTableEntry) type), ((TypeSymbolTableEntry) type).getBackingType()));
               
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
    		  if ($type_id.text.equals("fixedpt")) {
	    		  for (String id: ids) {
	      			symbolTable.put(new TigerVariable(CURRENT_SCOPE, strip(id), toDouble($fixedptlit.text), symbolTable.getFixedPtType(), TigerPrimitive.FIXEDPT));
	      			
	      		}
      		} else if ($type_id.text.equals("int")) {
      		  System.out.println("A fixedpt constant cannot be declared to a variable of type int on line "+$type_id.start.getLine());
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
						    intArray, ((TypeSymbolTableEntry) type), ((TypeSymbolTableEntry) type).getBackingType()));
						    
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
					                int2DArray, ((TypeSymbolTableEntry) type), ((TypeSymbolTableEntry) type).getBackingType()));
					}
					
					break;
					
				case INT:
					for (String id: ids) {
						// Gets rid of white space and adds to symbol table
							symbolTable.put(new TigerVariable(CURRENT_SCOPE, 
								strip(id), 
								toInteger($UNSIGNED_INTLIT.text), ((TypeSymbolTableEntry) type), ((TypeSymbolTableEntry) type).getBackingType()));
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
			if ($type_id.text.equals("int")) {
				for (String id: ids) {
					// Gets rid of white space and adds to symbol table
					symbolTable.put(new TigerVariable(CURRENT_SCOPE, strip(id), toInteger($UNSIGNED_INTLIT.text), symbolTable.getIntType(), TigerPrimitive.INT));
					
				}
			} else if ($type_id.text.equals("fixedpt")) {
			  System.out.println("An int constant cannot be declared to a variable of type fixedpt on line "+$type_id.start.getLine());
			}
        }
        	}
	->	^(ASSIGN ^(COLON id_list type_id) UNSIGNED_INTLIT) 
	|	VAR_KEY id_list COLON type_id SEMI
	{   
   		String idlist = $id_list.text; 
    	String[] ids = idlist.split(",");
    	if (!strip($type_id.text).equals("int") && !strip($type_id.text).equals("fixedpt")) {
    	  //type of declared type is transferred to the variables
    		SymbolTableEntry type = symbolTable.get($type_id.text, CURRENT_SCOPE);
    		//checks if it exists 
    		if (type != null && type instanceof TypeSymbolTableEntry) {
    		  TigerPrimitive backingType = ((TypeSymbolTableEntry) type).getBackingType();
    		  //prints warning that arrays are not initialized if the type are arrays and sets the value to null
    		  if (backingType == TigerPrimitive.INT_ARRAY || backingType == TigerPrimitive.FIXEDPT_ARRAY || backingType == TigerPrimitive.INT_2D_ARRAY || backingType == TigerPrimitive.FIXEDPT_2D_ARRAY) {
    		    switch (((TypeSymbolTableEntry) type).getBackingType()) {
    		      case INT_ARRAY:
    		        // Instantiates the 1D array into 0s
    		        Integer[] intArray = (Integer[]) make1DArray("int", 
    		        ((TypeSymbolTableEntry) type).getWidth(), "0");
          
    		        for (String id: ids) {
    		          // Gets rid of white space and adds to symbol table
    		          symbolTable.put(new TigerVariable(CURRENT_SCOPE, 
    		            strip(id), 
    		            intArray, ((TypeSymbolTableEntry) type), ((TypeSymbolTableEntry) type).getBackingType()));
                }
              break;
              case INT_2D_ARRAY:
			          // Instantiates the 2D array
			          Integer[][] int2DArray = (Integer[][]) make2DArray("int", 
			            ((TypeSymbolTableEntry) type).getWidth(), 
			            ((TypeSymbolTableEntry) type).getHeight(), "0");
			          for (String id: ids) {
			            // Gets rid of white space and adds to symbol table
				           symbolTable.put(new TigerVariable(CURRENT_SCOPE, 
				             strip(id), 
				             int2DArray, ((TypeSymbolTableEntry) type), ((TypeSymbolTableEntry) type).getBackingType()));
			          }
			        break;
			        case FIXEDPT_ARRAY:
	              // Instantiates the 1D array
	              Double[] fpArray = (Double[]) make1DArray("fixedpt", 
	                ((TypeSymbolTableEntry) type).getWidth(), "0.0");
	          
	              for (String id: ids) {
	                // Gets rid of white space and adds to symbol table
	                symbolTable.put(new TigerVariable(CURRENT_SCOPE, 
	                  strip(id), 
	                  fpArray, ((TypeSymbolTableEntry) type), ((TypeSymbolTableEntry) type).getBackingType()));
	              }
	            break;
	            case FIXEDPT_2D_ARRAY:
	             // Instantiates the 2D array
	             Double[][] fp2DArray = (Double[][]) make2DArray("fixedpt", 
	               ((TypeSymbolTableEntry) type).getWidth(), 
	               ((TypeSymbolTableEntry) type).getHeight(), "0.0");
	             for (String id: ids) {
	                // Gets rid of white space and adds to symbol table
	                symbolTable.put(new TigerVariable(CURRENT_SCOPE, 
	                  strip(id), 
	                  fp2DArray, ((TypeSymbolTableEntry) type), ((TypeSymbolTableEntry) type).getBackingType()));
	             }
             break;
    		    }
    		  } else {
    		    //apparently gets set to null if not array according to piazza
    		    System.out.println("WARNING:"+$id_list.text +" are are not initialized on line "+ $type_id.start.getLine()+ " and will be set to null");
	    		  for (String id: ids) {
	    		    symbolTable.put(new TigerVariable(CURRENT_SCOPE, strip(id), null, ((TypeSymbolTableEntry) type), ((TypeSymbolTableEntry) type).getBackingType()));
	    		  }
    		  }
    		} else {
    		  System.out.println("The type " + $type_id.text + 
          " does not exist or is not in an accessible scope from " 
          + $id_list.text + " on line " + $type_id.start.getLine());
    		}
    	} else {
    	  // prints out warning
    	  System.out.println("WARNING:"+$id_list.text +" are are not initialized on line "+ $type_id.start.getLine()+ " and will be set to null");
    		//initialiazes for both int and fixedpt.. to null
    	  if (strip($type_id.text).equals("int")) {
		   		for (String id: ids) {
	     			symbolTable.put(new TigerVariable(CURRENT_SCOPE, strip(id), null, symbolTable.getIntType(), TigerPrimitive.INT));
		   		}
	   		} else if (strip($type_id.text).equals("fixedpt")) {
	   		   for (String id: ids) {
            symbolTable.put(new TigerVariable(CURRENT_SCOPE, strip(id), null, symbolTable.getFixedPtType(), TigerPrimitive.FIXEDPT));
          }
	   		}
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
  :	(IF_KEY LPAREN expr RPAREN THEN_KEY stat_seq ELSE_KEY) => IF_KEY LPAREN expr {
    if (!($expr.isBool)) {
      System.out.println("The if statement on line "+$expr.start.getLine()+" requires a boolean expression");
    } else {
      if (!boolExprIsValid) {
        System.out.println("The boolean expression on line "+$expr.start.getLine()+" cannot be evaluated");
      }
    }
    boolIsValid = true;
    boolExprIsValid = true;
  } RPAREN THEN_KEY stat_seq ELSE_KEY stat_seq ENDIF_KEY SEMI 
	-> 	^(IF_KEY expr stat_seq ^(ELSE_KEY stat_seq))
	|	IF_KEY LPAREN expr {
	  if (!($expr.isBool)) {
      System.out.println("The if statement on line "+$expr.start.getLine()+" requires a boolean expression");
    } else {
      if (!boolExprIsValid) {
        System.out.println("The boolean expression on line "+$expr.start.getLine()+" cannot be evaluated");
      }
    }
    boolIsValid = true;
    boolExprIsValid = true;
  } RPAREN THEN_KEY stat_seq ENDIF_KEY SEMI 
	->	^(IF_KEY expr stat_seq)
	;

while_stat
	:	WHILE_KEY LPAREN expr {
	  if (!($expr.isBool)) {
	    System.out.println("The while loop on line "+$expr.start.getLine()+" requires a boolean expression");
	  } else {
      if (!boolExprIsValid) {
        System.out.println("The boolean expression on line "+$expr.start.getLine()+" cannot be evaluated");
      }
    }
    boolIsValid = true;
    boolExprIsValid = true;
	} RPAREN DO_KEY {numLoops++;} stat_seq ENDDO_KEY SEMI {
	  numLoops--;
	}
	->	^(WHILE_KEY expr stat_seq)
	;

for_stat
  :	FOR_KEY ID ASSIGN index_expr TO_KEY index_expr DO_KEY {numLoops++;} stat_seq ENDDO_KEY SEMI {
    numLoops--;
  }
	->	^(FOR_KEY ^(TO_KEY ^(ASSIGN ID index_expr) index_expr) stat_seq)
	;

assign_stat
	:	(value ASSIGN func_call) => value ASSIGN func_call SEMI {
	  SymbolTableEntry variable = symbolTable.get($value.id,CURRENT_SCOPE);
	  if (variable == null || !(variable instanceof TigerVariable)) {
	    System.out.println("The variable "+$value.id+" on line "+$value.start.getLine()+" was never declared");
	  } 
	}
  ->  ^(ASSIGN value func_call)
  | (value ASSIGN expr) => value ASSIGN expr SEMI {
    SymbolTableEntry variable = symbolTable.get($value.id,CURRENT_SCOPE);
    if ($expr.isBool) {
      System.out.println("Cannot assign boolean to variable");
    } else {
	    if (variable != null && variable instanceof TigerVariable) {
	      // if right expression type is not null or if they are not equal and right is not int and left is not fixedpt (for promotion)
	      // Dem parentheses doe
	     if ($expr.typing == null || (!((TigerVariable)variable).getType().equals($expr.typing.getType()) && !(((TigerVariable)variable).getType().equals(symbolTable.getFixedPtType()) &&($expr.typing.getType().equals(symbolTable.getIntType()))))) {
	      System.out.println("The variable "+$value.id+" on line "+$value.start.getLine()+" cannot be assigned to "+$expr.text+" because it has conflicting types");
	     } 
	    }
	   }
	  boolIsValid = true;
    boolExprIsValid = true;
    }
  -> ^(ASSIGN value expr)
	;

func_call
	:	ID LPAREN func_param_list RPAREN {
	  
	}
	->	^(AST_FUNC_CALL ID func_param_list)
	;
	
break_stat
	:	BREAK_KEY SEMI {
	  if (numLoops == 0) {
	    System.out.println("Break at line " +$break_stat.start.getLine() +" cannot occur outside of a loop");
	  }
	}
	->	BREAK_KEY
	;
	
return_stat
	: (RETURN_KEY expr) => RETURN_KEY expr SEMI
	-> ^(AST_RETURN_STAT RETURN_KEY expr)
	;

expr returns [OperationObject typing, Boolean isBool]
  : (boolExpr) => boolExpr {
    $typing = $boolExpr.typing;
    $isBool = $boolExpr.isBool;
  }
  | (numExpr) => numExpr {
    $typing = $numExpr.typing;
    $isBool = $numExpr.isBool;
  }
  | LPAREN! var1=expr RPAREN! {
    $typing = $var1.typing;
    $isBool = $var1.isBool;
  }
  ;
 
boolExpr returns [OperationObject typing, Boolean isBool]
  : (constval binop_p0) => constval binop_p0 expr {
    $typing = getTyping($constval.typing, $expr.typing, $boolExpr.start.getLine(), $binop_p0.text);
    $isBool = $constval.isBool || $binop_p0.isBool || $expr.isBool;
  }
  -> ^(binop_p0 constval expr) 
  | (value binop_p0) => value binop_p0 expr {
    $typing = getTyping($value.typing, $expr.typing, $boolExpr.start.getLine(), $binop_p0.text);
    $isBool = $value.isBool || $binop_p0.isBool || $expr.isBool;
  }
  -> ^(binop_p0 value expr)
  | (LPAREN expr RPAREN binop_p0) => LPAREN! var1=expr RPAREN! binop_p0^ var2=expr {
    $typing = getTyping($var1.typing, $var2.typing, $boolExpr.start.getLine(), $binop_p0.text);
    $isBool = $var1.isBool || $binop_p0.isBool || $var2.isBool;
  }
  ;
 
numExpr returns [OperationObject typing, Boolean isBool]
  : (constval binop_p2) => constval binop_p2 expr {
    $typing = getTyping($constval.typing, $expr.typing, $numExpr.start.getLine(), $binop_p2.text);
    $isBool = $constval.isBool || $binop_p2.isBool || $expr.isBool;
  }
  -> ^(binop_p2 constval expr)
  | constval {
    $typing = $constval.typing;
    $isBool = $constval.isBool;
  }
  | (value binop_p2) => value binop_p2 expr {
    $typing = getTyping($value.typing, $expr.typing, $numExpr.start.getLine(), $binop_p2.text);
    $isBool = $value.isBool || $binop_p2.isBool || $expr.isBool;
  }
  -> ^(binop_p2 value expr)
  | value {
    $typing = $value.typing;
    $isBool = $value.isBool;
  }
  | (LPAREN expr RPAREN binop_p2) => LPAREN! var1=expr RPAREN! binop_p2^ var2=expr {
    $typing = getTyping($var1.typing, $var2.typing, $numExpr.start.getLine(), $binop_p2.text);
    $isBool = $var1.isBool || $binop_p2.isBool || $var2.isBool;
  }
  ;
  
// Conditional ops
binop_p0 returns [Boolean isBool]
  :	AND {
    $isBool = true;
    boolIsValid = true;
  }
  | OR {
    $isBool = true;
    boolIsValid = true;
  }
  | binop_p1 {
    if (!boolIsValid) {
     boolExprIsValid = false; 
    } 
    boolIsValid=false;
    $isBool = true;
  }
  ;
binop_p1
  :	(EQ | NEQ | LESSER | GREATER | LESSEREQ | GREATEREQ);   
 
// Numerical ops
binop_p2 returns [Boolean isBool]
  :	(MINUS | PLUS | binop_p3) {
    $isBool = false;
  }
  ;
binop_p3 returns [Boolean isBool]
  :	(MULT | DIV) {
    $isBool = false;
  }
  ;
	
constval returns [OperationObject typing, Boolean isBool]
  :	(fixedptlit) => fixedptlit {
    $typing = new OperationObject(true, symbolTable.getFixedPtType(), $fixedptlit.text);
    $isBool = false;
  }
	|	intlit {
	  $typing = new OperationObject(true, symbolTable.getIntType(), $intlit.text);
	  $isBool = false;
	}
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
	: (expr) => expr (COMMA expr)*
	-> ^(AST_EXPR_LIST expr+)
	|  expr (COMMA expr)*
  ->  ^(AST_EXPR_LIST expr+)
	;

value returns [OperationObject typing, String id, Boolean isBool]
  :	(ID LBRACK index_expr RBRACK LBRACK) => ID LBRACK index_expr RBRACK LBRACK index_expr RBRACK {
  	  SymbolTableEntry entry = symbolTable.get(strip($ID.text),CURRENT_SCOPE);
  	  if (entry != null && entry instanceof TigerVariable) {
  	    if (((TigerVariable)entry).getBackingType() == TigerPrimitive.INT_2D_ARRAY || ((TigerVariable)entry).getBackingType() == TigerPrimitive.FIXEDPT_2D_ARRAY) {
  	      $typing = new OperationObject(false, ((TigerVariable)entry).getType(), $value.text);
  	    } else {
  	      System.out.println("The variable "+$ID.text+ " on line "+$value.start.getLine() +" is not a 2D array");
  	    }
  	  } else {
  	    System.out.println("The variable "+$ID.text+ " on line "+$value.start.getLine() +" is not a variable");
  	  }
  	  $id = $ID.text;
  	  $isBool = false;
  	}
	|	(ID LBRACK) => ID LBRACK index_expr RBRACK {
		    SymbolTableEntry entry = symbolTable.get(strip($ID.text),CURRENT_SCOPE);
	      if (entry != null && entry instanceof TigerVariable) {
	        if (((TigerVariable)entry).getBackingType() == TigerPrimitive.INT_ARRAY || ((TigerVariable)entry).getBackingType() == TigerPrimitive.FIXEDPT_ARRAY) {
	          $typing = new OperationObject(false, ((TigerVariable)entry).getType(), $value.text);
	        } else {
	          System.out.println("The variable "+$ID.text+ " on line "+$value.start.getLine() +" is not a 1D array");
	        }
	      } else {
	        System.out.println("The variable "+$ID.text+ " on line "+$value.start.getLine() +" is not a variable");
	      }
	  $id = $ID.text;
	  $isBool = false;
	}
	|	ID {
      SymbolTableEntry entry = symbolTable.get(strip($ID.text),CURRENT_SCOPE);
      if (entry != null && entry instanceof TigerVariable) {
            $typing = new OperationObject(false, ((TigerVariable)entry).getType(), $value.text);
        } else {
          System.out.println("The variable "+$ID.text+ " on line "+$value.start.getLine() +" is not a variable or was never declared");
        }
      $id = $ID.text;
      $isBool = false;
    }
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
	: (numExpr (COMMA numExpr)*)?
	-> ^(AST_PARAM_LIST (numExpr+)?)
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
