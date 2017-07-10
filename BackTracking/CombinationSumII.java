public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        helper(res, new ArrayList<Integer>(), candidates, target, 0);
        return res;
    }
    
    private void helper(List<List<Integer>> res, List<Integer> list, int[] candidates, int rest, int offset) {
        if (rest < 0) return;
        if (rest == 0) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = offset; i < candidates.length; i++) {
            if (i > offset && candidates[i] == candidates[i-1]) continue;
            list.add(candidates[i]);
            helper(res, list, candidates, rest - candidates[i], i + 1);
            list.remove(list.size() - 1);
        }
    }
}