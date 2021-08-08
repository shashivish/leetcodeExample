package com.example.leetcode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//https://leetcode.com/problems/generate-parentheses/
// Reference Video : https://www.youtube.com/watch?v=s9fokUqJ76A

public class LT_22_GenerateParantheses {

    Stack<String> stack = new Stack();
    List<String> result = new ArrayList();


    public static void main(String[] args) {

        LT_22_GenerateParantheses t = new LT_22_GenerateParantheses();
        int n = 3;
        System.out.println(t.generateParenthesis(n).toString());
    }

    public List<String> generateParenthesis(int n) {

        backtrack(0, 0, n);
        return result;

    }


    public void backtrack(int open, int close, int n) {

        if (open == close && close == n) {
            result.add(String.join("", stack));

        }

        if (open < n) {
            stack.add("(");
            backtrack(open + 1, close, n);
            stack.pop();
        }

        if (close < open) {
            stack.add(")");
            backtrack(open, close + 1, n);
            stack.pop();
        }

    }

}
