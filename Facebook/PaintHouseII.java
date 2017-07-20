public class Solution {

    public int minCostII(int[][] costs) {
        if (costs.length == 0 || costs[0].length == 0) return 0;
        int n = costs.length;
        int m = costs[0].length;
        
        int preMin = 0;
        int preIdx = -1;
        int preSec = 0;
        
        for (int i = 0; i < n; i++) {
            int currMin = Integer.MAX_VALUE;
            int currIdx = -1;
            int currSec = Integer.MAX_VALUE;
            int cost = 0;
            for (int j = 0; j < m; j++) {
                cost = costs[i][j] + (j == preIdx ? preSec : preMin);
                if (cost < currMin) {
                    currSec = currMin;
                    currMin = cost;
                    currIdx = j;
                } else if (cost < currSec) {
                    currSec = cost;
                }
            }
            preMin = currMin;
            preIdx = currIdx;
            preSec = currSec;
        }
        return preMin;
    }
}