/**
 * A TigerValue class represents a generic symbol or type in a Tiger program.
 * 
 * Valid types able to be represented in a TigerValue are: null, void function, 
 * int, fixedpt, int[], fixedpt[], int[][], fixedpt[][].
 */
public class TigerValue implements Comparable<TigerValue> {
	/**
	 * A null value.
	 */
	public static final TigerValue NULL = new TigerValue();
	/**
	 * A void function.
	 */
	public static final TigerValue VOID_FUNCTION = new TigerValue();
	/**
	 * The backing Java Object for this TigerValue.
	 */
	private Object value;

	/**
	 * A private constructor used only to handle NULL and VOID_FUNCTION.
	 */
	private TigerValue() {
		value = new Object();
	}
	
	/**
	 * Constructs a new TigerValue from a given non-null value.
	 * 
	 * @param value The given value.
	 */
	public TigerValue(Object value) {
		if (value == null) {
			throw new NullValueException();
		}
		
		this.value = value;
		validate();
	}

	/**
	 * Returns this TigerValue expressed as a Java Integer type.
	 * 
	 * @return This TigerValue expressed as a Java Integer type.
	 */
	public Integer asInteger() {
		return (Integer) value;
	}
	
	/**
	 * Returns this TigerValue expressed as a Java Integer[] type.
	 * 
	 * @return This TigerValue expressed as a Java Integer[] type.
	 */
	public Integer[] asIntegerArray() {
		return (Integer[]) value;
	}
	
	/**
	 * Returns this TigerValue expressed as a Java Integer[][] type.
	 * 
	 * @return This TigerValue expressed as a Java Integer[][] type.
	 */
	public Integer[][] asIntegerArrayArray() {
		return (Integer[][]) value;
	}
	
	/**
	 * Returns this TigerValue expressed as a Java Double type.
	 * 
	 * @return This TigerValue expressed as a Java Double type.
	 */
	public Double asDouble() {
		return (Double) value;
	}
	
	/**
	 * Returns this TigerValue expressed as a Java Double[] type.
	 * 
	 * @return This TigerValue expressed as a Java Double[] type.
	 */
	public Double[] asDoubleArray() {
		return (Double[]) value;
	}
	
	/**
	 * Returns this TigerValue expressed as a Java Double[][] type.
	 * 
	 * @return This TigerValue expressed as a Java Double[][] type.
	 */
	public Double[][] asDoubleArrayArray() {
		return (Double[][]) value;
	}
	
	/**
	 * Returns this TigerValue expressed as a Java Boolean type.
	 * 
	 * @return This TigerValue expressed as a Java Boolean type.
	 */
	public Boolean asBoolean() {
		return (Boolean) value;
	}

	@Override
	public int compareTo(TigerValue that) {
		if (this.isInt() && that.isInt()) {
			// Int-int comparison
			return this.asInteger().compareTo(that.asInteger());
		} else if ((this.isInt() && that.isFixedpt()) 
				|| (this.isFixedpt() && that.isInt())
				|| (this.isFixedpt() && that.isFixedpt())) {
			// Fixedpt-fixedpt comparison OR mixed int-fixedpt comparison; 
			// promote int to fixedpt for comparison
			return this.asDouble().compareTo(that.asDouble());
		} else {
			// No other comparisons make sense, throw exception
			throw new IncomparableException(this, that);
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (this.getClass() != o.getClass()) {
			return false;
		}
		
		// So, if we've come this far, this must be a TigerValue
		TigerValue that = (TigerValue) o;
		
		if ((this.isInt() && that.isFixedpt()) 
			|| (this.isFixedpt() && that.isInt())
			|| (this.isFixedpt() && that.isFixedpt())) {
			return (this.asDouble() - that.asDouble()) == 0;
		} else {
			// If all else fails, defer comparison to Object.equals()
			return this.value.equals(that.value);
		}
	}

	@Override
	public int hashCode() {
		return value.hashCode();
	}

	/**
	 * Checks if this TigerValue is of valid type; throws a InvalidValueException
	 * if the value fails to validate against TigerValue checks.
	 */
	private void validate() {
		if (!isBoolean()
			&& !isInt()
			&& !isFixedpt()
			&& !isIntArray()
			&& !isIntArrayArray()
			&& !isFixedptArray()
			&& !isFixedptArrayArray()
			&& !isNull()
			&& !isVoid()) {
			
			throw new InvalidValueException(value);
		}
	}
	
	/**
	 * Returns if the value is boolean.
	 * 
	 * @return True if the value or expression is a boolean type; false otherwise.
	 */
	public boolean isBoolean() {
		return value instanceof Boolean;
	}

	/**
	 * Returns if the value is an int type.
	 * 
	 * @return True if the value is an int type; false otherwise.
	 */
	public boolean isInt() {
		return value instanceof Integer;
	}
	
	/**
	 * Returns if the value is a fixedpt type.
	 * In Java, fixedpt types will be represented as doubles.
	 * 
	 * @return True if the value is a fixedpt type; false otherwise.
	 */
	public boolean isFixedpt() {
		return value instanceof Double;
	}

	/**
	 * Returns if the value is an array of int type.
	 * 
	 * @return True if the value is a one-dimensional int array; false otherwise.
	 */
	public boolean isIntArray() {
		return value instanceof Integer[];
	}
	
	/**
	 * Returns if the value is an array of arrays of int type.
	 * 
	 * @return True if the value is a two-dimensional int array; false otherwise.
	 */
	public boolean isIntArrayArray() {
		return value instanceof Integer[][];
	}
	
	/**
	 * Returns if the value is an array of fixedpt type.
	 * 
	 * @return True if the value is a one-dimensional fixedpt array; false otherwise.
	 */
	public boolean isFixedptArray() {
		return value instanceof Double[];
	}
	
	/**
	 * Returns if the value is an array of arrays of fixedpt type.
	 * 
	 * @return True if the value is a two-dimensional fixedpt array; false otherwise.
	 */
	public boolean isFixedptArrayArray() {
		return value instanceof Double[][];
	}

	/**
	 * Returns if the value is null.
	 * 
	 * @return True if the value is null; false otherwise.
	 */
	public boolean isNull() {
		return this.equals(NULL);
	}

	/**
	 * Returns if the value is a void function.
	 * 
	 * @return True if the value is a void function; false otherwise.
	 */
	public boolean isVoid() {
		return this.equals(VOID_FUNCTION);
	}

	@Override
	public String toString() {
		return isNull() ? "NULL" : isVoid() ? "VOID_FUNCTION" : String.valueOf(value);
	}
	
	/**
	 * An exception thrown when a value provided is not a valid type.
	 * Valid types include: null, void function, int, fixedpt, int[], 
	 * fixedpt[], int[][], fixedpt[][].
	 */
	private class InvalidValueException extends RuntimeException {
		private static final long serialVersionUID = 5027885730307151886L;

		/**
		 * An exception thrown when a value provided is not a valid type.
		 */
		private InvalidValueException(Object value) {
			super("Error: Value " + value.getClass().toString().toUpperCase() 
					+ " provided is of invalid type!");
		}
	}
	
	/**
	 * An exception thrown when a null value is passed into a 
	 * TigerValue's constructor.
	 */
	private class NullValueException extends RuntimeException {
		private static final long serialVersionUID = 4722560517569560784L;
		
		/**
		 * An exception thrown when a null value is passed into a 
		 * TigerValue's constructor.
		 */
		private NullValueException() {
			super("Error: Provided value cannot be null!");
		}
	}
	
	/**
	 * An exception thrown when two TigerValues cannot be compared.
	 */
	private class IncomparableException extends RuntimeException {
		private static final long serialVersionUID = -7270594830942550820L;
		
		/**
		 * An exception thrown when two TigerValues cannot be compared.
		 */
		private IncomparableException(TigerValue value1, TigerValue value2) {
			super("Error: " + value1 + " and " + value2 + " cannot be compared!");
		}
	}
}