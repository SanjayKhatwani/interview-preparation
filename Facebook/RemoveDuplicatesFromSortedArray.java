// No duplicates
public int removeDuplicates(int[] A) {
    if (A.length == 0) 
    	return 0;
    int i = 0;
    for (int j = 0; j < nums.length; j++) {
        if (nums[j] != nums[i]) {
            nums[++i] = nums[j];
        }
    }
    return i + 1;
}


// Allow two times appearance
public class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int n : nums)
            if (i < 2 || n > nums[i-2])
                nums[i++] = n;
        return i;
    }
}
