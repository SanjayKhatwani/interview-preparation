/*
Given a string and a string dictionary, find the longest string in the dictionary that can be formed by deleting some characters of the given string. If there are more than one possible results, return the longest word with the smallest lexicographical order. If there is no possible result, return the empty string.

Example 1:
Input:
s = "abpcplea", d = ["ale","apple","monkey","plea"]

Output: 
"apple"
Example 2:
Input:
s = "abpcplea", d = ["a","b","c"]

Output: 
"a"
*/

public class Solution {
    public String findLongestWord(String s, List<String> d) {
        String longest = "";
        for (String word : d) {
            int i = 0;
            for (char c : s.toCharArray()) {
                if (i < word.length() && c == word.charAt(i))
                    i++;
            }
            if (i == word.length()) {
                if (i > longest.length() || (i == longest.length() && word.compareTo(longest) < 0))
                    longest = word;
            }
        }
        return longest;
    }
}