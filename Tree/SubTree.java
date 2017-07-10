public class Solution {
    /**
     * @param T1, T2: The roots of binary tree.
     * @return: True if T2 is a subtree of T1, or false.
     */
    public boolean isSubtree(TreeNode T1, TreeNode T2) {
        // write your code here
        if (T2 == null) return true;
        else if (T1 == null) return false;
        
        if (isSame(T1, T2)) return true;
        return isSubtree(T1.left, T2) || isSubtree(T1.right, T2);
    }
    
    private boolean isSame(TreeNode n1, TreeNode n2) {
        if (n1 == null || n2 == null) 
            return n1 == n2;
        if (n1.val != n2.val) 
            return false;
        return isSame(n1.left, n2.left) && isSame(n1.right, n2.right);
    }
}