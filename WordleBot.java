import java.util.List;

public class WordleBot {
    public static final String ANSI_RESET = "\u001B[0m";
    
    List<String> answers;
    public WordleBot(List<String> answers) {
        this.answers = answers;
    }
    
    public String chooseBestWord() {
        return "salet";
    }

    public int playGame() {
        Wordle game = new Wordle(answers);
        int res = 0;
        while (res == 0) {
            String word = chooseBestWord();
            res = game.inputGuess(word);
        }
    
        return res;
      }

    public void runSeries(int n) {

    }
}
