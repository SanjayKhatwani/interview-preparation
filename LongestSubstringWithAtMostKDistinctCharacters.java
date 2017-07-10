public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int maxLen = 0;
        int start = 0, end = 0;
        while (end < s.length()) {
            char c = s.charAt(end);
            map.put(c, map.getOrDefault(c, 0) + 1);
            while (start < end && map.size() > k) {
                char c2 = s.charAt(start);
                map.put(c2, map.get(c2) - 1);
                if (map.get(c2) == 0)
                    map.remove(c2);
                start++;
            }
            if (map.size() <= k) {
                maxLen = Math.max(maxLen, end - start + 1);
            }
            end++;
        }
        return maxLen;
    }
}