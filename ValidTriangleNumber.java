public class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for (int end = nums.length - 1; end >= 2; end--) {
            int l = 0, r = end - 1;
            while (l < r) {
                if (nums[l] + nums[r] > nums[end]) {
                    count += r - l;
                    r--;
                } else {
                    l++;
                }
            }
        }
        return count;
    }
}