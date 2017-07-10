public class WordDistanceII {
    
    private Map<String, List<Integer>> map;

    public WordDistance(String[] words) {
        map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            String w = words[i];
            if (! map.containsKey(w)) {
                map.put(w, new ArrayList<Integer>());
            }
            map.get(w).add(i);
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);
        int ret = Integer.MAX_VALUE;
        for (int i = 0, j = 0; i < list1.size() && j < list2.size(); ) {
            int index1 = list1.get(i), index2 = list2.get(j);
            ret = Math.min(ret, Math.abs(index1 - index2));
            if (index1 < index2) i++;
            else j++;
        }
        return ret;
    }
}