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

    /**
     * search the BSTNode
     *
     * @param data
     * @return
     */
    public BSTNode<T> search(T data) {
        return search(data, mRoot);
    }

    /**
     * search with recursion
     *
     * @param data
     * @param tree
     * @return
     */
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

    /**
     * search without recursion
     *
     * @param data
     * @param tree
     * @return
     */
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

    /**
     * find max node
     *
     * @return
     */
    public BSTNode<T> max() {
        return max(mRoot);
    }

    private BSTNode<T> max(BSTNode<T> tree) {
        BSTNode<T> node = tree;
        BSTNode<T> result = null;
        while (node != null) {
            if (node.right == null) {
                result = node;
                break;
            } else {
                node = node.right;
            }
        }
        return result;
    }

    /**
     * find min node
     *
     * @return
     */
    public BSTNode<T> min() {
        return min(mRoot);
    }

    public BSTNode<T> min(BSTNode<T> tree) {
        BSTNode<T> node = tree;
        BSTNode<T> result = null;
        while (node != null) {
            if (node.left == null) {
                result = node;
                break;
            } else {
                node = node.left;
            }
        }
        return result;
    }


    /**
     * 查找node的前驱，左子树的最大值
     *
     * @param targetNode
     * @return
     */
    public BSTNode<T> predecessor(BSTNode<T> targetNode) {
        if (targetNode == null) return null;
        // 如果有左子树，则寻找左子树的最大节点
        if (targetNode.left != null) {
            return max(targetNode.left);
        }
        // 如果没有左子树，有二种情况，
        // 1. 父节点的右子树，则前驱是父节点
        // 2. 父节点的左子树，则继续向上寻找，直到找到 节点是右节点 的时候，该父节点就是我们的答案
        BSTNode<T> parent = targetNode.parent;
        while (parent != null && targetNode == parent.left) {
            targetNode = parent;
            parent = parent.parent;
        }
        return parent;
    }

}
