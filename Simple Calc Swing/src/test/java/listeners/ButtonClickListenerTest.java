package listeners;

import blogic.math.Calculations;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;
import utils.Constants;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.stream.Stream;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.ArgumentMatchers.anyDouble;

class ButtonClickListenerTest {

    private final JTextField textF = Mockito.mock(JTextField.class);
    private final JTextField textF2 = Mockito.mock(JTextField.class);
    private final JTextField textF3 = Mockito.mock(JTextField.class);
    private final JTextArea textArea = Mockito.mock(JTextArea.class);
    private final Calculations calculations = Mockito.mock(Calculations.class);

    private final ButtonClickListener cut = new ButtonClickListener(textF, textF2, textF3, textArea, calculations);

    static Stream<Arguments> nominalOperationTestData() {
        return Stream.of(
                arguments("1", "2444", "2445", 1, 2444, 2445),
                arguments("-1.033", "2444.034", "2443.001", -1.033, 2444.034, 2443.001)
        );
    }

    static Stream<Arguments> invalidSignTestData() {
        return Stream.of(
                arguments("1", "2444", "2445"),
                arguments("-1.033", "2444.034", "443.001")
        );
    }

    static Stream<Arguments> exceptionTestData() {
        return Stream.of(
                arguments("1", "2444", "Error Message 1", 1, 2444, 2445),
                arguments("-1.033", "2444.034", "Error Message 2", -1.033, 2444.034, 2443.001)
        );
    }

    @ParameterizedTest(name = "Plus. Input data is {0}, {1}")
    @MethodSource("nominalOperationTestData")
    void additionTest(String val1Str, String val2Str, String resultStr, double val1, double val2, double result) {
        String operation = "+";

        Mockito.when(textF.getText()).thenReturn(val1Str);
        Mockito.when(textF2.getText()).thenReturn(val2Str);
        Mockito.when(textF3.getText()).thenReturn(operation);
        Mockito.when(calculations.addition(val1, val2)).thenReturn(result);

        cut.actionPerformed(Mockito.mock(ActionEvent.class));

        Mockito.verify(textArea, Mockito.only()).setText(resultStr);
    }

    @ParameterizedTest(name = "Minus. Input data is {0}, {1}")
    @MethodSource("nominalOperationTestData")
    void minusTest(String val1Str, String val2Str, String resultStr, double val1, double val2, double result) {
        String operation = "-";

        Mockito.when(textF.getText()).thenReturn(val1Str);
        Mockito.when(textF2.getText()).thenReturn(val2Str);
        Mockito.when(textF3.getText()).thenReturn(operation);
        Mockito.when(calculations.subtraction(val1, val2)).thenReturn(result);

        cut.actionPerformed(Mockito.mock(ActionEvent.class));

        Mockito.verify(textArea, Mockito.only()).setText(resultStr);
    }

    @ParameterizedTest(name = "Invalid operation. Input data is {2}")
    @MethodSource("invalidSignTestData")
    void invalidSymbolTest(String val1Str, String val2Str, String operation) {
        Mockito.when(textF.getText()).thenReturn(val1Str);
        Mockito.when(textF2.getText()).thenReturn(val2Str);
        Mockito.when(textF3.getText()).thenReturn(operation);

        cut.actionPerformed(Mockito.mock(ActionEvent.class));

        Mockito.verify(calculations, Mockito.never()).subtraction(anyDouble(), anyDouble());
        Mockito.verify(calculations, Mockito.never()).addition(anyDouble(), anyDouble());
        Mockito.verify(textArea, Mockito.only()).setText(Constants.ERROR_TEXT);
    }

    @ParameterizedTest(name = "Exception operation. Message is {2}")
    @MethodSource("exceptionTestData")
    void arithmeticExceptionTest(String val1Str, String val2Str, String message, double val1, double val2) {
        String operation = "+";

        Mockito.when(textF.getText()).thenReturn(val1Str);
        Mockito.when(textF2.getText()).thenReturn(val2Str);
        Mockito.when(textF3.getText()).thenReturn(operation);
        Mockito.when(calculations.addition(val1, val2)).thenThrow(new ArithmeticException(message));

        cut.actionPerformed(Mockito.mock(ActionEvent.class));

        Mockito.verify(textArea, Mockito.only()).setText(message);
    }
}