public class Solution {
    public int subarraySum(int[] nums, int k) {
    	int count = 0;
    	Map<Integer, Integer> map = new HashMap<>();
    	map.put(0, 1);
    	
    	int sum = 0;
    	for (int num : nums) {
    		sum += num;
    		count += map.getOrDefault(sum - k, 0);
    		map.put(sum, map.getOrDefault(sum, 0) + 1);
    	}
    	return count;
    }
}