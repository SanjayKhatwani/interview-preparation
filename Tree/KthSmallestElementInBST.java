public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        int count = countNodes(root.left);
        if (count >= k) {
            return kthSmallest(root.left, k);
        } else if (count < k - 1) {
            return kthSmallest(root.right, k - 1 - count);
        }
        
        return root.val;
    }
    
    public int countNodes(TreeNode n) {
        if (n == null) return 0;
        return 1 + countNodes(n.left) + countNodes(n.right);
    }
}