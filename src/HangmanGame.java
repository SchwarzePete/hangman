import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class HangmanGame {
    Player player;
    Dictionary wordDictionary;
    Word randomlyChosenWord;
    Scanner playerInput;

    public HangmanGame(Scanner playerInput){
        System.out.println("Welcome to Hangman!");
        this.playerInput = playerInput;
        wordDictionary = new Dictionary();
    }

    private void setRandomlyChosenWord(String word){
        randomlyChosenWord = new Word(word);
    }

    private Word getRandomlyChosenWord(){
        return randomlyChosenWord;
    }

    private void setPlayer(Player player){
        this.player = player;
    }

    public Player getPlayer(){
        return player;
    }

    private void loadDictionary(){
       // wordDictionary.loadWords();
    };

    private void selectRandomWord(){
        Collections.shuffle(wordDictionary.words);
        randomlyChosenWord = new Word(wordDictionary.words.get(0).toUpperCase());
    }

    void setupGame(){
        createPlayer();
        loadDictionary();
        selectRandomWord();
    }

    private void checkGuess(Character guessedLetter) {
        if(player.getGuessedLetters().contains(guessedLetter)){
            System.out.println("Already guessed this letter!");
            checkGuess(askForLetter());
        }
        player.addGuessedLetter(guessedLetter);
        List<Integer> letterPositions = IntStream.iterate(randomlyChosenWord.getVisibleWord().indexOf(guessedLetter), index -> index >= 0,
                index -> randomlyChosenWord.getVisibleWord().indexOf(guessedLetter, index + 1)).boxed().collect(Collectors.toList());
        if(letterPositions.size() == 0){
            player.incrementIncorrectLetterCount();

        }
        else {
            StringBuilder word = new StringBuilder(randomlyChosenWord.getHiddenWord());

            for (int letterPosition : letterPositions) {
                word.setCharAt(letterPosition, guessedLetter);
            }
            randomlyChosenWord.setHiddenWord(word.toString());
        }
    }

    private Character askForLetter() {
        System.out.println("Guess a letter:");
        return validateLetter(playerInput.next());
    }

    private char validateLetter(String next) {
        return (next.length() == 1 && Character.isLetter(next.charAt(0))) ? next.charAt(0) : askForLetter();
    }

    private void produceOutput() {
       outputHangman();
       outputHiddenWord();
       player.outputPlayerDetails();
    }

    private void createPlayer() {
        System.out.println("Please enter your name: ");
        setPlayer(new Player(playerInput.next()));
    }


    private void outputHangman() {
        printTop();
        switch (player.getIncorrectLetterCount()){
            case 0:
                ;
            case 1:
                ;
            case 2:
                ;
            case 3:
                ;
            case 4:
                ;
            case 5:
                ;
            case 6:
                ;

        }
        printBottom();
    }

    private void printTop() {
        System.out.println("   =====|=");
    }

    private void printBottom() {
        System.out.println("_--------------_");
    }

    private void outputHiddenWord(){
        System.out.println("Word: " + randomlyChosenWord.getHiddenWord());
    }

    public boolean playGame() {
        while(player.getIncorrectLetterCount() < 7) {
            produceOutput();
            checkGuess(Character.toUpperCase(askForLetter()));
            if(!randomlyChosenWord.getHiddenWord().contains("_")){
                System.out.println("Congrats, you won!");
                return true;
            }
        }
        System.out.println("You have died... good game!");
        return true;
    }
}
