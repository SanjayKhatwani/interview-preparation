public class Solution {
    public int trailingZeroes(int n) {
        if (n < 5) return 0;
        int count = 0;
        for (int i = 5; i <= n; i += 5) {
            count += numOfFive(i);
        }
        return count;
    }
    
    private int numOfFive(int n) {
        int num = 0;
        if (n % 5 != 0) return 0;
        while (n > 0 && n % 5 == 0) {
            num++;
            n /= 5;
        }
        return num;
    }
    
}