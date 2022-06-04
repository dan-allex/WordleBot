public class Wordle {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    
    String correctWord;
    String EMPTY_STR = "_____";
    String[] guesses = new String[6];
    int guessNum = 0;
  
    public Wordle(String correctWord) {
      this.correctWord = correctWord;
  
      for (int i = 0; i < this.guesses.length; i++) {
        this.guesses[i] = this.EMPTY_STR;
      }
    }
  
    // return 0: game still in progress
    // return -1: game lost
    // return else: guesses took
    public int inputGuess(String guess) {
      this.guessNum += 1;
      this.guesses[this.guessNum - 1] = guess;

      displayGame();


     if (guess.equals(this.correctWord)) {
        return this.guessNum;
      }
  
      if(this.guessNum == 6) {
          return -1;
      }
  
      return 0;
  }

  public int countChar(String word, char search) {
      int count = 0;
      for (int i = 0; i < word.length(); i++) {
        if (word.charAt(i) == search) {
            count++;
        } 
      }

      return count;
  }

  public int nthChar(String word, int index) {
    int count = 0;
    char c = word.charAt(index);
    for (int i = 0; i < word.length(); i++) {
        if (word.charAt(i) == c) {
            count++;
            if (i == index) {
                return count;
            }
        } 
    }
    return count;
  }

  public int charsInCorrectPos(String guess, String correct, char c) {
    int count = 0;
    for (int i = 0; i < correct.length(); i++) {
        if (correct.charAt(i) == c && guess.charAt(i) == c) {
            count++;
        } 
    }
    return count;
  }
  
    public void displayGame() {
      for (int i = 0; i < this.guesses.length; i++) {
        String word = this.guesses[i];
        String coloredWord = "";
        for (int j = 0; j < word.length(); j++) {
          if (word.charAt(j) == this.correctWord.charAt(j)) {
            coloredWord += ANSI_GREEN + word.charAt(j);
          }
          else if (this.nthChar(word, j) <= this.countChar(this.correctWord, word.charAt(j)) - charsInCorrectPos(word, this.correctWord, word.charAt(j))) {
            coloredWord += ANSI_YELLOW + word.charAt(j);
          }
          else {
            coloredWord += ANSI_BLACK + word.charAt(j);
          }
        }
        System.out.println(coloredWord);
      }
    }
  }
