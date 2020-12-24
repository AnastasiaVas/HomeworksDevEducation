package tests;

import main.Randomizer;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class RandomizerTests {
    static Randomizer random;
    @BeforeAll
    public static void beforeAll(){
        random = new Randomizer();
    }

    @Test
    public void randomizerTest_ONE_RAND_NUM(){
        int[] randNum = random.rand(1);
        System.out.println(Arrays.toString(randNum));
    }

    @Test
    public void randomizerTest_TEN_RAND_NUMBERS(){
        int[] array = random.rand(10);
        System.out.println(Arrays.toString(array));
    }

    @Test
    public void randomizerTest_TEN_RAND_NUMBERS_FROM_1_TO_10(){
        int[] array = random.rand(1,10,10);
        System.out.println(Arrays.toString(array));
    }

    @Test
    public void randomizerTest_TEN_RAND_NUMBERS_FROM_20_TO_50(){
        int[] array = random.rand(20,50,10);
        System.out.println(Arrays.toString(array));
    }

    @Test
    public void randomizerTest_TEN_RAND_NUMBERS_FROM_min10_TO_10(){
        int[] array = random.rand(-10,10,10);
        System.out.println(Arrays.toString(array));
    }

    @Test
    public void randomizerTest_RAND_NUMBER_OF_RAND_NUMBERS_FROM_min10_TO_35(){
        int[] array = random.rand(-10,35,"random");
        System.out.println(Arrays.toString(array));
    }

}
