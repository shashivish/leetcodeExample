package com.example.leetcode.easy.linkedlist;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TestJava {
    public static void main(String[] args) {
        char p = 'p';
        List<Character>  list = new ArrayList<>();
        list.add(p);

        Set<Character> set = new HashSet<>();
        set.add(p);

        System.out.println(list.remove(p));
        System.out.println(set.remove(p));
    }
}
