public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s == null || p == null || s.length() < p.length()) return res;
        Map<Character, Integer> map = new HashMap<>();
        for (char c : p.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int head = 0, end = 0;
        int counter = map.size();
        while (end < s.length()) {
            char c = s.charAt(end);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) counter--;
            }
            end++;
            while (counter == 0) {
                char t = s.charAt(head);
                if (map.containsKey(t)) {
                    map.put(t, map.get(t) + 1);
                    if (map.get(t) > 0) counter++;
                }
                if (counter > 0) {
                    if (end - head == p.length())
                        res.add(head);
                }
                head++;
            }
        }
        return res;
    }
}