package view;

import listeners.ConversionCatButtonListener;
import utils.Constants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ConverterView {
    JFrame frame;
    JPanel panel;
    JLabel label1;
    JLabel label4;
    JTextField textF;
    JTextArea textArea;
    JButton button;
    ButtonGroup bGroup;
    public ConverterView() {
        panel = new JPanel();
        frame = new JFrame();
        bGroup = new ButtonGroup();
        label1 = new JLabel(Constants.ConvView.VALUE_TO_CONVERT);
        label1.setBounds(45, 50, 100, 40);
        textF = new JTextField();
        textF.setBounds(150, 50, 190, 40);
        label4 = new JLabel(Constants.ConvView.RESULT);
        label4.setBounds(45, 290, 100, 40);
        textArea = new JTextArea();
        textArea.setBounds(150, 290, 190, 100);
        button = new JButton(Constants.ConvView.CALCULATE);
        button.setBounds(45, 230, 295, 40);

        frame.add(button);
        frame.add(label1);
        frame.add(textF);
        frame.add(label4);
        frame.add(textArea);
        frame.add(panel, BorderLayout.CENTER);

        frame.setSize(400, 500);
        frame.setLayout(null);
        frame.setVisible(true);
        panel.setVisible(true);
        panel.setBounds(45, 100, 290, 120);
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

        panel.add(lengthB);
        panel.add(temperatureB);
        panel.add(weightB);
        panel.add(timeB);
        panel.add(volumeB);

        ActionListener listener = new ConversionCatButtonListener(panel, bGroup, button, lengthB, temperatureB, weightB, timeB, volumeB);

        button.addActionListener(listener);
        lengthB.addActionListener(listener);
        temperatureB.addActionListener(listener);
        weightB.addActionListener(listener);
        timeB.addActionListener(listener);
        volumeB.addActionListener(listener);
    }
}
