package Homework1Tests;

import Homework1.Functions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.awt.*;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class FunctionsTest {

    static Functions functions;

    @BeforeAll
    static void variablesInitialization(){
        functions = new Functions();
    }

    @Tag("dayNumToString")
    static Stream<Arguments> dayNumToStringArgs(){
        return Stream.of(
                arguments(1, "sunday"),
                arguments(3, "tuesday"),
                arguments(6, "friday")
        );
    }

    @Tag("distanceBetweenTwoPoints")
    static Stream<Arguments> distanceBetweenTwoPointsArgs(){
        return Stream.of(
                arguments(new Point(1,3), new Point(-1,5), 2.8284271247461903),
                arguments(new Point(0,-23), new Point(2,-27), 4.47213595499958),
                arguments(new Point(-20,-5), new Point(13,0), 33.37663853655727)
        );
    }

    @Tag("digitsToString")
    static Stream<Arguments> digitsToStringArgs(){
        return Stream.of(
                arguments(937, "девятсот тридцать семь"),
                arguments(999, "девятсот девяносто девять"),
                arguments(0, "ноль"),
                arguments(13, "тринадцать"),
                arguments(45, "сорок пять")
        );
    }

    @Tag("stringToDigits")
    static Stream<Arguments> stringToDigitsArgs(){
        return Stream.of(
                arguments("девятсот тридцать семь", 937),
                arguments("девятсот девяносто девять", 999),
                arguments("ноль", 0),
                arguments("тринадцать", 13),
                arguments("сорок пять", 45)
        );
    }

    @Tag("dayNumToString")
    @ParameterizedTest
    @MethodSource("dayNumToStringArgs")
    void dayNumToStringTest (int num, String expected){
        String actual = functions.dayNumToString(num);
        Assertions.assertEquals(expected, actual);
    }

    @Tag("dayNumToString")
    @ParameterizedTest
    @ValueSource(ints = {0, -1, -37, 100, 53})
    void dayNumToStringTest_ILLEGAL_VALUES (int num){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            functions.dayNumToString(num);
        });
    }

    @Tag("distanceBetweenTwoPoints")
    @ParameterizedTest
    @MethodSource("distanceBetweenTwoPointsArgs")
    void distanceBetweenTwoPointsTest (Point pointA, Point pointB, double expected){
        double actual = functions.distanceBetweenTwoPoints(pointA, pointB);
        Assertions.assertEquals(expected, actual);
    }

    @Tag("digitsToString")
    @ParameterizedTest
    @MethodSource("digitsToStringArgs")
    void digitsToStringTest_LEGAL_VALUES (int num, String expected){
        String actual = functions.digitsToString(num);
        Assertions.assertEquals(expected, actual);
    }

    @Tag("digitsToString")
    @ParameterizedTest
    @ValueSource(ints = {-1, 1000, 1201})
    void digitsToStringTest_ILLEGAL_VALUES (int num){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            functions.digitsToString(num);
        });
    }

    @Tag("stringToDigits")
    @ParameterizedTest
    @MethodSource("stringToDigitsArgs")
    void stringToDigitsTest_LEGAL_VALUES (String num, int expected){
        int actual = functions.stringToDigits(num);
        Assertions.assertEquals(expected, actual);
    }

    @Tag("stringToDigits")
    @ParameterizedTest
    @ValueSource(strings = {"минус один", "тысяча", "тысяча двести один"})
    void stringToDigitsTest_ILLEGAL_VALUES (String num){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            functions.stringToDigits(num);
        });
    }
}
