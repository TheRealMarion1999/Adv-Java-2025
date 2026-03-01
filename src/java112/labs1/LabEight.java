package java112.labs1;
import java.io.*;
import java.util.*;

public class LabEight {
    SortedSet<String> someStrings;

    public static void main(String[] args) {
        final Integer NUMBER_OF_ARGUMENTS = 1;
        if (args.length != NUMBER_OF_ARGUMENTS) {
            System.out.println("Please enter one argument on the command line, an output file name");
            return;
        } else {
            LabEight lab = new LabEight();
            lab.run(args[0]);

        }
    }
    public void run(String filePathName) {
        someStrings = new TreeSet<>();
        someStrings.add("one");
        someStrings.add("one");
        someStrings.add("five");
        someStrings.add("two");
        someStrings.add("four");
        someStrings.add("two");
        someStrings.add("three");
        someStrings.add("three");
        someStrings.add("four");
        someStrings.add("three");
        writeListToOutputFile(filePathName);
    }

    public void writeListToOutputFile(String filePathName) {
        PrintWriter printer = null;
        try {
            printer = new PrintWriter(new FileWriter(filePathName));

            for (String s : someStrings) {
                printer.println(s);
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
            System.out.println("an IO error occurred");
        } finally {
            try {
                if (printer != null) {
                    printer.close();
                }
            } catch (Exception exception) {
                exception.printStackTrace();
                System.out.println("There was an issue closing the program.");
            }
        }
    }
}