/*
Given a string S, you are allowed to convert it to a palindrome by adding characters in front of it. 
Find and return the shortest palindrome you can find by performing this transformation.

For example:

Given "aacecaaa", return "aaacecaaa".

Given "abcd", return "dcbabcd".
*/

public class Solution {
    public String shortestPalindrome(String s) {
        if (s == null || s.length() == 0)
            return "";
        if (s.length() <= 1)
            return s;
        int[] lsp = buildLsp(s + "#" + new StringBuilder(s).reverse().toString());
        return new StringBuilder(s.substring(lsp[2*s.length()])).reverse().toString() + s;
        
    }
    
    private int[] buildLsp(String s) {
        int[] lsp = new int[s.length()];
        lsp[0] = 0;
        for (int i = 1; i < lsp.length; i++) {
            int j = lsp[i - 1];
            while (j > 0 && s.charAt(j) != s.charAt(i)) {
                j = lsp[j - 1];
            }
            if (s.charAt(j) == s.charAt(i)) {
                lsp[i] = j + 1;
            } else {
                lsp[i] = 0;
            }
        }
        return lsp;
    }
}