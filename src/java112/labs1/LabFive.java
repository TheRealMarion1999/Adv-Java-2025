package java112.labs1;

import java.io.FileWriter;
import java.io.IOException;
/**
 * creates a text file with the name of the first argument input through the terminal, with the contents of the second argument
 * 
 * @author TheRealMarion1999
 */

public class LabFive {
    /**
     * the main method of the class
     * 
     * @param args arguments input through command terminal
     */
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Please enter two arguments on the command line, a file name and a message");
            return;
        } else {
            LabFive fifthLab = new LabFive();
            fifthLab.run(args[0], args[1]);
        }
    }
    /**
     * Thing that runs after main has determined the correct number of arguments
     * 
     * @param fileName the desired name of the output file
     * @param message the contents of the output file
     */
    public void run(String fileName, String message) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(fileName);
            writer.write(message);
            System.out.println("success");
        } catch (IOException inputOutputError) {
            System.out.println("an error occurred.");
            inputOutputError.printStackTrace();
        } catch (Exception exception) {
            System.out.println("There was a problem");
            exception.printStackTrace();
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (Exception exception) {
                System.out.println("There was a problem");
                exception.printStackTrace();
            }
        }
    }
}
