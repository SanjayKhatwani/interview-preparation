class Solution {
    /**
     * @param A: sorted integer array A which has m elements, 
     *           but size of A is m+n
     * @param B: sorted integer array B which has n elements
     * @return: void
     */
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        // write your code here
        for (int i = m - 1, j = n - 1; i >= 0 || j >= 0; ) {
            if (i >= 0 && j >= 0) {
                if (A[i] > B[j]) {
                    A[i + j + 1] = A[i];
                    i--;
                } else {
                    A[i + j + 1] = B[j];
                    j--;
                }
            } else if (j >= 0) {
                A[j] = B[j--];
            } else {
                return;
            }
        }
    }
}