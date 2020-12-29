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
}
