public class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> sumToIndex = new HashMap<>();
        sumToIndex.put(0, -1);
        int sum = 0, max = 0;
        
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int diff = 2 * sum - i - 1;
            if (sumToIndex.containsKey(diff)) {
                max = Math.max(max, i - sumToIndex.get(diff));
            } else {
                sumToIndex.put(diff, i);
            }
        }
        
        return max;
    }
}