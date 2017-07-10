public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length < 2 || k < 0 || t < 0)
            return false;
     
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            long curr = (long) nums[i];
     
            long leftBoundary = (long) curr - t;
            long rightBoundary = (long) curr + t + 1; //right boundary is exclusive, so +1
            Set<Long> sub = set.subSet(leftBoundary, rightBoundary);
            if (sub.size() > 0)
                return true;
     
            set.add(curr);   
     
            if (set.size() > k) {
                set.remove((long) nums[i-k]);
            }
        }
     
        return false;
    }
}