public class Solution {
    
    public int sumOfLeftLeaves(TreeNode root) {
        int sum = 0;
        if (root == null) return sum;
        if (root.left != null) {
            if (isLeaf(root.left)) {
                sum += root.left.val;
            } else {
                sum = sum + sumOfLeftLeaves(root.left);
            }
        }
        return sum + sumOfLeftLeaves(root.right);
        
    }
    
    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }
    
}