import trees.impl.*;

import java.util.Arrays;

public class Main {
    public static void main (String args[]){
        BSTree bsTree = new BSTree();
   //     bsTree.add(8);
   //     bsTree.add(1);
   //     bsTree.add(3);
   //     bsTree.add(9);
   //     bsTree.print();
        bsTree.init(new int[]{1,2,3,4,5,6,7,8,9,10});
        bsTree.print();
        bsTree.reverse();
        bsTree.print();
    }
}
