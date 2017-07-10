public class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) 
            return 0;
        int diameter = maxDepth(root.left) + maxDepth(root.right);
        return Math.max(diameter, Math.max(diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right)));
    }
    
    private int maxDepth(TreeNode root) {
        if (root == null) 
            return 0;
        int leftdepth = maxDepth(root.left);
        int rightdepth = maxDepth(root.right);
        return 1 + Math.max(leftdepth, rightdepth);
    }
}