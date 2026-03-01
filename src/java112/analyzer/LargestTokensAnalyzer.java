
package java112.analyzer;
import java.util.*;
import java.io.*;

/**
 * Finds unique tokens which are greater than or equal to a specified number
 * 
 * @author TheRealMarion1999
 */

 public class LargestTokensAnalyzer implements TokenAnalyzer {
  
    private Properties properties;
    private Set<String> largestTokens;
    private int minimumTokenLength;
    /**
     * Constructor for the class
     */
    public LargestTokensAnalyzer() {
        largestTokens = new TreeSet<String>();
    }
    /**
     * Constructor for the class
     * 
     * @param properties properties file taken from the second argument of the driver class
     */
    public LargestTokensAnalyzer(Properties properties) {
        this();
        this.properties = properties;
        setMinTokenLength();
    }

    /**
     * returns the set of largest tokens, used for testing
     * 
     * @return largest tokens
     */
    public Set<String> getLargestTokens() {
        return largestTokens;
    }

    /**
     * gets the path for the output file from properties
     * 
     * @return file path
     */
    public String getFilePath() {
        String filePath = properties.getProperty("output.directory") + properties.getProperty("output.file.largest.words");
        return filePath;
    }
    /**
     * gets the minimum token length from the properties file
     * 
     */
    public void setMinTokenLength() {
        minimumTokenLength = Integer.parseInt(properties.getProperty("largest.words.minimum.length"));
    }

    /**
     * writes each word from the largestTokens Set to a txt file 
     * 
     * @param inputFilePath path used for the input file
     */
    public void generateOutputFile(String inputFilePath) {
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(getFilePath())))) {
            for (String word : largestTokens) {
                writer.println(word);
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
     * adds each token of the input string array, which is from the text file used by FileAnalysis.readFile(), adds each token to the largestTokens set
     * @param token the currently input string from the array
     */
    public void processToken(String token) {
        if (token.length() >= minimumTokenLength) {
            largestTokens.add(token);
        }
    }
 }