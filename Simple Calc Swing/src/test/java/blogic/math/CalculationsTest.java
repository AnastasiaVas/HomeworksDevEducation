package blogic.math;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class CalculationsTest {

    private final Calculations cut = new Calculations();

    static Stream<Arguments> multiplyData() {
        return Stream.of(
                arguments(8, 5, 40),
                arguments(8.1, 5, 40.5),
                arguments(8.1, 2, 16.2)
        );
    }

    @ParameterizedTest(name = "Plus. Input data is {0}, {1}")
    @MethodSource("multiplyData")
    void multiplication(double num1, double num2, double exp) {
        double act = cut.multiplication(num1, num2);

        assertEquals(exp, act);
    }
}