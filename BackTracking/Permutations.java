public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];
        List<List<Integer>> res = new ArrayList<>();
        helper(nums, res, new ArrayList<Integer>(), used);
        return res;
    }
    
    private void helper(int[] nums, List<List<Integer>> res, List<Integer> list, boolean[] used) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                list.add(nums[i]);
                used[i] = true;
                helper(nums, res, list, used);
                list.remove(list.size()-1);
                used[i] = false;
            }
        }
    }
}