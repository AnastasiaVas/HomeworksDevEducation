package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Randomizer {

    Random random = new Random();
    ArrayList<Integer> digAlreadyCalled = new ArrayList<Integer>();

    public int[] rand(int min, int max, int numOfDigGenerated) {
        ArrayList<Integer> digAlreadyCalled = new ArrayList<Integer>();
        if (numOfDigGenerated > (max-min+1)){
            throw new IllegalArgumentException("Number of digits to generate shouldn't be bigger than number of digits within a given range.");
        }
        int[] randNums = new int[numOfDigGenerated];
        int numOfDigits = max - min+1;
        Random random = new Random();
        for (int i = 0; i < numOfDigGenerated; i++) {
            while (true) {
                int generateNumber = random.nextInt(numOfDigits);
                int randNumber = generateNumber + min;
                    if (!digAlreadyCalled.contains(randNumber)) {
                        digAlreadyCalled.add(randNumber);
                        randNums[i] = randNumber;
                        break;
                    }
            }
        }
        return randNums;
    }

    public int[] rand(int min, int max, String rand) {
        ArrayList<Integer> digAlreadyCalled = new ArrayList<Integer>();
        String answer = rand.toLowerCase();
        int numOfDigGenerated;
        if (answer.equals("random")) {
            numOfDigGenerated = random.nextInt(12) + 3;
        } else {
            throw new IllegalArgumentException("String \"random\" should be provided as number of digits to generate.");
        }
        int[] randNums = new int[numOfDigGenerated];
        int numOfDigits = max - min + 1;
        for (int i = 0; i < numOfDigGenerated; i++) {
            while (true) {
                int generateNumber = random.nextInt(numOfDigits);
                int randNumber = generateNumber + min;
                if (!digAlreadyCalled.contains(randNumber)) {
                    digAlreadyCalled.add(randNumber);
                    randNums[i] = randNumber;
                    break;
                }
            }
        }
        return randNums;
    }

    public int[] rand(int numOfDigGenerated) {
        ArrayList<Integer> digAlreadyCalled = new ArrayList<Integer>();
        int[] randNums = new int[numOfDigGenerated];
        for (int i = 0; i < numOfDigGenerated; i++) {
            while (true) {
                int randNumber = random.nextInt();
                if (!digAlreadyCalled.contains(randNumber)) {
                    digAlreadyCalled.add(randNumber);
                    randNums[i] = randNumber;
                    break;
                }
            }
        }
        return randNums;
    }

}
