import java.awt.*;
import java.awt.geom.Point2D;

public class Main {
    public static void main(String args[]) {
        Point2D.Double point = new Point2D.Double(0, -1);
        System.out.println(MathClass.pointInTheArea(point));
    }
}
