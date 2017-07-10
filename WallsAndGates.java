
public class Solution {
    private static int[][] pairs = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    
    public void wallsAndGates(int[][] rooms) {
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0)
                    dfs(rooms, i, j, 0);
            }
        }
    }
    
    private void dfs(int[][] rooms, int i, int j, int dist) {
        if (i < 0 || i >= rooms.length || j < 0 || j >= rooms[0].length || rooms[i][j] < dist)
            return;
        rooms[i][j] = dist;
        for (int[] pair : pairs) {
            dfs(rooms, i + pair[0], j + pair[1], dist + 1);
        }
    }
}