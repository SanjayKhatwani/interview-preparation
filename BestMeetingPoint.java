/*
为了保证总长度最小，我们只要保证每条路径尽量不要重复就行了，
比如1->2->3<-4这种一维的情况，如果起点是1，2和4，那2->3和1->2->3这两条路径就有重复了。
为了尽量保证右边的点向左走，左边的点向右走，那我们就应该去这些点中间的点作为交点。
由于是曼哈顿距离，我们可以分开计算横坐标和纵坐标，结果是一样的。
所以我们算出各个横坐标到中点横坐标的距离，加上各个纵坐标到中点纵坐标的距离，就是结果了。
*/

public class Solution {
    public int minTotalDistance(int[][] grid) {
        List<Integer> xlist = new ArrayList<>();
        List<Integer> ylist = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) 
                    xlist.add(i);
            }
        }
        for (int j = 0; j < grid[0].length; j++) {
            for (int i = 0; i < grid.length; i++) {
                if (grid[i][j] == 1)
                    ylist.add(j);
            }
        }
        return getMin(xlist) + getMin(ylist);
    }
    
    private int getMin(List<Integer> list) {
        int res = 0;
        int start = 0; 
        int end = list.size() - 1;
        while (start < end)
            res += list.get(end--) - list.get(start++);
        return res;
    }
}