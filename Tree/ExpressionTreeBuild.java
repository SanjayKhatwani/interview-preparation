/**
 * Definition of ExpressionTreeNode:
 * public class ExpressionTreeNode {
 *     public String symbol;
 *     public ExpressionTreeNode left, right;
 *     public ExpressionTreeNode(String symbol) {
 *         this.symbol = symbol;
 *         this.left = this.right = null;
 *     }
 * }
 */

public class Solution {
    class TreeNode {
        int val;
        ExpressionTreeNode eNode;
        public TreeNode(int val, String s) {
            this.val = val;
            eNode = new ExpressionTreeNode(s);
        }
    }
    /**
     * @param expression: A string array
     * @return: The root of expression tree
     */
    public ExpressionTreeNode build(String[] expression) {
        if (expression == null || expression.length == 0) {
            return null;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        int base = 0;
        int val = 0;

        for (int i = 0; i < expression.length; i++) {
            if (expression[i].equals("(")) {
                base += 10;
                continue;
            }
            if (expression[i].equals(")")) {
                base -= 10;
                continue;
            }
            val = getWeight(base, expression[i]);
            TreeNode node = new TreeNode(val, expression[i]);
            while (!deque.isEmpty() && node.val <= deque.peek().val) {
                node.eNode.left = deque.pop().eNode;
            }
            if (!deque.isEmpty()) {
                deque.peek().eNode.right = node.eNode;
            }
            deque.push(node);
        }
        if (deque.isEmpty()) {
            return null;
        }
        TreeNode rst = deque.pop();
        while (!deque.isEmpty()) {
            rst = deque.pop();
        }
        return rst.eNode;
    }

    //Calculate weight for characters
    public int getWeight(int base, String s) {
        if (s.equals("+") || s.equals("-")) {
            return base + 1;
        }
        if (s.equals("*") || s.equals("/")) {
            return base + 2;
        }
        return Integer.MAX_VALUE;
    }
}
