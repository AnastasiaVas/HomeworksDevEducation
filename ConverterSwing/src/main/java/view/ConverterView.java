package view;

import listeners.ButtonsListener;
import utils.Constants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ConverterView {
    JFrame frame;
    JPanel panel;
    JLabel label1;
    JLabel label4;
    JTextField inputText;
    JTextArea outputText;
    JButton button;
    ButtonGroup bGroup;
    public ConverterView() {
        panel = new JPanel();
        frame = new JFrame();
        bGroup = new ButtonGroup();
        label1 = new JLabel(Constants.ConvView.VALUE_TO_CONVERT);
        label1.setBounds(45, 50, 100, 40);
        inputText = new JTextField();
        inputText.setBounds(150, 50, 190, 40);
        label4 = new JLabel(Constants.ConvView.RESULT);
        label4.setBounds(45, 330, 100, 40);
        outputText = new JTextArea();
        outputText.setBounds(150, 330, 190, 100);
        button = new JButton(Constants.ConvView.CALCULATE);
        button.setBounds(45, 270, 295, 40);

        frame.add(button);
        frame.add(label1);
        frame.add(inputText);
        frame.add(label4);
        frame.add(outputText);
        frame.add(panel, BorderLayout.CENTER);

        frame.setSize(400, 500);
        frame.setLayout(null);
        frame.setVisible(true);
        panel.setVisible(true);
        panel.setBounds(45, 100, 290, 110);
        panel.setVisible(true);

        JButton lengthB = new JButton(Constants.ConvView.LENGTH);
        JButton temperatureB = new JButton(Constants.ConvView.TEMPERATURE);
        JButton weightB = new JButton(Constants.ConvView.WEIGHT);
        JButton timeB = new JButton(Constants.ConvView.TIME);
        JButton volumeB = new JButton(Constants.ConvView.VOLUME);
        lengthB.setBounds(45, 100, 50, 40);
        temperatureB.setBounds(105, 100, 50, 40);
        weightB.setBounds(165, 100, 50, 40);
        timeB.setBounds(225, 100, 50, 40);
        volumeB.setBounds(45, 150, 50, 40);

        char t = '\u21C4';
        JButton switchB = new JButton(String.valueOf(t));
        Font newButtonFont=new Font(switchB.getFont().getName(),switchB.getFont().getStyle(),20);
        switchB.setFont(newButtonFont);
        switchB.setBounds(150,220,100,30);
        switchB.setVisible(false);

        panel.add(lengthB);
        panel.add(temperatureB);
        panel.add(weightB);
        panel.add(timeB);
        panel.add(volumeB);
        frame.add(switchB);

        ActionListener listener = new ButtonsListener(panel, bGroup, button, switchB, lengthB, temperatureB, weightB, timeB, volumeB, inputText, outputText);

        button.addActionListener(listener);
        switchB.addActionListener(listener);
        lengthB.addActionListener(listener);
        temperatureB.addActionListener(listener);
        weightB.addActionListener(listener);
        timeB.addActionListener(listener);
        volumeB.addActionListener(listener);
    }
}
