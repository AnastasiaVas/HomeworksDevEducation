package Homework1Tests;

import Homework1.Functions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class FunctionsTest {

    static Functions functions;

    @BeforeAll
    static void variablesInitialization(){
        functions = new Functions();
    }

    @Tag("dayNumToString")
    static Stream<Arguments> dayNumToStringValues(){
        return Stream.of(
                arguments(1, "Sunday"),
                arguments(3, "Tuesday"),
                arguments(6, "Friday")
        );
    }

    @Tag("dayNumToString")
    @ParameterizedTest
    @MethodSource("dayNumToStringValues")
    void dayNumToStringTest (int num, String expected){
        String actual = functions.dayNumToString(num);
        Assertions.assertEquals(expected, actual);
    }

    @Tag("dayNumToString")
    @ParameterizedTest
    @ValueSource(ints = {0, -1, -37, 100, 53})
    void dayNumToStringTest_ILLEGAL_VALUES (int num){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            functions.dayNumToString(num);
        });
    }
}
