public class Solution {
    public int closestValue(TreeNode root, double target) {
        int res = root.val;
        TreeNode curr = root;
        while (curr != null) {
            if (Math.abs(target - curr.val) < Math.abs(target - res)) {
                res = curr.val;
            }      
            curr = curr.val > target ? curr.left: curr.right;
        }     
        return res;
    }
}