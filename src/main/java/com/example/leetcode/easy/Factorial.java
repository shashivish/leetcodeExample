package com.example.leetcode.easy;

public class Factorial {

    public static void main(String[] args) {

        Factorial f = new Factorial();
        int  value =5;
        int result= f.evaluate(value);
        System.out.println("Factorial of " +value + "! is : " + result);

    }
    public int evaluate(int value) {

        if (value == 0)
            return 1;
        else
            return value * evaluate(value - 1);
    }
}
