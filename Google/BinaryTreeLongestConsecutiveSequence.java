// Must be from parent to child
public class Solution {
    public int longestConsecutive(TreeNode root) {
        if (root == null) return 0;
        return Math.max(helper(root.left, root.val, 1), helper(root.right, root.val, 1));
    }
    
    private int helper(TreeNode root, int preVal, int pathLen) {
        if (root == null) return pathLen;
        pathLen = (root.val == preVal + 1) ? pathLen + 1 : 1;
        int left = helper(root.left, root.val, pathLen);
        int right = helper(root.right, root.val, pathLen);
        return Math.max(pathLen, Math.max(left, right));
    }
}

// Can be from child to parent to child

/*
This solution is very simple. With every node, we associate two values/variables named inrinr and dcrdcr, 
where incrincr represents the length of the longest incrementing branch below the current node including itself, 
and dcrdcr represents the length of the longest decrementing branch below the current node including itself.

We make use of a recursive function longestPath(node) which returns an array of the form [inr, dcr][inr,dcr] for the calling node. 
We start off by assigning both inrinr and dcrdcr as 1 for the current node. 
This is because the node itself always forms a consecutive increasing as well as decreasing path of length 1.

Then, we obtain the length of the longest path for the left child of the current node using longestPath[root.left]. 
Now, if the left child is just smaller than the current node, it forms a decreasing sequence with the current node. 
Thus, the dcrdcr value for the current node is stored as the left child's dcrdcr value + 1. 
But, if the left child is just larger than the current node, it forms an incrementing sequence with the current node. 
Thus, we update the current node's inrinr value as left\_child(inr) + 1left_child(inr)+1.

Then, we do the same process with the right child as well. 
But, for obtaining the inrinr and dcrdcr value for the current node, 
we need to consider the maximum value out of the two values obtained from the left and the right child for both inrinr and dcrdcr, 
since we need to consider the longest sequence possible.

Further, after we've obtained the final updated values of inrinr and dcrdcr for a node, 
we update the length of the longest consecutive path found so far as maxval = \text{max}(inr + dcr - 1)maxval=max(inr+dcr−1).
*/
public class Solution {
    int maxval = 0;
    public int longestConsecutive(TreeNode root) {
        longestPath(root);
        return maxval;
    }
    private int[] longestPath(TreeNode root) {
        if (root == null)
            return new int[] {0, 0};
        int inr = 1, dcr = 1;
        if (root.left != null) {
            int[] l = longestPath(root.left);
            if (root.val == root.left.val + 1)
                dcr = l[1] + 1;
            else if (root.val == root.left.val - 1)
                inr = l[0] + 1;
        }
        if (root.right != null) {
            int[] r = longestPath(root.right);
            if (root.val == root.right.val + 1)
                dcr = Math.max(dcr, r[1] + 1);
            else if (root.val == root.right.val - 1)
                inr = Math.max(inr, r[0] + 1);
        }
        maxval = Math.max(maxval, dcr + inr - 1);
        return new int[] {inr, dcr};
    }
}