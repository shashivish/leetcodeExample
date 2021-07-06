package com.example.leetcode.easy.linkedlist;

public class LinkedListTest {

    public static void main(String[] args) {
        SingleLinkedList<String> singleLinkedList = new SingleLinkedList<>();
        singleLinkedList.add("test1");
        singleLinkedList.add("test2");
        singleLinkedList.add("test3");
        singleLinkedList.deleteNode("test1");
        singleLinkedList.add("test4");
        singleLinkedList.add("test5");
        singleLinkedList.deleteNode("test4");
        singleLinkedList.print();








    }
}
