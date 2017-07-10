public class BSTIterator {

    Deque<TreeNode> stack = new ArrayDeque<>();
    
    //@param root: The root of binary tree.
    public BSTIterator(TreeNode root) {
        // write your code here
        TreeNode curr = root;
        while (curr != null) {
            stack.push(curr);
            curr = curr.left;
        }
    }

    //@return: True if there has next node, or false
    public boolean hasNext() {
        // write your code here
        return !stack.isEmpty();
    }
    
    //@return: return next node
    public TreeNode next() {
        // write your code here
        TreeNode node = stack.pop();
        TreeNode curr = node.right;
        while (curr != null) {
            stack.push(curr);
            curr = curr.left;
        }
        return node;
    }
    
}