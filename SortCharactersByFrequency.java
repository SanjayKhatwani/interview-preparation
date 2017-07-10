public class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        List<Character>[] buckets = new List[s.length() + 1];
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            char c = entry.getKey();
            int val = entry.getValue();
            if (buckets[val] == null)
                buckets[val] = new LinkedList<>();
            buckets[val].add(c);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = buckets.length - 1; i > 0; i--) {
            if (buckets[i] != null && buckets[i].size() > 0) {
                for (char c : buckets[i])
                    for (int j = 0; j < i; j++)
                        sb.append(c);
            }
        }
        return sb.toString();
    }
}