import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      Wordle test = new Wordle("gamer");
  
      WordlePlayer player = new WordlePlayer(test, scanner);
      System.out.println(player.playGame());
    }
  }