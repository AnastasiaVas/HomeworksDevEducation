import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;

public class Randomizer {

    public static void main (String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int min, max;
        while (true) {
            while (true) {
                try {
                    System.out.println("Please enter minimum number.");
                    min = Integer.parseInt(reader.readLine());
                    if (min < 1 || min > 500) {
                        throw new IllegalArgumentException("Minimum number should be greater or equal to 1");
                    } else break;
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
            while (true) {
                try {
                    System.out.println("Please enter maximum number.");
                    max = Integer.parseInt(reader.readLine());
                    if (max > 500 || max < 1) {
                        throw new IllegalArgumentException("Maximum number should be less or equal to 500");
                    } else break;
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
            try {
                if (min > max) {
                    throw new InputMismatchException("Minimum number should be less or equal to maximum number.");
                }
                else break;
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
            }
        }
        ArrayList<Integer> digAlreadyCalled = new ArrayList<Integer>();
        while (true) {
            System.out.println("Please choose options: generate, help or exit");
            String answer = reader.readLine();
            if (answer.equalsIgnoreCase("generate")) {
                generate(min, max, digAlreadyCalled);
            }
            else if (answer.equalsIgnoreCase("exit")){
                exit();
            }
            else if (answer.equalsIgnoreCase("help")){
                help();
            }
        }
    }


    public static void generate(int min, int max, ArrayList<Integer> digAlreadyCalled){
        int numOfDigits = max-min+1;
        Random random = new Random();
        while (true) {
            int generateNumber = random.nextInt(numOfDigits);
            int randNumber = generateNumber + min;
            if (digAlreadyCalled.size() != numOfDigits){
                if (!digAlreadyCalled.contains(randNumber)) {
                    digAlreadyCalled.add(randNumber);
                    System.out.println("Random number is " + randNumber);
                    break;
                }
            }
            else{
                System.out.println("All possible numbers has already been generated");
                break;
            }
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

    public static void help() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                System.out.println("Please, enter a number of the option you need a help with: \n 1 - how to exit an app \n 2 - how to generate a random number \n 3 - generate a random number from different range \n 4 - exit help section");
                String answer = reader.readLine();
                if (!answer.equals("1") && !answer.equals("2") && !answer.equals("3") && !answer.equals("4")) {
                    throw new IllegalArgumentException("Please, enter digits 1, 2, 3 or 4.");
                }
                int answerInt = Integer.parseInt(answer);
                if (answerInt == 1) {
                    System.out.println("In order to exit an app you need to go back to main menu and choose an exit option by entering \"exit\".\n");
                    break;
                } else if (answerInt == 2) {
                    System.out.println("In order to generate a random number between the minimum and maximum values you've entered you need to go back to the main menu and choose a generate option by entering \"generate\".\n");
                }
                else if (answerInt == 3) {
                    System.out.println("In order to generate a random number from a different range you need to exit an app and run it again.\n");
                }
                else if (answerInt == 4) {
                    break;
                }
            }
            catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
