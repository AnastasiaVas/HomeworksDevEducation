import trees.impl.AVLTree;
import trees.impl.BSTreeProcedural;
import trees.impl.BSTreeRecursive;

import java.util.Arrays;

public class Main {
    public static void main(String args[]){
        AVLTree avlTree1 = new AVLTree();
        avlTree1.init(new int[]{80,70,50,55,72,71,75,85,90});
        System.out.println(Arrays.toString(avlTree1.toArray()));
        avlTree1.prettyPrint();
        avlTree1.add(77);
        System.out.println("root is " + avlTree1.root.value);
        avlTree1.prettyPrint();
    }
}
