/*
There are a row of n houses, each house can be painted with one of the k colors. 
The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.
The cost of painting each house with a certain color is represented by a n x k cost matrix. 
For example, costs[0][0] is the cost of painting house 0 with color 0; costs[1][2] is the cost of painting house 1 with color 2, and so on... 
Find the minimum cost to paint all houses.

*/
public class Solution {
    public int minCostII(int[][] costs) {
        if (costs != null && costs.length == 0) return 0;

        int prevMin = 0, prevSecMin = 0, prevMinIdx = -1;
        
        for (int i = 0; i < costs.length; i++) {
            int currMin = Integer.MAX_VALUE, currSecMin = Integer.MAX_VALUE, currMinIdx = -1;
            for (int j = 0; j < costs[0].length; j++) {
                costs[i][j] += (prevMinIdx == j ? prevSecMin : prevMin);
                // 找出最小和次小的，最小的要记录下标，方便下一轮判断
                if (costs[i][j] < currMin) {
                    currSecMin = currMin;
                    currMin = costs[i][j];
                    currMinIdx = j;
                } else if (costs[i][j] < currSecMin) {
                    currSecMin = costs[i][j];
                }
            }
            prevMin = currMin;
            prevSecMin = currSecMin;
            prevMinIdx = currMinIdx;
        }
        return prevMin;
    }
}