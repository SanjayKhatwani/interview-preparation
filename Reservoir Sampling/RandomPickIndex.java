public class Solution {

    int[] nums;
    Random rand;

    public Solution(int[] nums) {
        this.nums = nums;
        this.rand = new Random();
    }
    
    public int pick(int target) {
        int idx = -1;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                idx = (rand.nextInt(++count) == 0 ? i : idx);
            }
        }
        
        return idx;
    }
}
