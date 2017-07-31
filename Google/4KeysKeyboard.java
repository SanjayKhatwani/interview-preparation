public class Solution {
    public int maxA(int N) {
        if (N <= 6) return N;
        
        int[] screen = new int[N];
        for (int i = 1; i <= 6; i++) 
            screen[i - 1] = i;

        for (int i = 7; i <= N; i++) {
            for (int b = i - 3; b >= 1; b--) {
                int curr = (i - b - 1) * screen[b - 1];
                screen[i - 1] = Math.max(screen[i - 1], curr);
            }
        }

        return screen[N - 1];
    }
}