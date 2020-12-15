import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    public static void main(String[] args) throws IOException {
        int pickedNumber = new Random().nextInt(99) + 1;
        System.out.println(pickedNumber);
        int numOfAttempts = 5;
        guessGame(pickedNumber, numOfAttempts);
    }

    public static void guessGame(int pickedNumber, int numOfAttempts) throws IOException {
        Scanner reader = new Scanner(System.in);
        int prevChoice = 0;
        int attempts = 0;
        while (attempts < numOfAttempts) {
            try {
                System.out.println("Guess a number between 1 and 100, you have 5 attempts in total. You can exit by entering \"exit\" at any time.");
                String answerStr = reader.nextLine();
                if (answerStr.equalsIgnoreCase("exit")) {
                    exit();
                } else {
                    int answer = Integer.parseInt(answerStr);
                    if (answer < 1 || answer > 100) {
                        throw new IllegalArgumentException("Entered value should fall between 1 and 100.");
                    } else if (answer == pickedNumber) {
                        System.out.println("Congrats! You won.");
                        break;
                    } else if (prevChoice != 0) {

                        if (Math.abs(prevChoice - pickedNumber) > Math.abs(answer - pickedNumber)) {
                            System.out.println("You are getting closer!");
                        } else {
                            System.out.println("You are getting colder :(");
                        }
                    } else {
                        System.out.println("You've got 4 more attempts!");
                    }
                    prevChoice = answer;
                    attempts++;
                }
            } catch (NumberFormatException e) {
                System.out.println("Entered value should be an integer.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        if (attempts >= numOfAttempts) {
            System.out.println("Sorry, but you are out of attempts.");
        }
    }


    public static void exit() throws IOException {
        while (true) {
            System.out.println("Are you sure that you want to quit the app?");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String answer = reader.readLine();
            if (answer.toLowerCase().equals("yes")) System.exit(0);
            else if (!answer.toLowerCase().equals("no")) System.out.println("Please answer \"yes\" or \"no\"");
            else break;
        }
    }
}
