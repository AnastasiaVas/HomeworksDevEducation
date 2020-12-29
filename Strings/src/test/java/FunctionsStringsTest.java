import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class FunctionsStringsTest {

    public static FunctionsStrings funStrs;

    @BeforeAll
    public static void variable() {
         funStrs = new FunctionsStrings();
    }

    @ParameterizedTest
    @MethodSource("listOfSentences")
    void shortestWordTest(String input, int lengthOfShortestWord) {
        assertEquals(lengthOfShortestWord, funStrs.shortestWord(input));
    }

    private static Stream<Arguments> listOfSentences() {
        return Stream.of(
                arguments("I have an apple.", 1),
                arguments("There is a peach in my garden.", 1),
                arguments("The    cat    is    on   the tree   ", 2),
                arguments("  The,,,, cat is . on the /// tree.", 2),
                arguments("", 0)
        );
    }

    @Test
    void shortestWordTest_EXCEPTION(){
        Assertions.assertThrows(NumberFormatException.class, () -> {
           funStrs.shortestWord(" ,   /// .");
        });
    }
}
