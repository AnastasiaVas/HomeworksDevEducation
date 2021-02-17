package trees.impl;

import trees.ITree;

public class AVLTree implements ITree {

    public Node root;

    public class Node {
        public int value;
        public Node parent;
        public Node left;
        public Node right;
        int balanceF;
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
        if (node == null) {
            return new Node(val);
        }

        if (val < node.value) {
            node.left = addInternal(val, node.left);
        } else if (val > node.value) {
            node.right = addInternal(val, node.right);
        }
        return balance(node);
    }

    private Node balance(Node node)
    {
        fixHeight(node);
        if( balanceF(node)==2 )
        {
            if( balanceF(node.right) < 0 )
                node.right = rotateRight(node.right);
            return rotateLeft(node);
        }
        if( balanceF(node)==-2 )
        {
            if( balanceF(node.left) > 0  )
                node.left = rotateLeft(node.left);
            return rotateRight(node);
        }
        return node;
    }

    private int balanceF(Node node)
    {
        return height(node.right)-height(node.left);
    }

    void fixHeight(Node node)
    {
        int hl = height(node.left);
        int hr = height(node.right);
        node.height = (Math.max(hl, hr))+1;
    }

    private int height(Node node)
    {
        return node == null ? -1 : node.height;
    }

    Node rotateRight(Node node)
    {
        Node temp = node.left;
        node.left = temp.right;
        temp.right = node;
        fixHeight(node);
        fixHeight(temp);
        return temp;
    }

    Node rotateLeft(Node node)
    {
        Node temp = node.right;
        node.right = temp.left;
        temp.left = node;
        fixHeight(node);
        fixHeight(temp);
        return temp;
    }

    @Override
    public void del(int val) {
        delInternal(this.root, val);
    }

    private Node delInternal(Node node, int val){
        if (node == null)
            return node;
        if (val < node.value)
            node.left = delInternal(node.left, val);
        else if (val > node.value)
            node.right = delInternal(node.right, val);
        else {
            if (node.left == null)
                return node.right;
            else if (node.right == null)
                return node.left;
            node.value = minValue(node.right);
            node.right = delInternal(node.right, node.value);
        }

        return balance(node);
    }

    private int minValue(Node node)
    {
        int minV = node.value;
        while (node.left != null)
        {
            minV = node.left.value;
            node = node.left;
        }
        return minV;
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
}
