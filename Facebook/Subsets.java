// nums contains duplicates
public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        dfs(res, new ArrayList<>(), nums, 0);
        return res;
    }
    private void dfs(List<List<Integer>> res, List<Integer> list, int[] nums, int offset) {
        res.add(new ArrayList<>(list));
        for (int i = offset; i < nums.length; i++) {
            if (i > offset && nums[i] == nums[i - 1]) continue;
            list.add(nums[i]);
            dfs(res, list, nums, i + 1);
            list.remove(list.size() - 1);
        }
    }
}