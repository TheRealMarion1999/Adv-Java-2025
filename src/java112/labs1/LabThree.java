package java112.labs1;

/**
 * This is the class used for Lab 3
 * Checks if a single input has been input through the command line, and prints the input to the console. It will not print to the console if there is more than one input.
 */

public class LabThree {
    /**
     * recieves a value from main()'s args parameter and prints it.
     * 
     * @param input an individual string pulled from the arguments of main()
     */
    public void run(String input) {
        System.out.println("input: " + input);
    }

    /**
     * Main method of LabThree 
     * @param args - an Array of arguments input by the command line
     */
    public static void main(String[] args) {
        //Probably could've also done it by checking if it *was* 1, but I just did it this way. Glass Half Empty, I suppose.
        if (args.length != 1) {
            System.out.println("Please enter one argument on the command line");
        } else {
            LabThree someObject = new LabThree();
            someObject.run(args[0]);
        }
    }
}