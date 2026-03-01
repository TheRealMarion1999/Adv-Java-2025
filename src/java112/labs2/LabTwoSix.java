package java112.labs2;
import java.util.*;
import java.io.*;

/**
 * 
 * @author TheRealMarion1999
 */
public class LabTwoSix {
    private Properties properties;

    public static void main(String[] args) {
        final int NUMBER_OF_ARGS = 1;
        if (args.length != NUMBER_OF_ARGS) {
            return;
        } else {
            LabTwoSix lab26 = new LabTwoSix();
            lab26.run(args);
        }
    }

    public void loadProperties(String propertiesFilePath)  {
        properties = new Properties();
        try {
            properties.load(this.getClass().getResourceAsStream(propertiesFilePath));
        } catch(IOException ioe) {
            System.out.println("Can't load the properties file");
            ioe.printStackTrace();
        } catch(Exception e) {
            System.out.println("Problem: " + e);
            e.printStackTrace();
        }
    }

    public void run(String[] args) {
        loadProperties(args[0]);
        String pipis = properties.getProperty("virus");
        System.out.println(pipis);
        pipis = properties.getProperty("website");
        System.out.println(pipis);
    }
}