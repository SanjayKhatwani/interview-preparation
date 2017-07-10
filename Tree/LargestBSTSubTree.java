/*
Given a binary tree, find the largest subtree which is a Binary Search Tree (BST), 
where largest means subtree with largest number of nodes in it.
*/

public class Solution {
    int max = 0;

    public int largestBSTSubtree(TreeNode root) {
        helper(root);
        return max;
    }
    
    public int[] helper(TreeNode root) {
        if (root == null) 
            return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, 0};

        int[] lResult = helper(root.left);
        int[] rResult = helper(root.right);
        
        if (root.val <= lResult[1] || root.val >= rResult[0]) 
            return new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE, 0};
        
        int size = 1 + lResult[2] + rResult[2];
        
        max = Math.max(max, size);
        
        return new int[]{Math.min(lResult[0], root.val), Math.max(rResult[1], root.val), size};
    }
}