public class Solution {
    public boolean isMatch(String str, String pattern) {
        int i = 0, j = 0, match = 0, starIdx = -1;
        int m = str.length(), n = pattern.length();
        while (i < m) {
            // advancing both pointers
            if (j < n  && (pattern.charAt(j) == '?' || str.charAt(i) == pattern.charAt(j))) {
                i++;
                j++;
            }
            // * found, only advancing pattern pointer
            else if (j < n && pattern.charAt(j) == '*') {
                starIdx = j;
                match = i;
                j++;
            }
           // last pattern pointer was *, advancing string pointer
            else if (starIdx != -1) {
                j = starIdx + 1;
                i = ++match;
            }
           //current pattern pointer is not star, last patter pointer was not *
           //characters do not match
            else return false;
        }
        
        //check for remaining characters in pattern
        while (j < n && pattern.charAt(j) == '*')
            j++;
        
        return j == n;
    }
}