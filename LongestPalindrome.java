public class Solution {
    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0) 
            return 0;
        Set<Character> hs = new HashSet<>();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (hs.contains(s.charAt(i))) {
                hs.remove(s.charAt(i));
                count++;
            } else {
                hs.add(s.charAt(i));
            }
        }
        return count * 2 + (hs.isEmpty() ? 0 : 1); 
    }
}