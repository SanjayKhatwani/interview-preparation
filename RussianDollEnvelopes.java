/*
You have a number of envelopes with widths and heights given as a pair of integers (w, h). One envelope can fit into another if and only if both the width and height of one envelope is greater than the width and height of the other envelope.

What is the maximum number of envelopes can you Russian doll? (put one inside other)

Example:
Given envelopes = [[5,4],[6,4],[6,7],[2,3]], the maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).
*/

public class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0 || envelopes[0] == null || envelopes[0].length != 2)
            return 0;
        Arrays.sort(envelopes, (a, b) -> {
                if (a[0] == b[0])
                    return b[1] - a[1];
                else
                    return a[0] - b[0];
        });
        int dp[] = new int[envelopes.length];
        int len = 0;
        for (int[] envelope : envelopes) {
            int index = Arrays.binarySearch(dp, 0, len, envelope[1]);
            if (index < 0) index = -(index + 1);
            dp[index] = envelope[1];
            if (index == len) len++;
        }
        return len;
    }
}



// O(n^2) dynamic programming

public class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null
            || envelopes.length == 0
            || envelopes[0] == null
            || envelopes[0].length == 0) {
            return 0;    
        }
        
        Arrays.sort(envelopes, (a, b) -> a[0] - b[0]);
        
        int n = envelopes.length;
        int[] dp = new int[n];
        
        int res = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
            
            ret = Math.max(ret, dp[i]);
        }
        return ret;
    }
}