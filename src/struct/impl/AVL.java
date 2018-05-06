package struct.impl;

/**
 * @Author: jicheng
 * @Since: 2018年05月06日 上午10:09
 */
public class AVL<E extends Comparable<E>> {
    private class Node {
        private int balance;
        private E value;
        private Node left;
        private Node right;

        public Node(E value, Node left, Node right, int balance) {
            this.balance = balance;
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public Node(E value, Node left, Node right) {
            this(value, left, right, 0);
        }

        public Node(E value) {
            this(value, null, null, 0);
        }
    }

    private Node root;


    public boolean isEmpty() {
        return root == null;
    }

    public int height() {
        if (isEmpty()) {
            return 0;
        }
        return height(this.root);
    }

    private int height(Node node) {

        if (node == null) {
            return 0;
        }
        return Math.max(height(node.left), height(node.right)) + 1;
    }

    public void addValue(E value) {
        if (isEmpty()) {
            this.root = new Node(value);
            return;
        }
        this.root = addValue(this.root, value);
    }

    private Node addValue(Node node, E value) {

        if (node == null) {
            return new Node(value);
        }
        int leftHeight = 0, rightHeight = 0;
        if (node.value.compareTo(value) > 0) {
            node.left = addValue(node.left, value);
            leftHeight = this.height(node.left);
        } else if (node.value.compareTo(value) < 0) {
            node.right = addValue(node.right, value);
            rightHeight = this.height(node.right);
        } else{
            return node;
        }
        int balance = leftHeight - rightHeight;
        if (Math.abs(balance) > 1) {
            node = rotate(node, balance);
        }else {
            node.balance = balance;
        }
        return node;
    }

    private Node rotate(Node node, int balance) {
        if (balance < 0) {
            if(node.right.balance<0){//右右情况
                node = lRotate(node);
            }else{//右左情况
                node.right =  rRotate(node.right);
                node = lRotate(node);
            }
        } else {
            if(node.left.balance>0){//左左的情况
                node = rRotate(node);
            }else{//左右的情况
                node.left = lRotate(node.left);
                node = rRotate(node);
            }
        }
        return node;
    }

    private Node rRotate(Node node) {

        Node newNod = node.left;
        node.left = newNod.right;
        newNod.right = node;
        int balance = height(newNod.left)-height(newNod.right);
        newNod.balance = balance;
        return newNod;
    }

    private Node lRotate(Node node) {
        Node newNode = node.right;
        node.right = newNode.left;
        newNode.left = node;
        int balance = height(newNode.left)-height(newNode.right);
        newNode.balance = balance;
        return newNode;
    }
}
