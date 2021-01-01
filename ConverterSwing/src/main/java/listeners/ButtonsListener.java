package listeners;

import utils.Switcher;
import view.PanelChanges;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonsListener implements ActionListener {

    private final ButtonGroup bGroup;
    private final JPanel panel;
    private final JButton button;
    private final JButton lengthB;
    private final JButton temperatureB;
    private final JButton weightB;
    private final JButton timeB;
    private final JButton volumeB;
    private String convCategory;
    private final JTextField inputText;
    private final JTextArea outputText;
    private final JButton switchB;
    JPanel jp;

    public ButtonsListener(JPanel panel, ButtonGroup bGroup, JButton button, JButton switchB, JButton lengthB, JButton temperatureB, JButton weightB, JButton timeB, JButton volumeB, JTextField inputText, JTextArea outputText) {
        this.bGroup = bGroup;
        this.panel = panel;
        this.button = button;
        this.lengthB = lengthB;
        this.temperatureB = temperatureB;
        this.weightB = weightB;
        this.timeB = timeB;
        this.volumeB = volumeB;
        this.inputText = inputText;
        this.outputText = outputText;
        this.switchB = switchB;
    }


    public void actionPerformed(ActionEvent e) {
        PanelChanges panelCh = new PanelChanges();
        Object source = e.getSource();
        Switcher switcher = new Switcher();
        if (source == button){
            try {
                switch (convCategory) {
                    case "length" -> {
                        double answerDouble = switcher.LengthSwitcher(jp, inputText);
                        if (answerDouble % 1 == 0) {
                            outputText.setText(String.valueOf((int) answerDouble));
                        } else {
                            outputText.setText(String.valueOf(answerDouble));
                        }
                    }
                    case "temperature" -> {
                    double answerDouble = switcher.TempSwitcher(jp, inputText);
                    if (answerDouble % 1 == 0) {
                        outputText.setText(String.valueOf((int) answerDouble));
                    } else {
                        outputText.setText(String.valueOf(answerDouble));
                    }
                }
                    case "weight" -> {
                        double answerDouble = switcher.WeightSwitcher(jp, inputText);
                        if (answerDouble % 1 == 0) {
                            outputText.setText(String.valueOf((int) answerDouble));
                        } else {
                            outputText.setText(String.valueOf(answerDouble));
                        }
                    }
                    case "time" -> {
                        double answerDouble = switcher.TimeSwitcher(jp, inputText);
                        if (answerDouble % 1 == 0) {
                            outputText.setText(String.valueOf((int) answerDouble));
                        } else {
                            outputText.setText(String.valueOf(answerDouble));
                        }
                    }
                    case "volume" -> {
                        double answerDouble = switcher.VolumeSwitcher(jp, inputText);
                        if (answerDouble % 1 == 0) {
                            outputText.setText(String.valueOf((int) answerDouble));
                        } else {
                            outputText.setText(String.valueOf(answerDouble));
                        }
                    }
                }
            }
            catch (NullPointerException ex){
                outputText.setText(ex.getMessage());
            }
        } else if (source == switchB) {
            String panelName = jp.getName();
            if (panelName.equals("From")) {
                switch (convCategory) {
                    case "length" -> jp = panelCh.LengthPanelToMeters(panel, bGroup, switchB);
                    case "temperature" -> jp = panelCh.TempPanelToCelsius(panel, bGroup, switchB);
                    case "weight" -> jp = panelCh.WeightPanelToKG(panel, bGroup, switchB);
                    case "time" -> jp = panelCh.TimePanelToSec(panel, bGroup, switchB);
                    case "volume" -> jp = panelCh.VolumePanelToLiters(panel, bGroup, switchB);
                }
            } else if (panelName.equals("To")) {
                switch (convCategory) {
                    case "length" -> jp = panelCh.LengthPanelFromMeters(panel, bGroup, switchB);
                    case "temperature" -> jp = panelCh.TempPanelFromCelsius(panel, bGroup, switchB);
                    case "weight" -> jp = panelCh.WeightPanelFromKG(panel, bGroup, switchB);
                    case "time" -> jp = panelCh.TimePanelFromSec(panel, bGroup, switchB);
                    case "volume" -> jp = panelCh.VolumePanelFromLiters(panel, bGroup, switchB);
                }
            }
        }else if (source == lengthB) {
            convCategory = "length";
            jp = panelCh.LengthPanelFromMeters(panel, bGroup, switchB);
        } else if (source == temperatureB){
            convCategory = "temperature";
            jp = panelCh.TempPanelFromCelsius(panel, bGroup, switchB);
        } else if (source == weightB) {
            convCategory = "weight";
            jp = panelCh.WeightPanelFromKG(panel, bGroup, switchB);
        } else if (source == timeB){
            convCategory = "time";
            jp = panelCh.TimePanelFromSec(panel, bGroup, switchB);
        } else if (source == volumeB) {
            convCategory = "volume";
            jp = panelCh.VolumePanelFromLiters(panel, bGroup, switchB);
        }

    }
}
