package view;

import listeners.ButtonsListener;
import utils.Constants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ConverterView {
    JFrame frame;
    public JPanel panel;
    JLabel label1;
    JLabel label4;
    JTextField inputText;
    JTextArea outputText;
    JButton button;
    public JButton backB;
    public JButton switchB;
    ButtonGroup bGroup;
    public JButton lengthB;
    public JButton temperatureB;
    public JButton weightB;
    public JButton timeB;
    public JButton volumeB;
    public ConverterView() {
        panel = new JPanel();
        frame = new JFrame();
        bGroup = new ButtonGroup();
        backB = new JButton();
        backB.setText("Go Back");
        label1 = new JLabel(Constants.ConvView.VALUE_TO_CONVERT);
        label1.setBounds(45, 50, 100, 40);
        inputText = new JTextField();
        inputText.setBounds(150, 50, 190, 40);
        label4 = new JLabel(Constants.ConvView.RESULT);
        label4.setBounds(45, 330, 100, 40);
        outputText = new JTextArea();
        outputText.setBounds(150, 330, 190, 100);
        button = new JButton(Constants.ConvView.CALCULATE);
        button.setBounds(50, 270, 300, 40);

        frame.add(button);
        frame.add(label1);
        frame.add(inputText);
        frame.add(label4);
        frame.add(outputText);
        frame.add(panel, BorderLayout.CENTER);

        frame.setSize(400, 500);
        frame.setLayout(null);
        frame.setVisible(true);
        panel.setBounds(45, 100, 290, 110);
        panel.setVisible(true);

        lengthB = new JButton(Constants.ConvView.LENGTH);
        temperatureB = new JButton(Constants.ConvView.TEMPERATURE);
        weightB = new JButton(Constants.ConvView.WEIGHT);
        timeB = new JButton(Constants.ConvView.TIME);
        volumeB = new JButton(Constants.ConvView.VOLUME);

        char t = '\u21C4';
        switchB = new JButton(String.valueOf(t));
        Font newButtonFont=new Font(switchB.getFont().getName(),switchB.getFont().getStyle(),20);
        switchB.setFont(newButtonFont);
        switchB.setBounds(50,220,140,30);
        switchB.setVisible(false);
        backB.setBounds(210,220,140,30);
        backB.setVisible(false);

        panel.add(lengthB);
        panel.add(temperatureB);
        panel.add(weightB);
        panel.add(timeB);
        panel.add(volumeB);
        frame.add(switchB);
        frame.add(backB);

        ActionListener listener = new ButtonsListener(panel, bGroup, button, switchB, lengthB, temperatureB, weightB, timeB, volumeB, inputText, outputText, backB);

        button.addActionListener(listener);
        switchB.addActionListener(listener);
        backB.addActionListener(listener);
        lengthB.addActionListener(listener);
        temperatureB.addActionListener(listener);
        weightB.addActionListener(listener);
        timeB.addActionListener(listener);
        volumeB.addActionListener(listener);
    }
}
