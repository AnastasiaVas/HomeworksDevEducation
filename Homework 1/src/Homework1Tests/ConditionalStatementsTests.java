package Homework1Tests;
import Homework1.ConditionalStatements;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class ConditionalStatementsTests {
    @Nested
    class SumOrMultiplyTests{
        @Test
        void SumOrMultiplyTest_A_IS_PAIRED(){
            int a = 8, b = 10;
            int expected = a*b;
            int actual = ConditionalStatements.sumOrMultiply(a, b);
            Assertions.assertEquals(expected, actual);
        }
        @Test
        void SumOrMultiplyTest_A_IS_ODD(){
            int a = 7, b = 10;
            int expected = a+b;
            int actual = ConditionalStatements.sumOrMultiply(a, b);
            Assertions.assertEquals(expected, actual);
        }
    }
    @Nested
    class CoordinatesTest{
        @Test
        void CoordinatesTest_FIRST_QUADRANT(){
            int x = 8, y = 10;
            String expected = "The point lies in the first quadrant.";
            String actual = ConditionalStatements.coordinates(x, y);
            Assertions.assertEquals(expected, actual);
        }
        @Test
        void CoordinatesTest_SECOND_QUADRANT(){
            int x = -8, y = 10;
            String expected = "The point lies in the second quadrant.";
            String actual = ConditionalStatements.coordinates(x, y);
            Assertions.assertEquals(expected, actual);
        }
        @Test
        void CoordinatesTest_THIRD_QUADRANT(){
            int x = -8, y = -10;
            String expected = "The point lies in the third quadrant.";
            String actual = ConditionalStatements.coordinates(x, y);
            Assertions.assertEquals(expected, actual);
        }
        @Test
        void CoordinatesTest_FOURTH_QUADRANT(){
            int x = 8, y = -10;
            String expected = "The point lies in the fourth quadrant.";
            String actual = ConditionalStatements.coordinates(x, y);
            Assertions.assertEquals(expected, actual);
        }
        @Test
        void CoordinatesTest_X_AXIS(){
            int x = 0, y = -10;
            String expected = "The point lies on the X-axis.";
            String actual = ConditionalStatements.coordinates(x, y);
            Assertions.assertEquals(expected, actual);
        }
        @Test
        void CoordinatesTest_Y_AXIS(){
            int x = -2, y = 0;
            String expected = "The point lies on the Y-axis.";
            String actual = ConditionalStatements.coordinates(x, y);
            Assertions.assertEquals(expected, actual);
        }
        @Test
        void CoordinatesTest_ORIGIN(){
            int x = 0, y = 0;
            String expected = "The point lies at the origin.";
            String actual = ConditionalStatements.coordinates(x, y);
            Assertions.assertEquals(expected, actual);
        }
    }
    @Nested
    class MaxSumOrMultipTest {
        @Test
        void MaxSumOrMultipTest_SUM_IS_SMALLER(){
            int a = 8, b = 10, c = 11;
            int expected = a*b*c+3;
            int actual = ConditionalStatements.maxSumOrMultip(a,b,c);
            Assertions.assertEquals(expected, actual);
        }
        @Test
        void MaxSumOrMultipTest_MULTIP_IS_SMALLER(){
            int a = 1, b = 2, c = -2;
            int expected = a+b+c+3;
            int actual = ConditionalStatements.maxSumOrMultip(a,b,c);
            Assertions.assertEquals(expected, actual);
        }
    }
    @Nested
    class StudentEvalTest {
        @Test
        void StudentEvalTest_ON_THE_BRINK(){
            int grade = 40;
            char expected = 'D';
            int actual = ConditionalStatements.studentEval(grade);
            Assertions.assertEquals(expected, actual);
        }
        @Test
        void StudentEvalTest_GRADE_A(){
            int grade = 91;
            char expected = 'A';
            int actual = ConditionalStatements.studentEval(grade);
            Assertions.assertEquals(expected, actual);
        }
        @Test
        void StudentEvalTest_GRADE_B(){
            int grade = 79;
            char expected = 'B';
            int actual = ConditionalStatements.studentEval(grade);
            Assertions.assertEquals(expected, actual);
        }
        @Test
        void StudentEvalTest_GRADE_C(){
            int grade = 70;
            char expected = 'C';
            int actual = ConditionalStatements.studentEval(grade);
            Assertions.assertEquals(expected, actual);
        }
        @Test
        void StudentEvalTest_GRADE_D(){
            int grade = 51;
            char expected = 'D';
            int actual = ConditionalStatements.studentEval(grade);
            Assertions.assertEquals(expected, actual);
        }
        @Test
        void StudentEvalTest_GRADE_E(){
            int grade = 30;
            char expected = 'E';
            int actual = ConditionalStatements.studentEval(grade);
            Assertions.assertEquals(expected, actual);
        }
        @Test
        void StudentEvalTest_GRADE_F(){
            int grade = 16;
            char expected = 'F';
            int actual = ConditionalStatements.studentEval(grade);
            Assertions.assertEquals(expected, actual);
        }
        @Test
        void StudentEvalTest_VALUE_OUT_OF_RANGE() {
            int grade = 101;
            char expected = '-';
            int actual = ConditionalStatements.studentEval(grade);
            Assertions.assertEquals(expected, actual);
        }
    }
    @Nested
    class SumOfPositiveNumsTest{
        @Test
        void SumOfPositiveNumsTest_ONLY_NEGATIVE_IN_ARRAY(){
            int[] array = {-1,-2,-3,-4,-5,-6};
            int expected = 0;
            int actual = ConditionalStatements.sumOfPositiveNums(array);
            Assertions.assertEquals(expected, actual);
        }
        @Test
        void SumOfPositiveNumsTest(){
            int[] array = {1,2,-3,4,-5,-6};
            int expected = 7;
            int actual = ConditionalStatements.sumOfPositiveNums(array);
            Assertions.assertEquals(expected, actual);
        }
    }
}
