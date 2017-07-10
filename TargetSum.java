public class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int originSum = 0;
        for (int num : nums) {
            originSum += num;
        }
        // 如果原始sum就比S小（注意：原始的个元素都是非负的），那么就算令所有树都为正数，也无法sum成S
        // 且 如果S + originSum是奇数的话，无法用2整除，暗示着无法分成P和Q两个group来使得赋符号后的sum为S
        if (originSum < S || (S + originSum) % 2 != 0) {
            return 0;
        } else {
            // 下面解决一个问题：即在a[0->n-1]中找出一个集合P，使得P中所有元素之和为((S + originSum) / 2)
            return subsetSum(nums, (S + originSum) / 2);
        }
    }

    public int subsetSum(int[] nums, int target) {
        int[] dp = new int[target + 1];
        // 伪造f(-1, 0)的base base，即在a[0->-1]中找subset使得sum为0，伪造成有1种subset(即空集)。而对于f(-1,大于0的值)都是伪造成有0种subset。
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >= nums[i]; j--) {
                // f(i,j) = f(i-1, j) + f(i-1, j-a[i])
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[target];
    }
}