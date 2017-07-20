public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        TreeLinkNode pre = root;
        TreeLinkNode cur = null;
        while (pre.left != null) {
            cur = pre;
            while (cur != null) {
                cur.left.next = cur.right;
                if (cur.next != null) 
                    cur.right.next = cur.next.left;
                cur = cur.next;
            }
            pre = pre.left;
        }
    }
}


public class Solution {
    public void connect(TreeLinkNode root) {
        TreeLinkNode parent = root;
        TreeLinkNode pre = null;
        TreeLinkNode next = null;
        while (parent != null) { // loop to next level
            while (parent != null) { // loop in current level
                if (next == null) {
                    next = (parent.left != null) ? parent.left: parent.right;
                }
                if (parent.left != null) {
                    if (pre == null) {
                        pre = parent.left;
                    } else {
                        pre.next = parent.left;
                        pre = pre.next;
                    }
                }
                if (parent.right != null) {
                    if (pre == null) {
                        pre = parent.right;
                    } else {
                        pre.next = parent.right;
                        pre = pre.next;
                    }
                }
                parent = parent.next;
            }
            parent = next;
            next = null;
            pre = null;
        }
    }
}