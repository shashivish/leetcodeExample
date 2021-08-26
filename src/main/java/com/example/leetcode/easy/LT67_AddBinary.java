package com.example.leetcode.easy;

public class LT67_AddBinary {

    public static void main(String[] args) {

    }

    //My Worst Solution
    public String addBinary(String a, String b) {

        int positionA = a.length() - 1;
        int positionB = b.length() - 1;

        StringBuffer result = new StringBuffer();

        int carry = 0;
        int aPos = 0;
        int bPos = 0;

        while (positionA >= 0 || positionB >= 0) {
            if (positionA >= 0)
                aPos = Integer.valueOf(String.valueOf(a.charAt(positionA)));

            if (positionB >= 0)
                bPos = Integer.valueOf(String.valueOf(b.charAt(positionB)));

            int sum = aPos + bPos + carry;
            if (carry == 1)
                carry = 0;

            // 0+0+0 = 0 = 0
            // 1+0+0 = 1 = 1
            // 1+1+0 = 0 = 2
            // 1+1+1 = 1 = 3


            if (sum == 2) {
                sum = 0;carry = 1;
            }
            if (sum == 3) {
                sum = 1;carry = 1;

            }

            System.out.println("" + aPos + " + " + bPos + " = " + sum);
            result.append(sum);

            positionA--;
            positionB--;

            aPos = 0;
            bPos = 0;
        }


        if (carry == 1)
            result.append(carry);

        return result.reverse().toString();

    }

    //Optimized
    public String addBinaryOpt(String a, String b) {
        StringBuilder sb = new StringBuilder(); //Google immutability or string vs stringbuilder if you don't know why we use this instead of regular string
        int i = a.length() - 1, j = b.length() - 1, carry = 0; //two pointers starting from the back, just think of adding two regular ints from you add from back
        while (i >= 0 || j >= 0) {
            int sum = carry; //if there is a carry from the last addition, add it to carry
            if (j >= 0) sum += b.charAt(j--) - '0'; //we subtract '0' to get the int value of the char from the ascii
            if (i >= 0) sum += a.charAt(i--) - '0';
            sb.append(sum % 2); //if sum==2 or sum==0 append 0 cause 1+1=0 in this case as this is base 2 (just like 1+9 is 0 if adding ints in columns)
            carry = sum / 2; //if sum==2 we have a carry, else no carry 1/2 rounds down to 0 in integer arithematic
        }
        if (carry != 0) sb.append(carry); //leftover carry, add it
        return sb.reverse().toString();
    }
}
