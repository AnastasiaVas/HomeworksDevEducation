package Homework1Tests;

import Homework1.Loops;
import javafx.util.Pair;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

public class LoopsTest {
    @Nested
    class FactorialTest{
        @Test
        void factorialTest_POSITIVE_INPUT(){
            int input = 10;
            long expected = 3628800;
            long actual = Loops.factorial(input);
            Assert.assertEquals(expected,actual);
        }
        @Test
        void factorialTest_INPUT_ZERO(){
            int input = 0;
            long expected = 1;
            long actual = Loops.factorial(input);
            Assert.assertEquals(expected,actual);
        }
        @Test
        void factorialTest_INPUT_NEGATIVE(){
            int input = -3;
            Assert.assertThrows(IllegalArgumentException.class, () -> {
                    Loops.factorial(input);
        });
        }
    }

    @Nested
    class PrimeNumTest{
        @Test
        void primeNumTest_NEGATIVE_INPUT(){
            int input = -5;
            boolean expected = false;
            boolean actual = Loops.primeNum(input);
            Assert.assertEquals(expected,actual);
        }
        @Test
        void primeNumTest_POSITIVE_PRIME_INPUT(){
            int input = 13;
            boolean expected = true;
            boolean actual = Loops.primeNum(input);
            Assert.assertEquals(expected,actual);
        }
        @Test
        void primeNumTest_POSITIVE_NONPRIME_INPUT(){
            int input = 12;
            boolean expected = false;
            boolean actual = Loops.primeNum(input);
            Assert.assertEquals(expected,actual);
        }
    }

    @Nested
    class ReflectionTest{
        @Test
        void reflectionTest_ONE_DIGIT(){
            int input = 1;
            int expected = 1;
            int actual = Loops.reflection(input);
            Assert.assertEquals(expected,actual);
        }
        @Test
        void primeNum_USUAL(){
            int input = 1389;
            int expected = 9831;
            int actual = Loops.reflection(input);
            Assert.assertEquals(expected,actual);
        }
    }
    @Nested
    class SqrBinaryTest{
        @Test
        void srSqrBinaryTest_NEGATIVE_INPUT(){
            int input = -19;
            Assert.assertThrows(IllegalArgumentException.class, () ->{
                Loops.sqrBinary(input);
            });
        }
        @Test
        void srSqrBinaryTest_POSITIVE_INPUT_SQR_IS_WHOLE_NUMBER(){
            int input = 16;
            int expected = 4;
            int actual = Loops.sqrBinary(input);
            Assert.assertEquals(expected,actual);
        }
        @Test
        void srSqrBinaryTest_POSITIVE_INPUT_SQR_IS_NOT_WHOLE_NUMBER(){
            int input = 27;
            int expected = 5;
            int actual = Loops.sqrBinary(input);
            Assert.assertEquals(expected,actual);
        }
        @Test
        void srSqrBinaryTest_INPUT_ZERO(){
            int input = 0;
            int expected = 0;
            int actual = Loops.sqrBinary(input);
            Assert.assertEquals(expected,actual);
        }
    }
    @Nested
    class SqrBruteFTest{
        @Test
        void sqrBruteFTest_NEGATIVE_INPUT(){
            int input = -19;
            Assert.assertThrows(IllegalArgumentException.class, () ->{
                Loops.sqrBruteF(input);
            });
        }
        @Test
        void sqrBruteFTestm_POSITIVE_INPUT_SQR_IS_WHOLE_NUMBER(){
            int input = 16;
            int expected = 4;
            int actual = Loops.sqrBruteF(input);
            Assert.assertEquals(expected,actual);
        }
        @Test
        void sqrBruteFTest_POSITIVE_INPUT_SQR_IS_NOT_WHOLE_NUMBER(){
            int input = 27;
            int expected = 5;
            int actual = Loops.sqrBruteF(input);
            Assert.assertEquals(expected,actual);
        }
        @Test
        void sqrBruteFTest_INPUT_ZERO(){
            int input = 0;
            int expected = 0;
            int actual = Loops.sqrBruteF(input);
            Assert.assertEquals(expected,actual);
        }
    }
    @Nested
    class SumEvenNumsTest{
        @Test
        void sumEvenNumsTest_INPUT_ZERO(){
            int input = 0;
            Pair<Integer, Integer> expected = new Pair<>(0,0);
            Pair actual = Loops.sumEvenNums(input);
            Assert.assertEquals(expected,actual);
        }
        @Test
        void sumEvenNumsTest_INPUT_USUAL(){
            int input = 89;
            Pair<Integer, Integer> expected = new Pair<>(1980,44);
            Pair actual = Loops.sumEvenNums(input);
            Assert.assertEquals(expected,actual);
        }
    }
    @Nested
    class NumOfDigTest{
        @Test
        void numOfDigTest_INPUT_ZERO(){
            int input = 0;
            int expected = 1;
            int actual = Loops.numOfDig(input);
            Assert.assertEquals(expected,actual);
        }
        @Test
        void numOfDigTest_INPUT_MULTIPLE(){
            int input = 8906;
            int expected = 4;
            int actual = Loops.numOfDig(input);
            Assert.assertEquals(expected,actual);
        }
    }

}
