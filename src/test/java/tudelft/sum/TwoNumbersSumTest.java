package tudelft.sum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ArgumentConverter;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TwoNumbersSumTest {

    @ParameterizedTest(name = "{0}: [{1}] + [{2}] = [{3}]")
    @CsvSource(value = {
            "'zero first and second';0;0;0",
            "'zero first';0;1;1",
            "'zero second';1;0;1",
            "'sum two';1;1;2",
            "'sum nine';4;5;9",
            "'sum ten';5;5;1,0",
            "'sum ten (zero first)';0;1,0;1,0",
            "'sum ten (zero second)';1,0;0;1,0",
            "'sum twenty';1,0;1,0;2,0",
    }, delimiter = ';')
    void addTwoNumbers(String partition,
                       @ConvertWith(IntegerArrayListConverter.class) ArrayList<Integer> first,
                       @ConvertWith(IntegerArrayListConverter.class) ArrayList<Integer> second,
                       @ConvertWith(IntegerArrayListConverter.class) ArrayList<Integer> expected) {
        ArrayList<Integer> actual = new TwoNumbersSum().addTwoNumbers(first, second);
        Assertions.assertIterableEquals(expected, actual);
    }

    /**
     * Custom {@link ArgumentConverter} to convert a comma-separated string into an {@code ArrayList<Integer>}.
     *
     * @see <a href="https://junit.org/junit5/docs/current/user-guide/#writing-tests-parameterized-tests-argument-conversion-explicit">JUnit 5 User Guide - 3.14.4. Argument Conversion</a>
     */
    static class IntegerArrayListConverter implements ArgumentConverter {
        @Override
        public Object convert(Object o, ParameterContext parameterContext) throws ArgumentConversionException {
            String input = (String) o;
            return Stream.of(input.split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toCollection(ArrayList::new));
        }
    }
}
