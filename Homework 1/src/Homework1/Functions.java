package Homework1;

import constants.WeekDays;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.*;

public class Functions {
    public String dayNumToString(int num) {
        if (num < 1 || num > 7) {
            throw new IllegalArgumentException("Entered value should fall between 1 and 7.");
        }
        return WeekDays.values()[num - 1].toString().toLowerCase();
    }

    public double distanceBetweenTwoPoints(Point pointA, Point pointB) {
        return Math.sqrt(Math.pow(pointB.getX() - pointA.getX(), 2) + Math.pow(pointB.getY() - pointA.getY(), 2));
    }

    public String digitsToString(int num) {
        if (num < 0 || num > 999) {
            throw new IllegalArgumentException("Введенное число должно быть между 0 и 999.");
        }
        StringBuilder answer = new StringBuilder();
        int i = 0;
        int temp = 0;
        final String numInWords[][] = {
                {"ноль", "один", "два", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять"},
                {"десять", "одинадцать", "двенадцать", "тринадцать", "четырнадцать", "пятнадцать", "шестнадцать", "семнадцать", "восемнадцать", "девятнадцать"},
                {"", "", "двадцать", "тридцать", "сорок", "пятдесят", "шестдесят", "семдесят", "восемдесят", "девяносто"},
                {"", "сто", "двести", "триста", "четыриста", "пятсот", "шестсот", "семсот", "восемсот", "девятсот"}
        };
        while (true) {
            double fraction = (double) num / 10;
            num = (int) fraction;
            int lastDig = (int) Math.round((fraction - num) * 10);
            if (i == 0) {
                temp = lastDig;
            }
            if (i == 1) {
                if (lastDig == 1) {
                    answer.setLength(0);
                    answer.append(numInWords[i][temp]);
                    i++;
                } else {
                    i += 1;
                    answer.insert(0, numInWords[i][lastDig]);
                }
            } else {
                answer.insert(0, numInWords[i][lastDig]);
            }
            i++;
            if (num != 0) {
                answer.insert(0, " ");
            }
            if (num == 0) break;
        }
        return answer.toString();
    }

    public int stringToDigits(String num) {
        int answer = 0;
        final String digitsInStringArray[] = {"ноль", "один", "два", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять",
                "десять", "одинадцать", "двенадцать", "тринадцать", "четырнадцать", "пятнадцать", "шестнадцать", "семнадцать", "восемнадцать", "девятнадцать",
                "двадцать", "тридцать", "сорок", "пятдесят", "шестдесят", "семдесят", "восемдесят", "девяносто",
                "сто", "двести", "триста", "четыриста", "пятсот", "шестсот", "семсот", "восемсот", "девятсот"};

        ArrayList<String> digitsInString = new ArrayList<>();
        Collections.addAll(digitsInString, digitsInStringArray);

        final int stringInDigits[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 30, 40,
                50, 60, 70, 80, 90, 100, 200, 300, 400, 500, 600, 700, 800, 900};

        String clearedNumStr = num.strip().replaceAll(" +", " ");
        String[] strArray = clearedNumStr.split(" ");

        for (String str : strArray) {
            if (digitsInString.contains(str)) {
                answer += stringInDigits[digitsInString.indexOf(str)];
            } else {
                throw new IllegalArgumentException("Введенное значение должно быть числом между 0 и 999.");
            }
        }
        return answer;
    }
}
