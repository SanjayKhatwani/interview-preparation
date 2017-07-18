/*
Given a string S, you are allowed to convert it to a palindrome by adding characters in front of it. 
Find and return the shortest palindrome you can find by performing this transformation.

For example:

Given "aacecaaa", return "aaacecaaa".

Given "abcd", return "dcbabcd".
*/

public class Solution {
    public String shortestPalindrome(String s) {
        String str = s + "#" + new StringBuilder(s).reverse().toString();
        int[] next = nextTable(str);
        return new StringBuilder(s.substring(next[next.length - 1])).reverse() + s;
    }
    
    private int[] nextTable(String s) {
        int[] next = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            int index = next[i - 1];
            while (index > 0 && s.charAt(index) != s.charAt(i)) 
                index = next[index - 1];
            next[i] = s.charAt(i) == s.charAt(index) ? index + 1 : 0;
        }
        return next;
    }
}