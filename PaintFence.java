
public class Solution {
    public int numWays(int n, int k) {
        if (n == 0) return 0;
        if (n == 1) return k;
        int[] ways = new int[n];
        ways[0] = k;
        ways[1] = k*k;
        for (int i = 2; i < n; i++) {
            // 递推式：第三根柱子要么根第一个柱子不是一个颜色，要么跟第二根柱子不是一个颜色
            ways[i] = (k-1) * ways[i-2] + (k-1) * ways[i-1];
        }
        return ways[n-1];
    }
}