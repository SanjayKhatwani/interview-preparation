class Solution {
    /**
     * @param n an integer
     * @return the nth prime number as description.
     */
    public int nthUglyNumber(int n) {
        int[] uglys = new int[n];
        uglys[0] = 1;
        
        int p2 = 0, p3 = 0, p5 = 0;
        // p2, p3 & p5 share the same queue: uglys

        for (int i = 1; i < n; i++) {
            int lastNumber = uglys[i - 1];
            while (uglys[p2] * 2 <= lastNumber) p2++;
            while (uglys[p3] * 3 <= lastNumber) p3++;
            while (uglys[p5] * 5 <= lastNumber) p5++;
            
            uglys[i] = Math.min(Math.min(uglys[p2] * 2, uglys[p3] * 3), uglys[p5] * 5);
        }

        return uglys[n - 1];
    }
};
