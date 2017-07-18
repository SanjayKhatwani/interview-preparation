public boolean increasingTriplet(int[] nums) {
    int small = Integer.MAX_VALUE, big = Integer.MAX_VALUE;
    for (int n : nums) {
        if (n <= small) { 
        	small = n; 
        } else if (n <= big) { 
	        big = n; 
	    } else 
	    	return true; 
    }
    return false;
}


public class Solution {
    public boolean increasingTriplet(int[] nums) {
        int[] tails = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            int l = 0, r = len;
            while (l < r) {
                int mid = (l + r) / 2;
                if (tails[mid] < num) l = mid + 1;
                else r = mid;
            }
            tails[l] = num;
            if (l == len) len++;
        }
        return len >= 3;
    }
}