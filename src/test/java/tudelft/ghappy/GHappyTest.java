package tudelft.ghappy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GHappyTest {

    private GHappy gHappy;

    @BeforeEach
    public void initialize() {
        this.gHappy = new GHappy();
    }

    @Test
    public void empty() {
        boolean result = gHappy.gHappy("");
        Assertions.assertTrue(result);
    }

    @Test
    public void one() {
        boolean result = gHappy.gHappy("g");
        Assertions.assertFalse(result);
    }

    @Test
    public void twoHappy() {
        boolean result = gHappy.gHappy("gg");
        Assertions.assertTrue(result);
    }

    @Test
    public void twoUnhappy() {
        boolean result = gHappy.gHappy("gf");
        Assertions.assertFalse(result);
    }

    /**
     * Test examples
     */

    @Test
    public void example1() {
        boolean result = gHappy.gHappy("xxggxx");
        Assertions.assertTrue(result);
    }

    @Test
    public void example2() {
        boolean result = gHappy.gHappy("xxgxx");
        Assertions.assertFalse(result);
    }

    @Test
    public void example3() {
        boolean result = gHappy.gHappy("xxggyygxx");
        Assertions.assertFalse(result);
    }
}
