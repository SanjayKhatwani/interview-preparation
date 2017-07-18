// One Transaction
public class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        if (prices.length < 2)
            return max;
        int lowestPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            max = Math.max(max, prices[i] - lowestPrice);
            lowestPrice = Math.min(lowestPrice, prices[i]);
        }
        return max;
    }
}

// Any times transaction
public class Solution {
    public int maxProfit(int[] prices) {
        int total = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i + 1] > prices[i]) 
                total += prices[i + 1] - prices[i];
        }
        
        return total;
    }
}

// At most 2 transactions
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
            before[i] = Math.max(before[i - 1], prices[i] - lowest);
        }
        for (int j = len - 2; j >= 0; j--) {
            highest = Math.max(highest, prices[j]);
            after[j] = Math.max(after[j + 1], highest - prices[j]);
        }
        for (int k = 0; k < len; k++) {
            max = Math.max(max, before[k] + after[k]);
        }
        return max;
    }
}

// At most k transactions
public int maxProfit(int k, int[] prices) {
    int n = prices.length;
    if (n <= 1)
        return 0;
    
    //if k >= n/2, then you can make maximum number of transactions.
    if (k >=  n / 2) {
        int maxPro = 0;
        for (int i = 1; i < n; i++) {
            if (prices[i] > prices[i-1])
                maxPro += prices[i] - prices[i-1];
        }
        return maxPro;
    }
    
    int[][] dp = new int[k + 1][n];
    for (int i = 1; i <= k; i++) {
        int localMax = dp[i - 1][0] - prices[0];
        for (int j = 1; j < n; j++) {
            dp[i][j] = Math.max(dp[i][j - 1],  prices[j] + localMax);
            localMax = Math.max(localMax, dp[i - 1][j] - prices[j]);
        }
    }
    return dp[k][n-1];
}