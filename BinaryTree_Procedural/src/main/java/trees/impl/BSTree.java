package trees.impl;

import trees.ITree;
import util.Constants;

public class BSTree implements ITree {

    class Node {
        public int value;
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

    @Override
    public void del(int val) {
        System.out.println(delInternal(root, val));
    }

    private int delInternal(Node node, int val) {
        if (node == null) {
            throw new NullPointerException(Constants.NOT_FOUND);
        }
        if (node.value == val) {
            return node.value;
        }
        if (val < node.value) {
            return delInternal(node.left, val);
        } else {
            return delInternal(node.right, val);
        }
    }

    @Override
    public int getWidth() {
        return widthInternal(root, 0);
    }

    private int widthInternal(Node node, int size) {
        if (node != null) {
            if (node.value <= root.value) {
                size = widthInternal(node.left, size);
            }
            if (node.value >= root.value) {
                size = widthInternal(node.right, size);
            }
        }
        return ++size;
    }

    @Override
    public int getHeight() {
        return getHeightInternal(root);
    }

    private int getHeightInternal(Node node) {
        if (node == null) {
            return -1;
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


    private Node addInternal(Node currentNode, int value) {
        if (currentNode == null) {
            return new Node(value);
        }

        if (value < currentNode.value) {
            currentNode.left = addInternal(currentNode.left, value);
        } else if (value > currentNode.value) {
            currentNode.right = addInternal(currentNode.right, value);
        } else {
            return currentNode;
        }

        return currentNode;
    }
}
