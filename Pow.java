// Implement pow(x, n).

public class Solution {

    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (n < 0) return 1 / myPow(x, -n);
        double half = myPow(x, n / 2);
        return n % 2 == 0 ? half * half : half * half * x;
    }
    
}