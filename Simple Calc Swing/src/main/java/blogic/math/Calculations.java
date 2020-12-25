package blogic.math;

public class Calculations {

    public double multiplication(double num1, double num2){
        return num1 * num2;
    }

    public double division(double num1, double num2){
        if (num2 == 0){
            throw new ArithmeticException("Division by 0 is not possible.");
        }

        return num1 / num2;
    }

    public double addition(double num1, double num2){
        return num1 + num2;
    }

    public double subtraction(double num1, double num2) {
        return num1 - num2;
    }

    public double remainder(double num1, double num2){
        return num1 % num2;
    }
}
