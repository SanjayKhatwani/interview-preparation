public class Solution {

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        int len = 0;
        for (String word : words) 
            len += word.length();
        if (s == null || s.length() < len) 
            return res;
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        int wl = words[0].length();
        
        for (int i = 0; i < wl; i++) {
            Map<String, Integer> curMap = new HashMap<>(map); // copy the original map
            int head = i, end = i;
            int counter = map.size();
            while (end <= s.length() - wl) {
                String curr = s.substring(end, end + wl);
                if (curMap.containsKey(curr)) {
                    curMap.put(curr, curMap.get(curr) - 1);
                    if (curMap.get(curr) == 0) counter--;
                }
                end += wl;
                while (counter == 0) {
                    String str = s.substring(head, head + wl);
                    if (curMap.containsKey(str)) {
                        curMap.put(str, curMap.get(str) + 1);
                        if (curMap.get(str) > 0) counter++;
                    }
                    if (counter > 0 && end - head == len) {
                        res.add(head);
                    }
                    head += wl;
                }
            }
        }
        return res;
    }

}