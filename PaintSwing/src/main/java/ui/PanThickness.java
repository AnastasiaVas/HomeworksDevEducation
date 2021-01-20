package ui;

import listeners.PanThicknessBCL;

import javax.swing.*;
import java.awt.event.ActionListener;
import static utils.Constants.PanThicknessPanelControlNames.*;

public class PanThickness {
    public static JFrame panThicknessF;
    JPanel panThicknessP;
    JButton thinB ;
    JButton mediumB;
    JButton thickB;
    ActionListener actionListener;
    public PanThickness(){
        panThicknessP = new JPanel();
        panThicknessF = new JFrame();
        thinB = new JButton(THIN);
        mediumB = new JButton(MEDIUM);
        thickB = new JButton(THICK);
        actionListener = new PanThicknessBCL();
        panThicknessP.add(thinB);
        panThicknessP.add(mediumB);
        panThicknessP.add(thickB);
        panThicknessF.add(panThicknessP);
        actionListener = new PanThicknessBCL();
        thinB.addActionListener(actionListener);
        mediumB.addActionListener(actionListener);
        thickB.addActionListener(actionListener);
        panThicknessF.setSize(200,100);
        panThicknessF.setVisible(true);
    }
}
