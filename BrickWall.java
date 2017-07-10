public class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer,Integer> map = new HashMap<>();
        int sum = 0;
        for (List<Integer> list : wall) {
            sum = 0; // reset sum for each row
            for (int a : list) {
                sum += a;
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        map.put(sum, 0);
        int max = 0;
        for (int val : map.values()) {
            max = Math.max(max, val);
        }
        return wall.size() - max;
    }
}