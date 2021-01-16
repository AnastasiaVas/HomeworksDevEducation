import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.Assert.assertEquals;


public class ConversionFunctionsTest {

    public static ConversionFunctions cv = new ConversionFunctions();

    @BeforeAll
    public static void variable(){
        cv = new ConversionFunctions();
    }

    @ParameterizedTest
    @ValueSource(longs = {922337203685477580L, 22, - 345, 0, -9223372036854775L})
    void digitToStringTest (long num) {
        Assertions.assertEquals(String.valueOf(num), cv.digitToString(num));
    }

    @ParameterizedTest
    @ValueSource(doubles = {678.987, 0, -345, -6789.987645})
    void realNumToStringTest (double num) {
        Assertions.assertEquals(String.valueOf(num), cv.realNumToString(num));
    }

    @ParameterizedTest
    @ValueSource(strings = {"922337203685477580", "22", "-345", "0", "-9223372036854775"})
    void stringToDigitTest (String num) {
        Assertions.assertEquals(Double.valueOf(num), cv.stringToDigit(num));
    }

    @Test
    public void stringToDigitTest_EXCEPTION (){
        String num = "56jkyl6";
        Assertions.assertThrows(NumberFormatException.class, () -> {
            cv.stringToDigit(num);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"922337203685477580", "22.784", "-345.0", "0", "-9223372036854775.558"})
    void stringToRealNumTest (String num) {
        Assertions.assertEquals(Double.valueOf(num), cv.stringToRealNum(num));
    }

    @Test
    public void stringToRealNumTest_EXCEPTION (){
        String num = "56jkyl6";
        Assertions.assertThrows(NumberFormatException.class, () -> {
            cv.stringToDigit(num);
        });
    }
}
