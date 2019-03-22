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


    public BSTNode<T> successor(BSTNode<T> tree) {
        if (tree == null) return null;
        if (tree.right != null) return min(tree.right);
        BSTNode<T> parent = tree.parent;
        while (parent != null && parent.right == tree) {
            tree = parent;
            parent = parent.parent;
        }
        return parent;
    }

    /**
     * insert new node, find insert pos , this pos is must be a leaf!!!
     *
     * @param key
     * @return
     */
    public BSTNode<T> insert(T key) {
        if (mRoot == null) {
            mRoot = new BSTNode<>(key, null, null, null);
            return mRoot;
        }
        BSTNode<T> cur = mRoot;
        BSTNode<T> preParent = null;
        while (cur != null) {
            int cmp = cur.data.compareTo(key);
            if (cmp == 0) {
                // already exist
                return cur;
            } else if (cmp > 0) {
                preParent = cur;
                cur = cur.left;
                if (cur == null) {
                    cur = new BSTNode<>(key, null, null, preParent);
                    preParent.left = cur;
                    break;
                }
            } else {
                preParent = cur;
                cur = cur.right;
                if (cur == null) {
                    cur = new BSTNode<>(key, null, null, preParent);
                    preParent.right = cur;
                    break;
                }
            }
        }
        return cur;
    }

    /**
     * 删除对应值的节点
     *
     * @param key
     * @return
     */
    public BSTNode<T> remove(T key) {
        BSTNode<T> node = search(key);
        if (node == null) return null;
        // 如果要删除的节点 左右孩子都有，则获取到该节点的后继节点， 然后交换二个节点的值，这样就可以只用删除后继节点的位置就可以了
        // 后继节点因为 至多只会存在一个孩子，所以删除比较容易
        if (node.left != null && node.right != null) {
            BSTNode<T> successor = successor(node);
            node.data = successor.data;
            node = successor;
        }

        BSTNode<T> child = null;
        if (node.left != null) {
            child = node.left;
        } else if (node.right != null){
            child = node.right;
        }

        BSTNode<T> parent = node.parent;

        if (child != null) {
            child.parent = parent;
        }
        if (parent == null) {
            mRoot = child;
        } else if (parent.left == node) {
            parent.left = child;
        } else if (parent.right == node) {
            parent.right = child;
        }
        return node;
    }

}
