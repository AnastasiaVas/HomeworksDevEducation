package Homework1;

import java.util.ArrayList;
import java.util.List;

public class ArraysTasks {
    public static void main (String args[]){
        int[] array = new int[]{1,2,3,4,5};
        System.out.println(java.util.Arrays.toString(swapArray(array)));
    }
    public static String[] bubbleSort(String... array){
        int a,b;
        String t;
        int size = array.length;
        for (a = 1; a < size; a++) {
            for (b = size - 1; b >= a; b--) {
                if (array[b - 1].length() > array[b].length()) {
                    t = array[b - 1];
                    array[b - 1] = array[b];
                    array[b] = t;
                }
            }
        }
        return array;
    }

    public static int max (int... array) {
        if (array.length < 2){
            throw new IllegalArgumentException("Array shouldn't be empty.");
        }
            int max = array[0];
            for (int i : array) {
                if (i > max) max = i;
            }
            return max;
    }

    public static int maxIndex(int... array){
        if (array.length < 2){
            throw new IllegalArgumentException("Array shouldn't be empty.");
        }
        else {
            int max = array[0];
            int ind = 0;
            for (int i = 0; i < array.length; i++) {
                if (array[i] > max) {
                    max = array[i];
                    ind = i;
                }
            }
            return ind;
        }
    }

    public static int minIndex(int[] array){
        if (array.length < 2){
            throw new IllegalArgumentException("Array shouldn't be empty.");
        }
        else {
            int min = array[0];
            int ind = 0;
            for (int i = 0; i < array.length; i++) {
                if (array[i] < min) {
                    min = array[i];
                    ind = i;
                }
            }
            return ind;
        }
    }

    public static int oddElemCount(int... array){
        int count = 0;
        int ind = 0;
        for (int i = 0; i < array.length; i++){
            if (i % 2 != 0){
                count += 1;
            }
        }
        return count;
    }

    public static String[] reverseArray(String ... array){
        String[] revArray = new String[array.length];
        for (int j = 0; j < array.length; j++){
            revArray[array.length-1-j] = array[j];
        }
        return revArray;
    }

    public static int sumOfNumsWithOddIndices(int... array){
            int sumOfOdd = 0;
            int ind = 0;
            for (int i = 0; i < array.length; i++) {
                if (i % 2 != 0) {
                    sumOfOdd += array[i];
                }
            }
            return sumOfOdd;
    }

    public static int[] swapArray(int... array) {
            int mid = (int) (array.length / 2);
            boolean oddNumVal = false;
            int secHalf = mid;
            if (array.length % 2 != 0) {
                oddNumVal = true;
                secHalf = mid+1;
            }
            int temp;
            for (int i = 0; i < mid; i++) {
                temp = array[i];
                array[i] = array[secHalf];
                array[secHalf] = temp;
                secHalf++;
            }
            return array;
    }
}
