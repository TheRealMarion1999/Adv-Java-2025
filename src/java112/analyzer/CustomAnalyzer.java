
package java112.analyzer;
import java.util.*;
import java.io.*;

/**
 * Finds unique tokens which are greater than or equal to a specified number
 * 
 * @author TheRealMarion1999
 */

 public class CustomAnalyzer implements TokenAnalyzer {
    final String MAGIC_CHARACTER = "m";
    private Properties properties;
    private int magicCharacterOccurances = 0;
    private int totalCharacterOccurances = 0;
    /**
     * Constructor for the class
     */
    public CustomAnalyzer() {
        
    }
    /**
     * Constructor for the class
     * 
     * @param properties properties file taken from the second argument of the driver class
     */
    public CustomAnalyzer(Properties properties) {
        this();
        this.properties = properties;
    }

    /**
     * gets the path for the output file from properties
     * 
     * @return file path
     */
    public String getFilePath() {
        String filePath = properties.getProperty("output.directory") + properties.getProperty("output.file.token.custom");
        return filePath;
    }

    /**
     * writes each word from the largestTokens Set to a txt file 
     * 
     * @param inputFilePath path used for the input file
     */
    public void generateOutputFile(String inputFilePath) {
        float floatMagic = magicCharacterOccurances;
        float floatTotal = totalCharacterOccurances;
        double percentage = (floatMagic / floatTotal) * 100.00;
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(getFilePath())))) {
            writer.println("Out of " + totalCharacterOccurances + " characters, " + magicCharacterOccurances + " were the magic character.");
            writer.println("Magic Character: " + MAGIC_CHARACTER);
            writer.println("Percent of magic: " + percentage + "%");
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
        for (Character chara : token.toCharArray()) {
            if (Character.toString(chara).equals(MAGIC_CHARACTER)) {
                totalCharacterOccurances++;
                magicCharacterOccurances++;
            } else {
                totalCharacterOccurances++;
            }
        }
    }
 }