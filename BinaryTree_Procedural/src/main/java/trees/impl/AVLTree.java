package trees.impl;

import trees.ITree;

public class AVLTree implements ITree {

    public Node root;

    public class Node {
        public int value; // holds the key
        public Node parent; // pointer to the parent
        public Node left; // pointer to left child
        public Node right; // pointer to right child
        int balanceF; // balance factor of the node
        int height;

        public Node(int data) {
            this.value = data;
            this.parent = null;
            this.left = null;
            this.right = null;
            this.balanceF = 0;
            this.height = 0;
        }
    }

    @Override
    public void init(int[] ar) {
        for (int i : ar) {
            add(i);
        }
    }

    @Override
    public void print() {
        printInternal(root);
    }

    private void printInternal(Node node) {
        if (node != null) {
            printInternal(node.left);
            System.out.print(node.value + " ");
            printInternal(node.right);
        }
    }

    @Override
    public void clear() {

    }

    @Override
    public int size() {
        return sizeInternal(root);
    }

    public int sizeInternal(Node node) {
        if (node != null) {
            return (sizeInternal(node.left) + sizeInternal(node.right) + 1);
        } else return 0;
    }

    @Override
    public int[] toArray() {
        int[] array = new int[size()];
        if (root == null){
            return array;
        }
        int i = 0;
        sortArray(root, array, i);
        return array;
    }

    private int sortArray(Node node, int[] array, int i) {
        if (node.left != null) {
            i = sortArray(node.left, array, i);
        }
        if (node.right != null) {
            i = sortArray(node.right, array, i);
        }
        array[i] = node.value;
        return ++i;
    }

    @Override
    public void add(int val) {
        root = addInternal(val, root);
    }

    private Node addInternal(int val, Node node) {
        if (node == null)
            node = new Node(val);
        else if (val < node.value)
        {
            node.left = addInternal( val, node.left );
            if(height( node.left ) - height( node.right ) == 2 )
                if( val < node.left.value )
                    node = rotateWithLeftChild( node );
                else
                    node = doubleWithLeftChild( node );
        }
        else if( val > node.value )
        {
            node.right = addInternal( val, node.right );
            if( height( node.right ) - height( node.left ) == 2 )
                if( val > node.right.value)
                    node = rotateWithRightChild( node );
                else
                    node = doubleWithRightChild( node );
        }
        else
            ;  // Duplicate; do nothing
        node.height = max( height( node.left ), height( node.right ) ) + 1;
        return node;
    }

    private int height(Node node )
    {
        return node == null ? -1 : node.height;
    }

    private Node rotateWithLeftChild(Node tempNode)
    {
        System.out.println("rotateWithLeftChild");
        Node node = tempNode.left;
        tempNode.left = node.right;
        node.right = tempNode;
        tempNode.height = max( height( tempNode.left ), height( tempNode.right ) ) + 1;
        node.height = max( height( node.left ), tempNode.height ) + 1;
        return node;
    }

    /* Rotate binary tree node with right child */
    private Node rotateWithRightChild(Node tempNode)
    {
        System.out.println("rotateWithRightChild");
        Node node = tempNode.right;
        tempNode.right = node.left;
        node.left = tempNode;
        tempNode.height = max( height( tempNode.left ), height( tempNode.right ) ) + 1;
        node.height = max( height( node.right ), tempNode.height ) + 1;
        return node;
    }
    /**
     * Double rotate binary tree node: first left child
     * with its right child; then node k3 with new left child */
    private Node doubleWithLeftChild(Node node)
    {
        System.out.println("doubleWithLeftChild");
        node.left = rotateWithRightChild( node.left );
        return rotateWithLeftChild( node );
    }
    /**
     * Double rotate binary tree node: first right child
     * with its left child; then node k1 with new right child */
    private Node doubleWithRightChild(Node node)
    {
        System.out.println("doubleWithRightChild");
        node.right = rotateWithLeftChild( node.right );
        return rotateWithRightChild( node );
    }

    private int max(int leftN, int rightN)
    {
        return leftN > rightN ? leftN : rightN;
    }

    @Override
    public void del(int val) {
        delInternal(this.root, val);
    }

    private Node delInternal(Node node, int key){
        // search the key
        if (node == null) return node;
        else if (key < node.value) node.left = delInternal(node.left, key);
        else if (key > node.value) node.right = delInternal(node.right, key);
        else {
            // the key has been found, now delete it

            // case 1: node is a leaf node
            if (node.left == null && node.right == null) {
                node = null;
            }

            // case 2: node has only one child
            else if (node.left == null) {
                Node temp = node;
                node = node.right;
            }

            else if (node.right == null) {
                Node temp = node;
                node = node.left;
            }

            // case 3: has both children
            else {
                Node temp = minimumKey(node.right);
                node.value = temp.value;
                node.right = delInternal(node.right, temp.value);
            }

        }

        checkBalance(node);

        return node;
    }

    private Node minimumKey(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    private void checkBalance(Node node){
        if (node.balanceF < -1 || node.balanceF > 1) {
            rebalance(node);
            return;
        }

        if (node.parent != null) {
            if (node == node.parent.left) {
                System.out.println("node is on the left");
                node.parent.balanceF -= 1;
            }

            if (node == node.parent.right) {
                System.out.println("node is on the right");
                node.parent.balanceF += 1;
            }

            if (node.parent.balanceF != 0) {
                System.out.println("call checkBalance");
                checkBalance(node.parent);
            }
        }
    }

    private void rebalance(Node node) {
        if (node.balanceF > 0) {
            if (node.right.balanceF < 0) {
                rightRotate(node.right);
                leftRotate(node);
            } else {
                leftRotate(node);
            }
        } else if (node.balanceF < 0) {
            if (node.left.balanceF > 0) {
                leftRotate(node.left);
                rightRotate(node);
            } else {
                rightRotate(node);
            }
        }
    }

    void leftRotate(Node x) {
        System.out.println("leftRotate");
        Node y = x.right;
        x.right = y.left;
        if (y.left != null) {
            y.left.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == null) {
            this.root = y;
        } else if (x == x.parent.left) {
            x.parent.left = y;
        } else {
            x.parent.right = y;
        }
        y.left = x;
        x.parent = y;

        // update the balance factor
        x.balanceF = x.balanceF - 1 - Math.max(0, y.balanceF);
        y.balanceF = y.balanceF - 1 + Math.min(0, x.balanceF);
    }

    void rightRotate(Node x) {
        System.out.println("rightRotate");
        Node y = x.left;
        x.left = y.right;
        if (y.right != null) {
            y.right.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == null) {
            this.root = y;
        } else if (x == x.parent.right) {
            x.parent.right = y;
        } else {
            x.parent.left = y;
        }
        y.right = x;
        x.parent = y;

        // update the balance factor
        x.balanceF = x.balanceF + 1 - Math.min(0, y.balanceF);
        y.balanceF = y.balanceF + 1 + Math.max(0, x.balanceF);
    }

    @Override
    public int getWidth() {
        return 0;
    }

    @Override
    public int getHeight() {
        return 0;
    }

    @Override
    public int nodes() {
        return 0;
    }

    @Override
    public int leaves() {
        return 0;
    }

    @Override
    public void reverse() {

    }

    // print the tree structure on the screen
    public void prettyPrint() {
        printHelper(this.root, "", true);
    }

    private void printHelper(Node currPtr, String indent, boolean last) {
        // print the tree structure on the screen
        if (currPtr != null) {
            System.out.print(indent);
            if (last) {
                System.out.print("R----");
                indent += "     ";
            } else {
                System.out.print("L----");
                indent += "|    ";
            }

            System.out.println(currPtr.value + "(BF = " + currPtr.balanceF + ")");

            printHelper(currPtr.left, indent, false);
            printHelper(currPtr.right, indent, true);
        }
    }
}
