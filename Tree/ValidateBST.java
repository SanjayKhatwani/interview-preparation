private class Node {
    private int value;
    private Node right;
    private Node left;
}

public class Solution {
    public boolean isValidBST(TreeNode root) {
        return validate(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }
    
    private boolean validate(TreeNode root, long max, long min) {
        if (root == null) return true;
        if (root.val > max || root.val < min) return false;
        return validate(root.left, root.val, min) && validate(root.right, max, root.val);
    }
}
