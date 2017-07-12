public class BSTIterator {
    Deque<TreeNode> stack = new ArrayDeque<>();
    
    public BSTIterator(TreeNode root) {
        TreeNode curr = root;
        while (curr != null) {
            stack.push(curr);
            curr = curr.left;
        }
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
    
    public TreeNode next() {
        TreeNode node = stack.pop();
        TreeNode curr = node.right;
        while (curr != null) {
            stack.push(curr);
            curr = curr.left;
        }
        return node;
    }
}