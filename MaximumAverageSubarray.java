public class Solution {
    /**
     * @param nums an array with positive and negative numbers
     * @param k an integer
     * @return the maximum average
     */
    public double maxAverage(int[] nums, int k) {
        double l = Integer.MAX_VALUE, r = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; ++i) {
            l = Math.min(l, nums[i]);
            r = Math.max(r, nums[i]);
        }      
        while (r - l >= 1e-6) {
            double mid = (l + r) / 2.0;
            if (checkValid(nums, mid, k)) l = mid;
            else r = mid;
        }
        return l;
    }
    
    private boolean checkValid(int nums[], double mid, int k) {
        int n = nums.length;
        double minPre = 0;
        double[] sum = new double[n + 1];
        sum[0] = 0; 
        for (int i = 1; i <= n; ++i) {
            sum[i] = sum[i - 1] + nums[i - 1] - mid;
            if (i >= k) {
                if (sum[i] - minPre >= 0) return true;
                minPre = Math.min(minPre, sum[i - k + 1]);
            }
        }
        return false;
    }
}