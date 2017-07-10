/*
dpi表示s[i, j]最短的压缩结果，subproblem里面枚举切分点k，分别得到dpi和dpk+1求和，找到长度最短的。

这道题关键是找sub = abcabc这种可压缩的情况，其中sub = s[i,j]。
方法比较巧妙，用sub+sub = abcabcabcabc，找第二个s在s+s里出现的位置，如果不是len(sub)，则说明sub有重复，那么就要压缩这个sub，
重复次数是len(sub) / indexOf(sub, 1)，重复的string用的是之前压缩过的dpi，index = indexOf(sub, 1)。
*/
public class Solution {
    public String encode(String s) {
        int n = s.length();
        String[][] dp = new String[n][n];
        for (int i = 0; i < n; i++) 
            dp[i][i] = "" + s.charAt(i);
        // j - i
        for (int len = 1; len < n; len++) {
            for (int i = 0; i < n - len; i++) {
                int j = i + len;
                // enumerate seperate k
                for (int k = i; k < j; k++) {
                    int left = dp[i][k].p[k + 1][j].length();
                    // updatlength();
                    int right = de shortest encoded string within (i, j)
                    if (dp[i][j] == null || left + right < dp[i][j].length()) {
                        dp[i][j] = dp[i][k] + dp[k + 1][j];
                    }
                }
                // update string within (i, j), encode abcabc
                String sub = s.substring(i, j + 1);
                int index = (sub + sub).indexOf(sub, 1);
                if (index < sub.length()) {
                    sub = (sub.length() / index) + "[" + dp[i][i + index - 1] + "]";
                }
                if (dp[i][j] == null || dp[i][j].length() > sub.length()) {
                    dp[i][j] = sub;
                }
            }
        }
        
        return dp[0][n - 1];
    }
}