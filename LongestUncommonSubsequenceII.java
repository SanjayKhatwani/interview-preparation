/*
Given a list of strings, you need to find the longest uncommon subsequence among them. The longest uncommon subsequence is defined as the longest subsequence of one of these strings and this subsequence should not be any subsequence of the other strings.

A subsequence is a sequence that can be derived from one sequence by deleting some characters without changing the order of the remaining elements. Trivially, any string is a subsequence of itself and an empty string is a subsequence of any string.

The input will be a list of strings, and the output needs to be the length of the longest uncommon subsequence. If the longest uncommon subsequence doesn't exist, return -1.

Example 1:
Input: "aba", "cdc", "eae"
Output: 3
*/


public int findLUSlength(String[] strs) {
    int len = strs.length;
    
    // reverse sorting array with length 
    Arrays.sort(strs, (a, b) -> b.length() - a.length());
    
    for (int i = 0; i < len; i++) {
        int missMatchCount = strs.length - 1;
        for (int j = 0; j < len; j++) {
            if (i != j && !isSubSequence(strs[i], strs[j])) {
                missMatchCount--;
            }
        }
        
        // strs[i] is not a sub sequence of any other entry
        if (missMatchCount == 0) {
            return strs[i].length();
        }
    }
    
    return -1;
}

// check if s1 is subsequence of s2
private boolean isSubSequence(String s1, String s2) {
    int idx = 0;
    for (char ch : s2.toCharArray()) {
        if (idx < s1.length() && ch == s1.charAt(idx)) {
            idx++;
        }
    }
    
    return idx == s1.length();
}