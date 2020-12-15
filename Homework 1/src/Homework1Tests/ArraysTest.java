package Homework1Tests;

import Homework1.Arrays;
import Homework1.ConditionalStatements;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class ArraysTest {
    @Nested
    class BubbleSortTest{
        @Test
        void BubbleSortTest_MULTIPLE_VALUES(){
            String[] array = {"Tree", "Horse", "1", "House", "Apple", "The cat is on the tree"};
            String[] expected = {"1", "Tree", "Horse", "House", "Apple", "The cat is on the tree"};
            String[] actual = Arrays.bubbleSort(array);
            Assert.assertEquals(expected, actual);
        }
        @Test
        void BubbleSortTest_EMTY_ARRAY(){
            String[] array = {};
            String[] expected = {};
            String[] actual = Arrays.bubbleSort(array);
            Assert.assertEquals(expected, actual);
        }
    }
    @Nested
    class ArrayMaxTest {
        @Test
        void maxTest_EMTY_ARRAY() {
            int[] array = {};
            Assert.assertThrows(IllegalArgumentException.class, () -> {
                Arrays.max(array);
            });
        }
        @Test
        void maxTest_USUAL_ARRAY() {
            int[] array = {6,7,9,0,-50,34,256};
            int expected = 256;
            int actual = Arrays.max(array);
            Assert.assertEquals(expected, actual);
        }
    }
    @Nested
    class MaxIndexTest {
        @Test
        void maxIndexTest_EMTY_ARRAY() {
            int[] array = {};
            Assert.assertThrows(IllegalArgumentException.class, () -> {
                Arrays.maxIndex(array);
            });
        }
        @Test
        void maxTest_USUAL_ARRAY() {
            int[] array = {6,7,9,0,-50,34,256};
            int expected = 6;
            int actual = Arrays.maxIndex(array);
            Assert.assertEquals(expected, actual);
        }
    }

    @Nested
    class MinIndexTest {
        @Test
        void minIndexTest_EMTY_ARRAY() {
            int[] array = {};
            Assert.assertThrows(IllegalArgumentException.class, () -> {
                Arrays.minIndex(array);
            });
        }
        @Test
        void minTest_USUAL_ARRAY() {
            int[] array = {6,7,9,0,-50,34,256};
            int expected = 4;
            int actual = Arrays.minIndex(array);
            Assert.assertEquals(expected, actual);
        }
    }
    @Nested
    class OddElemCountTest {
        @Test
        void oddElemCountTest_EMTY_ARRAY() {
            int[] array = {};
            int expected = 0;
            int actual = Arrays.oddElemCount(array);
            Assert.assertEquals(expected, actual);
        }
        @Test
        void oddElemCountTest_USUAL_ARRAY() {
            int[] array = {6,7,9,0,-50,34,256};
            int expected = 3;
            int actual = Arrays.oddElemCount(array);
            Assert.assertEquals(expected, actual);
        }
    }    @Nested
    class ReverseArrayTest {
        @Test
        void reverseArrayTest_EMTY_ARRAY() {
            String[] array = {};
            String[] expected = {};
            String[] actual = Arrays.reverseArray(array);
            Assert.assertEquals(expected, actual);
        }
        @Test
        void reverseArrayTest_USUAL_ARRAY() {
            String[] array = {"Tree", "Horse", "1", "House", "Apple", "The cat is on the tree"};
            String[] expected = {"The cat is on the tree", "Apple", "House", "1", "Horse", "Tree"};
            String[] actual = Arrays.reverseArray(array);
            Assert.assertEquals(expected, actual);
        }
    }
    @Nested
    class SumOfNumsWithOddIndicesTest {
        @Test
        void sumOfNumsWithOddIndicesTest_EMTY_ARRAY() {
            int[] array = {};
            int expected = 0;
            int actual = Arrays.sumOfNumsWithOddIndices(array);
            Assert.assertEquals(expected, actual);
        }
        @Test
        void sumOfNumsWithOddIndicesTest_USUAL_ARRAY() {
            int[] array = {1,2,3,4,5};
            int expected = 6;
            int actual = Arrays.sumOfNumsWithOddIndices(array);
            Assert.assertEquals(expected, actual);
        }
    }
    @Nested
    class SwapArrayTest {
        @Test
        void swapArrayTest_EMPTY_ARRAY() {
            int[] array = {};
            int[] expected = {};
            int[] actual = Arrays.swapArray(array);
            Assert.assertEquals(expected, actual);
        }
        @Test
        void swapArrayTest_ODD_NUMBER_OF_VALUES() {
            int[] array = {1,2,3,4,5};
            int[] expected = {4,5,3,1,2};
            int[] actual = Arrays.swapArray(array);
            Assert.assertEquals(expected, actual);
        }
        void swapArrayTest_PAIRED_NUMBER_OF_VALUES() {
            int[] array = {1,2,3,4};
            int[] expected = {4,5,1,2};
            int[] actual = Arrays.swapArray(array);
            Assert.assertEquals(expected, actual);
        }
    }
}
