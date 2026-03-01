
package java112.analyzer;
import java.io.*;
import java.util.*;
import java.time.*;
import java.text.SimpleDateFormat;

/**
 * 
 * @author TheRealMarion1999
 */
public class FileSummaryAnalyzer implements TokenAnalyzer {


    private int totalTokensCount = 0;
    private Properties properties;
    
    /**
     * Constructor for the class
     */
    public FileSummaryAnalyzer() {
        
    }
    /**
     * Constructor for the class
     * 
     * @param properties properties file taken from the second argument of the driver class
     */
    public FileSummaryAnalyzer(Properties properties) {
        this();
        this.properties = properties;
    }

    /**
     * gets the total token count
     * 
     * @return integer representing token count
     */
    public int getTotalTokensCount() {
        return totalTokensCount;
    }
    /**
     * adds each token of the input string array, which is from the text file used by FileAnalysis.readFile(), adds each token to the distinctTokens array
     * @param token the currently input string from the array
     */
    public void processToken(String token) {
        //possibly add a constant array of "accepted single-character phrases", to weed out weird things in specifically the Bee Movie script.
        totalTokensCount++;
    }

    /**
     * writes a file summarizing the file size and token count.
     * 
     * @param inputFilePath path used for the input file
     */
    public void generateOutputFile(String inputFilePath) {
        Date currDateTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("EE LLL dd HH:mm:ss zz YYYY");
        String formattedDate = formatter.format(currDateTime);
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(getFilePath())));) {
            File file = new File(inputFilePath);
            String formattedDate2 = formatter.format(file.lastModified());
            //use some m a t h to make a box (it will be cute!)
            //THE TESTS DON'T LIKE MY CUTE BOX THIS IS CRINGE!
            writer.println(properties.getProperty("application.name"));
            writer.println(properties.getProperty("author"));
            writer.println(properties.getProperty("author.email.address"));
            writer.println("▯File Path: " + file.getPath()); //I'm not quite sure what you wanted from this one...
            writer.println("▯Path: " + file.getAbsolutePath());
            writer.println("▯Time of Analysis: " + formattedDate);
            writer.println("▯File Last Modified: " + formattedDate2);
            writer.println("▯File size: " + file.length());
            writer.println("▯Token Count: " + totalTokensCount);
            //writer.println("▯===================================================================▯"); test still being lame and standing in the way of my fun... >:(
        } catch(IOException ioException) {
            ioException.printStackTrace();
            System.out.println("An IO error occurred during input!");
        } catch(Exception exception) {
            exception.printStackTrace();
            System.out.println("A general error occurred during input!");
        }
    }

    /**
     * unused function designed to calculate the needed number of spaces before placing a "▯" to create the ASCII window.
     */
    public void asciiSpacesAdder() {
        
    }
    /**
     * gets the path for the output file from properties
     * 
     * @return file path
     */
    public String getFilePath() {
        String filePath = properties.getProperty("output.directory") + properties.getProperty("output.file.summary");
        return filePath;
    }
}