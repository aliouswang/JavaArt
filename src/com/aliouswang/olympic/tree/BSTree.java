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

    private void preOrder(BSTNode<T> node) {
        if (node == null) return;
        Log.d(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * in order traverse
     */
    public void inOrder() {
        inOrder(mRoot);
    }

    private void inOrder(BSTNode<T> node) {
        if (node != null) {
            inOrder(node.left);
            Log.d(node.data + " ");
            inOrder(node.right);
        }
    }

    /**
     * post order traverse
     */
    public void postOrder() {
        postOrder(mRoot);
    }

    private void postOrder(BSTNode<T> node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            Log.d(node.data + " ");
        }
    }
}
