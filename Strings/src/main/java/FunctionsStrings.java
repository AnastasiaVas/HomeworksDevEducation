import java.awt.*;
import java.util.Arrays;

public class FunctionsStrings {

    public int shortestWord(String input){
        String[] words = input.strip().split("[,;:.!?\\s]+");
        if (words.length == 0){
            throw new IllegalArgumentException("Input string has no words.");
        }
        int shortestWordLength = words[0].length();
        for (String str : words){
            int stringLength = str.length();
            if (stringLength < shortestWordLength){
                shortestWordLength = stringLength;
            }
        }
        return shortestWordLength;
    }

    public String[] replaceLastThreeSymb(String[] input, int wordLength){
        for (int i = 0; i < input.length; i++){
            int length = input[i].length();
            if (length == wordLength){
                char[] newString = input[i].toCharArray();
                for (int j = length - 3; j < length; j++) {
                    newString[j] = '$';
                }
                String output = "";
                for (char k : newString){
                    output += k;
                }
                input[i] = output;
            }
        }
        return input;
    }

    public String addSpacesAfterPunctMarks(String input){
        char[] charStr = input.toCharArray();
        String output = "";
        int firstID = 0;
        for (int i = 0; i < charStr.length; i++){
            char symb = charStr[i];
            if (symb == ',' || symb == '.' || symb == '!' || symb == '?' || symb == ';'|| symb == ':'){
                if (i == charStr.length - 1 || charStr[i+1] != ' ') {
                    for (int j = firstID; j <= i; j++) {
                        output += charStr[j];
                    }
                    if (i != charStr.length - 1) {
                        output += " ";
                    }
                }
                firstID = i + 1;
            }
        }
        return output;
    }

    public String oneCopyOfEachChar(String input){
        char[] output = new char[10];
        char[] inputCharArray = input.toCharArray();
        int count = 0;
        boolean inOutput = false;
        String outputStr = "";
        for (char str : inputCharArray){
            for (int i = 0; i < output.length; i++){
                if (str == output[i]){
                    inOutput = true;
                }
            }
            if (!inOutput) {
                output[count] = str;
                    count++;
                    if (count >= output.length - 1) {
                    char[] tempArray = output;
                    output = new char[output.length * 2 + 1];
                    for (int k = 0; k < tempArray.length; k++) {
                        output[k] = tempArray[k];
                    }
                }
            }
            inOutput = false;
        }
        for (char ch : output){
            if (ch != 0) {
                outputStr += ch;
            }
        }
        return outputStr;
    }

    public String numOfWords(String input){
        return null;
    }
}
