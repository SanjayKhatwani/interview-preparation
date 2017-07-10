public class Solution {

    /**
     * @param heights: an array of integers
     * @return: a integer
     */

    public int trapRainWater(int[] heights) {

        int left = 0, right = heights.length - 1; 
        int res = 0;
        if (left >= right) return res;

        int leftheight = heights[left];
        int rightheight = heights[right];

        while (left < right) {
            if (leftheight < rightheight) {
                if (leftheight > heights[++left]) {
                    res += (leftheight - heights[left]);
                } else {
                    leftheight = heights[left];
                }
            } else {
                if (rightheight > heights[--right]) {
                    res += (rightheight - heights[right]);
                } else {
                    rightheight = heights[right];
                }
            }
        }

        return res;
    }

}      
