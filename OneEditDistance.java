public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if (s.length() < t.length()) 
            return isOneEditDistance(t, s);
        int i = 0;
        for (; i < t.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                String ss = s.substring(i + 1);
                return ss.equals(t.substring(i + 1)) || ss.equals(t.substring(i));
            }
        }
        return i == s.length() - 1;
    }
}