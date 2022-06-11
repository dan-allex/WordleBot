public class WordleBot {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_WHITE = "\u001B[37m";
      
    public WordleBot() {
    }
  
    public int inputGuess() {
        return 0;
    }
    
    public String playGame() {
        int res = 0;
        while (res == 0) {
          res = inputGuess();
        }
    
        if (res == -1) {
          return ANSI_RESET + "L";
        }
        else {
          return ANSI_RESET + "W: " + res;
        }
      }

    public void runSeries(int n) {
        
    }
}
