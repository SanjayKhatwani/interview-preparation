public class Solution {
    public String encode(String s) {
        int n = s.length();
        String[][] dp = new String[n][n];

        for (int i = 0; i < n; i++) 
            dp[i][i] = "" + s.charAt(i);

        for (int len = 1; len < n; len++) {
            for (int i = 0; i < n - len; i++) {
                int j = i + len;
                // enumerate seperate k
                for(int k = i; k < j; k++) {
                    int left = dp[i][k].length();
                    int right = dp[k+1][j].length();
                    // update shortest encoded string within (i, j)
                    if(dp[i][j] == null || left + right < dp[i][j].length()) {
                        dp[i][j] = dp[i][k] + dp[k+1][j];
                    }
                }
                // update string within (i, j), encode abcabc
                String sub = s.substring(i, j + 1);
                int index = (sub + sub).indexOf(sub, 1);
                if(index < sub.length()) {
                    sub = (sub.length() / index) + "[" + dp[i][i+index-1] + "]";
                }
                if(dp[i][j] == null || dp[i][j].length() > sub.length()) {
                    dp[i][j] = sub;
                }
            }
        }
        
        return dp[0][n-1];
    }
}