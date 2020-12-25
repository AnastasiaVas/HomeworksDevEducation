package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelChanges {

    public JRadioButton kmRB;
    public JRadioButton mileRB;
    public JRadioButton nauticalMileRB;
    public JRadioButton cableRB;
    public JRadioButton leagueRB;
    public JRadioButton footRB;
    public JRadioButton yardRB;

    public JRadioButton kelvinRB;
    public JRadioButton fahrenheitRB;
    public JRadioButton romerRB;
    public JRadioButton rankinRB;
    public JRadioButton newtoneRB;
    public JRadioButton delisleRB;

    public JRadioButton gRB ;
    public JRadioButton caratRB;
    public JRadioButton engPoundRB;
    public JRadioButton poundRB;
    public JRadioButton stoneRB;
    public JRadioButton rusPoundRB;

    public void LengthPanel(JPanel panel, ButtonGroup bGroup){
        panel.revalidate();
        panel.removeAll();
        panel.repaint();
        JPanel jp = new JPanel();
        JLabel label = new JLabel();
        label.setBounds(45, 100, 310, 40);
        label.setText("Convert from meters to: ");
        panel.add(label);
        kmRB = new JRadioButton("km");
        mileRB = new JRadioButton("mile");
        nauticalMileRB = new JRadioButton("nautical mile");
        cableRB = new JRadioButton("cable");
        leagueRB = new JRadioButton("league");
        footRB = new JRadioButton("foot");
        yardRB = new JRadioButton("yard");
        jp.setPreferredSize(new Dimension(290, 120));

        jp.add(kmRB);
        jp.add(mileRB);
        jp.add(nauticalMileRB);
        jp.add(cableRB);
        jp.add(leagueRB);
        jp.add(footRB);
        jp.add(yardRB);

        bGroup.add(kmRB);
        bGroup.add(mileRB);
        bGroup.add(nauticalMileRB);
        bGroup.add(cableRB);
        bGroup.add(leagueRB);
        bGroup.add(footRB);
        bGroup.add(yardRB);

        panel.add(jp);
    }

    public void TemperaturePanel(JPanel panel, ButtonGroup bGroup){
        panel.revalidate();
        panel.removeAll();
        panel.repaint();
        JPanel jp = new JPanel();
        JLabel label = new JLabel();
        label.setBounds(45, 100, 310, 40);
        label.setText("Convert from celsius to: ");
        panel.add(label);
        kelvinRB = new JRadioButton("Kelvin scale");
        fahrenheitRB = new JRadioButton("Fahrenheit scale");
        romerRB = new JRadioButton("Römer scale");
        rankinRB = new JRadioButton("Rankine scale");
        newtoneRB = new JRadioButton("Newton scale");
        delisleRB = new JRadioButton("Delisle scale");
        jp.setPreferredSize(new Dimension(290, 120));

        jp.add(kelvinRB);
        jp.add(fahrenheitRB);
        jp.add(romerRB);
        jp.add(rankinRB);
        jp.add(newtoneRB);
        jp.add(delisleRB);

        bGroup.add(kelvinRB);
        bGroup.add(fahrenheitRB);
        bGroup.add(romerRB);
        bGroup.add(rankinRB);
        bGroup.add(newtoneRB);
        bGroup.add(delisleRB);

        panel.add(jp);
    }

    public void WeightPanel(JPanel panel, ButtonGroup bGroup){
        panel.revalidate();
        panel.removeAll();
        panel.repaint();
        JPanel jp = new JPanel();
        JLabel label = new JLabel();
        label.setBounds(45, 100, 310, 40);
        label.setText("Convert from kg to: ");
        panel.add(label);
        gRB = new JRadioButton("gram");
        caratRB = new JRadioButton("carat");
        engPoundRB = new JRadioButton( "eng pound");
        poundRB = new JRadioButton("pound");
        stoneRB = new JRadioButton("stone");
        rusPoundRB = new JRadioButton("rus pound");
        jp.setPreferredSize(new Dimension(290, 120));

        jp.add(gRB);
        jp.add(caratRB);
        jp.add(engPoundRB);
        jp.add(poundRB);
        jp.add(stoneRB);
        jp.add(rusPoundRB);

        bGroup.add(gRB);
        bGroup.add(caratRB);
        bGroup.add(engPoundRB);
        bGroup.add(poundRB);
        bGroup.add(stoneRB);
        bGroup.add(rusPoundRB);

        panel.add(jp);
    }

    public void TimePanel(JPanel panel, ButtonGroup bGroup){
        panel.revalidate();
        panel.removeAll();
        panel.repaint();
        JPanel jp = new JPanel();
        JLabel label = new JLabel();
        label.setBounds(45, 100, 310, 40);
        label.setText("Convert from seconds to: ");
        panel.add(label);
        JRadioButton minRB = new JRadioButton("minutes");
        JRadioButton hourRB = new JRadioButton("hours");
        JRadioButton dayRB = new JRadioButton( "days");
        JRadioButton weekRB = new JRadioButton("weeks");
        JRadioButton monthRB = new JRadioButton("months");
        JRadioButton astrYearRB = new JRadioButton("Astronomical Year");
        jp.setPreferredSize(new Dimension(290, 120));

        jp.add(minRB);
        jp.add(hourRB);
        jp.add(dayRB);
        jp.add(weekRB);
        jp.add(monthRB);
        jp.add(astrYearRB);

        bGroup.add(minRB);
        bGroup.add(hourRB);
        bGroup.add(dayRB);
        bGroup.add(weekRB);
        bGroup.add(monthRB);
        bGroup.add(astrYearRB);

        panel.add(jp);
    }

    public void VolumePanel(JPanel panel, ButtonGroup bGroup){
        panel.revalidate();
        panel.removeAll();
        panel.repaint();
        JPanel jp = new JPanel();
        JLabel label = new JLabel();
        label.setBounds(45, 100, 310, 40);
        label.setText("Convert from liters to: ");
        panel.add(label);
        JRadioButton cubicMetreRB = new JRadioButton("cubic metre");
        JRadioButton gallonRB = new JRadioButton("gallon");
        JRadioButton pintRB = new JRadioButton( "pint");
        JRadioButton quartRB = new JRadioButton("quart");
        JRadioButton barrelRB = new JRadioButton("barrel");
        JRadioButton cubicFootRB = new JRadioButton("cubic foot");
        JRadioButton cubicInchRB = new JRadioButton("cubic inch");
        jp.setPreferredSize(new Dimension(290, 120));

        jp.add(cubicMetreRB);
        jp.add(gallonRB);
        jp.add(pintRB);
        jp.add(quartRB);
        jp.add(barrelRB);
        jp.add(cubicFootRB);
        jp.add(cubicInchRB);

        bGroup.add(cubicMetreRB);
        bGroup.add(gallonRB);
        bGroup.add(pintRB);
        bGroup.add(quartRB);
        bGroup.add(barrelRB);
        bGroup.add(cubicFootRB);
        bGroup.add(cubicInchRB);

        panel.add(jp);
    }
}

/** C <--> K (Шкала Кельвина)*/
/** C <--> F (Шкала Фаренгейта)*/
/** C <--> Re (Шкала Реомюра) */
/** C <--> Ro (Шкала Рёмер)*/
/** C <--> Ra (Шкала Ранкина)*/
/** C <--> N (Шкала Ньютона)*/
/** C <--> D (Шкала Дели́ля)*/

