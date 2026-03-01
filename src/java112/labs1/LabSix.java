package java112.labs1;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.*;

/**
 * reads a .txt file from the first argument and copies its contents to a .txt file from the second argument.
 * 
 * @author TheRealMarion1999
 */

public class LabSix {
    /**
     * the main method of the class
     * 
     * @param args arguments input through command terminal
     */
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Please enter two arguments on the command line, an input file name and an output file name");
            return;
        } else {
            LabSix sixthLab = new LabSix();
            sixthLab.run(args[0], args[1]);
        }
    }
    /**
     * run if the correct number of arguments were input on startup
     * 
     * @param inputFileName the name of the file to be read
     * @param outputFileName the name of the file to created
     */
    public void run(String inputFileName, String outputFileName) {
        try(BufferedReader inputReader = new BufferedReader(new FileReader(inputFileName)); 
            BufferedWriter outputWriter = new BufferedWriter(new FileWriter(outputFileName))) {

            String line = null;

            while (inputReader.ready()) {
                line = inputReader.readLine();
                outputWriter.write(line);
                outputWriter.newLine();
            }

        } catch (FileNotFoundException fileNotFound) {
            System.out.println("File Not Found, that stinks.");
            fileNotFound.printStackTrace();
        } catch (IOException ioException) {
            System.out.println("Input-Output Exception");
            ioException.printStackTrace();
        } catch (Exception exception) {
            System.out.println("There was a problem");
            exception.printStackTrace();
        }
    }

    
}