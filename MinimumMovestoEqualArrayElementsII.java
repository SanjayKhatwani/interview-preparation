// O(n*logn)
public class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        int start = 0, end = nums.length - 1;
        while (start < end) {
            res += nums[end--] - nums[start++];
        }
        return res;
    }
}


// O(n), quick select
public class Solution {
    public int minMoves2(int[] nums) {
        int sum = 0;
        int mid = findKth(nums, nums.length / 2 + 1, 0, nums.length - 1);
        for (int num : nums) 
            sum += Math.abs(num - mid);
        return sum;
    }
    
    private int findKth(int[] arr, int k, int start, int end) {
        int l = start, r = end;
        int pivot = arr[end];
        while (l < r) {
            while (arr[l] < pivot && l < r) l++;
            while (arr[r] >= pivot && l < r) r--;
            swap(arr, l, r);
        }
        swap(arr, l, end);
        if (k == l + 1) return arr[l];
        else if (k > l + 1) return findKth(arr, k, l + 1, end);
        else return findKth(arr, k, start, l - 1);
    }
    
    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}