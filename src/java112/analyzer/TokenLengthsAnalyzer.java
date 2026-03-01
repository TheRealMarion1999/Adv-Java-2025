package java112.analyzer;
import java.util.*;
import java.io.*;
/**
 * Determines the length frequency of the tokens in an input file and displays the frequency in an output file
 * 
 * @author TheRealMarion1999
 */

 public class TokenLengthsAnalyzer implements TokenAnalyzer {
    private Map<Integer, Integer> tokenLengths;
    private Properties properties;
    final int NUMBER_OF_ASTERISKS = 80;
    final String ASTERISKS = "********************************************************************************";

    public TokenLengthsAnalyzer() {
        tokenLengths = new TreeMap<Integer, Integer>();
    }

    public TokenLengthsAnalyzer(Properties properties) {
        this();
        this.properties = properties;
    }

    /**
     * writes each word in the distinct tokens TreeSet to a text file
     * 
     * @param inputFilePath path used for the input file
     */
    public void generateOutputFile(String inputFilePath) {
        //createHistogram();
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(getFilePath())))) {
            for (int counts : tokenLengths.keySet()) {
                writer.println(counts + "\t" + tokenLengths.get(counts));
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
     * counts a token's length and adds it to a Map
     * 
     * @param token the token input in FileAnalysis
     */
    public void processToken(String token) {
        if (tokenLengths.containsKey(token.length())) {
            int currentCount = tokenLengths.get(token.length());
            tokenLengths.put(token.length(), currentCount + 1);
        } else {
            tokenLengths.put(token.length(), 1);
        }
    }
    /**
     * returns the token lengths map
     * 
     * @return the map counting token lengths
     */
    public Map<Integer, Integer> getTokenLengths() {
        return tokenLengths;
    }

    

    /**
     * returns the path for the output file from properties
     * 
     * @return file path
     */
    public String getFilePath() {
        String filePath = properties.getProperty("output.directory") + properties.getProperty("output.file.token.lengths");
        return filePath;
    }

    //ugly! bad! should be fixed! >:v
    public void createHistogram() {
        TreeMap<Integer, String> histogram = new TreeMap<Integer, String>();
        for (int key : tokenLengths.keySet()) {
            histogram.put(tokenLengths.get(key), "*");
        }
        //this needs to be adjusted. Number of Asterisks must be dynamic.
        int usedAsterisks = NUMBER_OF_ASTERISKS;
        for (int key : histogram.descendingMap().keySet()) {
            if (usedAsterisks > 1) {
                histogram.put(key, ASTERISKS.substring(0, usedAsterisks));
                usedAsterisks /= 2;
            } else {
                usedAsterisks = 1;
                histogram.put(key, ASTERISKS.substring(0, usedAsterisks));
            }
        }
        TreeMap<Integer, String> realHistogram = new TreeMap<Integer, String>();
        for (int key : tokenLengths.keySet()) {
            for (int key2 : histogram.keySet()) {
                if (tokenLengths.get(key) == key2) {
                    realHistogram.put(key, histogram.get(key2));
                } 
            }
        }
        //???
        //if NUMBER_OF_ASTERISKS / i < 1:
            //used_asterisks = 1:
        // loop over the string writing in "*" x the number of used asterisks
        //write to histogram file with the formula "key + "\t" + "value"        
    }
 }