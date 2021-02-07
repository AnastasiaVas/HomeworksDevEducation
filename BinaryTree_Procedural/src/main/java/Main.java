import trees.impl.BSTreeRecursive;

import java.util.Arrays;

public class Main {
    public static void main(String args[]){
        BSTreeRecursive bsTreeR1 = new BSTreeRecursive();
        BSTreeRecursive bsTreeR2 = new BSTreeRecursive();
        BSTreeRecursive bsTreeR3 = new BSTreeRecursive();

        bsTreeR1.init(new int[]{2,1,3});
        bsTreeR2.init(new int[]{80, 70, 50, 55, 72, 71, 75, 85});
        System.out.println(Arrays.toString(bsTreeR1.toArray()));
        System.out.println(Arrays.toString(bsTreeR2.toArray()));
        System.out.println(Arrays.toString(bsTreeR3.toArray()));
    }
}
