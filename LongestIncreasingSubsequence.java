public class Solution {

    public int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int size = 0;
        for (int x : nums) {
            int i = 0, j = size;
            while (i != j) {
                int m = (i + j) / 2;
                if (tails[m] < x)
                    i = m + 1;
                else
                    j = m;
            }
            tails[i] = x;
            if (i == size) ++size;
        }
        return size;
    }
}


// Better solution
public class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int[] dp = new int[nums.length];
        int maxLen = 0;
        for (int num : nums) {
            int pos = Arrays.binarySearch(dp, 0, maxLen, num);
            if (pos < 0) pos = -(pos + 1);
            dp[pos] = num;
            if (pos == maxLen) maxLen++;
        }
        return maxLen;
    }
}