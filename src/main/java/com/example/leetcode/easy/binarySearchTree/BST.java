package com.example.leetcode.easy.binarySearchTree;

import java.security.PublicKey;

public class BST {

    Node root;

    public BST() {
        root = null;
    }

    // Create New Node
    public Node createNewNode(int value) {
        return new Node(value, null, null);
    }

    // Add Operation
    public void add(Node rootNode, Node newNode) {

        if (root == null) {
            root = newNode;
            return;
        }
        if (newNode.value > rootNode.value) {

            if (rootNode.right == null) {
                rootNode.right = newNode;
                return;
            }
            add(rootNode.right, newNode);
        } else {
            if (rootNode.left == null) {
                rootNode.left = newNode;
                return;
            }
            add(rootNode.left, newNode);
        }
    }

    //Search Operation
    public void Search(int value, Node startNode) {
        if (root == null) {
            System.out.println("Tree is empty");
            return;
        }

        if (startNode == null) {
            System.out.println("Node is not found");
            return;
        }

        if (startNode.value == value) {
            System.out.println("Value found ");
            return;
        }

        if (value > startNode.value) {
            Search(value, startNode.right);
        } else {
            Search(value, startNode.left);
        }


    }

    // Print Binary Tree
    public void print(Node startNode) {
        if (startNode == null) {
            return;
        }
        System.out.println(startNode.value);
        print(startNode.right);
        print(startNode.left);
    }

    //Delete Node From Binary Tree
    public void delete(int value, Node startNode) {
        if (root == null) {
            System.out.println("Tree is empty");
            return;
        }

        if (startNode == null) {
            System.out.println("Delete Node is not found");
            return;
        }


        if (value > startNode.value &&  startNode.right != null) {
            if (value == startNode.right.value) {
                Node tempNode = startNode.right;
                startNode.right = tempNode.right;
                startNode.right.left = tempNode.left;
                System.out.println("Node Deleted");
                return;
            }
            delete(value, startNode.right);
        } else {
            if ( value < startNode.value && startNode.left != null) {
                if (value == startNode.left.value) {

                    Node tempNode = startNode.left;
                    startNode.left = tempNode.left;
                    startNode.left.right = tempNode.right;
                    System.out.println("Node Deleted");
                    return;
                }
                delete(value, startNode.left);
            }
        }


    }


}
