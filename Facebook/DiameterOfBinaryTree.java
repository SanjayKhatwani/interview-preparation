public class Solution {

    int diameter = 0;
    
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return diameter;
    }
    
    private int depth(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);
        diameter = Math.max(diameter, leftDepth + rightDepth);
        return Math.max(leftDepth, rightDepth) + 1;
    }
    
}