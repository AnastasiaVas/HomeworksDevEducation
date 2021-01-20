package listeners;

import ui.PanThickness;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static utils.Constants.PanThicknessPanelControlNames.*;
import static ui.DrawArea.g2;
import static ui.PanThickness.panThicknessF;

public class PanThicknessBCL implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton) e.getSource();
        String sourceName = source.getText();
        changePanThickness(sourceName);
    }

    public void changePanThickness(String sourceName){
        switch (sourceName) {
            case THIN:
                g2.setStroke(new BasicStroke(1.0f));
                panThicknessF.dispose();
            case MEDIUM:
                g2.setStroke(new BasicStroke(5.0f));
                panThicknessF.dispose();
            case THICK:
                g2.setStroke(new BasicStroke(10.0f));
                panThicknessF.dispose();
        }
    }
}
