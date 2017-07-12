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
            if (map[c] >= 0) {
                counter--;
            }
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


public class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || t.length() > s.length()) return "";
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int counter = map.size();
        int begin = 0, end = 0;
        int head = 0;
        int len = Integer.MAX_VALUE;
        while (end < s.length()) {
            char c = s.charAt(end);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) counter--;
            }
            end++;
            while (counter == 0) {
                char c2 = s.charAt(begin);
                if (map.containsKey(c2)) {
                    map.put(c2, map.get(c2) + 1);
                    if (map.get(c2) > 0) 
                        counter++;
                    if (end - begin < len) {
                        len = end - begin;
                        head = begin;
                    }
                }
                begin++;
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(head, head + len);
    }
}