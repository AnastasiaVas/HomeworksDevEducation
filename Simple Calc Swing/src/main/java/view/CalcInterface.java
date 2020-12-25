package view;

import blogic.math.Calculations;
import listeners.ButtonClickListener;
import utils.Constants;

import javax.swing.*;
import java.awt.event.ActionListener;


public class CalcInterface {

    public CalcInterface() {
        JFrame frame = new JFrame();
        JLabel label1 = new JLabel(Constants.CalcInterfVals.VALUE_1);
        label1.setBounds(45, 50, 100, 40);
        JTextField textF = new JTextField();
        textF.setBounds(150, 50, 190, 40);
        JLabel label2 = new JLabel(Constants.CalcInterfVals.VALUE_2);
        label2.setBounds(45, 110, 100, 40);
        JTextField textF2 = new JTextField();
        textF2.setBounds(150, 110, 190, 40);
        JLabel label3 = new JLabel(Constants.CalcInterfVals.OPERATION);
        label3.setBounds(45, 170, 100, 40);
        JTextField textF3 = new JTextField();
        textF3.setBounds(150, 170, 190, 40);
        JButton button = new JButton(Constants.CalcInterfVals.CALCULATE);
        button.setBounds(45, 230, 295, 40);
        JLabel label4 = new JLabel(Constants.CalcInterfVals.RESULT);
        label4.setBounds(45, 290, 100, 40);
        JTextArea textArea = new JTextArea();
        textArea.setBounds(150, 290, 190, 100);
        textArea.setLineWrap(true);

        frame.add(label1);
        frame.add(label2);
        frame.add(label3);
        frame.add(textF);
        frame.add(textF2);
        frame.add(textF3);
        frame.add(button);
        frame.add(label4);
        frame.add(textArea);
        frame.setSize(400, 500);
        frame.setLayout(null);
        frame.setVisible(true);

        ActionListener listener = new ButtonClickListener(textF, textF2, textF3, textArea, new Calculations());

        button.addActionListener(listener);
    }
}
