package com.aliouswang.olympic.tree;

import com.aliouswang.olympic.util.Log;

public class BSTree<T extends Comparable<T>>{

    private BSTNode<T> mRoot;
    public class BSTNode<T extends Comparable<T>>{
        public T data;
        public BSTNode<T> left;
        public BSTNode<T> right;
        public BSTNode<T> parent;

        public BSTNode(T data, BSTNode<T> left, BSTNode<T> right, BSTNode<T> parent) {
            this.data = data;
            this.left = left;
            this.right = right;
            this.parent = parent;
        }

    }

    /**
     * pre order traverse
     */
    public void preOrder() {
        preOrder(mRoot);
    }

    private void preOrder(BSTNode<T> tree) {
        if (tree == null) return;
        Log.d(tree.data + " ");
        preOrder(tree.left);
        preOrder(tree.right);
    }

    /**
     * in order traverse
     */
    public void inOrder() {
        inOrder(mRoot);
    }

    private void inOrder(BSTNode<T> tree) {
        if (tree != null) {
            inOrder(tree.left);
            Log.d(tree.data + " ");
            inOrder(tree.right);
        }
    }

    /**
     * post order traverse
     */
    public void postOrder() {
        postOrder(mRoot);
    }

    private void postOrder(BSTNode<T> tree) {
        if (tree != null) {
            postOrder(tree.left);
            postOrder(tree.right);
            Log.d(tree.data + " ");
        }
    }

    public BSTNode<T> search(T data) {
        return search(data, mRoot);
    }

    private BSTNode<T> search(T data, BSTNode<T> tree) {
        if (tree == null) return null;
        int cmp = tree.data.compareTo(data);
        if (cmp == 0) {
            return tree;
        } else if (cmp < 0) {
            return search(data, tree.left);
        } else {
            return search(data, tree.right);
        }
    }

    private BSTNode<T> searchWithoutRecursion(T data, BSTNode<T> tree) {
        BSTNode<T> currentRoot = tree;
        while (currentRoot != null) {
            int cmp = currentRoot.data.compareTo(data);
            if (cmp == 0) {
                return currentRoot;
            } else if (cmp < 0) {
                currentRoot = currentRoot.left;
            } else {
                currentRoot = currentRoot.right;
            }
        }
        return null;
    }

}
