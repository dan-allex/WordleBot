import java.util.Scanner;


class WordlePlayer {
  public static final String ANSI_RESET = "\u001B[0m";
  public static final String ANSI_BLACK = "\u001B[30m";
  public static final String ANSI_WHITE = "\u001B[37m";
  public static final String ANSI_GREEN = "\u001B[32m";
  public static final String ANSI_YELLOW = "\u001B[33m";
    Wordle game;
    Scanner scan;
    
    public WordlePlayer(Wordle game, Scanner scan) {
      this.game = game;
      this.scan = scan;
    }
    
    public int takeInput() {
    System.out.println(ANSI_WHITE + "Enter a guess:");
      String guess = scan.next();
      return this.game.inputGuess(guess);
    }
  
    public String playGame() {
      int res = 0;
      while (res == 0) {
        res = takeInput();
      }
  
      if (res == -1) {
        return ANSI_WHITE + "L";
      }
      else {
        return ANSI_WHITE + "W: " + res;
      }
    }
  }
