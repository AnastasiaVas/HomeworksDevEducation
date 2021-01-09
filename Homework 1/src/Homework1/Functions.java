package Homework1;

public class Functions {
    public String dayNumToString(int num){
        if (num <1 || num > 7){
            throw new IllegalArgumentException("Entered value should fall between 1 and 7.");
        }
        String[] weekDaysStr = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        return weekDaysStr[num-1];
    }
}
