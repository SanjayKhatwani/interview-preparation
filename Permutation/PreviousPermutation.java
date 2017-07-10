public class Solution {

    public List<Integer> previousPermuation(List<Integer> nums) {
		if (nums == null || nums.size() <= 1) 
		    return nums;
		int i = nums.size() - 1;
		while (i > 0 && nums.get(i) >= nums.get(i - 1)) i--;
		swapRange(nums, i, nums.size() - 1);
		if (i > 0) {
		    int j = i;
		    while (nums.get(j) >= nums.get(i - 1)) j++;
		    swap(nums, i - 1, j);
		}
		return nums;
    }
    
    private void swap(List<Integer> nums, int i, int j) {
        int tmp = nums.get(i);
        nums.set(i, nums.get(j));
        nums.set(j, tmp);
    }
    
    private void swapRange(List<Integer> nums, int start, int end) {
        while (start < end) {
            swap(nums, start++, end--);
        }
    }

}