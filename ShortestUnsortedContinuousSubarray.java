public class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
	    int beg = n - 1, end = 0;
	    int min = nums[n - 1], max = nums[0];

	    for (int i = 1; i < n; i++) {
	      	max = Math.max(max, nums[i]);
	      	min = Math.min(min, nums[n - 1 - i]);
	      	if (nums[i] < max) 
	      		end = i;
	      	if (nums[n - 1 - i] > min) 
	      		beg = n - 1 - i; 
	    }
	    
	    return end > beg ? end - beg + 1 : 0;
    }
}