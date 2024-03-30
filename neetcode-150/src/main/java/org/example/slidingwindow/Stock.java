package org.example.slidingwindow;

public class Stock {
    public int maxProfit(int[] prices) {
        int N = prices.length;

        int maxProfit = 0;
        int maxSoFar = prices[N-1];
        for (int i = N-2; i >= 0; i--) {
            maxSoFar = Math.max(maxSoFar, prices[i]);
            maxProfit = Math.max(maxProfit, maxSoFar - prices[i]);
        }
        return maxProfit;
    }
}
