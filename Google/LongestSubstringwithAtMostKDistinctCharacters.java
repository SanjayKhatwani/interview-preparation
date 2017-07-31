public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int[] counts = new int[256];
        int count = 0;
        int maxLen = 0;
        int start = 0, end = 0;
        while (end < s.length()) {
            char c = s.charAt(end);
            if (++counts[c] == 1) count++;
            while (start < end && count > k) {
                char c2 = s.charAt(start);
                if (--counts[c2] == 0)
                    count--;
                start++;
            }
            if (count <= k) {
                maxLen = Math.max(maxLen, end - start + 1);
            }
            end++;
        }
        return maxLen;
    }
}