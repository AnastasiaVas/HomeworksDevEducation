package Homework1Tests;

import Homework1.ArraysTasks;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class ArraysTasksTest {
    @Nested
    class BubbleSortTest{
        @Test
        void BubbleSortTest_MULTIPLE_VALUES(){
            String[] array = {"Tree", "Horse", "1", "House", "Apple", "The cat is on the tree"};
            String[] expected = {"1", "Tree", "Horse", "House", "Apple", "The cat is on the tree"};
            String[] actual = ArraysTasks.bubbleSort(array);
            Assertions.assertEquals(expected, actual);
        }
        @Test
        void BubbleSortTest_EMTY_ARRAY(){
            String[] array = {};
            String[] expected = {};
            String[] actual = ArraysTasks.bubbleSort(array);
            Assertions.assertEquals(expected, actual);
        }
    }
    @Nested
    class ArrayMaxTest {
        @Test
        void maxTest_EMTY_ARRAY() {
            int[] array = {};
            Assertions.assertThrows(IllegalArgumentException.class, () -> {
                ArraysTasks.max(array);
            });
        }
        @Test
        void maxTest_USUAL_ARRAY() {
            int[] array = {6,7,9,0,-50,34,256};
            int expected = 256;
            int actual = ArraysTasks.max(array);
            Assertions.assertEquals(expected, actual);
        }
    }
    @Nested
    class MaxIndexTest {
        @Test
        void maxIndexTest_EMTY_ARRAY() {
            int[] array = {};
            Assertions.assertThrows(IllegalArgumentException.class, () -> {
                ArraysTasks.maxIndex(array);
            });
        }
        @Test
        void maxTest_USUAL_ARRAY() {
            int[] array = {6,7,9,0,-50,34,256};
            int expected = 6;
            int actual = ArraysTasks.maxIndex(array);
            Assertions.assertEquals(expected, actual);
        }
    }

    @Nested
    class MinIndexTest {
        @Test
        void minIndexTest_EMTY_ARRAY() {
            int[] array = {};
            Assertions.assertThrows(IllegalArgumentException.class, () -> {
                ArraysTasks.minIndex(array);
            });
        }
        @Test
        void minTest_USUAL_ARRAY() {
            int[] array = {6,7,9,0,-50,34,256};
            int expected = 4;
            int actual = ArraysTasks.minIndex(array);
            Assertions.assertEquals(expected, actual);
        }
    }
    @Nested
    class OddElemCountTest {
        @Test
        void oddElemCountTest_EMTY_ARRAY() {
            int[] array = {};
            int expected = 0;
            int actual = ArraysTasks.oddElemCount(array);
            Assertions.assertEquals(expected, actual);
        }
        @Test
        void oddElemCountTest_USUAL_ARRAY() {
            int[] array = {6,7,9,0,-50,34,256};
            int expected = 3;
            int actual = ArraysTasks.oddElemCount(array);
            Assertions.assertEquals(expected, actual);
        }
    }    @Nested
    class ReverseArrayTest {
        @Test
        void reverseArrayTest_EMTY_ARRAY() {
            String[] array = {};
            String[] expected = {};
            String[] actual = ArraysTasks.reverseArray(array);
            Assertions.assertEquals(expected, actual);
        }
        @Test
        void reverseArrayTest_USUAL_ARRAY() {
            String[] array = {"Tree", "Horse", "1", "House", "Apple", "The cat is on the tree"};
            String[] expected = {"The cat is on the tree", "Apple", "House", "1", "Horse", "Tree"};
            String[] actual = ArraysTasks.reverseArray(array);
            Assertions.assertEquals(expected, actual);
        }
    }
    @Nested
    class SumOfNumsWithOddIndicesTest {
        @Test
        void sumOfNumsWithOddIndicesTest_EMTY_ARRAY() {
            int[] array = {};
            int expected = 0;
            int actual = ArraysTasks.sumOfNumsWithOddIndices(array);
            Assertions.assertEquals(expected, actual);
        }
        @Test
        void sumOfNumsWithOddIndicesTest_USUAL_ARRAY() {
            int[] array = {1,2,3,4,5};
            int expected = 6;
            int actual = ArraysTasks.sumOfNumsWithOddIndices(array);
            Assertions.assertEquals(expected, actual);
        }
    }
    @Nested
    class SwapArrayTest {
        @Test
        void swapArrayTest_EMPTY_ARRAY() {
            int[] array = {};
            int[] expected = {};
            int[] actual = ArraysTasks.swapArray(array);
            Assertions.assertEquals(expected, actual);
        }
        @Test
        void swapArrayTest_ODD_NUMBER_OF_VALUES() {
            int[] array = {1,2,3,4,5};
            int[] expected = {4,5,3,1,2};
            int[] actual = ArraysTasks.swapArray(array);
            Assertions.assertEquals(expected, actual);
        }
        void swapArrayTest_PAIRED_NUMBER_OF_VALUES() {
            int[] array = {1,2,3,4};
            int[] expected = {4,5,1,2};
            int[] actual = ArraysTasks.swapArray(array);
            Assertions.assertEquals(expected, actual);
        }
    }
}
