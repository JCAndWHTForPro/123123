package struct.impl;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉搜索树
 *
 * @Author: jicheng
 * @Since: 2018年05月02日 下午5:57
 */
public class BST<E extends Comparable<E>> {
    private class Node {
        private E value;
        private Node leftNode;
        private Node rightNode;

        public Node(E value, Node leftNode, Node rightNode) {
            this.value = value;
            this.leftNode = leftNode;
            this.rightNode = rightNode;
        }

        public Node(E value) {
            this(value, null, null);
        }

        public Node() {
            this(null, null, null);
        }
    }

    private Node root;

    public void addValue(E value) {
        if (root == null) {
            this.root = new Node(value);
            return;
        }
        this.root = addValue(root, value);
    }

    private Node addValue(Node node, E value) {
        if (node == null) {
            return new Node(value);
        }
        if (node.value.compareTo(value) < 0) {
            node.rightNode = addValue(node.rightNode, value);
        } else if (node.value.compareTo(value) > 0) {
            node.leftNode = addValue(node.leftNode, value);
        }

        return node;

    }


    public E findMin() {
        if (root == null) {
            throw new IllegalArgumentException("tree is null");
        }
        return findMin(root).value;
    }

    private Node findMin(Node node) {
        if (node.leftNode == null) {
            return node;
        }
        return findMin(node.leftNode);

    }

    public E findMax() {
        if (root == null) {
            throw new IllegalArgumentException("tree is null");
        }
        return findMax(root).value;
    }

    private Node findMax(Node node) {
        if (node.rightNode == null) {
            return node;
        }
        return findMin(node.rightNode);
    }

    public E deleteMin() {
        E result = findMin();
        this.root = deleteMin(root);
        return result;
    }

    private Node deleteMin(Node node) {
        if (node.leftNode == null) {
            Node rightNode = node.rightNode;
            node.rightNode = null;
            return rightNode;
        }
        node.leftNode = deleteMin(node.leftNode);
        return node;
    }

    public E deleteMax() {
        E result = findMax();
        this.root = deleteMax(this.root);
        return result;
    }

    private Node deleteMax(Node node) {
        if (node.rightNode == null) {
            Node leftNode = node.leftNode;
            node.leftNode = null;
            return leftNode;
        }
        node.rightNode = deleteMax(node.rightNode);
        return node;
    }

    public void deleteNode(E value) {
        if (root == null) {
            throw new IllegalArgumentException("null");
        }

        this.root = deleteNode(root, value);
    }

    private Node deleteNode(Node node, E value) {
        if (node == null) {
            return node;
        }
        if (node.value.compareTo(value) > 0) {
            node.leftNode = deleteNode(node.leftNode, value);
            return node;
        } else if (node.value.compareTo(value) < 0) {
            node.rightNode = deleteNode(node.rightNode, value);
            return node;
        } else {
            if (node.leftNode == null) {
                return node.rightNode;
            }
            if (node.rightNode == null) {
                return node.leftNode;
            }
            Node result = new Node(findMin(node.rightNode).value);
            result.rightNode = deleteMin(node.rightNode);
            result.leftNode = node.leftNode;
            node.leftNode = null;
            node.rightNode = null;
            return result;
        }
    }

    public void inOrder(){
        if(root == null){
            throw new IllegalArgumentException("root is null");
        }
        inOrder(this.root);
    }

    private void inOrder(Node node) {
        if(node == null){
            return;
        }
        inOrder(node.leftNode);
        System.out.println(node.value);
        inOrder(node.rightNode);
    }

    public void levelOrder(){
        if(root == null){
            throw new IllegalArgumentException("root is null");
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            Node node = queue.poll();
            System.out.println(node.value);
            if(node.leftNode!=null) {
                queue.add(node.leftNode);
            }
            if(node.rightNode!=null) {
                queue.add(node.rightNode);
            }
        }
    }


}
