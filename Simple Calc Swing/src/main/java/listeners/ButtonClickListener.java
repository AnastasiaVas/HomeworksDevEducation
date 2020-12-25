package listeners;

import blogic.math.Calculations;
import utils.Constants;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonClickListener implements ActionListener {

    private final JTextField textF;
    private final JTextField textF2;
    private final JTextField textF3;
    private final JTextArea textArea;
    private final Calculations calculations;

    public ButtonClickListener(JTextField textF, JTextField textF2, JTextField textF3, JTextArea textArea, Calculations calculations) {
        this.textF = textF;
        this.textF2 = textF2;
        this.textF3 = textF3;
        this.textArea = textArea;
        this.calculations = calculations;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        double num1 = Double.parseDouble(textF.getText());
        double num2 = Double.parseDouble(textF2.getText());
        char num3 = textF3.getText().charAt(0);
        double answer;
        try {
            if (num3 == '*') {
                answer = calculations.multiplication(num1, num2);
            } else if (num3 == '/') {
                answer = calculations.division(num1, num2);
            } else if (num3 == '+') {
                answer = calculations.addition(num1, num2);
            } else if (num3 == '-') {
                answer = calculations.subtraction(num1, num2);
            } else if (num3 == '%') {
                answer = calculations.remainder(num1, num2);
            } else {
                textArea.setText(Constants.ERROR_TEXT);
                return;
            }
        }
        catch (ArithmeticException ex){
            textArea.setText(ex.getMessage());
            return;
        }
        String result = answer % 1 == 0 ? String.valueOf((int) answer) : String.valueOf(answer);
        textArea.setText(result);
    }
}
