public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() > s2.length()) return false;
        int[] map = new int[26];
        for (char c : s1.toCharArray()) 
            map[c - 'a']++;
        int counter = s1.length();
        int i = 0, j = 0;
        while (j < s2.length()) {
            char c = s2.charAt(j++);
            map[c - 'a']--;
            if (map[c - 'a'] >= 0) counter--;
            while (counter == 0) {
                char ch = s2.charAt(i);
                map[ch - 'a']++;
                if (map[ch - 'a'] > 0) {
                    counter++;
                    if (j - i == s1.length())
                        return true;
                }
                i++;
            }
        }
        return false;
    }
}