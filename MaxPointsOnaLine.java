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
        if (points.length <= 1)
            return points.length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < points.length; i++) {
            Point cur = points[i];
            Map<String, Integer> map = new HashMap<>();
            int dup = 1, localMax = 0;
            for (int j = i + 1; j < points.length; j++) {
                    Point iter = points[j];
                    if (iter.x == cur.x && iter.y == cur.y) {
                        dup++;
                    } else {
                        String key = getSlopeInString(cur, iter);
                        map.put(key, map.getOrDefault(key, 0) + 1);
                        localMax = Math.max(localMax, map.get(key));
                    }
            }
            max = Math.max(max, localMax + dup);
            map.clear();
        }
        return max;
    }

    public String getSlopeInString(Point cur, Point iter) {
        int numerator = iter.y - cur.y;
        int denominator = iter.x - cur.x;
        String sign = getSign(numerator, denominator);
        int gcd = gcd(Math.abs(numerator), Math.abs(denominator));
        return sign + Math.abs(numerator)/gcd + "/" + Math.abs(denominator)/gcd;
    }
    
    public int gcd(int a, int b) {
        if (b == 0)
            return a;
        else
            return gcd(b, a % b);
    }

    public String getSign(int a, int b) {
        if (a <= 0 && b <= 0 || a >= 0 && b >= 0)
            return "+";
        else 
            return "-";
    }
}