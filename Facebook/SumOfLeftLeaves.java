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


// Iterative
public int sumOfLeftLeaves(TreeNode root) {
    if (root == null) return 0;
    int ans = 0;
    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);
    
    while (!stack.empty()) {
        TreeNode node = stack.pop();
        if (node.left != null) {
            if (node.left.left == null && node.left.right == null)
                ans += node.left.val;
            else
                stack.push(node.left);
        }
        if (node.right != null) {
            if (node.right.left != null || node.right.right != null)
                stack.push(node.right);
        }
    }
    
    return ans;
}