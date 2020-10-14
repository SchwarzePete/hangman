import java.util.HashSet;
import java.util.Set;

public class Player {
    private String name;
    private int incorrectLetterCount = 0;
    private Set<Character> guessedLetters;

    public Player(String name){
        this.name = name;
        guessedLetters = new HashSet();
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void incrementIncorrectLetterCount(){
        incorrectLetterCount++;
    }

    public void addGuessedLetter(Character guessedLetter){
        guessedLetters.add(guessedLetter);
    }

    public int getIncorrectLetterCount(){
        return incorrectLetterCount;
    }


    public Set<Character> getGuessedLetters() {
        return guessedLetters;
    }

    public void setGuessedLetters(Set<Character> guessedLetters) {
        this.guessedLetters = guessedLetters;
    }

    void outputPlayerDetails(){
        System.out.println("Guessed Letters#:          "  + getGuessedLetters().toString());
        System.out.println("Incorrect Guess #: " + getIncorrectLetterCount());
    }
}
