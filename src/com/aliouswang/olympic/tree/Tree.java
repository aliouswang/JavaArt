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
            return;
        }
        insert(key, value, root);
    }

    private void insert(int key, int value, Node startNode) {
        if (key == startNode.key) {
            startNode.value = value;
            return;
        } else if (key < startNode.key) {
            if (startNode.left == null) {
                startNode.left = new Node(key, value);
                return;
            }else {
                insert(key, value, startNode.left);
            }
        } else if (key > startNode.key) {
            if (startNode.right == null) {
                startNode.right = new Node(key, value);
                return;
            }else {
                insert(key, value, startNode.right);
            }
        }
    }

    public Node findReplaceNode(Node deleteNode) {
        Node findNode = find(deleteNode.key);
        //left child is not null
        if (findNode.left != null) {
            return findBiggest(findNode.left);
        }else if (findNode.right != null) {
            return findSmallest(findNode.right);
        }else return null;
    }

    public Node findBiggest(Node startNode) {
        if (startNode.right == null) return startNode;
        else return findBiggest(startNode.right);
    }

    public Node findSmallest(Node startNode) {
        if (startNode.left == null) return startNode;
        else return findSmallest(startNode.left);
    }

    public void preOrder() {
        preOrder(root);
    }

    public void preOrder(Node rootNode) {
        if (rootNode == null) return;
        System.out.print(rootNode.value + ",");
        preOrder(rootNode.left);
        preOrder(rootNode.right);
    }

    public void midOrder() {

    }

    public void postOrder() {

    }


}
