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
