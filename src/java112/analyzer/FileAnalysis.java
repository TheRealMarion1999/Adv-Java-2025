package java112.analyzer;

import java.io.*;
import java.util.*;

import java112.utilities.PropertiesLoader;

import java.io.FileNotFoundException;
/**
 * Reads and activates a text file input in the Driver class, sending its information to DistinctTokensAnalyzer and FileSummaryAnalyzer classes
 * 
 * @author TheRealMarion1999
 */
public class FileAnalysis implements PropertiesLoader {
    /**
     * the required number of arguments
     */
    private static final int NUMBER_OF_ARGUMENTS = 2;

    private List<TokenAnalyzer> analyzerList;

    
    /**
     * checks for the amount of arguments in the 
     * @param arguments inherited from Drivers "args" variable. Input from the Terminal
     */
    public void analyze(String[] arguments) {
        if (arguments.length != NUMBER_OF_ARGUMENTS) {
            System.out.println("This is the inccorect number of arguments");
            return;
        } else {
            Properties properties = loadProperties(arguments[1]);
            createAnalyzers(properties);
            openInputFile(arguments[0]);
            
        }
    }
    /**
     * Initializes the FileSummaryAnalyzer and DistinctTokensAnalyzer classes.
     * 
     */
    private void createAnalyzers(Properties properties) {
        analyzerList = new ArrayList<TokenAnalyzer>();
        analyzerList.add(new FileSummaryAnalyzer(properties));
        analyzerList.add(new DistinctTokensAnalyzer(properties));
        analyzerList.add(new DistinctTokenCountsAnalyzer(properties));
        analyzerList.add(new LargestTokensAnalyzer(properties));
        analyzerList.add(new TokenLengthsAnalyzer(properties));
        analyzerList.add(new TokenLocationSearchAnalyzer(properties));
        //analyzerList.add(new LexicalDensityAnalyzer(properties));
        analyzerList.add(new CustomAnalyzer(properties));
    }
    /**
     * opens the file input by the parameter.
     * 
     * @param inputFilePath Path for the input file. Inherited from Analyze().
     */
    private void openInputFile(String inputFilePath) {
        try (FileReader file = new FileReader(inputFilePath)) {
            //ANIMATE THIS (VERY IMPORTANT!!!)
            System.out.println("Girls are now analyzing, please wait warmly...");
            readfile(file, inputFilePath);
            System.out.println("Analysis Complete!");

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
     * reads the file associated with inputFilePath and splits it into individual tokens of non-special characters.
     * Due to issues with certain files, I recommend using [^a-zA-Z0-9'_] if you want to keep apostrophes
     * 
     * @param reader A FileReader which will read the file.
     * @param inputFilePath Path for the input file. Inherited from openInputFile().
     * @throws FileNotFoundException thrown when the input file does not exist
     * @throws IOException thrown when there is an error with the input file
     * @throws Exception thrown during a general error.
     */
    private void readfile(FileReader reader, String inputFilePath) throws FileNotFoundException, IOException, Exception {
        try (BufferedReader inputReader = new BufferedReader(reader)) {

            String line = null;
            while (inputReader.ready()) {
                line = inputReader.readLine();
                //gonna have to find a way to un-split words with an apostrophe
                parseLines(line.split("[^a-zA-Z0-9_]"));
                
            }
            writeOutputFiles(inputFilePath);
        }
    }

    /**
     * initiates writing information to an output file using the FileSummaryAnalyzer class and the DistinctTokensAnalyzer class.
     * 
     * @param inputFilePath Path for the input file. Inherited from readFile().
     */
    private void writeOutputFiles(String inputFilePath) {
        for (TokenAnalyzer analyzer : analyzerList) {
            analyzer.generateOutputFile(inputFilePath);;
        }
    }

    /**
     * passes a string array created by readFile() to the distributeTokens method
     * 
     * @param line A string array created by readFile()
     */
    private void parseLines(String[] line) {
        for (String token : line) {
            if (!token.equals("")) {
                distributeTokens(token);
            }
        }
    }

    /**
     * loops through tokens for each analyzer in the list, processing each of them
     * 
     * @param token the token gotten from the file
     */
    private void distributeTokens(String token) {
        for (TokenAnalyzer analyzer : analyzerList) {
            analyzer.processToken(token);
        }  
    }
 }