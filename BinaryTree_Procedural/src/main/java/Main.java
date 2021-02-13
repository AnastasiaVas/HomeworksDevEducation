import trees.impl.AVLTree;
import trees.impl.BSTreeProcedural;
import trees.impl.BSTreeRecursive;

import java.util.Arrays;

public class Main {
    public static void main(String args[]){
        AVLTree avlTree1 = new AVLTree();
        avlTree1.init(new int[]{80,70,50,72,85,83,90,95,88});
        System.out.println(Arrays.toString(avlTree1.toArray()));
        avlTree1.prettyPrint();
        avlTree1.add(100);
        avlTree1.prettyPrint();
        avlTree1.add(105);
        avlTree1.prettyPrint();
        avlTree1.add(105);
        System.out.println("root is " + avlTree1.root.value);
        avlTree1.prettyPrint();
    }
}
