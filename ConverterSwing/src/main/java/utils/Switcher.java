package utils;

import claculations.*;

import static utils.Constants.LabelsText.*;

import javax.swing.*;
import java.awt.*;

public class Switcher {

    public double switchMeasurementSystems(JPanel panel, JTextField inputText, ICalculator calculator){
        double finValue = 0;
        JRadioButton radioButton;
        String lengthUnit;
        if (inputText.getText().isEmpty()) {
            throw new NullPointerException("Please, enter a value you want to convert.");
        } else {
            double receivedValue = Double.parseDouble(inputText.getText());

            for (Component c : panel.getComponents()) {
                radioButton = (JRadioButton) c;
                if (radioButton.isSelected()) {
                    lengthUnit = radioButton.getText();
                    String panelName = panel.getName();
                    if (panelName.equals(FROM)) {
                        finValue = calculator.valueFromStandardUnit(lengthUnit, receivedValue);
                    } else if (panelName.equals(TO)) {
                        finValue = calculator.valueToStandardUnit(lengthUnit, receivedValue);

                    }
                }
            }
            return finValue;
        }
    }
}
