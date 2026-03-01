package java112.labs1;
import java.io.*;
/**
 * outputs the contents of a .txt file to the terminal
 * 
 * @author TheRealMarion1999
 */
public class LabFour {
    /**
     * the main function of the class
     * 
     * @param args arguments input through command terminal
     */
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Please enter one argument on the command line");
            return;
        } else {
            LabFour labFour = new LabFour();
            labFour.run(args[0]);
        }
    }
    /**
     * run if the correct number of arguments were input on startup
     * 
     * @param input the name of the file to be read
     */
    public void run(String input) {
        BufferedReader inputReader = null;
        try {
            inputReader = new BufferedReader(new FileReader(input));

            String line = null;

            while (inputReader.ready()) {
                line = inputReader.readLine();
                System.out.println(line);
            }

        } catch (FileNotFoundException fileNotFound) {
            System.out.println("File Not Found. You blew it.");
            fileNotFound.printStackTrace();
        } catch (IOException ioException) {
            System.out.println("Input-Output Exception");
            ioException.printStackTrace();
        } catch (Exception exception) {
            System.out.println("There was a problem");
            exception.printStackTrace();
        } finally {
            try {
                if (inputReader != null) {
                    inputReader.close();
                }
            } catch (Exception exception) {
                System.out.println("There was a problem");
                exception.printStackTrace();
            }
        }

    }
}
