public class Solution {

    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
        char[] chs = s.toCharArray();
        long[] dp = new long[2];
        
        dp[0] = ways(chs[0]);
        if (chs.length == 1) 
            return (int) dp[0];
        dp[1] = dp[0] * ways(chs[1]) + ways(chs[0], chs[1]);

        for (int i = 2; i < chs.length; i++) {
            long tmp = dp[1];
            dp[1] = (dp[1] * ways(chs[i]) + dp[0] * ways(chs[i - 1], chs[i])) % 1000000007;
            dp[0] = tmp;
        }
        return (int) dp[1];
    }
    
    private int ways(char c) {
        if (c == '*') return 9;
        if (c > '0' && c <= '9') return 1;
        return 0;
    }
    
    private int ways(char c1, char c2) {
        String str = c1 + "" + c2;
        if (c1 != '*' && c2 != '*') {
            int num = Integer.parseInt(str);
            if (num >= 10 && num <= 26) return 1;
        } else if (c1 == '*' && c2 == '*') {
            return 15;
        } else if (c1 == '*') {
            return (c2 >= '0' && c2 <= '6') ? 2 : 1;
        } else {
            if (c1 == '1') return 9;
            else if (c1 == '2') return 6;
        }
        return 0;
    }

}