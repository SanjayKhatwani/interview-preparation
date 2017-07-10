public class Solution {

    public static final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

	public int longestIncreasingPath(int[][] matrix) {
	    if (matrix.length == 0 || matrix[0].length == 0) 
	    	return 0;
	    int m = matrix.length, n = matrix[0].length;
	    // Longest increasing path starting at point (m, n)
	    int[][] cache = new int[m][n];
	    int max = 1;
	    for (int i = 0; i < m; i++) {
	        for (int j = 0; j < n; j++) {
	            int len = dfs(matrix, i, j, cache, Integer.MIN_VALUE);
	            max = Math.max(max, len);
	        }
	    }   
	    return max;
	}

	public int dfs(int[][] matrix, int i, int j, int[][] cache, int baseValue) {
		if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || matrix[i][j] <= baseValue)
			return 0;
	    if (cache[i][j] != 0) 
	    	return cache[i][j];
	    int max = 1;
	    for (int[] dir : dirs) {
	        int x = i + dir[0], y = j + dir[1];
	        int len = 1 + dfs(matrix, x, y, cache, matrix[i][j]);
	        max = Math.max(max, len);
	    }
	    cache[i][j] = max;
	    return max;
	}

}