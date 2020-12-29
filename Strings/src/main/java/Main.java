import java.util.Arrays;

public class Main {

    public static void main (String args[]){
        FunctionsStrings str = new FunctionsStrings();
        String[] array = {"Apple", "Peach", "Watermelon", "Ginger", "Avocado"};
        System.out.println(Arrays.toString(str.replaceLastThreeSymb(array, 5)));
    }
}
