package Homework1;

import javafx.util.Pair;

public class Loops {

    public static void main (String args[]){
        System.out.println(numOfDig(0));
    }

    public static long factorial(int n){
        if (n < 0){
            throw new IllegalArgumentException("Input value shouldn't be negative.");
        }
        long f = 1L;
        for (long i = 2L; i <= n; i++){
            f *= i;
        }
        return f;
    }

    public static boolean primeNum(int num){
        boolean answer = true;
        if (num < 0){
            return answer = false;
        }
        if (num > 0) {
            for (int i = 2; i <= num / 2; i++) {
                if (num % i == 0) {
                    answer = false;
                    break;
                }
            }
        }
        return answer;
    }

    public static int reflection(int num){
        int numLen = String.valueOf(num).length();
        double digD;
        int digI = num;
        double digit;
        int answer = 0;
        int i = numLen-1;
        while(i >= 0){ ;
            digD = (double) digI / 10;
            digI = (int) digD;
            digit = (digD - digI) * 10;
            if (i != 0) {
                answer += digit * Math.pow(10, i);
            }
            else answer += digit;
            i--;
        }
        return answer;
    }

    public static int sqrBinary(int num){
        if (num < 0){
            throw new IllegalArgumentException("Input value shouldn't be negative.");
        }
        else {
            int min = 1;
            int max = num;
            int previous = 0;
            while (true) {
                int mid = (max + min) / 2;
                if (previous == mid) return mid;
                int sq = mid * mid;
                if (num == sq) return mid;
                else if (num < sq) max = mid;
                else min = mid;
                previous = mid;
            }
        }
    }

    public static int sqrBruteF(int num){
        if (num < 0){
            throw new IllegalArgumentException("Input value shouldn't be negative.");
        }
        else {
            int sqr;
            int i = 1;
            while (true) {
                sqr = i * i;
                if (sqr == num) {
                    return i;
                } else if (sqr > num) {
                    return i - 1;
                } else i++;
            }
        }
    }

    public static Pair sumEvenNums (int num){
        int i = 1;
        int sum = 0;
        int count = 0;
        while (i <= num){
            if (i % 2 == 0){
                sum += i;
                count++;
            }
            i++;
        }
        Pair<Integer, Integer> pair = new Pair<>(sum, count);
        return pair;
    }

    public static int numOfDig(int num){
        int count = 1;
        int wholePart = num;
        while (true){
            wholePart = wholePart / 10;
            if (wholePart != 0){
                count++;
            }
            else{
                break;
            }
        }
        return count;
    }
}
