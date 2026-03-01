package java112.analyzer;

/**
 * Interface to be used with FileSummaryAnalyzer and DistinctTokensAnalyzer
 */
public interface TokenAnalyzer {

    /**
     * processes a token
     * @param token the token which is being passed from FileAnalysis
     */
    public abstract void processToken(String token);

    /**
     * generates an output file
     * 
     * @param inputFilePath the path to the input file
     */
    public abstract void generateOutputFile(String inputFilePath);

    public default void bweh() {
        System.out.println("bweh");
    }
}