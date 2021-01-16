package view;

import static utils.Constants.LabelsText.*;

import javax.swing.*;
import java.awt.*;

public class PanelChanges {

    JPanel jp = new JPanel();
    JLabel label = new JLabel();

    public JPanel LengthPanelFromMeters(JPanel panel, ButtonGroup bGroup, JButton switchB, JButton backB) {
        UnitsPanels unitsPanels = new UnitsPanels();
        label.setText(FROM_METERS);
        jp = unitsPanels.LengthUnitsPanel(bGroup);
        jp.setName(FROM);
        PanelRevalidation(panel, switchB, backB);
        return jp;
    }

    public JPanel LengthPanelToMeters(JPanel panel, ButtonGroup bGroup, JButton switchB, JButton backB) {
        UnitsPanels unitsPanels = new UnitsPanels();
        label.setText(TO_METERS);
        jp = unitsPanels.LengthUnitsPanel(bGroup);
        jp.setName(TO);
        PanelRevalidation(panel, switchB, backB);
        return jp;
    }

    public JPanel TempPanelFromCelsius(JPanel panel, ButtonGroup bGroup, JButton switchB, JButton backB) {
        UnitsPanels unitsPanels = new UnitsPanels();
        label.setText(FROM_CELSIUS);
        jp = unitsPanels.TemperatureUnitsPanel(bGroup);
        jp.setName(FROM);
        PanelRevalidation(panel, switchB, backB);
        return jp;
    }

    public JPanel TempPanelToCelsius(JPanel panel, ButtonGroup bGroup, JButton switchB, JButton backB) {
        UnitsPanels unitsPanels = new UnitsPanels();
        label.setText(TO_CELSIUS);
        jp = unitsPanels.TemperatureUnitsPanel(bGroup);
        jp.setName(TO);
        PanelRevalidation(panel, switchB, backB);
        return jp;
    }

    public JPanel WeightPanelFromKG(JPanel panel, ButtonGroup bGroup, JButton switchB, JButton backB) {
        UnitsPanels unitsPanels = new UnitsPanels();
        label.setText(FROM_KG);
        jp = unitsPanels.WeightUnitsPanel(bGroup);
        jp.setName(FROM);
        PanelRevalidation(panel, switchB, backB);
        return jp;
    }

    public JPanel WeightPanelToKG(JPanel panel, ButtonGroup bGroup, JButton switchB, JButton backB) {
        UnitsPanels unitsPanels = new UnitsPanels();
        label.setText(TO_KG);
        jp = unitsPanels.WeightUnitsPanel(bGroup);
        jp.setName(TO);
        PanelRevalidation(panel, switchB, backB);
        return jp;
    }

    public JPanel TimePanelFromSec(JPanel panel, ButtonGroup bGroup, JButton switchB, JButton backB) {
        UnitsPanels unitsPanels = new UnitsPanels();
        label.setText(FROM_SECONDS);
        jp = unitsPanels.TimeUnitsPanel(bGroup);
        jp.setName(FROM);
        PanelRevalidation(panel, switchB, backB);
        return jp;
    }

    public JPanel TimePanelToSec(JPanel panel, ButtonGroup bGroup, JButton switchB, JButton backB) {
        UnitsPanels unitsPanels = new UnitsPanels();
        label.setText(TO_SECONDS);
        jp = unitsPanels.TimeUnitsPanel(bGroup);
        jp.setName(TO);
        PanelRevalidation(panel, switchB, backB);
        return jp;
    }

    public JPanel VolumePanelFromLiters(JPanel panel, ButtonGroup bGroup, JButton switchB, JButton backB) {
        UnitsPanels unitsPanels = new UnitsPanels();
        label.setText(FROM_LITERS);
        jp = unitsPanels.VolumeVUnitsPanel(bGroup);
        jp.setName(FROM);
        PanelRevalidation(panel, switchB, backB);
        return jp;
    }

    public JPanel VolumePanelToLiters(JPanel panel, ButtonGroup bGroup, JButton switchB, JButton backB) {
        UnitsPanels unitsPanels = new UnitsPanels();
        label.setText(TO_LITERS);
        jp = unitsPanels.VolumeVUnitsPanel(bGroup);
        jp.setName(TO);
        PanelRevalidation(panel, switchB, backB);
        return jp;
    }

    public void PanelRevalidation(JPanel panel, JButton switchB, JButton backB) {
        panel.revalidate();
        panel.removeAll();
        panel.repaint();
        label.setBounds(45, 100, 310, 40);
        switchB.setVisible(true);
        backB.setVisible(true);
        jp.setPreferredSize(new Dimension(290, 120));
        panel.add(label);
        panel.add(jp);
    }

}