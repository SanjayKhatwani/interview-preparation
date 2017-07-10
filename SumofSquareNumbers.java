public class Solution {
    public boolean judgeSquareSum(int c) {
        if (c < 0) {
            return false;
        }
        int l = 0, r = (int) Math.sqrt(c) ;
        while (l <= r) {
            int cur = l * l + r * r;
            if (cur < c) {
                l++;
            } else if (cur > c) {
                r--;
            } else {
                return true;
            }
        }
        return false;
    }
}