public class Solution {

    public int longestPalindromeSubseq(String s) {
        char[] chars = s.toCharArray();
        int l = chars.length;
        int[][] dp = new int[l][l];

        for (int i = 0; i < l; i++)
            dp[i][i] = 1;
        
        for (int i = 1; i < l; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (chars[i] == chars[j])
                    dp[j][i] = 2 + dp[j + 1][i - 1];
                else 
                    dp[j][i] = Math.max(dp[j][i - 1], dp[j + 1][i]);
            }
        }
        
        return dp[0][l-1];
    }

}