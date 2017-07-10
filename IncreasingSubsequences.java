/*
Given an integer array, your task is to find all the different possible increasing subsequences of the given array, and the length of an increasing subsequence should be at least 2 .

Example:
Input: [4, 6, 7, 7]
Output: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
*/

public class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, new ArrayList<Integer>(), nums, 0);
        return res;
    }
    
    private void helper(List<List<Integer>> res, List<Integer> list, int[] nums, int start) {
        if (list.size() > 1) {
            res.add(new ArrayList<Integer>(list));
        } 
        // we have to skip duplicates in each recursion, so we use a hash set to record what we have used in this particular recursion.
        Set<Integer> used = new HashSet<>();
        for (int i = start; i < nums.length; i++) {
            if (used.contains(nums[i])) continue;
            if (list.size() == 0 || nums[i] >= list.get(list.size() - 1)) {
                list.add(nums[i]);
                used.add(nums[i]);
                helper(res, list, nums, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }
}