/*
Input: Array = {"10", "0001", "111001", "1", "0"}, m = 5, n = 3
Output: 4

Explanation: This are totally 4 strings can be formed by the using of 5 0s and 3 1s, which are “10,”0001”,”1”,”0”
*/

public int findMaxForm(String[] strs, int m, int n) {
    int[][] dp = new int[m + 1][n + 1];
    int[] nums = new int[]{0,0};
    for (String str : strs) {
        nums = calculate(str);
        for (int j = m; j >= nums[0]; j--) {
            for (int k = n; k >= nums[1]; k--) {
                if (j >= nums[0] && k >= nums[1]) {
                    dp[j][k] = Math.max(dp[j][k], dp[j - nums[0]][k - nums[1]] + 1);
                } else {
                    dp[j][k] = dp[j][k];
                }
            }
        }
    }
    
    return dp[m][n];
}

private int[] calculate(String str) {
    int[] res = new int[2];
    for (char ch : str.toCharArray()) {
        res[ch - '0']++;
    }
    return res;
}