public class Solution {
    /**
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    public void flatten(TreeNode root) {
        // write your code here
        toList(root);
    }
    
    private TreeNode toList(TreeNode root) {
        if (root == null) return root;
        TreeNode leftList = toList(root.left);
        TreeNode rightList = toList(root.right);
        root.left = null;
        root.right = leftList;
        TreeNode p = root;
        while (p.right != null) p = p.right;
        p.right = rightList;
        return root;
    }
}