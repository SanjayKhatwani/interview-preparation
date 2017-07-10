/*
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.
*/

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int col = matrix[0].length - 1;
        int row = 0;
        // Check the last element of each line
        while (col >= 0 && row <= matrix.length - 1) {
            if (matrix[row][col] < target) {
                row++;
            } else if (matrix[row][col] > target) {
                col--;
            } else {
            	return true;
            }
        }
        return false;
    }
}


// return count of apperance
// from left bottom to top right

public class Solution {
    /**
     * @param matrix: A list of lists of integers
     * @param: A number you want to search in the matrix
     * @return: An integer indicate the occurrence of target in the given matrix
     */
    public int searchMatrix(int[][] matrix, int target) {
        // write your code here
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int row = m - 1, col = 0;
        int count = 0;
        while (row >= 0 && col < n) {
            if (matrix[row][col] > target) 
                row--;
            else if (matrix[row][col] < target) 
                col++;
            else {
                count++;
                row--;
                col++;
            };
        }
        return count;
    }
}