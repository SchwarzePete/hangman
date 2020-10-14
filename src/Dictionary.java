import java.util.ArrayList;
import java.util.List;

public class Dictionary {
    List<String> words = new ArrayList<>();

    public Dictionary(){
        words.add("Test");
        words.add("Begin");
        words.add("Real");
        words.add("Bagel");
    }

    private void loadWords(){
        words.clear();
        //loading
    }
}
