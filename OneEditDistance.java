public class Solution {
    /**
     * @param s a string
     * @param t a string
     * @return true if they are both one edit distance apart or false
     */
    public boolean isOneEditDistance(String s, String t) {
        if (t.length() < s.length()) 
            return isOneEditDistance(t, s);

        int i;
        for (i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (s.length() == t.length()) 
                    return s.substring(i+1).equals(t.substring(i+1));
                else 
                    return s.substring(i+1).equals(t.substring(i+2));
            }
        }
        return i == t.length() - 1;
    }
}