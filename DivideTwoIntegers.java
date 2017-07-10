public class Solution {
    public int divide(int dividend, int divisor) {
        if (divisor == 0) 
            return dividend >= 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        
        if (dividend == 0)
            return 0;
        
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;
        
        boolean isNegative = (dividend < 0 && divisor > 0) || 
                             (dividend > 0 && divisor < 0);
                             
        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);
        int result = 0;
        while (a >= b) {
            int shift = 0;
            while (a >= (b << shift)) {
                shift++;
            }
            shift--;
            a -= (b << shift);
            result += (1 << shift);
        }
        return isNegative? -result: result;

    }
}