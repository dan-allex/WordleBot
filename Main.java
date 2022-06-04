import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

  private static final List<String> readLines(String inputfile) {
    try {
        return Files.readAllLines(Paths.get(inputfile));
    } catch (IOException e) {
        return Collections.singletonList("Corrupted");
    }
}
    public static void main(String[] args) {
      List<String> answers = readLines("answers.txt");
      Scanner scanner = new Scanner(System.in);
      Wordle test = new Wordle(answers);
  
      WordlePlayer player = new WordlePlayer(test, scanner);
      System.out.println(player.playGame());
    }
  }