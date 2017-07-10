/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int rob(TreeNode root) {
        int[] res = helper(root);
        return Math.max(res[0], res[1]);
    }

    private int[] helper(TreeNode root) {
    	if (root == null) return new int[2];
    	int[] res = new int[2];
    	int[] leftRes = helper(root.left);
    	int[] rightRes = helper(root.right);
    	res[0] = root.val + leftRes[1] + rightRes[1];
    	res[1] = Math.max(leftRes[0], leftRes[1]) + Math.max(rightRes[0], rightRes[1]);
    	return res;
    }
}