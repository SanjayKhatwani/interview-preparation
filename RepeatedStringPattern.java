public class Solution {
    public boolean repeatedSubstringPattern(String s) {
        if (s == null || s.length() == 0) return false;
        int[] next = getNext(s);
        int l = s.length();
        return next[l - 1] != 0 && l % (l - next[l - 1]) == 0;
    }
    
    private int[] getNext(String s) {
        int[] next = new int[s.length()];

        for (int i = 1; i < s.length(); i++) {
            int index = next[i - 1];
            while (index > 0 && s.charAt(index) != s.charAt(i)) {
                index = next[index - 1];
            }
            if (s.charAt(index) == s.charAt(i)) {
                next[i] = index + 1;
            } else {
                next[i] = 0;
            }
        }

        return next;
    }
}