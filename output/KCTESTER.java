import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class KCTESTER {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String content = "hi";
		try {
		content = new Scanner(new File("/Users/cevanish12/git/tiger-compiler/ir-output.tigir")).useDelimiter("\\Z").next();
		} catch (FileNotFoundException e) {
			System.out.println("file doesn't exist");
		}
		//System.out.println(content);
		CFGIntraBlockAllocation cfg = new CFGIntraBlockAllocation(content);
		cfg.findBlocks();
		//cfg.storeAllTemporaries();
		cfg.buildCFG();

	}

}
