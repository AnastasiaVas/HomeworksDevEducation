package model;
import java.awt.*;
import static utils.Constants.MainPanelControlNames.*;

public class ColourFactory {

    public Color getColour(String sourceName) {
        return switch (sourceName) {
            case BLACK -> Color.black;
            case BLUE -> Color.blue;
            case GREEN -> Color.green;
            case RED -> Color.red;
            case MAGENTA -> Color.magenta;
            case YELLOW -> Color.yellow;
            case CYAN -> Color.cyan;
            case WHITE -> Color.white;
            case GRAY -> Color.gray;
            case LIGHT_GRAY -> Color.lightGray;
            case DARK_GRAY -> Color.darkGray;
            case ORANGE -> Color.orange;
            case PINK -> Color.pink;
            default -> null;
        };
    }
}
