package com.example.leetcode.easy;

import java.util.Map;
import java.util.TreeMap;

public class LT12_IntegerToRoman {

    public static void main(String[] args) {

        LT12_IntegerToRoman l = new LT12_IntegerToRoman();
        System.out.println(l.intToRoman(12));

    }

    public String intToRoman(int num) {
        String romanString = "";  int prevValue = 0;int netxVal = 0;
        if (num == 0)
            return romanString;
        Map<Integer, String> roman = new TreeMap<>();
        roman.put(1, "I");roman.put(4, "IV");roman.put(5, "V");roman.put(9, "IX");roman.put(10, "X");roman.put(40, "XL");
        roman.put(50, "L");roman.put(90, "XC");roman.put(100, "C");roman.put(400, "CD");roman.put(500, "D");roman.put(900, "CM");roman.put(1000, "M");

        //Check if Number if Already Present in Map
        if (roman.containsKey(num)) {
            return roman.get(num); }

        while (num > 0) { // Iterate till num becomes 0;
            System.out.println("Looking for Number " + num);
            for (Map.Entry<Integer, String> e : roman.entrySet()) {
                if (prevValue == 0) {
                    prevValue = e.getKey();
                } else {
                    netxVal = e.getKey();
                    if (num >= prevValue && num < netxVal) {
                        System.out.println("Range Found " + prevValue + " - " + netxVal);
                        break;
                    }
                    prevValue = netxVal;
                }
            }
            num = num - prevValue;
            romanString = romanString + roman.get(prevValue);
        }
        return romanString;

    }

}
