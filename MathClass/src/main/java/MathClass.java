import java.awt.*;
import java.awt.geom.Point2D;

public class MathClass {
    public static void main (String args[]){
        System.out.println(equation(-1));
    }


    public static double projectileRangeInDegrees(double initSpeed, double angle) {
        double angleDeg = Math.toRadians(angle);
        return projectileRangeInRad(initSpeed, angleDeg);
    }

    public static double projectileRangeInRad(double initSpeed, double angle){
        double gravityAccel = 9.81;
        System.out.println(Math.sin(2*angle));
        return (Math.pow(initSpeed, 2) * Math.sin(2*angle) / gravityAccel);
    }

    public static double distanceBetweenTwoMovingCars(double car1Speed, double car2Speed, double initDistance, double time){
        double finDistance = Math.abs(initDistance + car1Speed*time + car2Speed*time);
        return finDistance;
    }

    public static int pointInTheArea(Point2D.Double point){
        Point point1 = new Point();
        point1.setLocation(0, -1);
        Point point2 = new Point();
        point2.setLocation(-2,2);
        Point point3 = new Point();
        point3.setLocation(2,2);
        Point point4 = new Point();
        point4.setLocation(0,0);
        double outerTriangleSide1 = (point1.getX() - point.getX()) * (point2.getY() - point1.getY()) - (point2.getX() - point1.getX()) * (point1.getY() - point.getY());
        double outerTriangleSide2 = (point2.getX() - point.getX()) * (point3.getY() - point2.getY()) - (point3.getX() - point2.getX()) * (point2.getY() - point.getY());
        double outerTriangleSide3 = (point3.getX() - point.getX()) * (point1.getY() - point3.getY()) - (point1.getX() - point3.getX()) * (point3.getY() - point.getY());
        if ((outerTriangleSide1 >= 0 && outerTriangleSide2 >= 0 && outerTriangleSide3 >= 0) || (outerTriangleSide1 <= 0 && outerTriangleSide2 <= 0 && outerTriangleSide3 <= 0)) {
            double innerTriangleSide1 = (point4.getX() - point.getX()) * (point2.getY() - point4.getY()) - (point2.getX() - point4.getX()) * (point4.getY() - point.getY());
            double innerTriangleSide2 = (point2.getX() - point.getX()) * (point3.getY() - point2.getY()) - (point3.getX() - point2.getX()) * (point2.getY() - point.getY());
            double innerTriangleSide3 = (point3.getX() - point.getX()) * (point4.getY() - point3.getY()) - (point4.getX() - point3.getX()) * (point3.getY() - point.getY());
            if ((innerTriangleSide1 > 0 && innerTriangleSide2 > 0 && innerTriangleSide3 > 0) || (innerTriangleSide1 < 0 && innerTriangleSide2 < 0 && innerTriangleSide3 < 0)) {
                return 0;
            }
            else return 1;

        } else {
            return 0;
        }
    }

    public static double equation(double rad){
        double val1 = Math.sqrt(Math.exp(rad+1)+2*Math.exp(rad)*Math.cos(rad));
        double val2 = rad - Math.exp(rad + 1) * Math.sin(rad);
        double val3 = Math.abs(Math.cos(rad));
        double val4 = Math.exp(Math.sin(rad));
        double answer;
        if (val1 <= 0 || val2 <= 0 || val4 == 0) {
            throw new IllegalArgumentException("Input value is not acceptable.");
        }
        answer = (6 * Math.log(val1)) / (Math.log(val2) + val3 / val4);
        return answer;
    }
}
