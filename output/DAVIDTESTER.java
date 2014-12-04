import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/*
 * Adapted from KCTester.java
 */
public class DAVIDTESTER {

	public static void main(String[] args) {
		String content = "";
		Scanner scan;
		try {
		content = new Scanner(new File("/Users/dcbenas/Desktop/CFGoutput.txt")).useDelimiter("\\Z").next();
		} catch (FileNotFoundException e) {
			System.out.println("Read error.");
		}
		MIPSGenerator generator = new MIPSGenerator(content);
		generator.outputMIPS();
	}

}
