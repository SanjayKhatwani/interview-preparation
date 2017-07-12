public class Solution {

    int max = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        singlePathSum(root);
        return max;
    }
    
    private int topDownPathSum(TreeNode root) {
        if (root == null) return 0;
        
        int left = Math.max(topDownPathSum(root.left), 0);
        int right = Math.max(topDownPathSum(root.right), 0);
        
        max = Math.max(max, left + root.val + right);
        
        return root.val + Math.max(left, right);
    }
}