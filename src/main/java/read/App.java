package read;

import java.io.File;


public class App 
{
    public static void main( String[] args )
    {
    	if (args.length != 2) {
    		System.out.println("Error:\n usage 'program inputFile outputFile'");
    		System.exit(1);
    	}
    	final String dir = System.getProperty("user.dir");
    	String inputFileName = args[0];
    	String outputFileNanme = args[1];
    	File inputFile = new File(inputFileName);
    	File outputFile = new File(outputFileNanme);
    	
    	if (inputFile.exists()) {
    		System.out.println("inputfile: OK" + " out " + outputFile.exists());
    		System.out.println(inputFile.getAbsolutePath());
    	} else {
    		System.out.println("No input file");
    	}
        System.out.println("current dir = " + dir);
    }
}