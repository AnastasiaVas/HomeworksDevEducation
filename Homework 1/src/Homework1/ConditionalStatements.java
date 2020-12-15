package Homework1;

public class ConditionalStatements {
    public static void main (String args[]) {
    }

    public static int sumOrMultiply(int a, int b){
        int answer;
        if (a % 2 == 0) answer = a*b;
        else answer = a+b;
        return answer;
    }

    public static String coordinates(int x, int y){
        String answer = "";
        if (x > 0){
            if (y > 0) answer = "The point lies in the first quadrant.";
            else if (y < 0) answer = "The point lies in the fourth quadrant.";
        }
        else if (x < 0){
            if (y > 0) answer = "The point lies in the second quadrant.";
            else if (y < 0) answer = "The point lies in the third quadrant.";
        }
        else if (x == 0 && y == 0){
            answer = "The point lies at the origin.";
        }
        else if (x == 0){
            answer = "The point lies on the X-axis.";
        }
        else if (y == 0){
        } answer = "The point lies on the Y-axis.";
        return answer;
    }

    public static int maxSumOrMultip (int a, int b, int c){
        return Math.max(a * b * c, a + b + c) + 3;
    }

    public static char studentEval(int grade){
        char evaluation = '-';
        try {
            if (grade < 0 || grade > 100) {
                throw new IllegalArgumentException("Entered value should be a digit that falls within a range 1-100");
            } else if (grade <= 19 && grade >= 0) evaluation = 'F';
            else if (grade >= 20 && grade <= 39) evaluation = 'E';
            else if (grade >= 40 && grade <= 59) evaluation = 'D';
            else if (grade >= 60 && grade <= 74) evaluation = 'C';
            else if (grade >= 75 && grade <= 89) evaluation = 'B';
            else evaluation = 'A';
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        return evaluation;
    }

    public static int sumOfPositiveNums(int... numbers){
        int sum = 0;
        for (int i: numbers){
            if (i > 0) sum += i;
        }
        return sum;
    }
}
