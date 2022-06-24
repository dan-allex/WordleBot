import java.util.List;
import java.util.Random;

public class Wordle {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RED = "\u001B[31m";
    
   
    String correctWord;
    Random rand;
    List<String> answers;
    String EMPTY_STR = "_____";
    String[] guesses = new String[6];
    int guessNum = 0;
  
    public Wordle(List<String> newAnswers) {
      answers = newAnswers;
      this.rand = new Random();
      correctWord = answers.get(this.rand.nextInt(this.answers.size()));
      for (int i = 0; i < this.guesses.length; i++) {
        guesses[i] = EMPTY_STR;
      }
    }
  
    public int inputGuess(String guess) {
      java.util.HashSet<String> wordSet = new java.util.HashSet<String>();
      for(String ans: answers) {
        wordSet.add(ans);
       
      }

      if(!wordSet.contains(guess)) {
        if(guess.length() == 5) {
        System.out.println(ANSI_RED + "Enter a valid word");
        return 0;
        }
      }
      if(guess.length() > 5) {
        System.out.println(ANSI_RED + "Enter a 5 letter word");
        return 0;
      }

      if(guess.length() < 5) {
        System.out.println(ANSI_RED + "Word is too short");
        return 0;
      }

    guessNum += 1;
    guesses[guessNum - 1] = guess;
      displayGame();

      if (guess.equals(correctWord)) {
        return guessNum;
      }

      else if(guessNum == 6) {
        this.guesses[guessNum - 1] = guess;
        System.out.println(ANSI_RED + "you lost. The correct word is " + correctWord);
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
        String coloredWord = ANSI_RESET;
        for (int j = 0; j < word.length(); j++) {
          if (word.charAt(j) == this.correctWord.charAt(j)) {
            coloredWord += ANSI_GREEN + word.charAt(j);
          }
          else if (this.nthChar(word, j) <= this.countChar(this.correctWord, word.charAt(j)) - charsInCorrectPos(word, this.correctWord, word.charAt(j))) {
            coloredWord += ANSI_YELLOW + word.charAt(j);
          }
          else {
            coloredWord += ANSI_RESET + word.charAt(j);
          }
        }
        System.out.println(coloredWord);
      }
    }
  }
