package com.example.leetcode.easy;

public class PalindromeNumber {

    public static void main(String[] args) {

        PalindromeNumber palindromeNumber = new PalindromeNumber();
        System.out.println( palindromeNumber.isPalindrome(121));

    }


    public boolean isPalindrome(int x) {


        if (x < 0 )
            return false;


        if (x == 0 )
            return true;


        int reverseNumber = 0 ;

        while (x > 0)
        {
            int mod =  x%10 ; // 1 // 2
            x = x/10; // 12 // 1
            reverseNumber = 10*reverseNumber + mod;

        }

        System.out.print("Reverse Number " + reverseNumber);


        if(reverseNumber == x)
        {
            return true;
        }
        else
        {
            return false;
        }



    }

}
