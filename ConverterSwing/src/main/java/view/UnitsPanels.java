package view;

import javax.swing.*;
import java.awt.*;

public class UnitsPanels {

    public JPanel LengthUnitsPanel(ButtonGroup bGroup){
        JPanel jp = new JPanel();
        JRadioButton kmRB = new JRadioButton("km");
        JRadioButton mileRB = new JRadioButton("mile");
        JRadioButton nauticalMileRB = new JRadioButton("nautical mile");
        JRadioButton cableRB = new JRadioButton("cable");
        JRadioButton leagueRB = new JRadioButton("league");
        JRadioButton footRB = new JRadioButton("foot");
        JRadioButton yardRB = new JRadioButton("yard");
        jp.setPreferredSize(new Dimension(290, 110));

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

        return jp;
    }

    public JPanel TemperatureUnitsPanel(ButtonGroup bGroup){
        JPanel jp = new JPanel();
        JRadioButton kelvinRB = new JRadioButton("Kelvin scale");
        JRadioButton fahrenheitRB = new JRadioButton("Fahrenheit scale");
        JRadioButton romerRB = new JRadioButton("Römer scale");
        JRadioButton rankinRB = new JRadioButton("Rankine scale");
        JRadioButton newtoneRB = new JRadioButton("Newton scale");
        JRadioButton delisleRB = new JRadioButton("Delisle scale");
        jp.setPreferredSize(new Dimension(290, 110));

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

        return jp;
    }

    public JPanel WeightUnitsPanel(ButtonGroup bGroup){
        JPanel jp = new JPanel();
        JRadioButton gRB = new JRadioButton("gram");
        JRadioButton caratRB = new JRadioButton("carat");
        JRadioButton engPoundRB = new JRadioButton( "eng pound");
        JRadioButton poundRB = new JRadioButton("pound");
        JRadioButton stoneRB = new JRadioButton("stone");
        JRadioButton rusPoundRB = new JRadioButton("rus pound");
        jp.setPreferredSize(new Dimension(290, 110));

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

        return jp;
    }

    public JPanel TimeUnitsPanel(ButtonGroup bGroup){
        JPanel jp = new JPanel();
        JRadioButton minRB = new JRadioButton("minutes");
        JRadioButton hourRB = new JRadioButton("hours");
        JRadioButton dayRB = new JRadioButton( "days");
        JRadioButton weekRB = new JRadioButton("weeks");
        JRadioButton monthRB = new JRadioButton("months");
        JRadioButton astrYearRB = new JRadioButton("Astronomical Year");
        jp.setPreferredSize(new Dimension(290, 110));

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

        return jp;
    }

    public JPanel VolumeVUnitsPanel(ButtonGroup bGroup){
        JPanel jp = new JPanel();
        JRadioButton cubicMetreRB = new JRadioButton("cubic metre");
        JRadioButton gallonRB = new JRadioButton("gallon");
        JRadioButton pintRB = new JRadioButton( "pint");
        JRadioButton quartRB = new JRadioButton("quart");
        JRadioButton barrelRB = new JRadioButton("barrel");
        JRadioButton cubicFootRB = new JRadioButton("cubic foot");
        JRadioButton cubicInchRB = new JRadioButton("cubic inch");
        jp.setPreferredSize(new Dimension(290, 110));

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

        return jp;
    }
}
