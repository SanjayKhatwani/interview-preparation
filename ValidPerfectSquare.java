// 牛顿法

public class Solution {
    public boolean isPerfectSquare(int num) {
        long r = num;
        while (r*r > num)
            r = (r + num/r) / 2;
        return r*r == num;
    }
}

// 二分搜索法

public boolean isPerfectSquare(int num) {
    int low = 1, high = num;
    while (low <= high) {
        long mid = (low + high) >>> 1;
        if (mid * mid == num) {
            return true;
        } else if (mid * mid < num) {
            low = (int) mid + 1;
        } else {
            high = (int) mid - 1;
        }
    }
    return false;
}