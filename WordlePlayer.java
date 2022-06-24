import java.util.Scanner;


class WordlePlayer {
  public static final String ANSI_RESET = "\u001B[0m";
  public static final String ANSI_GREEN = "\u001B[32m";
  public static final String ANSI_RED = "\u001B[31m";

    Wordle game;
    Scanner scan = new Scanner(System.in);
    
    
    public WordlePlayer(Wordle newGame, Scanner newScan) {
      game = newGame;
      scan = newScan;
     
    }
   
    public int takeInput() {
      System.out.println(ANSI_GREEN + "Enter a guess:" + ANSI_RESET);
      String guess = scan.next();
      
      return game.inputGuess(guess);
    }
    
    public String playGame() {
      int res = 0;
      while (res == 0) {
           res = takeInput();
      }
       if (res == -1) {
          return "";
      }
      
      else {
         return ANSI_GREEN + "You won in " + res + " 4 tries";
        }
     }
  }
