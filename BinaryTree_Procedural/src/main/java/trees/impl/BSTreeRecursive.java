package trees.impl;

import trees.ITree;
import util.Constants;

import java.util.*;

public class BSTreeRecursive implements ITree {

    public class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
            right = null;
            left = null;
        }
    }

    public Node root;

    @Override
    public void init(int[] ar) {
        for (int i : ar) {
            add(i);
        }
    }

    @Override
    public void print() {
        sortPrint(root);
    }

    private void sortPrint(Node node) {
        if (node != null) {
            sortPrint(node.left);
            System.out.print(" " + node.value);
            sortPrint(node.right);
        }
    }

    @Override
    public void clear() {
        root = null;
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
        root = addInternal(root, val);
    }

    private Node addInternal(Node currentNode, int value) {
        if (currentNode == null) {
            return new Node(value);
        }

        if (value < currentNode.value) {
            currentNode.left = addInternal(currentNode.left, value);
        } else if (value > currentNode.value) {
            currentNode.right = addInternal(currentNode.right, value);
        }
        return currentNode;
    }

    @Override
    public void del(int val) {
        root = delInternal(root, val);
    }

    private Node delInternal(Node node, int value) {
        if (node == null)
            return node;
        if (value < node.value)
            node.left = delInternal(node.left, value);
        else if (value > node.value)
            node.right = delInternal(node.right, value);
        else {
            if (node.left == null)
                return node.right;
            else if (node.right == null)
                return node.left;
            node.value = minValue(node.right);
            node.right = delInternal(node.right, node.value);
        }

        return node;
    }

    private int minValue(Node node)
    {
        int minv = node.value;
        while (node.left != null)
        {
            minv = node.left.value;
            node = node.left;
        }
        return minv;
    }


    @Override
    public int getWidth() {
        if (root == null){
            return 0;
        }
        int level = 1;
        Map<Integer, Integer> map = new HashMap<>();
        widthInternal(root, level, map);
        return map.values().stream().max(Comparator.naturalOrder()).get();
    }

    private void widthInternal(Node node, int level, Map<Integer, Integer> map) {
        if (node == null){
            return;
        }

        map.put(level, map.getOrDefault(level, 0) + 1);

        widthInternal(node.left, level + 1, map);
        widthInternal(node.right, level + 1, map);
    }

    @Override
    public int getHeight() {
        return getHeightInternal(root);
    }

    private int getHeightInternal(Node node) {
        if (node == null) {
            return 0;
        } else {
            int leftH = getHeightInternal(node.left);
            int rightH = getHeightInternal(node.right);
            if (leftH > rightH) {
                return (leftH + 1);
            } else {
                return (rightH + 1);
            }
        }
    }

    @Override
    public int nodes() {
        return nodeInternal(root);
    }

    public int nodeInternal(Node node) {
        if (node != null && (node.left != null || node.right != null)) {
            return (nodeInternal(node.left) + nodeInternal(node.right) + 1);
        } else return 0;
    }

    @Override
    public int leaves() {
        return leavesInternal(root);
    }

    private int leavesInternal(Node node) {
        if (node != null) {
            if (node.left == null && node.right == null) {
                return 1;
            } else {
                return leavesInternal(node.left) + leavesInternal(node.right);
            }
        } else {
            return 0;
        }
    }

    @Override
    public void reverse() {
        reverseInternal(root);
    }

    private void reverseInternal(Node currentNode) {
        if (currentNode != null) {
            if (currentNode.left != null || currentNode.right != null) {
                Node temp = currentNode.left;
                currentNode.left = currentNode.right;
                currentNode.right = temp;
            }
            reverseInternal(currentNode.left);
            reverseInternal(currentNode.right);
        }
    }
}
