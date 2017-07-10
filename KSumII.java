public class Solution {
    /**
     * @param A: an integer array.
     * @param k: a positive integer (k <= length(A))
     * @param target: a integer
     * @return a list of lists of integer 
     */ 
    public List<List<Integer>> kSumII(int[] A, int k, int target) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        if (A.length == 0) return res;
        dfs(res, new ArrayList<Integer>(), A, k, target, 0);
        return res;
    }
    
    private void dfs(List<List<Integer>> res, List<Integer> list, int[] A, int k, int left, int pos) {
        if (left == 0 && list.size() == k) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        if (list.size() > k || pos == A.length) {
            return;
        }
        for (int i = pos; i < A.length; i++) {
            list.add(A[i]);
            dfs(res, list, A, k, left - A[i], i + 1);
            list.remove(list.size() - 1);
        }
    }
}