class Solution {
    /**
     * @param nums: A list of integer which is 0, 1 or 2 
     * @return: nothing
     */
    public void sortColors(int[] nums) {
        // write your code here
        int head = 0; 
        int tail = nums.length - 1;
        int i = 0;
        while (i <= tail) {
            if (nums[i] == 0) {
                swap(nums, i++, head++);
            } else if (nums[i] == 2) {
                swap(nums, i, tail--);
            } else {
                i++;
            }
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[j];
        nums[j] = nums[i];
        nums[i] = tmp;
    }
}