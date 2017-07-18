public class Solution {

    public int[] searchRange(int[] nums, int target) {
        int index1 = binarySearch1(nums, target, 0, nums.length-1);
        int index2 = binarySearch2(nums, target, 0, nums.length-1);
        int[] result = {index1, index2};
        return result;
    }
    
    public int binarySearch1(int[] nums, int target, int low, int high) {
        if (low > high) return -1;
        if (low == high) return nums[low] == target ? low : -1;
        int mid = low + (high - low) / 2;
        if (nums[mid] >= target) {
            return binarySearch1(nums, target, low, mid);
        } else {
            return binarySearch1(nums, target, mid + 1, high);
        }
    }
    
    public int binarySearch2(int[] nums, int target, int low, int high) {
        if (low > high) return -1;
        if (low == high) return nums[low] == target ? low : -1;
        int mid = low + (high - low) / 2 + 1;
        if (nums[mid] <= target) {
            return binarySearch2(nums, target, mid, high);
        } else {
            return binarySearch2(nums, target, low, mid - 1);
        }
    }
    
}