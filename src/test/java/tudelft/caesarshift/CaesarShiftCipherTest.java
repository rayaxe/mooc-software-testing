package tudelft.caesarshift;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CaesarShiftCipherTest {

    private CaesarShiftCipher cipher;

    @BeforeEach
    public void initialize() {
        this.cipher = new CaesarShiftCipher();
    }

    @ParameterizedTest(name = "{0}: ({1}, {2}) = {3}")
    @CsvSource({ "'no-shift',a,0,a", "'shift-one',a,1,b", "'shift-minus-one',a,-1,z", "'shift-max',a,26,a", "'shift-max-minus-one',a,25,z" })
    public void one(String partition, String message, int shift, String expected) {
        String actual = cipher.caesarShiftCipher(message, shift);
        Assertions.assertEquals(expected, actual);
    }
}
