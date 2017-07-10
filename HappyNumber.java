public class Solution {
    public boolean isHappy(int n) {
        int slow = n, fast = n;
        do {
            slow = sum(slow);
            fast = sum(sum(fast));
        } while (slow != fast);
        return slow == 1;
    }
    
    private int sum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += (num % 10) * (num % 10);
            num /= 10;
        }
        return sum;
    }
}