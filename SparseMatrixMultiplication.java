public class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int m = A.length, n = B.length, l = B[0].length;
        int[][] res = new int[m][l];
        if (m == 0 || n == 0) return res;
        
        for (int i = 0; i < m; i++) {
            for (int k = 0; k < n; k++) {
                if (A[i][k] != 0) {
                    for (int j = 0; j < l; j++) {
                        res[i][j] += A[i][k] * B[k][j];
                    }
                }
            }
        }
        return res;
    }
}