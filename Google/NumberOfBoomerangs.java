''public class Solution {
    public int numberOfBoomerangs(int[][] points) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                if (j == i) continue;
                int dist = getDist(points[i], points[j]);
                map.put(dist, map.getOrDefault(dist, 0) + 1);
            }
            for (int val : map.values()) 
                count += val * (val - 1);
            map.clear();
        }
        return count;
    }
    
    private int getDist(int[] a, int[] b) {
        int m = a[0] - b[0];
        int n = a[1] - b[1];
        return m * m + n * n;
    }
}