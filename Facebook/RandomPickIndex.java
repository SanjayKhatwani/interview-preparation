/*
int[] nums = new int[] {1,2,3,3,3};
Solution solution = new Solution(nums);

pick(3) should return either index 2, 3, or 4 randomly. Each index should have equal probability of returning.
pick(1) should return 0. Since in the array only nums[0] is equal to 1.
*/

public class Solution {

    int[] nums;
    Random rand;
    
    public Solution(int[] nums) {
        this.nums = nums;
        this.rand = new Random();
    }
    
    public int pick(int target) {
        int count = 0;
        int res = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                count++;
                if (rand.nextInt(count) == 0)
                    res = i;
            }
        }
        return res;        
    }

}