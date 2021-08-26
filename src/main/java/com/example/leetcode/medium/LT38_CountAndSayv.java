package com.example.leetcode.medium;

public class LT38_CountAndSayv {
    public static void main(String[] args) {

        LT38_CountAndSayv t = new LT38_CountAndSayv();
        System.out.println(t.countAndSay(12));

    }


    //My Solution  -15 RuntTime
    public String countAndSay(int n) {
        if (n == 1)
            return "1";
        String start = "1";
        int counter = 1;
        while (counter <= n - 1) {
            String s = start;
            char[] c = s.toCharArray();
            int count = 0;
            String tempString = "";
            int tmpPointer = 0;
            for (int i = 0; i < c.length; i++) {
                for (int j = i; j < c.length; j++) {
                    if (c[i] == c[j]) {
                        tmpPointer = j;
                        count++;
                    } else {
                        if (c[i] != c[j]) {
                            break;
                        }
                    }
                    i = tmpPointer;
                }
                //  System.out.println("Count" + count + " Say " + c[i]);
                tempString = tempString + count + "" + String.valueOf(c[i]);
                count = 0; // reset count
            }
            //  System.out.println("New String" + tempString );
            start = tempString;
            counter++;
        }

        return start;
    }


    /**
     * Optimized Approach 99% Runtime
     */

    public String countAndSayOpt(int n) {
        String s = "1";
        for (int i = 1; i < n; i++) {
            s = countIdx(s);
        }
        return s;
    }

    public String countIdx(String s) {
        StringBuilder sb = new StringBuilder();
        char c = s.charAt(0);
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                count++;
            } else {
                sb.append(count);
                sb.append(c);
                c = s.charAt(i);
                count = 1;
            }
        }
        sb.append(count);
        sb.append(c);
        return sb.toString();
    }
}
