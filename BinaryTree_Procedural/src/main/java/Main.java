import trees.impl.BSTreeProcedural;
import trees.impl.BSTreeRecursive;

import java.util.Arrays;

public class Main {
    public static void main(String args[]){
        BSTreeProcedural bsTreeP1 = new BSTreeProcedural();
        BSTreeRecursive bsTreeP2 = new BSTreeRecursive();
        bsTreeP1.init(new int[]{55, 50, 71, 75, 72, 70, 85, 80});
   //     bsTreeP1.del(50);
        bsTreeP1.print();

   //     bsTreeP1.init(new int[]{2,1,3});

    }
}