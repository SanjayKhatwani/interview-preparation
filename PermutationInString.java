public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() > s2.length()) return false;
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int begin = 0, end = 0;
        int counter = map.size();
        while (end < s2.length()) {
            char c = s2.charAt(end);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) counter--;
            }
            end++;
            while (counter == 0) {
                char t = s2.charAt(begin);
                if (map.containsKey(t)) {
                    map.put(t, map.get(t) + 1);
                    if (map.get(t) > 0) counter++;
                }
                if (counter > 0) {
                    if (end - begin == s1.length()) 
                        return true;
                }
                begin++;
            }
        }
        return false;
    }
}