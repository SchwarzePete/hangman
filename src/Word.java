public class Word {
    private String visibleWord;
    private String hiddenWord;

    public Word(String randomWord){
        visibleWord = randomWord;
        hiddenWord = randomWord.replaceAll("[A-Z]","_");
    }

    public void setVisibleWord(String word){
        visibleWord = word;
    }

    public String getVisibleWord(){
        return visibleWord;
    }

    public void setHiddenWord(String word){
        hiddenWord = word;
    }

    public String getHiddenWord(){
        return hiddenWord;
    }
}
