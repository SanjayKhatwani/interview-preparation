public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s == null || p == null || s.length() < p.length()) return res;
        int[] map = new int[26];
        for (char c : p.toCharArray())
            map[c - 'a']++;
        int counter = p.length();
        int i = 0, j = 0, head = 0;
        while (j < s.length()) {
            char c = s.charAt(j);
            map[c - 'a']--;
            if (map[c - 'a'] >= 0) counter--;
            j++;
            while (counter == 0) {
                char ch = s.charAt(i);
                map[ch - 'a']++;
                if (map[ch - 'a'] > 0) {
                    counter++;
                    if (j - i == p.length())
                        res.add(i);
                }
                i++;
            }
        }
        return res;
    }
}