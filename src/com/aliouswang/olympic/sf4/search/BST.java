package com.aliouswang.olympic.sf4.search;

public class BST<Key extends Comparable<Key>, Value> {

    private Node root;

    private class Node {
        private Key key;
        private Value value;
        private Node left, right;
        private int N;  //this node as root tree size

        public Node(Key key, Value value, int N) {
            this.key = key;
            this.value = value;
            this.N = N;
        }
    }

    public int size() {
        return size(root);
    }

    private int size(Node node) {
        if (node == null) {
            return 0;
        } else {
            return size(node.left) + size(node.right) + 1;
        }
    }

    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node node, Key key) {
        if (node == null) return null;
        int cmp = node.key.compareTo(key);
        if (cmp < 0) {
            return get(node.left, key);
        } else if (cmp > 0) {
            return get(node.right, key);
        } else return node.value;
    }

    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    private Node put(Node node, Key key, Value value) {
        if (node == null) {
           return new Node(key, value, 1);
        } else {
            int cmp = node.key.compareTo(key);
            if (cmp < 0) {
                node.left = put(node.left, key, value);
            } else if (cmp > 0) {
                node.right = put(node.right, key, value);
            } else {
                node.value = value;
            }
            node.N = size(node.left) + size(node.right) + 1;
            return node;
        }
    }

    public Key minKey() {
        return minKey(root);
    }

    private Key minKey(Node node) {
        if (node == null) return null;
        if (node.left != null) return minKey(node.left);
        else return node.key;
    }

    public Key maxKey() {
        return maxKey(root);
    }

    private Key maxKey(Node node) {
        if (node == null) return null;
        if (node.right != null) return maxKey(node.right);
        else return node.key;
    }

    public Node floor(Key key) {
        return floor(root, key);
    }

    private Node floor(Node node, Key key) {
        if (node == null) return null;
        int cmp = node.key.compareTo(key);
        if (cmp == 0) return node;
        else if (cmp < 0) return floor(node.left, key);
        Node floor = floor(node.right, key);
        if (floor == null) return node;
        return floor;
    }

    public Key select(int k) {
        return select(root, k).key;
    }

    private Node select(Node node, int k) {
        if (node == null) return null;
        int size = size(node.left);
        if (k < size) {
            return select(node.left, k);
        } else if (k > size) {
            return select(node.right, k - size - 1);
        } return node;
    }

    public int rank(Key key) {
        return rank(root, key);
    }

    private int rank(Node node, Key key) {
        if (node == null) return 0;
        int cmp = node.key.compareTo(key);
        if (cmp == 0) return size(node.left);
        else if (cmp < 0) return rank(node.left, key);
        else return 1 + size(node.left) + rank(node.right, key);
    }

    public void deleteMin() {
        root = deleteMin(root);
    }

    private Node deleteMin(Node node) {
        if (node.left == null) {
            return node.right;
        }
        node.left = deleteMin(node.left);
        node.N = size(node.left) + size(node.right) + 1;
        return node;
    }

    public void deleteMax() {
        root = deleteMax(root);
    }

    private Node deleteMax(Node node) {
        if (node.right == null) return node.left;
        node.right = deleteMax(node);
        node.N = size(node.left) + size(node.right) + 1;
        return node;
    }

}
