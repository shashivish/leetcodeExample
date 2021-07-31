package com.example.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class LT28_IndexOfImplement {

    public static void main(String[] args) {

        String s1 = "hello";
        String s2 = "ll";

        LT28_IndexOfImplement t = new LT28_IndexOfImplement();
        System.out.println(t.strStr(s1,s2));

    }


//Online Solution Found
//    public int strStr(String haystack, String needle) {
//        for (int i = 0; ; i++) {
//            for (int j = 0; ; j++) {
//                if (j == needle.length()) return i;
//                if (i + j == haystack.length()) return -1;
//                if (needle.charAt(j) != haystack.charAt(i + j)) break;
//            }
//        }
//    }

// My Solution
    public int strStr(String haystack, String needle) {

        if (needle.length() == 0)
            return 0;

        if(needle.length() > haystack.length())
            return -1;

        char[] hchar = haystack.toCharArray();
        char[] nchar = needle.toCharArray();

        char c = nchar[0];
        int startPosition =-1;


        // Find possible Match Location
        List<Integer> possibleMatchStartList  =  possibleMatch(c, hchar);
        System.out.println("Possible Match Start Location " + possibleMatchStartList.toString());


        // Iterate on Each Start Position and Try Match String
        for(int start : possibleMatchStartList)
        {
            System.out.println("Trying Start " +  start);
            startPosition = validateMatch(start , nchar ,  hchar);
            if(startPosition >=0)
                break;

        }



        return startPosition;

    }

    /**
     Get List of Possible Start Position
     **/

    public List<Integer> possibleMatch(char c, char[] hchar )
    {
        List<Integer>  list = new ArrayList<>();

        for(int i = 0 ; i < hchar.length ; i++)
        {
            if(c ==hchar[i])
                list.add(i);
        }

        return list;
    }

    //Validate Match
    public int validateMatch(int haystackStartPtr ,  char[] nchar , char[] hchar)
    {
        int startPosition = -1;
        boolean flag = true;
        int j = 0;
        for(int i = haystackStartPtr ; i < hchar.length ; i++)
        {
            if(j < nchar.length)
            {
                if(hchar[i]== nchar[j])
                {
                    if(flag == true)
                    {
                        startPosition = i ; flag = false;
                    }

                    j++;
                }else
                {
                    startPosition = -1; // If any char in needle did not match , make startPosition -1;
                }

            }

        }

        if(j < nchar.length) // if haystack has reached to end but still needle is not completely processed.
            startPosition = -1;

        return startPosition;
    }

}
