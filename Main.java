import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
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
      Wordle test = new Wordle(answers);
      Scanner scan = new Scanner(System.in);

      
  
      WordlePlayer player = new WordlePlayer(test,scan);
      System.out.println(player.playGame());

      
    }
  }