public class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
        char[] chs = s.toCharArray();
        int[] dp = new int[2];
        dp[0] = ways(chs[0]);
        if (chs.length < 2)
            return dp[0];
        dp[1] = dp[0] * ways(chs[1]) + ways(chs[0], chs[1]);
        for (int i = 2; i < chs.length; i++) {
            int tmp = dp[1];
            dp[1] = dp[1] * ways(chs[i]) + dp[0] * ways(chs[i - 1], chs[i]);
            dp[0] = tmp;
        }
        return dp[1];
    }
    
    private int ways(char c) {
        return (c > '0' && c <= '9') ? 1 : 0;
    }
    
    private int ways(char c1, char c2) {
        if (c1 == '1') return 1;
        if (c1 == '2') return (c2 >= '0' && c2 <= '6') ? 1 : 0;
        return 0;
    }
}