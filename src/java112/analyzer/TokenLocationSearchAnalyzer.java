package java112.analyzer;
import java.util.*;
import java.io.*;

/**
 * determines the location of words determined by search_tokens.txt
 * 
 * @author TheRealMarion1999
 */
public class TokenLocationSearchAnalyzer implements TokenAnalyzer {
    final int MAX_LINE_LENGTH = 80;
    private Map<String, List<Integer>> foundLocations;
    private Properties properties;
    private int currentTokenLocation;

    public TokenLocationSearchAnalyzer() {
        foundLocations = new TreeMap<String, List<Integer>>();
        currentTokenLocation = 0;
    }

    public TokenLocationSearchAnalyzer(Properties properties) {
        this();
        this.properties = properties;
        loadSearchFile("config/" + properties.getProperty("classpath.search.tokens"));
    }

    /**
     * Determines if a token is part of the list of searched words and marks its location
     * 
     * @param token the token in put during fileAnalysis
     */
    public void processToken(String token) {
        currentTokenLocation++;
        for (String searchedWords : foundLocations.keySet()) {
            if (token.equals(searchedWords)) {
                foundLocations.get(searchedWords).add(currentTokenLocation);
            }
        }
    }

    /**
     * loads the search file and prepares it for reading
     * 
     * @param inputFilePath path to the text file used for searching. input through properties
     */
    private void loadSearchFile(String inputFilePath) {
        try (FileReader file = new FileReader(inputFilePath)) {
            readfile(file, inputFilePath);

        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("There is no such file!");
            fileNotFoundException.printStackTrace();
        } catch (IOException ioException) {
            System.out.println("An IO error occurred during input!");
            ioException.printStackTrace();
        } catch (Exception exception) {
            System.out.println("A general error occurred during input!");
            exception.printStackTrace();
        }
    }

    /**
     * reads the search file and puts its contents into foundLocations
     * @param reader a File Reader
     * @param inputFilePath the input file path
     * @throws FileNotFoundException from loadSearchFile
     * @throws IOException from loadSearchFile
     * @throws Exception from loadSearchFile
     */
    private void readfile(FileReader reader, String inputFilePath) throws FileNotFoundException, IOException, Exception {
        try (BufferedReader inputReader = new BufferedReader(reader)) {

            String line = null;
            while (inputReader.ready()) {
                line = inputReader.readLine();
                if (!line.equals("")) {
                    foundLocations.put(line, new ArrayList<Integer>());
                }
                
            }
        }
    }

    /**
     * writes each line in the foundLocations map to a text file
     * 
     * @param inputFilePath path used for the input file
     */
    public void generateOutputFile(String inputFilePath) {
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(getFilePath())))) {
            for (String key : foundLocations.keySet()) {
                //int lineStart = 0;
                writer.println(key + " =");
                List<Integer> brackets = foundLocations.get(key);
                //writer.println();
                writer.print("[");
                goodStringSlicer(brackets, writer);
                //writer.println(brackets2.toString());
                //badStringSlicer(brackets, writer);
                writer.println("]");
                writer.println();
                //absolutely horrid and disgusting way of doing it, but it does do it.
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
     * 
     * gets the length of each input
     * 
     * @param list the list of integers put in through generateOutputFile
     * @param writer the file writer used by generateOutputFile
     */
    public void goodStringSlicer(List<Integer> list, PrintWriter writer) {
        int charaCount = 1;
        for (int entry : list) {
            String entryAsString = entry + ", ";
            charaCount = charaCount + entryAsString.length();
            if (charaCount < MAX_LINE_LENGTH) {
                writer.print(entryAsString);
                //entryAsString = "\n" + entryAsString;
                //charaCount = 0;
            } else {
                //brackets2.add(entryAsString);
                charaCount = 0;
                writer.println();
                writer.print(entryAsString);
                charaCount = entryAsString.length();
            }
        }
    }

    /**
     * returns the path for the output file from properties
     * 
     * @return file path
     */
    public String getFilePath() {
        String filePath = properties.getProperty("output.directory") + properties.getProperty("output.file.token.search.locations");
        return filePath;
    }

    public Map<String, List<Integer>> getFoundLocations() {
        return foundLocations;
    }
}