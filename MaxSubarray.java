public class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int max = Integer.MIN_VALUE;
        int preSum = 0, maxEndingHere = 0;
        for (int n : nums) {
            maxEndingHere = preSum > 0 ? preSum + n : n;
            max = Math.max(max, maxEndingHere);
            preSum = maxEndingHere;
        }
        return max;
    }
}