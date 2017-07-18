public class Solution {

    public String minWindow(String s, String t) {
        int[] map = new int[256];
        for (char c : t.toCharArray()) 
            map[c]++;
        int counter = t.length();
        int i = 0, j = 0, head = 0, minlen = Integer.MAX_VALUE;
        while (j < s.length()) {
            char c = s.charAt(j);
            map[c]--;
            if (map[c] >= 0) counter--;
            j++;
            while (counter == 0) {
                char ch = s.charAt(i);
                map[ch]++;
                if (map[ch] > 0) {
                    counter++;
                    if (j - i < minlen) {
                        minlen = j - i;
                        head = i;
                    }
                }
                i++;
            }
        }
        return minlen == Integer.MAX_VALUE ? "" : s.substring(head, head + minlen);
    }
    
}