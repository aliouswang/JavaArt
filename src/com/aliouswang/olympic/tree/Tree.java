package com.aliouswang.olympic.tree;

public class Tree {

    Node root;

    public Tree() {

    }

    private void init() {

    }

    public Node find(int key) {
        if (root == null) return null;
        return find(key, root);
    }

    private Node find(int key, Node startNode) {
        if (startNode == null) return null;
        if (startNode.key == key) return startNode;
        else if (startNode.key > key) {
            return find(key, startNode.left);
        }else return find(key, startNode.right);
    }

    public void insert(int key, int value) {
        if (root == null) {
            root = new Node(key, value);
        }
    }

}
