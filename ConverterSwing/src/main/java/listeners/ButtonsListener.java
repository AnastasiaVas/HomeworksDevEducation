package listeners;

import claculations.*;
import utils.Switcher;
import view.PanelChanges;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static utils.Constants.ConvView.*;
import static utils.Constants.LabelsText.*;

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
    ICalculator calculator;

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
        if (source == button) {
            try {
                double answerDouble = switcher.switchMeasurementSystems(jp, inputText, calculator);
                if (answerDouble % 1 == 0) {
                    outputText.setText(String.valueOf((int) answerDouble));
                } else {
                    outputText.setText(String.valueOf(answerDouble));
                }
            } catch (NullPointerException ex) {
                outputText.setText(ex.getMessage());
            }
        } else if (source == switchB) {
            String panelName = jp.getName();
            if (panelName.equals(FROM)) {
                switch (convCategory) {
                    case LENGTH -> jp = panelCh.LengthPanelToMeters(panel, bGroup, switchB);
                    case TEMPERATURE -> jp = panelCh.TempPanelToCelsius(panel, bGroup, switchB);
                    case WEIGHT -> jp = panelCh.WeightPanelToKG(panel, bGroup, switchB);
                    case TIME -> jp = panelCh.TimePanelToSec(panel, bGroup, switchB);
                    case VOLUME -> jp = panelCh.VolumePanelToLiters(panel, bGroup, switchB);
                }
            } else if (panelName.equals(TO)) {
                switch (convCategory) {
                    case LENGTH -> jp = panelCh.LengthPanelFromMeters(panel, bGroup, switchB);
                    case TEMPERATURE -> jp = panelCh.TempPanelFromCelsius(panel, bGroup, switchB);
                    case WEIGHT -> jp = panelCh.WeightPanelFromKG(panel, bGroup, switchB);
                    case TIME -> jp = panelCh.TimePanelFromSec(panel, bGroup, switchB);
                    case VOLUME -> jp = panelCh.VolumePanelFromLiters(panel, bGroup, switchB);
                }
            }
        } else if (source == lengthB) {
            calculator = new LengthCalc();
            convCategory = LENGTH;
            jp = panelCh.LengthPanelFromMeters(panel, bGroup, switchB);
        } else if (source == temperatureB) {
            calculator = new TemperatureCalc();
            convCategory = TEMPERATURE;
            jp = panelCh.TempPanelFromCelsius(panel, bGroup, switchB);
        } else if (source == weightB) {
            calculator = new WeightCalc();
            convCategory = WEIGHT;
            jp = panelCh.WeightPanelFromKG(panel, bGroup, switchB);
        } else if (source == timeB) {
            calculator = new TimeCalc();
            convCategory = TIME;
            jp = panelCh.TimePanelFromSec(panel, bGroup, switchB);
        } else if (source == volumeB) {
            calculator = new VolumeCalc();
            convCategory = VOLUME;
            jp = panelCh.VolumePanelFromLiters(panel, bGroup, switchB);
        }

    }
}
