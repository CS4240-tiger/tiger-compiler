/**
 * A node for use in Tiger parse tree walking evaluation.
 */
public interface TigerNode {
	/**
	 * Evaluates the given node into a TigerValue.
	 * 
	 * @return The resultant TigerValue.
	 */
	TigerValue eval();
}