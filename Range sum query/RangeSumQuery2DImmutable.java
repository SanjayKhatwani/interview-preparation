public class NumMatrix {

    int[][] sums;

    public NumMatrix(int[][] matrix) {
    	int m = matrix.length;
    	int n = m > 0 ? matrix[0].length : 0;
    	sums = new int[m + 1][n + 1];
    	for (int i = 0; i < m; i++) {
    	 	for (int j = 0; j < n; j++) {
    	 		sums[i + 1][j + 1] = matrix[i][j] + sums[i][j + 1] + sums[i + 1][j] - sums[i][j];
    	 	}
    	 }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sums[row2 + 1][col2 + 1] + sums[row1][col1] - sums[row2 + 1][col1] - sums[row1][col2 + 1];
    }
}