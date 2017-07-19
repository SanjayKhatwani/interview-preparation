public class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        int longest = 1;
        for (int num : nums) {
            if (map.containsKey(num))
                continue;
            int leftLen = map.getOrDefault(num - 1, 0);
            int rightLen = map.getOrDefault(num + 1, 0);
            int currLen = leftLen + rightLen + 1;
            map.put(num, currLen);
            map.put(num - leftLen, currLen);
            map.put(num + rightLen, currLen);
            
            longest = Math.max(longest, currLen);
        }
        return longest;
    }
}