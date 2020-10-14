import java.util.Scanner;

public class HangmanRunner {

    public static void main(String[] args) {
        try(Scanner playerInput = new Scanner(System.in)) {
            System.out.println("Welcome to Hangman!  Would you like to play?!  Yes/No?");
            if(positive(playerInput.next())){
                HangmanGame game = new HangmanGame(playerInput);
                game.setupGame();
                if(game.playGame()){
                    //play again feature
                }
            }
        }
    }

    private static boolean positive(String input) {
        return input.toLowerCase().equals("yes") || input.toLowerCase().equals("y");
    }
}
