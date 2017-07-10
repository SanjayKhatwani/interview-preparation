public class Solution {

    public int numberOfPatterns(int m, int n) {
        int[][] pass = new int[10][10];
        pass[1][3] = pass[3][1] = 2;
        pass[1][7] = pass[7][1] = 4;
        pass[3][9] = pass[9][3] = 6;
        pass[7][9] = pass[9][7] = 8;
        pass[1][9] = pass[9][1] = pass[3][7] = pass[7][3] = pass[2][8] = pass[8][2] = pass[4][6] = pass[6][4] = 5;
        
        boolean[] visited = new boolean[10];
        
        int num = 0;
        for (int i = m; i <= n; i++) {
            num += dfs(pass, visited, 1, i-1) * 4;
            num += dfs(pass, visited, 2, i-1) * 4;
            num += dfs(pass, visited, 5, i-1);
        }
        
        return num;
    }
    
    private int dfs(int[][] pass, boolean[] visited, int start, int left) {
        if (left == 0) {
            return 1;
        }
        visited[start] = true;
        int total = 0;
        for (int i = 1; i <= 9; i++) {
            if (!visited[i] && (pass[start][i] == 0 || visited[pass[start][i]])) {
                total += dfs(pass, visited, i, left - 1);
            }
        }
        visited[start] = false;
        return total;
    }
    
}