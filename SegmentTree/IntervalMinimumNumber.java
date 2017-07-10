/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */
public class Solution {
    public List<Integer> intervalMinNumber(int[] A, List<Interval> queries) {
        List<Integer> res = new ArrayList<>();
        if (A == null || A.length == 0)
            return res;
        TreeNode root = buildTree(A, 0, A.length - 1);
        for (Interval interval : queries) {
            res.add(queryTree(root, interval.start, interval.end));
        }
        return res;
    }
    
    private TreeNode buildTree(int[] A, int start, int end) {
        if (start > end) return null;
        TreeNode root = new TreeNode(start, end);
        if (start == end) {
            root.val = A[start];
        } else {
            int mid = (start + end) / 2;
            root.left = buildTree(A, start, mid);
            root.right = buildTree(A, mid + 1, end);
            root.val = Math.min(root.left.val, root.right.val);
        }
        return root;
    }
    
    private int queryTree(TreeNode root, int start, int end) {
        if (root.start == start && root.end == end) 
            return root.val;
        int mid = (root.start + root.end) / 2;
        int leftmin = mid < start ? Integer.MAX_VALUE : queryTree(root.left, start, Math.min(mid, end));
        int rightmin = mid >= end ? Integer.MAX_VALUE : queryTree(root.right, Math.max(mid + 1, start), end);
        return Math.min(leftmin, rightmin);
    }
    
}

class TreeNode {
    int val;
    int start, end;
    TreeNode left, right;
    public TreeNode(int start, int end) {
        this.start = start;
        this.end = end;
    }
}