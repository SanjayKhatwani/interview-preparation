/*
It is easy to know that at grid P, since " at any point his health point drops to 0 or below, he dies immediately", 
the remaining health value should be at least 1, that is, initialHealth + dungeon >= 1, we have initialHealth = max(1, 1 - dungeon[i][j]). 
(Notice, at any grid, the initial health should be at least 1 (for example, test case [1,0,0] require initial health 1 even though it has positive remaining health at grid[0][1] and grid[0][2])
Similarly, to satisfy the initial health of dungeon[i][j], the initial health of dungeon[i-1][j] (or dungeon[i][j-1]) should be at least initialHealth[i-1][j] + dungeon[i-1][j] = initialHealth[i][j], 
that is, initialHealth[i][j] = initialHealth[i][j] - dungeon[i-1][j].
In addition, if grid[i][j] can go both grid[i+1][j] and grid[i][j+1] to P, we should choose a path with less initial health between grid[i+1][j] and grid[i][j+1] since it require less initial health of grid[i][j].
We can simply code the solution by having the dynamic programming equations.
*/

public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
		if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) return 0;
	    
	    int m = dungeon.length;
	    int n = dungeon[0].length;
	    
	    int[][] health = new int[m][n];

	    health[m - 1][n - 1] = Math.max(1 - dungeon[m - 1][n - 1], 1);

	    for (int i = m - 2; i >= 0; i--) {            
	        health[i][n - 1] = Math.max(health[i + 1][n - 1] - dungeon[i][n - 1], 1);
	    }

	    for (int j = n - 2; j >= 0; j--) {
	        health[m - 1][j] = Math.max(health[m - 1][j + 1] - dungeon[m - 1][j], 1);
	    }

	    for (int i = m - 2; i >= 0; i--) {
	        for (int j = n - 2; j >= 0; j--) {
	            int down = Math.max(health[i + 1][j] - dungeon[i][j], 1);
	            int right = Math.max(health[i][j + 1] - dungeon[i][j], 1);
	            health[i][j] = Math.min(right, down);
	        }
	    }

	    return health[0][0];
    }
}