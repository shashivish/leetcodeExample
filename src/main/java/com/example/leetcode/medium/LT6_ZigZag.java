package com.example.leetcode.medium;

public class LT6_ZigZag {
    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int rows = 3;
        LT6_ZigZag t = new LT6_ZigZag();
        System.out.println(t.convert(s, rows));


    }

    public String convert(String s, int numRows) {

        System.out.println("STRING LENGTH : " + s.length());

        if (s.length() < 2)
            return s;


        System.out.println("S : " + s + " Rows : " + numRows);


        int col = s.length(); /// numRows + numRows;
        int row = numRows;
        char[][] store = new char[col][numRows];

        System.out.println("row " + row + " col " + col);

        int stringPointer = 0;

        int i = 0;
        int j = 0;

        for (i = 0; i < col; i++) {

            if (stringPointer >= s.length()) {
                break;
            }

            if (j <= 0) {
                j = 0;
                row = store[0].length;
            }

            while (j < row && stringPointer < s.length()) {
                char c = s.charAt(stringPointer);

                //  System.out.println("Pushing Element at Posistion i & j " + i + "-" + j + " Char " + c);
                store[i][j] = c;
                j++;
                stringPointer++;
            }

            if (j == row && row != 0) {
                j = j - 2;
                row--;
                // System.out.println("Continue");
            }


        }
        String sb = "";
        i = 0;
        j = 0;
        row = store[0].length; // ROW RESET

        for (i = 0; i < row; i++) {

            for (j = 0; j < col; j++) {
                String sp = String.valueOf(store[j][i]);
                // System.out.println("Position j - i " + " | " + j +" - "+i   );
                if (sp != null && sp.trim().length() > 0) {

                    sb = sb + sp;
                }

            }


        }
        return sb;

    }
}
