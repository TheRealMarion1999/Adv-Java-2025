
package java112.analyzer;
/**
 * Starts the program and not much else
 * 
 * @author TheRealMarion1999
 */
public class Driver {
  /**
   * The main function of the class
   * 
   * @param args arguments input through the terminal
   */
    public static void main(String[] args) {
      FileAnalysis analyzer = new FileAnalysis();
      analyzer.analyze(args);
    }
 }