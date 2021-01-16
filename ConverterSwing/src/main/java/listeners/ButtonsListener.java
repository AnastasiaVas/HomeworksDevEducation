package listeners;

import claculations.*;
import main.Main;
import utils.Switcher;
import view.ConverterView;
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
    private final JButton backB;
    JPanel jp;
    ICalculator calculator;

    public ButtonsListener(JPanel panel, ButtonGroup bGroup, JButton button, JButton switchB, JButton lengthB, JButton temperatureB, JButton weightB, JButton timeB, JButton volumeB, JTextField inputText, JTextArea outputText, JButton backB) {
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
        this.backB = backB;
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
            } catch (NumberFormatException ex){
                outputText.setText("Entered value should be a digit.");
            }
        } else if (source == switchB) {
            String panelName = jp.getName();
            if (panelName.equals(FROM)) {
                switch (convCategory) {
                    case LENGTH -> jp = panelCh.LengthPanelToMeters(panel, bGroup, switchB, backB);
                    case TEMPERATURE -> jp = panelCh.TempPanelToCelsius(panel, bGroup, switchB, backB);
                    case WEIGHT -> jp = panelCh.WeightPanelToKG(panel, bGroup, switchB, backB);
                    case TIME -> jp = panelCh.TimePanelToSec(panel, bGroup, switchB, backB);
                    case VOLUME -> jp = panelCh.VolumePanelToLiters(panel, bGroup, switchB, backB);
                }
            } else if (panelName.equals(TO)) {
                switch (convCategory) {
                    case LENGTH -> jp = panelCh.LengthPanelFromMeters(panel, bGroup, switchB, backB);
                    case TEMPERATURE -> jp = panelCh.TempPanelFromCelsius(panel, bGroup, switchB, backB);
                    case WEIGHT -> jp = panelCh.WeightPanelFromKG(panel, bGroup, switchB, backB);
                    case TIME -> jp = panelCh.TimePanelFromSec(panel, bGroup, switchB, backB);
                    case VOLUME -> jp = panelCh.VolumePanelFromLiters(panel, bGroup, switchB, backB);
                }
            }
        } else if (source == lengthB) {
            calculator = new LengthCalc();
            convCategory = LENGTH;
            jp = panelCh.LengthPanelFromMeters(panel, bGroup, switchB, backB);
        } else if (source == temperatureB) {
            calculator = new TemperatureCalc();
            convCategory = TEMPERATURE;
            jp = panelCh.TempPanelFromCelsius(panel, bGroup, switchB, backB);
        } else if (source == weightB) {
            calculator = new WeightCalc();
            convCategory = WEIGHT;
            jp = panelCh.WeightPanelFromKG(panel, bGroup, switchB, backB);
        } else if (source == timeB) {
            calculator = new TimeCalc();
            convCategory = TIME;
            jp = panelCh.TimePanelFromSec(panel, bGroup, switchB, backB);
        } else if (source == volumeB) {
            calculator = new VolumeCalc();
            convCategory = VOLUME;
            jp = panelCh.VolumePanelFromLiters(panel, bGroup, switchB, backB);
        } else if (source == backB){
            panel.revalidate();
            panel.removeAll();
            panel.repaint();
            panel.setBounds(45, 100, 290, 110);
            panel.setVisible(true);
            panel.add(lengthB);
            panel.add(temperatureB);
            panel.add(weightB);
            panel.add(timeB);
            panel.add(volumeB);
            switchB.setVisible(false);
            backB.setVisible(false);
        }

    }
}
