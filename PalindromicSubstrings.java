public class Solution {
    int count = 0;
    public int countSubstrings(String s) {
        count = 0;
        for (int i = 0; i < s.length(); i++) {
            checkPalindrome(s, i, i);
            checkPalindrome(s, i, i + 1);
        }
        return count;
    }
    
    private void checkPalindrome(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            count++;
            i--;
            j++;
        }
    }
}