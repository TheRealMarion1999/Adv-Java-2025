package java112.analyzer;
import java.io.*;
import java.util.*;

public class LexicalDensityAnalyzer implements TokenAnalyzer{
    private static final String[] NON_LEXICAL_WORDS = {
        "to", "he", "she", "we", "they", 
        "are", "aren't", "the", "at", "this", 
        "from", "our", "than", "any", "on", "it's",
        "up", "us", "over", "and", "be", "that", "his",
        "her", "hers", "him", "which", "where", "because",
        "is", "of", "a", "its", "it", "I", "I'll", "an", 
        "for", "your", "in", "had", "as", "so", "So", "The"};
    
    private List<String> lexicalWords;
    private float totalWordsCount;
    private Properties properties;

    LexicalDensityAnalyzer() {
        lexicalWords = new ArrayList<String>();
    }

    LexicalDensityAnalyzer(Properties properties) {
        this();
        this.properties = properties;
    }
    

    public void processToken(String token) {
        if (lexicalChecker(token)) {
            totalWordsCount++;
        } else {
            totalWordsCount++;
            lexicalWords.add(token);
        }
        
    }

    public void generateOutputFile(String inputFilePath) {
        double percentLexical = (lexicalWords.size() / totalWordsCount) * 100.0;
        int finalPercent = (int) percentLexical;
        int finalWordsCount = (int) totalWordsCount;
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(getFilePath())))) {
            writer.println("The document uses " + lexicalWords.size() + " lexical words and has " + finalWordsCount + " words. It is " + finalPercent + "% lexical");
            for (String word : lexicalWords) {
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

    public boolean lexicalChecker(String token) {
        for (String b : NON_LEXICAL_WORDS) {
            if (token.equals(b)) {
                return true;
            }
        }
        return false;
    }

    /**
     * returns the path for the output file from properties
     * 
     * @return file path
     */
    public String getFilePath() {
        String filePath = properties.getProperty("output.directory") + properties.getProperty("output.file.token.lexical.density");
        return filePath;
    }
}