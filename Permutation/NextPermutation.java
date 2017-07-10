public class Solution {

    public int[] nextPermutation(int[] nums) {
        if (nums.length <= 1) return nums;
        
        int i = nums.length - 1;
        while (i > 0 && nums[i] <= nums[i-1]) i--;
        swapRange(nums, i, nums.length - 1);
        if (i > 0) {
            int j = i;
            while (nums[j] <= nums[i - 1]) j++;
            swap(nums, i - 1, j);
        }
        return nums;
    }
    
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    
    private void swapRange(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start++, end--);
        }
    }
    
}
