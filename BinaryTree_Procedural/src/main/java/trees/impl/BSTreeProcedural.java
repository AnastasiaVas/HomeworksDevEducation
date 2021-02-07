package trees.impl;

import trees.ITree;
import util.Constants;

public class BSTreeProcedural implements ITree {

    class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
            right = null;
            left = null;
        }
    }

    public Node root;

    @Override
    public void init(int[] ar) {

    }

    @Override
    public void print() {

    }

    @Override
    public void clear() {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public int[] toArray() {
        return new int[0];
    }

    @Override
    public void add(int val) {

    }

    @Override
    public void del(int val) {
        Node[] nodeArr = new Node[2];
        nodeArr = findNodes(root, val, nodeArr);
        delInternal(nodeArr[0], nodeArr[1]);
        //    delInternal(root, val);
    }

    private int delInternal(Node node, Node parent) {
        if (node.left == null && node.right == null){
            parent.left = null;
            parent.right = null;
        } else if (node.right == null){
            if (node == root) {
                root = node.left;
            } else if (node == parent.left){
                parent.left = node.left;
            } else {
                parent.right = node.left;
            }
        } else if (node.left == null){
            if (node == root) {
                root = node.right;
            } else if (node == parent.left){
                parent.left = node.right;
            } else {
                parent.right = node.right;
            }
        } else {

            twoChildren(node);
        }
        return 0;
    }

    private Node twoChildren(Node node){
        if (node != null){
            return node.left;
        }
        return null;
    }

    public Node[] findNodes(Node node, int val, Node[] nodeArr){
        if (node == null) {
            throw new IllegalArgumentException(Constants.NOT_FOUND);
        }
        if (node.value == val) {
            if (node == root){
                nodeArr[0] = root;
                nodeArr[1] = root;
            } else {
                nodeArr[1] = node;
            }
            return nodeArr;
        }
        nodeArr[0] = node;
        if (val < node.value) {
            return findNodes(node.left, val, nodeArr);
        } else {
            return findNodes(node.right, val, nodeArr);
        }
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
