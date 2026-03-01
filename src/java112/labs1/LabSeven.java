package java112.labs1;
import java.io.*;
import java.util.*;

public class LabSeven {
    List<String> someStrings;

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Please enter one argument on the command line, an output file name");
            return;
        } else {
            LabSeven labSeven = new LabSeven();
            labSeven.run(args[0]);

        }
    }
    public void run(String filePathName) {
        someStrings = new ArrayList<>();
        someStrings.add("one");
        someStrings.add("two");
        someStrings.add("three");
        someStrings.add("four");
        someStrings.add("five");
        someStrings.add("six");
        someStrings.add("seven");
        someStrings.add("eight");
        someStrings.add("nine");
        someStrings.add("ten");
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