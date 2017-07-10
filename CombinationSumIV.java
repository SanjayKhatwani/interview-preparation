public class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] ways = new int[target + 1];
        ways[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i >= nums[j])
                    ways[i] += ways[i - nums[j]];
            }
        }
        return ways[target];
    }
}
