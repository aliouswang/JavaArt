package com.aliouswang.olympic.tree;

public class TreeTest {

    public static void main(String[] args) {

        Tree tree = new Tree();
        tree.insert(6, 6);
        tree.insert(3, 3);
        tree.insert(14, 14);
        tree.insert(10, 10);
        tree.insert(9, 9);
        tree.insert(13, 131);
        tree.insert(11, 11);
        tree.insert(12, 12);
        tree.insert(16, 16);

        System.out.println("find key 13 value: " + tree.find(13).value);

        System.out.println("find replace : " + tree.findReplaceNode(new Node(11, 11)).value);

        tree.preOrder();
    }

}
