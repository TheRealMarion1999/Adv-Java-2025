package java112.analyzer;
import java.util.*;
import java.io.*;
/**
 * Counts the number of unique Tokens (USING A HASHMAP THiS IS VERY IMPORTANT!!!)
 * 
 * @author TheRealMarion1999
 */
public class DistinctTokenCountsAnalyzer implements TokenAnalyzer {
    private Map<String, Integer> tokensCounter;
    private Properties properties;

    /**
     * constructor for the class
     */
    public DistinctTokenCountsAnalyzer() {
        tokensCounter = new TreeMap<String, Integer>();
    }

    /**
     * Constructor for the class
     * 
     * @param properties properties file taken from the second argument of the driver class
     */
    public DistinctTokenCountsAnalyzer(Properties properties) {
        this();
        this.properties = properties;
    }

    /**
     * returns the tokensCounter map
     * @return tokensCounter
     */
    public Map<String, Integer> getTokensCounter() {
        return tokensCounter;
    }

    /**
     * returns the properties file
     * @return properties file
     */
    public Properties getProperties() {
        return properties;
    }

    /**
     * sets the properties variable. Never use this.
     * @param value the new properties file
     */
    public void setProperties(Properties value) {
        properties = value;
    }

    /**
     * sets the tokens Counter map. Never use this.
     * 
     * @param value the new tokens map
     */
    public void setTokensCounter(Map<String, Integer> value) {
        tokensCounter = value;
    }

    /**
     * checks if the parameter is currently in the tokensCounter map, and adds it to the map if it's not and adds 1 to its value if it is.
     * 
     * @param token token taken from FileAnalysis, which is currently being processed.
     */
    public void processToken(String token) {
        if (tokensCounter.containsKey(token)) {
            int total = tokensCounter.get(token);
            tokensCounter.put(token, total + 1);
            //tokensCounter.computeIfPresent(token, (k, v) -> v + 1);
        } else {
            tokensCounter.put(token, 1);
        }
    }

    /**
     * writes each word in the Map to a text file
     * 
     * @param inputFilePath path used for the input file
     */
    public void generateOutputFile(String inputFilePath) {
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(getFilePath())))) {
            for (String key : tokensCounter.keySet()) {
                writer.println(key + "\t" + tokensCounter.get(key));
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
        String filePath = properties.getProperty("output.directory") + properties.getProperty("output.file.distinct.counts");
        return filePath;
    }

    /**
     * returns the tokensCounter Map
     * 
     * @return tokensCounter
     */
    public Map<String, Integer> getDistinctTokenCounts() {
        return tokensCounter;
    }
}
