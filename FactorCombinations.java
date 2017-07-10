public class Solution {
    public List<List<Integer>> getFactors(int n) {
        
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tmp  = new ArrayList<>();
        dfs(result, tmp, n, 2);
        return result;
    }
    
    public void dfs(List<List<Integer>> result, List<Integer> tmp, int n, int start) {
        if (n == 1) {
            if (tmp.size() > 1) {
                result.add(new ArrayList<Integer>(tmp));
            }
            return;
        }
        
        for (int i = start; i <= n; i++) {
            if (n % i == 0) {
                tmp.add(i);
                dfs(result, tmp, n / i, i);
                tmp.remove(tmp.size() - 1);
            }
        }
    }
}