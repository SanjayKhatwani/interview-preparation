public class Solution {
    /**
     * @param n n pairs
     * @return All combinations of well-formed parentheses
     */
    public List<String> generateParenthesis(int n) {
        // Write your code here
        List<String> res = new ArrayList<>();
        helper(res, "", 0, 0, n);
        return res;
    }
    
    private void helper(List<String> res, String prev, int left, int right, int limit) {
        if (left == limit && right == limit) {
            res.add(prev);
            return;
        } 
        if (left < limit) {
            helper(res, prev + "(", left + 1, right, limit);
        }
        if (right < limit && right < left) {
            helper(res, prev + ")", left, right + 1, limit);
        }
    }
}