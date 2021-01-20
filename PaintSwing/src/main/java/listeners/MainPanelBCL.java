package listeners;

import io.FileChooserDemo;
import model.ColourFactory;
import ui.PanThickness;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import static ui.DrawArea.*;
import static ui.SwingPaint.*;
import static utils.Constants.MainPanelControlNames.*;

public class MainPanelBCL implements ActionListener {
    public PanThickness panThickness;
    FileChooserDemo fileChooser = new FileChooserDemo();
    FileChooserDemo.SaveImage saveImage = fileChooser.new SaveImage();

    ColourFactory colourFactory = new ColourFactory();

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton) e.getSource();
        String sourceName = source.getText();
        if (!sourceName.equals(CLEAR) && !sourceName.equals(ANOTHER_COLOR) && !sourceName.equals(SAVE) &&
                !sourceName.equals(OPEN) && !sourceName.equals(PAN_THICKNESS)) {
            chooseColor(sourceName);
        } else if (sourceName.equals(ANOTHER_COLOR)){
            chooseAnotherColor();
        } else if (sourceName.equals(SAVE)){
            try {
                saveImage.saveFile();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        } else if (sourceName.equals(OPEN)){
            saveImage.openFile();
        } else if (sourceName.equals(CLEAR)){
            drawArea.clear();
        }  else if (sourceName.equals(PAN_THICKNESS)){
            panThickness = new PanThickness();
        }
    }

    private void chooseColor(String sourceName) {
        if (colourFactory.getColour(sourceName) != null) {
            g2.setPaint(colourFactory.getColour(sourceName));
        }
    }

    public void chooseAnotherColor() {
        JLabel banner;
        JFrame ColorChooserDemo2 = new JFrame();
        banner = new JLabel("Pan Colour",
                JLabel.CENTER);
        banner.setForeground(Color.yellow);
        Color newColor = JColorChooser.showDialog(
                ColorChooserDemo2,
                "Choose pan colour",
                banner.getBackground());
        g2.setPaint(newColor);
    }

}
