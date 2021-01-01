package utils;

import claculations.*;

import static utils.Constants.LabelsText.*;
import static utils.Constants.LengthUnits.*;
import static utils.Constants.TimeUnits.*;
import static utils.Constants.TemperatureUnits.*;
import static utils.Constants.VolumeUnits.*;
import static utils.Constants.WeightUnits.*;

import com.sun.tools.javac.Main;
import view.ConverterView;
import view.PanelChanges;

import javax.swing.*;
import java.awt.*;

public class Switcher {

    public double LengthSwitcher(JPanel panel, JTextField inputText) {
        double finValue = 0;
        JRadioButton radioButton;
        String lengthUnit;
        if (inputText.getText().isEmpty()) {
            throw new NullPointerException("Please, enter a value you want to convert.");
        } else {
            double receivedValue = Double.parseDouble(inputText.getText());

            for (Component c : panel.getComponents()) {
                radioButton = (JRadioButton) c;
                LengthCalc lengthCalc = new LengthCalc(receivedValue);
                if (radioButton.isSelected()) {
                    lengthUnit = radioButton.getText();
                    String panelName = panel.getName();
                    if (panelName.equals(FROM)) {
                        switch (lengthUnit) {
                            case KILOMETERS -> finValue = lengthCalc.fromKMCalc();
                            case MILES -> finValue = lengthCalc.fromMilesCalc();
                            case NAUTICAL_MILE -> finValue = lengthCalc.fromNautMilesCalc();
                            case CABLE -> finValue = lengthCalc.fromCableCalc();
                            case LEAGUE -> finValue = lengthCalc.fromLeagueCalc();
                            case FOOT -> finValue = lengthCalc.fromFootCalc();
                            case YARD -> finValue = lengthCalc.fromYardCalc();
                        }
                    } else if (panelName.equals(TO)) {
                        switch (lengthUnit) {
                            case KILOMETERS -> finValue = lengthCalc.toKMCalc();
                            case MILES -> finValue = lengthCalc.toMilesCalc();
                            case NAUTICAL_MILE -> finValue = lengthCalc.toNautMilesCalc();
                            case CABLE -> finValue = lengthCalc.toCableCalc();
                            case LEAGUE -> finValue = lengthCalc.toLeagueCalc();
                            case FOOT -> finValue = lengthCalc.toFootCalc();
                            case YARD -> finValue = lengthCalc.toYardCalc();
                        }
                    }
                }
            }
            return finValue;
        }
    }

    public double TempSwitcher(JPanel panel, JTextField inputText){
        double finValue = 0;
        JRadioButton radioButton;
        String lengthUnit;
        if (inputText.getText().isEmpty()) {
            throw new NullPointerException("Please, enter a value you want to convert.");
        } else {
            double receivedValue = Double.parseDouble(inputText.getText());

            for (Component c : panel.getComponents()) {
                radioButton = (JRadioButton) c;
                TemperatureCalc tempCalc = new TemperatureCalc(receivedValue);
                if (radioButton.isSelected()) {
                    lengthUnit = radioButton.getText();
                    String panelName = panel.getName();
                    if (panelName.equals(FROM)) {
                        switch (lengthUnit) {
                            case FAHRENHEIT_SCALE -> finValue = tempCalc.fromFahrenheitCalc();
                            case ROMER_SCALE -> finValue = tempCalc.fromRomerCalc();
                            case RANKIN_SCALE -> finValue = tempCalc.fromRankinCalc();
                            case NEWTON_SCALE -> finValue = tempCalc.fromNewtoneCalc();
                            case DELISLE_SCALE -> finValue = tempCalc.fromDelisleCalc();
                            case KELVIN_SCALE -> finValue = tempCalc.fromKelvinCalc();
                        }
                    } else if (panelName.equals(TO)) {
                        switch (lengthUnit) {
                            case FAHRENHEIT_SCALE -> finValue = tempCalc.toFahrenheitCalc();
                            case ROMER_SCALE -> finValue = tempCalc.toRomerCalc();
                            case RANKIN_SCALE -> finValue = tempCalc.toRankinCalc();
                            case NEWTON_SCALE -> finValue = tempCalc.toNewtoneCalc();
                            case DELISLE_SCALE -> finValue = tempCalc.toDelisleCalc();
                            case KELVIN_SCALE -> finValue = tempCalc.toKelvinCalc();
                        }
                    }
                }
            }
            return finValue;
        }
    }

    public double WeightSwitcher(JPanel panel, JTextField inputText){
        double finValue = 0;
        JRadioButton radioButton;
        String lengthUnit;
        if (inputText.getText().isEmpty()) {
            throw new NullPointerException("Please, enter a value you want to convert.");
        } else {
            double receivedValue = Double.parseDouble(inputText.getText());

            for (Component c : panel.getComponents()) {
                radioButton = (JRadioButton) c;
                WeightCalc weightCalc = new WeightCalc(receivedValue);
                if (radioButton.isSelected()) {
                    lengthUnit = radioButton.getText();
                    String panelName = panel.getName();
                    if (panelName.equals(FROM)) {
                        switch (lengthUnit) {
                            case GRAM -> finValue = weightCalc.fromGramCalc();
                            case CARAT -> finValue = weightCalc.fromCaratCalc();
                            case ENGLISH_POUND -> finValue = weightCalc.fromEngPoundCalc();
                            case POUND -> finValue = weightCalc.fromPoundCalc();
                            case RUSSIAN_POUND -> finValue = weightCalc.fromRusPoundCalc();
                            case STONE -> finValue = weightCalc.fromStoneCalc();
                        }
                    } else if (panelName.equals(TO)) {
                        switch (lengthUnit) {
                            case GRAM -> finValue = weightCalc.toGramCalc();
                            case CARAT -> finValue = weightCalc.toCaratCalc();
                            case ENGLISH_POUND -> finValue = weightCalc.toEngPoundCalc();
                            case POUND -> finValue = weightCalc.toPoundCalc();
                            case RUSSIAN_POUND -> finValue = weightCalc.toRusPoundCalc();
                            case STONE -> finValue = weightCalc.toStoneCalc();
                        }
                    }
                }
            }
            return finValue;
        }
    }

    public double TimeSwitcher(JPanel panel, JTextField inputText){
        double finValue = 0;
        JRadioButton radioButton;
        String lengthUnit;
        if (inputText.getText().isEmpty()) {
            throw new NullPointerException("Please, enter a value you want to convert.");
        } else {
            double receivedValue = Double.parseDouble(inputText.getText());

            for (Component c : panel.getComponents()) {
                radioButton = (JRadioButton) c;
                TimeCalc timeCalc = new TimeCalc(receivedValue);
                if (radioButton.isSelected()) {
                    lengthUnit = radioButton.getText();
                    String panelName = panel.getName();
                    if (panelName.equals(FROM)) {
                        switch (lengthUnit) {
                            case MINUTES -> finValue = timeCalc.fromMinuteCalc();
                            case HOURS -> finValue = timeCalc.fromHourCalc();
                            case DAYS -> finValue = timeCalc.fromDaysCalc();
                            case WEEKS -> finValue = timeCalc.fromWeeksCalc();
                            case MONTHS -> finValue = timeCalc.fromMonthsCalc();
                            case ASTRONOMICAL_YEAR -> finValue = timeCalc.fromAstrYearsCalc();
                        }
                    } else if (panelName.equals(TO)) {
                        switch (lengthUnit) {
                            case MINUTES -> finValue = timeCalc.toMinuteCalc();
                            case HOURS -> finValue = timeCalc.toHourCalc();
                            case DAYS -> finValue = timeCalc.toDaysCalc();
                            case WEEKS -> finValue = timeCalc.toWeeksCalc();
                            case MONTHS -> finValue = timeCalc.toMonthsCalc();
                            case ASTRONOMICAL_YEAR -> finValue = timeCalc.toAstrYearsCalc();
                        }
                    }
                }
            }
            return finValue;
        }
    }

    public double VolumeSwitcher(JPanel panel, JTextField inputText) {
        double finValue = 0;
        JRadioButton radioButton;
        String lengthUnit;
        if (inputText.getText().isEmpty()) {
            throw new NullPointerException("Please, enter a value you want to convert.");
        } else {
            double receivedValue = Double.parseDouble(inputText.getText());

            for (Component c : panel.getComponents()) {
                radioButton = (JRadioButton) c;
                VolumeCalc volumeCalc = new VolumeCalc(receivedValue);
                if (radioButton.isSelected()) {
                    lengthUnit = radioButton.getText();
                    String panelName = panel.getName();
                    if (panelName.equals(FROM)) {
                        switch (lengthUnit) {
                            case CUBIC_METRE -> finValue = volumeCalc.fromCubicMetreCalc();
                            case GALLON -> finValue = volumeCalc.fromGallonCalc();
                            case PINT -> finValue = volumeCalc.fromPintCalc();
                            case QUARTS -> finValue = volumeCalc.fromQuartCalc();
                            case BARREL -> finValue = volumeCalc.fromBarrelCalc();
                            case CUBIC_FOOT -> finValue = volumeCalc.fromCubicFootCalc();
                            case CUBIC_INCH -> finValue = volumeCalc.fromCubicInchCalc();
                        }
                    } else if (panelName.equals(TO)) {
                        switch (lengthUnit) {
                            case CUBIC_METRE -> finValue = volumeCalc.toCubicMetreCalc();
                            case GALLON -> finValue = volumeCalc.toGallonCalc();
                            case PINT -> finValue = volumeCalc.toPintCalc();
                            case QUARTS -> finValue = volumeCalc.toQuartCalc();
                            case BARREL -> finValue = volumeCalc.toBarrelCalc();
                            case CUBIC_FOOT -> finValue = volumeCalc.toCubicFootCalc();
                            case CUBIC_INCH -> finValue = volumeCalc.toCubicInchCalc();
                        }
                    }
                }
            }
            return finValue;
        }
    }
}
