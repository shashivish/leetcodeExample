package com.example.leetcode.medium;

import java.util.*;

// Problem Statement : https://leetcode.com/problems/letter-combinations-of-a-phone-number/

public class LT17_Phone {

    public static void main(String[] args) {
        LT17_Phone t = new LT17_Phone();
        System.out.println(t.letterCombinations("234"));

    }


    //Optimized Approach
    public List<String> letterCombinations(String digits) {
        LinkedList<String> ans = new LinkedList<String>();
        if (digits.isEmpty()) return ans;
        String[] mapping = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        while (ans.peek().length() != digits.length()) {
            String remove = ans.remove();
            String map = mapping[digits.charAt(remove.length()) - '0'];
            for (char c : map.toCharArray()) {
                ans.addLast(remove + c);
            }
        }
        return ans;
    }

    // My Brute Force Approach
    public List<String> letterCombinationsBruteForce(String digits) {

        //digits = "2345";

        List<String> result = new ArrayList();

        if (digits.length() == 0)
            return result;

        Map<String, String> map = new HashMap();
        map.put("2", "abc");
        map.put("3", "def");
        map.put("4", "ghi");
        map.put("5", "jkl");
        map.put("6", "mno");
        map.put("7", "pqrs");
        map.put("8", "tuv");
        map.put("9", "wxyz");

        if (digits.length() == 1) {
            String s = map.get(digits);
            result = Arrays.asList(s.split(""));
            return result;
        }
        int j = 0;
        List<String> l1 = new ArrayList();
        List<String> l2 = new ArrayList();
        while (j + 1 < digits.length()) {


            if (j == 0) //Initialized l1 when you are starting
            {
                l1 = Arrays.asList(map.get(String.valueOf(digits.charAt(j))).split(""));
                l2 = Arrays.asList(map.get(String.valueOf(digits.charAt(j + 1))).split(""));

            } else {
                //Just initialized l2 and using already populated l1 for merging
                l2 = Arrays.asList(map.get(String.valueOf(digits.charAt(j + 1))).split(""));
            }
            l1 = mergedList(l1, l2);
            j++;
        }


        return l1;
    }

    List<String> mergedList(List<String> l1, List<String> l2) {
        List<String> m = new ArrayList();


        for (int i = 0; i < l1.size(); i++) {
            for (int j = 0; j < l2.size(); j++) {
                String tmp = l1.get(i) + l2.get(j);
                m.add(tmp);
            }
        }

        return m;

    }
}
