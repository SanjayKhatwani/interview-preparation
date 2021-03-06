public class Solution {

    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        if (!isLeaf(root)) {
            res.add(root.val);
        }
        TreeNode t = root.left;
        while (t != null) {
            if (!isLeaf(t)) {
                res.add(t.val);
            }
            t = t.left != null ? t.left : t.right;
        }
        addLeaves(res, root);
        Deque<Integer> deque = new LinkedList<>();
        t = root.right;
        while (t != null) {
            if (!isLeaf(t)) {
                deque.push(t.val);
            }
            t = t.right != null ? t.right : t.left;
        }
        while (!deque.isEmpty()) {
            res.add(deque.pop());
        }
        return res;
    }

    private boolean isLeaf(TreeNode t) {
        return t.left == null && t.right == null;
    }

    private void addLeaves(List<Integer> res, TreeNode root) {
        if (isLeaf(root)) {
            res.add(root.val);
        } else {
            if (root.left != null) addLeaves(res, root.left);
            if (root.right != null) addLeaves(res, root.right);
        }
    }
    
}