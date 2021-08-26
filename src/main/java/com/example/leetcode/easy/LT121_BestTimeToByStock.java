package com.example.leetcode.easy;

public class LT121_BestTimeToByStock {

    public static void main(String[] args) {

        int[] data = {7,1,5,3,6,4};
        LT121_BestTimeToByStock  t = new LT121_BestTimeToByStock();
        System.out.println(t.maxProfit(data));

    }

    //My Logic O(N^2) complexity
    public int maxProfit(int[] prices) {

        int maxProfit = 0;
        int finalMaxProfit = 0;


        for (int left = 0; left < prices.length; left++) {

            if ((left == 0) || (prices[left] != prices[left - 1])) {
                int right = prices.length - 1;
                while (left < right) {

                    if (prices[right] > prices[left]) {
                        //calculate profit
                        maxProfit = prices[right] - prices[left];

                        if (maxProfit > finalMaxProfit)
                            finalMaxProfit = maxProfit;
                    }

                    right--;
                }
            }

        }

        return finalMaxProfit;
    }


    //Optimized Approach  - O(N) Complexity

    public int maxProfitOptimized(int prices[]) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice)
                minprice = prices[i];
            else if (prices[i] - minprice > maxprofit)
                maxprofit = prices[i] - minprice;
        }
        return maxprofit;
    }
}
