package listeners;

import utils.Switcher;
import view.PanelChanges;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConversionCatButtonListener implements ActionListener {

    private final ButtonGroup bGroup;
    private final JPanel panel;
    private final JButton button;
    private final JButton lengthB;
    private final JButton temperatureB;
    private final JButton weightB;
    private final JButton timeB;
    private final JButton volumeB;
    private String convCategory;

    public ConversionCatButtonListener(JPanel panel, ButtonGroup bGroup, JButton button, JButton lengthB, JButton temperatureB, JButton weightB, JButton timeB, JButton volumeB) {
        this.bGroup = bGroup;
        this.panel = panel;
        this.button = button;
        this.lengthB = lengthB;
        this.temperatureB = temperatureB;
        this.weightB = weightB;
        this.timeB = timeB;
        this.volumeB = volumeB;
    }

    public void actionPerformed(ActionEvent e) {
        PanelChanges panelC = new PanelChanges();
        Object source = e.getSource();
        Switcher switcher = new Switcher();

        if (source == button){
            Object selectedItem = bGroup.getSelection();
            switch (convCategory) {
                case "length" -> switcher.LengthSwitcher(selectedItem);
                case "temperature" -> switcher.TempSwitcher(selectedItem);
                case "weight" -> switcher.WeightSwitcher(selectedItem);
                case "time" -> switcher.TimeSwitcher(selectedItem);
                case "volume" -> switcher.VolumeSwitcher(selectedItem);
            }
        } else if (source == lengthB) {
            convCategory = "length";
            panelC.LengthPanel(panel, bGroup);
        } else if (source == temperatureB){
            convCategory = "temperature";
            panelC.TemperaturePanel(panel, bGroup);
        } else if (source == weightB) {
            convCategory = "weight";
            panelC.WeightPanel(panel, bGroup);
        } else if (source == timeB){
            convCategory = "time";
            panelC.TimePanel(panel, bGroup);
        } else if (source == volumeB) {
            convCategory = "volume";
            panelC.VolumePanel(panel, bGroup);
        }

    }
}
