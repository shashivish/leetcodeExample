package com.example.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

public class LT5_LongestPalindromeString {

    private int lo, maxLen;

    public static void main(String[] args) {

        //String s = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";

        String s = "babad";
        LT5_LongestPalindromeString t = new LT5_LongestPalindromeString();

        long t1 = System.currentTimeMillis();
        System.out.println(t.longestPalindromeWithN2(s));
        long t2 = System.currentTimeMillis();
        System.out.println(t2 - t1);


    }


    //Brute Force Approach
    public String longestPalindrome(String s) {

        if (s == null && s.length() == 0)
            return "";

        System.out.println(s);
        int i = 0;
        int j = 0;

        String str = "";
        String maxPalindromeString = "";

        for (i = 0; i < s.length(); i++) {
            for (j = i; j < s.length(); j++) {

                if (s.charAt(i) == s.charAt(j)) {
                    str = s.substring(i, j + 1);
                    //System.out.println("Checking for Palindrome " + str);
                    if (isPalindrome(str)) {
                        if (str.length() > maxPalindromeString.length())
                            maxPalindromeString = str;
                    }
                }
            }
        }


        return maxPalindromeString;

    }


    public boolean isPalindrome(String str) {

        int i = 0, j = str.length() - 1;

        while (i < j) {
            if (str.charAt(i) != str.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }


    public String longestPalindromeWithN2(String s) {
        int len = s.length();
        if (len < 2)
            return s;

        for (int i = 0; i < len - 1; i++) {
            extendPalindrome(s, i, i);  //assume odd length, try to extend Palindrome as possible
            extendPalindrome(s, i, i + 1); //assume even length.
        }
        return s.substring(lo, lo + maxLen);
    }

    private void extendPalindrome(String s, int j, int k) {
        while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
            j--;
            k++;
        }
        if (maxLen < k - j - 1) {
            lo = j + 1;
            maxLen = k - j - 1;
        }
    }


}
