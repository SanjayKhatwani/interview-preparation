public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(res, root, 0);
        return res;
    }
    
    private void helper(List<Integer> list, TreeNode root, int level) {
        if (root == null) return;
        if (level == list.size()) list.add(root.val);
        helper(list, root.right, level + 1);
        helper(list, root.left, level + 1);
    }
}