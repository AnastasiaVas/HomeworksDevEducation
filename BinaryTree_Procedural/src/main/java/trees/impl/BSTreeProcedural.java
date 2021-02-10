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

        // traverse the tree
        while (currNode != null || nodeStack.size() > 0) {

            /* Reach the left most Node of the
            curr Node */
            while (currNode != null) {
                /* place pointer to a tree node on
                   the stack before traversing
                  the node's left subtree */
                nodeStack.push(currNode);
                currNode = currNode.left;
            }

            /* Current must be NULL at this point */
            currNode = nodeStack.pop();

            System.out.print(currNode.value + " ");

            /* we have visited the node and its
               left subtree.  Now, it's right
               subtree's turn */
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

        // Using level order Traversal.
        Queue<Node> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);

        int count = 1;
        while (!nodeQueue.isEmpty()) {
            Node temp = nodeQueue.poll();

            // when the queue is empty:
            // the poll() method returns null.
            if (temp != null) {
                if (temp.left != null) {
                    // Increment count
                    count++;

                    // Enqueue left child
                    nodeQueue.offer(temp.left);
                }
                if (temp.right != null) {
                    // Increment count
                    count++;

                    // Enqueue left child
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
        // traverse the tree
        while (currNode != null || nodeStack.size() > 0) {

            /* Reach the left most Node of the
            curr Node */
            while (currNode != null) {
                /* place pointer to a tree node on
                   the stack before traversing
                  the node's left subtree */
                nodeStack.push(currNode);
                currNode = currNode.left;
            }

            /* Current must be NULL at this point */
            currNode = nodeStack.pop();

            nodeArray[i] = currNode.value;
            i++;
            /* we have visited the node and its
               left subtree.  Now, it's right
               subtree's turn */
            currNode = currNode.right;
        }
        return nodeArray;
    }

    @Override
    public void add(int val) {

        Node newNode = new Node(val); // Создание нового узла
        if (root == null) // Корневой узел не существует
            root = newNode;
        else // Корневой узел занят
        {
            Node current = root; // Начать с корневого узла
            Node parent;
            while (true) // (внутренний выход из цикла)
            {
                parent = current;
                if (val < current.value) // Двигаться налево?
                {
                    current = current.left;
                    if (current == null) // Если достигнут конец цепочки,
                    { // вставить слева
                        parent.left = newNode;
                        return;
                    }
                } else // Или направо?
                {
                    current = current.right;
                    if (current == null) // Если достигнут конец цепочки,
                    { // вставить справа
                        parent.right = newNode;
                        return;
                    }
                }
            }
        }
    }

    @Override
    public void del(int val) {
        Node[] nodeArr = new Node[2];
        nodeArr = findNodes(root, val, nodeArr);
        delInternal(nodeArr[0], nodeArr[1]);
    }

    private void delInternal(Node node, Node parent) {
        if (node.left == null && node.right == null) {
            parent.left = null;
            parent.right = null;
        } else if (node.right == null) {
            if (node == root) {
                root = node.left;
            } else if (node == parent.left) {
                parent.left = node.left;
            } else {
                parent.right = node.left;
            }
        } else if (node.left == null) {
            if (node == root) {
                root = node.right;
            } else if (node == parent.left) {
                parent.left = node.right;
            } else {
                parent.right = node.right;
            }
        } else {

            twoChildren(node, parent);
        }
    }

    private void twoChildren(Node node, Node parent) {
        Node successor = getSuccessor(node);

        if (node == root) {
            root = successor;
        } else if (node == parent.left) {
            parent.left = successor;
        } else {
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

    public Node[] findNodes(Node node, int val, Node[] nodeArr) {
        if (node == null) {
            throw new IllegalArgumentException(Constants.NOT_FOUND);
        }
        if (node.value == val) {
            if (node == root) {
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
        // Base Case
        if (root == null)
            return 0;

        // Create an empty queue for level order tarversal
        Queue<Node> nodeQueue = new LinkedList();

        // Enqueue Root and initialize height
        nodeQueue.add(root);
        int height = 0;

        while (true) {
            // nodeCount (queue size) indicates number of nodes
            // at current lelvel.
            int nodeCount = nodeQueue.size();
            if (nodeCount == 0)
                return height;
            height++;

            // Dequeue all nodes of current level and Enqueue all
            // nodes of next level
            while (nodeCount > 0) {
                Node newNode = nodeQueue.peek();
                nodeQueue.remove();
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

        // Using level order Traversal.
        Queue<Node> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);

        int count = 1;
        while (!nodeQueue.isEmpty()) {
            Node temp = nodeQueue.poll();

            // when the queue is empty:
            // the poll() method returns null.
            if (temp != null) {
                if (temp.left != null && (temp.left.left != null || temp.left.right != null)) {
                    // Increment count
                    count++;

                    // Enqueue left child
                    nodeQueue.offer(temp.left);
                }
                if (temp.right != null && (temp.right.left != null || temp.right.right != null)) {
                    // Increment count
                    count++;

                    // Enqueue left child
                    nodeQueue.offer(temp.right);
                }
            }
        }

        return count;
    }

    @Override
    public int leaves() {
        Queue<Node> queue = new LinkedList<>();
        if (root == null){
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
        // base case: if the tree is empty
        if (root == null) {
            return;
        }

        // maintain a queue and push the root node
        Queue<Node> nodeQueue = new ArrayDeque<>();
        nodeQueue.add(root);

        // loop till queue is empty
        while (!nodeQueue.isEmpty())
        {
            // dequeue front node
            Node curr = nodeQueue.poll();

            // swap the left child with the right child
            swapNodes(curr);

            // enqueue left child of the popped node
            if (curr.left != null) {
                nodeQueue.add(curr.left);
            }

            // enqueue right child of the popped node
            if (curr.right != null) {
                nodeQueue.add(curr.right);
            }
        }
    }

    private void swapNodes(Node node)
    {
        if (node == null) {
            return;
        }

        Node temp = node.left;
        node.left = node.right;
        node.right = temp;
    }
}
