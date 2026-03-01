package java112.analyzer;
import java.io.*;
import java.util.*;

/**
 * 
 * @author TheRealMarion1999
 */
public class DistinctTokensAnalyzer implements TokenAnalyzer{


    /**
     * TreeSet to contain words in
     */
    private SortedSet<String> distinctTokens;

    private Properties properties;
    
    /**
     * Constructor for the class
     * 
     * @param properties properties file taken from the second argument of the driver class
     */
    public DistinctTokensAnalyzer(Properties properties) {
        this();
        this.properties = properties;
    }
    /**
     * constructor for the class
     */
    public DistinctTokensAnalyzer() {
        distinctTokens = new TreeSet<>();
    }

    /**
     * This is not used, it exists entirely to fulfill test requirements.
     * 
     * There just really wasn't a place for it...
     * @return Set
     */
    public Set getDistinctTokens() {
        return distinctTokens;
    }

    /**
     * adds each token of the input string array, which is from the text file used by FileAnalysis.readFile(), adds each token to the distinctTokens array
     * @param token the currently input string from the array
     */
    public void processToken(String token) {
        //possibly add a constant array of "accepted single-character phrases", to weed out weird things in specifically the Bee Movie script.
        distinctTokens.add(token);
    }

    /**
     * writes each word in the distinct tokens TreeSet to a text file
     * 
     * @param inputFilePath path used for the input file
     */
    public void generateOutputFile(String inputFilePath) {
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(getFilePath())))) {
            for (String words : distinctTokens) {
                writer.println(words);
            }
        } catch(IOException ioException) {
            System.out.println("An IO error occurred during input!");
            ioException.printStackTrace();
        } catch(Exception exception) {
            System.out.println("A general error occurred during input!");
            exception.printStackTrace();
        }
        
    }
    /**
     * gets the path for the output file from properties
     * 
     * @return file path
     */
    public String getFilePath() {
        String filePath = properties.getProperty("output.directory") + properties.getProperty("output.file.distinct");
        return filePath;
    }
}