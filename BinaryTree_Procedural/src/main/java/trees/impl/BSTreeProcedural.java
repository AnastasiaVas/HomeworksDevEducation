package trees.impl;

import trees.ITree;
import util.Constants;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BSTreeProcedural implements ITree {

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
        if (root == null)
            return;


        Stack<Node> nodeStack = new Stack<>();
        Node currNode = root;
        while (currNode != null || nodeStack.size() > 0) {
            while (currNode != null) {
                nodeStack.push(currNode);
                currNode = currNode.left;
            }
            currNode = nodeStack.pop();
            System.out.print(currNode.value + " ");

            currNode = currNode.right;
        }
    }

    @Override
    public void clear() {
        root = null;
    }

    @Override
    public int size() {
        if (root == null) {
            return 0;
        }

        Queue<Node> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);
        int count = 1;
        while (!nodeQueue.isEmpty()) {
            Node temp = nodeQueue.poll();

            if (temp != null) {
                if (temp.left != null) {
                    count++;
                    nodeQueue.offer(temp.left);
                }
                if (temp.right != null) {
                    count++;
                    nodeQueue.offer(temp.right);
                }
            }
        }

        return count;
    }

    @Override
    public int[] toArray() {

        int[] nodeArray = new int[size()];

        if (root == null)
            return nodeArray;


        Stack<Node> nodeStack = new Stack<>();
        Node currNode = root;
        int i = 0;
        while (currNode != null || nodeStack.size() > 0) {

            while (currNode != null) {
                nodeStack.push(currNode);
                currNode = currNode.left;
            }

            currNode = nodeStack.pop();

            nodeArray[i] = currNode.value;
            i++;
            currNode = currNode.right;
        }
        return nodeArray;
    }

    @Override
    public void add(int val) {

        Node newNode = new Node(val);
        if (root == null)
            root = newNode;
        else {
            Node current = root;
            Node parent;
            while (true) {
                parent = current;
                if (val < current.value) {
                    current = current.left;
                    if (current == null) {
                        parent.left = newNode;
                        return;
                    }
                } else {
                    current = current.right;
                    if (current == null) {
                        parent.right = newNode;
                        return;
                    }
                }
            }
        }
    }

    @Override
    public void del(int val) {
        if (root == null){
            throw new IllegalArgumentException(Constants.NOT_FOUND);
        }
        Node current = root;
        Node parent = root;
        boolean isLeft = true;
        while (current.value != val)
        {
            parent = current;
            if (val < current.value)
            {
                if (current.left == null){
                    throw new IllegalArgumentException(Constants.NOT_FOUND);
                }
                isLeft = true;
                current = current.left;
            } else {
                if (current.right == null){
                    throw new IllegalArgumentException(Constants.NOT_FOUND);
                }
                isLeft = false;
                current = current.right;
            }
        }
        if (current.left == null && current.right == null) {
            if (current == root)
                root = null;
            else if (isLeft) {
                parent.left = null;
            }
            else {
                parent.right = null;
            }
        }
        else if (current.right == null)
            if (current == root)
                root = current.left;
            else if (isLeft)
                parent.left = current.left;
            else
                parent.right = current.left;
        else if (current.left == null)
            if (current == root)
                root = current.right;
            else if (isLeft)
                parent.left = current.right;
            else
                parent.right = current.right;
        else {
            Node successor = getSuccessor(current);
            if (current == root) {
                root = successor;
            } else if (isLeft) {
                parent.left = successor;
            } else
                parent.right = successor;
        }
    }


    private Node getSuccessor(Node node) {
        Node successorParent = node;
        Node successor = node;
        Node current = node.right;
        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.left;
        }
        if (successor != node.right)
            successorParent.left = successor.right;
        successor.right = node.right;
        return successor;

    }

    @Override
    public int getWidth() {
        int width = 0;
        int nodesOnLevel;
        Queue<Node> nodeQueue = new LinkedList<>();
        if (root == null) return 0;
        nodeQueue.add(root);

        while (!nodeQueue.isEmpty()) {
            nodesOnLevel = nodeQueue.size();
            if (nodesOnLevel > width) {
                width = nodesOnLevel;
            }
            while (nodesOnLevel > 0) {
                Node n = nodeQueue.remove();
                if (n.left != null) nodeQueue.add(n.left);
                if (n.right != null) nodeQueue.add(n.right);
                nodesOnLevel--;
            }
        }
        return width;
    }

    @Override
    public int getHeight() {
        if (root == null)
            return 0;

        Queue<Node> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        int height = 0;

        while (true) {
            int nodeCount = nodeQueue.size();
            if (nodeCount == 0)
                return height;
            height++;
            while (nodeCount > 0) {
                Node newNode = nodeQueue.peek();
                nodeQueue.remove();
                assert newNode != null;
                if (newNode.left != null)
                    nodeQueue.add(newNode.left);
                if (newNode.right != null)
                    nodeQueue.add(newNode.right);
                nodeCount--;
            }
        }
    }

    @Override
    public int nodes() {
        if (root == null) {
            return 0;
        }

        Queue<Node> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);

        int count = 1;
        while (!nodeQueue.isEmpty()) {
            Node temp = nodeQueue.poll();
            if (temp != null) {
                if (temp.left != null && (temp.left.left != null || temp.left.right != null)) {
                    count++;
                    nodeQueue.offer(temp.left);
                }
                if (temp.right != null && (temp.right.left != null || temp.right.right != null)) {
                    count++;
                    nodeQueue.offer(temp.right);
                }
            }
        }

        return count;
    }

    @Override
    public int leaves() {
        Queue<Node> queue = new LinkedList<>();
        if (root == null) {
            return 0;
        }
        queue.add(root);
        int count = 0;
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            if (temp.left != null)
                queue.add(temp.left);
            if (temp.right != null)
                queue.add(temp.right);
            if (temp.left == null && temp.right == null)
                count++;
        }
        return count;
    }

    @Override
    public void reverse() {
        if (root == null) {
            return;
        }
        Queue<Node> nodeQueue = new ArrayDeque<>();
        nodeQueue.add(root);
        while (!nodeQueue.isEmpty()) {
            Node curr = nodeQueue.poll();
            swapNodes(curr);
            if (curr.left != null) {
                nodeQueue.add(curr.left);
            }
            if (curr.right != null) {
                nodeQueue.add(curr.right);
            }
        }
    }

    private void swapNodes(Node node) {
        if (node == null) {
            return;
        }

        Node temp = node.left;
        node.left = node.right;
        node.right = temp;
    }
}
