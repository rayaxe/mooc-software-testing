package tudelft.mirror;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MirrorTest {

    private Mirror mirror;

    @BeforeEach
    public void initialize() {
        this.mirror = new Mirror();
    }

    @Test
    public void empty() {
        String result = mirror.mirrorEnds("");
        Assertions.assertEquals("", result);
    }

    @Test
    public void one() {
        String result = mirror.mirrorEnds("a");
        Assertions.assertEquals("a", result);
    }

    @Test
    public void twoSame() {
        String result = mirror.mirrorEnds("aa");
        Assertions.assertEquals("aa", result);
    }

    @Test
    public void twoDifferent() {
        String result = mirror.mirrorEnds("ab");
        Assertions.assertEquals("", result);
    }

    /**
     * Test examples
     */

    @Test
    public void example1() {
        String result = mirror.mirrorEnds("abXYZba");
        Assertions.assertEquals("ab", result);
    }

    @Test
    public void example2() {
        String result = mirror.mirrorEnds("abca");
        Assertions.assertEquals("a", result);
    }

    @Test
    public void example3() {
        String result = mirror.mirrorEnds("aba");
        Assertions.assertEquals("aba", result);
    }
}
