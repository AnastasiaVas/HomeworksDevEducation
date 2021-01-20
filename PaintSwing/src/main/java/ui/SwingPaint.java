package ui;

import listeners.MainPanelBCL;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;

import static utils.Constants.MainPanelControlNames.*;

public class SwingPaint {

    public JButton clearBtn, redBtn, greenBtn, blueBtn, yellowBtn, cyanBtn, magentaBtn, whiteBtn, blackBtn, grayBtn,
            light_grayBtn, dark_grayBtn, orangeBtn, pinkBtn, chooseAnotherColorBtn, saveBtn, openBtn, panThicknessBtn;
    public static DrawArea drawArea;

    public  SwingPaint(){
        redBtn = new JButton(RED);
        redBtn.setBackground(Color.red);
        greenBtn = new JButton(GREEN);
        greenBtn.setBackground(Color.green);
        blueBtn = new JButton(BLUE);
        blueBtn.setBackground(Color.blue);
        yellowBtn = new JButton(YELLOW);
        yellowBtn.setBackground(Color.yellow);
        cyanBtn = new JButton(CYAN);
        cyanBtn.setBackground(Color.cyan);
        magentaBtn = new JButton(MAGENTA);
        magentaBtn.setBackground(Color.magenta);
        whiteBtn = new JButton(WHITE);
        whiteBtn.setBackground(Color.white);
        blackBtn = new JButton(BLACK);
        blackBtn.setBackground(Color.black);
        grayBtn = new JButton(GRAY);
        grayBtn.setBackground(Color.gray);
        light_grayBtn = new JButton(LIGHT_GRAY);
        light_grayBtn.setBackground(Color.lightGray);
        dark_grayBtn = new JButton(DARK_GRAY);
        dark_grayBtn.setBackground(Color.darkGray);
        orangeBtn = new JButton(ORANGE);
        orangeBtn.setBackground(Color.orange);
        pinkBtn = new JButton(PINK);
        pinkBtn.setBackground(Color.pink);
        clearBtn = new JButton(CLEAR);
        chooseAnotherColorBtn = new JButton(ANOTHER_COLOR);
        chooseAnotherColorBtn.setFont(new Font("Arial", Font.BOLD, 10));
        saveBtn = new JButton(SAVE);
        openBtn = new JButton(OPEN);
        panThicknessBtn = new JButton(PAN_THICKNESS);
    }

    public void show(){

        ActionListener actionListener = new MainPanelBCL();

        JFrame frame = new JFrame(SWING_PAINT);
        Container content = frame.getContentPane();
        content.setLayout(new BorderLayout());
        drawArea = new DrawArea();

        content.add(drawArea, BorderLayout.CENTER);

        JPanel controls = new JPanel();

        redBtn.addActionListener(actionListener);
        greenBtn.addActionListener(actionListener);
        blueBtn.addActionListener(actionListener);
        yellowBtn.addActionListener(actionListener);
        cyanBtn.addActionListener(actionListener);
        magentaBtn.addActionListener(actionListener);
        whiteBtn.addActionListener(actionListener);
        blackBtn.addActionListener(actionListener);
        grayBtn.addActionListener(actionListener);
        light_grayBtn.addActionListener(actionListener);
        dark_grayBtn.addActionListener(actionListener);
        orangeBtn.addActionListener(actionListener);
        pinkBtn.addActionListener(actionListener);
        saveBtn.addActionListener(actionListener);
        openBtn.addActionListener(actionListener);
        panThicknessBtn.addActionListener(actionListener);

        clearBtn.addActionListener(actionListener);
        chooseAnotherColorBtn.addActionListener(actionListener);

        controls.add(saveBtn);
        controls.add(openBtn);
        controls.add(clearBtn);
        controls.add(panThicknessBtn);
        controls.add(chooseAnotherColorBtn);

        controls.setPreferredSize(new Dimension(100, 600));
        controls.setLayout(new GridLayout(17,1,0, 0));
        controls.add(redBtn);
        controls.add(greenBtn);
        controls.add(blueBtn);
        controls.add(yellowBtn);
        controls.add(cyanBtn);
        controls.add(magentaBtn);
        controls.add(whiteBtn);
        controls.add(blackBtn);
        controls.add(grayBtn);
        controls.add(light_grayBtn);
        controls.add(dark_grayBtn);
        controls.add(orangeBtn);

        frame.getContentPane().add(controls,EAST);

        frame.setSize(900, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

}