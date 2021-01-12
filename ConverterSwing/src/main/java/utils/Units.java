package utils;

import javax.swing.*;
import java.util.EnumSet;

public enum Units {
    KM(1000,"km"),
    MILE(0.00062,"miles"),
    NAUTICAL_MILE(0.00062,"nautical mile"),
    CABLE(0.054,"cable"),
    LEAGUE(0.0002071237,"league"),
    FOOT(3.28084,"foot"),
    YARD(1.09361,"yard"),

    KELVIN_SCALE (0, 273.15, "Kelvin scale"),
    FAHRENHEIT_SCALE (1.8, 32, "Fahrenheit scale"),
    ROMER_SCALE (0.52, 7.5, "Römer scale"),
    RANKIN_SCALE (1.8, 273.15, "Rankine scale"),
    NEWTON_SCALE (0.33000, "Newton scale"),
    DELISLE_SCALE (1.5, 100, "Delisle scale"),

    GRAM (1000, "gram"),
    CARAT (5000, "carat"),
    ENGLISH_POUND (0.3048, "eng pound"),
    POUND (0.3048, "pound"),
    RUSSIAN_POUND (3.28084, "rus pound"),
    STONE (0.157473, "stone"),

    MINUTES (0.0166667, "minutes"),
    HOURS (0.000277778, "hours"),
    DAYS (0.0000115741, "days"),
    WEEKS (1.6534E-6, "weeks"),
    MONTHS (3.80517e-7, "months"),
    ASTRONOMICAL_YEAR (31557600, "astronomical year"),

    CUBIC_METRE (0.001, "cubic metre"),
    GALLON (0.264172, "gallon"),
    PINT (2.11338, "pint"),
    QUARTS (1.05669, "quarts"),
    BARREL (0.00628981, "barrel"),
    CUBIC_FOOT (0.0353147, "cubic foot"),
    CUBIC_INCH (61.0237, "cubic inch");

    public static EnumSet<Units> groupLength = EnumSet.of(KM, MILE, NAUTICAL_MILE, CABLE, LEAGUE, FOOT, YARD);
    public static EnumSet<Units> groupTemperature = EnumSet.of(KELVIN_SCALE, FAHRENHEIT_SCALE, ROMER_SCALE, RANKIN_SCALE, NEWTON_SCALE, DELISLE_SCALE );
    public static EnumSet<Units> groupTime = EnumSet.of(MINUTES, HOURS, DAYS, WEEKS, MONTHS, ASTRONOMICAL_YEAR);
    public static EnumSet<Units> groupWeight = EnumSet.of(GRAM, CARAT, ENGLISH_POUND, POUND, RUSSIAN_POUND, STONE);
    public static EnumSet<Units> groupVolume = EnumSet.of(CUBIC_METRE, GALLON, PINT, QUARTS, BARREL, CUBIC_FOOT, CUBIC_INCH);


    private final double valueInStandardUnit;
    private final String name;
    private double auxiliaryValue;

    Units(double valueInStandardUnit, String name) {
        this.valueInStandardUnit = valueInStandardUnit;
        this.name = name;
    }

    Units(double valueInStandardUnit, double auxiliaryValue, String name) {
        this.valueInStandardUnit = valueInStandardUnit;
        this.name = name;
        this.auxiliaryValue = auxiliaryValue;
    }

    public double getValueInStandardUnit(){return valueInStandardUnit;}
    public String getName(){return name;}
    public double getAuxiliaryValue(){return auxiliaryValue;}
}
