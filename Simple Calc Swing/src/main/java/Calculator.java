import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Calculator {
    JFrame frame;
    JLabel label1, label2, label3, label4;
    JTextField textF, textF2, textF3;
    JTextArea textArea;
    JButton button;

    Calculator() {
        frame = new JFrame();//creating instance of JFrame
        label1 = new JLabel("Число 1");
        label1.setBounds(45, 50, 100, 40);
        textF = new JTextField();
        textF.setBounds(150, 50, 190, 40);
        label2 = new JLabel("Число 2");
        label2.setBounds(45, 110, 100, 40);
        textF2 = new JTextField();
        textF2.setBounds(150, 110, 190, 40);
        label3 = new JLabel("Операция");
        label3.setBounds(45, 170, 100, 40);
        textF3 = new JTextField();
        textF3.setBounds(150, 170, 190, 40);
        button = new JButton("Посчитать");//creating instance of JButton
        button.setBounds(45, 230, 295, 40);
        label4 = new JLabel("Результат");
        label4.setBounds(45, 290, 100, 40);
        textArea = new JTextArea();
        textArea.setBounds(150, 290, 190, 100);
        textArea.setLineWrap(true);
        frame.add(label1);
        frame.add(label2);
        frame.add(label3);
        frame.add(textF);
        frame.add(textF2);
        frame.add(textF3);
        frame.add(button);//adding button in JFrame
        frame.add(label4);
        frame.add(textArea);
        frame.setSize(400, 500);//400 width and 500 height
        frame.setLayout(null);//using no layout managers
        frame.setVisible(true);//making the frame visible
        button.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                valuesGetter();
            }
        });
    }

    public void valuesGetter() {
        double num1 = Double.parseDouble(textF.getText());
        double num2 = Double.parseDouble(textF2.getText());
        char num3 = textF3.getText().charAt(0);
        double answer;
        try {
            if (num3 == '*') {
                answer = multiplication(num1, num2);
            } else if (num3 == '/') {
                answer = division(num1, num2);
            } else if (num3 == '+') {
                answer = addition(num1, num2);
            } else if (num3 == '-') {
                answer = subtraction(num1, num2);
            } else if (num3 == '%') {
                answer = remainder(num1, num2);
            } else {
                throw new IllegalArgumentException("Доступны только такие операции: *, /, +, -, %");
            }
            if (answer % 1 == 0){
                textArea.setText(String.valueOf((int)answer));
            }
            else {
                textArea.setText(String.valueOf(answer));
            }
        }
        catch (IllegalArgumentException e){
            textArea.setText(e.getMessage());
        }
        catch (ArithmeticException e){
            textArea.setText(e.getMessage());
        }
    }

    public double multiplication(double num1, double num2){
        return num1*num2;
    }

    public double division(double num1, double num2){
        if (num2 == 0){
            throw new ArithmeticException("Division by 0 is not possible.");
        }
        double result = num1/num2;
        return result;
    }

    public double addition(double num1, double num2){
        return num1+num2;
    }

    public double subtraction(double num1, double num2){
        return num1-num2;
    }

    public double remainder(double num1, double num2){
        return num1 % num2;
    }
}
