import java.util.Scanner;


class WordlePlayer {
    Wordle game;
    Scanner scan;
    
    public WordlePlayer(Wordle game, Scanner scan) {
      this.game = game;
      this.scan = scan;
    }
    
    public int takeInput() {
    System.out.println("Enter a guess:");
      String guess = scan.next();
      return this.game.inputGuess(guess);
    }
  
    public String playGame() {
      int res = 0;
      while ((res = takeInput()) == 0) {
        
      }
  
      if (res == -1) {
        return "L";
      }
      else {
        return "W: " + res;
      }
    }
  }
