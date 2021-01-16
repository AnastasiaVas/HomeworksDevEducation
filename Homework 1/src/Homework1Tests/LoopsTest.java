package Homework1Tests;

import Homework1.Loops;
import jdk.jfr.Category;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class LoopsTest {

        @Test
        @Tag("factorialTest")
        void factorialTest_POSITIVE_INPUT(){
            int input = 10;
            long expected = 3628800;
            long actual = Loops.factorial(input);
            Assertions.assertEquals(expected,actual);
        }
        @Test
        @Tag("factorialTest")
        void factorialTest_INPUT_ZERO(){
            int input = 0;
            long expected = 1;
            long actual = Loops.factorial(input);
            Assertions.assertEquals(expected,actual);
        }
        @Test
        @Tag("factorialTest")
        void factorialTest_INPUT_NEGATIVE(){
            int input = -3;
            Assertions.assertThrows(IllegalArgumentException.class, () -> {
                    Loops.factorial(input);
        });
        }


        @Test
        @Tag("primeNumTest")
        void primeNumTest_NEGATIVE_INPUT(){
            int input = -5;
            boolean expected = false;
            boolean actual = Loops.primeNum(input);
            Assertions.assertEquals(expected,actual);
        }
        @Test
        @Tag("primeNumTest")
        void primeNumTest_POSITIVE_PRIME_INPUT(){
            int input = 13;
            boolean expected = true;
            boolean actual = Loops.primeNum(input);
            Assertions.assertEquals(expected,actual);
        }
        @Test
        @Tag("primeNumTest")
        void primeNumTest_POSITIVE_NONPRIME_INPUT(){
            int input = 12;
            boolean expected = false;
            boolean actual = Loops.primeNum(input);
            Assertions.assertEquals(expected,actual);
        }

        @Test
        @Tag("primeNumTest")
        void reflectionTest_ONE_DIGIT(){
            int input = 1;
            int expected = 1;
            int actual = Loops.reflection(input);
            Assertions.assertEquals(expected,actual);
        }
        @Test
        @Tag("primeNumTest")
        void primeNum_USUAL(){
            int input = 1389;
            int expected = 9831;
            int actual = Loops.reflection(input);
            Assertions.assertEquals(expected,actual);
        }

        @Test
        @Tag("srSqrBinaryTest")
        void srSqrBinaryTest_NEGATIVE_INPUT(){
            int input = -19;
            Assertions.assertThrows(IllegalArgumentException.class, () ->{
                Loops.sqrBinary(input);
            });
        }
        @Test
        @Tag("srSqrBinaryTest")
        void srSqrBinaryTest_POSITIVE_INPUT_SQR_IS_WHOLE_NUMBER(){
            int input = 16;
            int expected = 4;
            int actual = Loops.sqrBinary(input);
            Assertions.assertEquals(expected,actual);
        }
        @Test
        @Tag("srSqrBinaryTest")
        void srSqrBinaryTest_POSITIVE_INPUT_SQR_IS_NOT_WHOLE_NUMBER(){
            int input = 27;
            int expected = 5;
            int actual = Loops.sqrBinary(input);
            Assertions.assertEquals(expected,actual);
        }
        @Test
        @Tag("srSqrBinaryTest")
        void srSqrBinaryTest_INPUT_ZERO(){
            int input = 0;
            int expected = 0;
            int actual = Loops.sqrBinary(input);
            Assertions.assertEquals(expected,actual);
        }

        @Test
        @Tag("sqrBruteFTes")
        void sqrBruteFTest_NEGATIVE_INPUT(){
            int input = -19;
            Assertions.assertThrows(IllegalArgumentException.class, () ->{
                Loops.sqrBruteF(input);
            });
        }
        @Test
        @Tag("sqrBruteFTes")
        void sqrBruteFTest_POSITIVE_INPUT_SQR_IS_WHOLE_NUMBER(){
            int input = 16;
            int expected = 4;
            int actual = Loops.sqrBruteF(input);
            Assertions.assertEquals(expected,actual);
        }
        @Test
        @Tag("sqrBruteFTes")
        void sqrBruteFTest_POSITIVE_INPUT_SQR_IS_NOT_WHOLE_NUMBER(){
            int input = 27;
            int expected = 5;
            int actual = Loops.sqrBruteF(input);
            Assertions.assertEquals(expected,actual);
        }
        @Test
        @Tag("sqrBruteFTes")
        void sqrBruteFTest_INPUT_ZERO(){
            int input = 0;
            int expected = 0;
            int actual = Loops.sqrBruteF(input);
            Assertions.assertEquals(expected,actual);
        }

        @Tag("sumEvenNumsTest")
        static Stream<Arguments> sumEvenNumsTest_LEGAL_INPUT() {
            return Stream.of(
                    arguments(30, "Sum of even numbers withing a range 1-30 is 240, and the number of even numbers is 15"),
                    arguments(45, "Sum of even numbers withing a range 1-45 is 506, and the number of even numbers is 22"),
                    arguments(78, "Sum of even numbers withing a range 1-78 is 1560, and the number of even numbers is 39")
            );
        }
        @Tag("sumEvenNumsTest")
            @ParameterizedTest
            @ValueSource(ints = {-1,0,-100,-50,-579})
            void sumEvenNumsTest_ILLEGAL_ARGUMENTS (int num){
            Assertions.assertThrows(IllegalArgumentException.class, () -> {
                Loops.sumEvenNumsBetweenOneAndNinetyNine(num);
            });
            }

        @ParameterizedTest
        @Tag("sumEvenNumsTest")
        @MethodSource("sumEvenNumsTest_LEGAL_INPUT")
        void sumEvenNumsTest_LEGAL_ARGUMENTS (int num, String expected){
            String actual = Loops.sumEvenNumsBetweenOneAndNinetyNine(num);
            Assertions.assertEquals(expected, actual);
        }

        @Test
        @Tag("numOfDigTest")
        void numOfDigTest_INPUT_ZERO(){
            int input = 0;
            int expected = 1;
            int actual = Loops.numOfDig(input);
            Assertions.assertEquals(expected,actual);
        }
        @Test
        @Tag("numOfDigTest")
        void numOfDigTest_INPUT_MULTIPLE(){
            int input = 8906;
            int expected = 4;
            int actual = Loops.numOfDig(input);
            Assertions.assertEquals(expected,actual);
        }

}
