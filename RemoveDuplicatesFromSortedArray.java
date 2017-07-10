public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1)
            return nums.length;
        int i = 0, j = 0;
        while (j < nums.length) {
            if (nums[j] == nums[i]) {
                j++;
                continue;
            }
            if (j - i > 1) {
                nums[++i] = nums[j];
            } else {
                i++;
                j++;
            }
        }
        return i+1;
    }
}