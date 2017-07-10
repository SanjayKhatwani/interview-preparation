public class Solution {

    public String minWindow(String s, String t) {

        if (t.length() > s.length()) 
            return "";

        String result = "";
     
        //character counter for t
        Map<Character, Integer> target = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            target.put(c, target.getOrDefault(c, 0) + 1);
        }
     
        // character counter for s
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int minLen = s.length() + 1;
        int count = 0; // the total of mapped characters
     
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (target.containsKey(c)) {
                if (map.getOrDefault(c, 0) < target.get(c)) {
                    count++;
                }
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
     
            if (count == t.length()) {
                char sc = s.charAt(left);
                while (!map.containsKey(sc) || map.get(sc) > target.get(sc)) {
                    if (map.containsKey(sc) && map.get(sc) > target.get(sc)) {
                        map.put(sc, map.get(sc) - 1);
                    }
                    sc = s.charAt(++left);
                }
     
                if (i - left + 1 < minLen) {
                    result = s.substring(left, i + 1);
                    minLen = i - left + 1;
                }
            }
        }
     
        return result;
    }

}