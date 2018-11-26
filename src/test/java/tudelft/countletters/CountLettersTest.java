package tudelft.countletters;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CountLettersTest {

    @Test
    public void multipleMatchingWords() {
        int words = new CountLetters().count("cats|catr|dogs");
        Assertions.assertEquals(3, words);
    }

    @Test
    public void lastWordDoesNotMatch() {
        int words = new CountLetters().count("cat|dog");
        Assertions.assertEquals(0, words);
    }

}