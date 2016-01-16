import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) {
        System.out.println("Please enter a word:");

        Scanner sc = new Scanner(System.in);
        String word = sc.next();
        Game game = new Game(word);

        Prompter prompter = new Prompter(game);
        prompter.play();
    }
}
