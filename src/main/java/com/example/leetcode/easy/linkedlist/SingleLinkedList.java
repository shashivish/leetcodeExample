package com.example.leetcode.easy.linkedlist;

public class SingleLinkedList<T> {

    private Node head;

    public void add(T data) {
        Node node = new Node();
        node.value = data;
        node.next = null;

        if (head == null) {
            head = node;
        } else {
            Node travelNode = head;

            while (travelNode.next != null) {
                // Travel to End
                travelNode = travelNode.next;
            }
            travelNode.next = node;

        }
    }

    public void print() {

        if (head == null) {
            System.out.println("Linked List is Empty.");
            return;
        }


        Node node = head;
        while (node.next != null) {
            System.out.println(node.value);
            node = node.next;
        }
        System.out.println(node.value);

    }

    // null
    // 1 -> null
    // 1 -> 2 -> null : 2
    // 1 -> 2 -> 3 -> null :  2

    public void deleteNode(T data) {

        if (head == null) {
            System.out.println("Linked List is Empty.");
            return;
        }

        if (head.next == null) {
            head = null;
            System.out.println("Item Removed From List " + data);
            return;
        }

        if (head.value == data) {
            Node node = head;
            head = node.next;
            node = null;
            System.out.println("Item Removed From List " + data);
            return;

        }

        Node node = head;
        Node prevNode = null;
        while (node.next != null) {
            if (node.value == data) {
                prevNode.next = node.next;
                node = null;
                System.out.println("Item Removed From List " + data);
                return;
            }

            prevNode = node;
            node = node.next;
        }

        // Delete Last Element of Node
        if (node.next == null) {
            prevNode.next = null;
            node = null;
            System.out.println("Item Removed From List " + data);

        }


    }

}
