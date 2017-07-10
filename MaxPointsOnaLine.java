/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    public int maxPoints(Point[] points) {
        if (points == null || points.length == 0) return 0;

        Map<Double, Integer> map = new HashMap<>();
        int max = 0;

        for (int i = 0; i < points.length; i++) {
            int duplicate = 1;
            int vertical = 0;
            for (int j = i + 1; j < points.length; j++) {
                if (points[i].x == points[j].x) {
                    if (points[i].y == points[j].y) duplicate++;
                    else vertical++;
                } else {
                    double slope = (double)(points[j].y - points[i].y) / (double)(points[j].x - points[i].x);
                    map.put(slope, map.getOrDefault(slope, 0) + 1);
                }
            }

            for (Integer count : map.values()) {
                max = Math.max(max, count + duplicate);
            }
            
            max = Math.max(vertical + duplicate, max);
            map.clear();
        }

        return max;
    }
}