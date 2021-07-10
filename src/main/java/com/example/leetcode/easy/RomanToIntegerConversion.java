package com.example.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class RomanToIntegerConversion {

    public static void main(String[] args) {

        RomanToIntegerConversion r = new RomanToIntegerConversion();
        System.out.println(r.romanToInt("IV"));
    }


    public int romanToInt(String s) {


        Map<String, Integer> romanToIntMap = new HashMap();
        romanToIntMap.put("I", 1);
        romanToIntMap.put("V", 5);
        romanToIntMap.put("X", 10);
        romanToIntMap.put("L", 50);
        romanToIntMap.put("C", 100);
        romanToIntMap.put("D", 500);
        romanToIntMap.put("M", 1000);

        int value = 0;

        for (int i = 0; i < s.length(); i++) {
            int s1 = romanToIntMap.get(String.valueOf(s.charAt(i)));

            if (i + 1 < s.length()) {
                int s2 = romanToIntMap.get(String.valueOf(s.charAt(i + 1)));

                if (s1 < s2) {
                    value = value + s2 - s1;
                    i++;
                }
                if (s1 >= s2) {
                    value = value + s1;
                }
            } else {
                value = value + s1;
            }

        }


        return value;


    }
}
