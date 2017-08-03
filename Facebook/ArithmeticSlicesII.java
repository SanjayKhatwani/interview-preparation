public class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        Map<Integer, Integer>[] dp = new Map[A.length];
        int res = 0;
        for (int i = 0; i < A.length; i++) {
            dp[i] = new HashMap<>();
            for (int j = 0; j < i; j++) {
                long diff = (long) A[i] - A[j];
                if (diff < Integer.MIN_VALUE || diff > Integer.MAX_VALUE) continue;
                int d = (int) diff;
                int a = dp[i].getOrDefault(d, 0);
                int b = dp[j].getOrDefault(d, 0);
                dp[i].put(d, a + b + 1);
                res += b;
            }
        }
        return res;
    }
}