// At most two transactions

public class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int len = prices.length;
        if (len <= 1) return max;
        
        int[] before = new int[len];
        int[] after = new int[len];
        int lowest = prices[0];
        int highest = prices[len - 1];
        
        for (int i = 1; i < len; i++) {
            lowest = Math.min(lowest, prices[i]);
            before[i] = Math.max(before[i-1], prices[i] - lowest);
        }
        for (int j = len - 2; j >= 0; j--) {
            highest = Math.max(highest, prices[j]);
            after[j] = Math.max(after[j+1], highest - prices[j]);
        }
        for (int k = 0; k < len; k++) {
            max = Math.max(max, before[k] + after[k]);
        }
        return max;
    }
}