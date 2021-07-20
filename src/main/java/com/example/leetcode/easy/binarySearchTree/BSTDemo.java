package com.example.leetcode.easy.binarySearchTree;

public class BSTDemo {

    public static void main(String[] args) {

        BST b = new BST();
        b.add(b.root, b.createNewNode(10));
        b.add(b.root, b.createNewNode(12));
        b.add(b.root, b.createNewNode(11));
        b.add(b.root, b.createNewNode(14));
        b.add(b.root, b.createNewNode(7));
        b.add(b.root, b.createNewNode(5));
        b.add(b.root, b.createNewNode(9));
        b.add(b.root, b.createNewNode(16));
        b.add(b.root, b.createNewNode(13));

        b.print(b.root);
        b.Search(4, b.root);
        b.delete(44, b.root);
        b.print(b.root);

    }
}
