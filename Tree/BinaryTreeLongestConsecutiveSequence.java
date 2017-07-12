public class Solution {

    public int longestConsecutive(TreeNode root) {
        if (root == null) return 0;
        return Math.max(dfs(root.left, root.val, 1), dfs(root.right, root.val, 1));
    }

    private int dfs(TreeNode root, int parentVal, int count) {
        if (root == null) return count;
        count = (root.val == parentVal + 1) ? count + 1 : 1;
        int left = dfs(root.left, root.val, count);
        int right = dfs(root.right, root.val, count);
        return Math.max(count, Math.max(left, right));
    }
    
}