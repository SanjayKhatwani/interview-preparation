/**
 * Definition of SegmentTreeNode:
 * public class SegmentTreeNode {
 *     public int start, end, max;
 *     public SegmentTreeNode left, right;
 *     public SegmentTreeNode(int start, int end, int max) {
 *         this.start = start;
 *         this.end = end;
 *         this.max = max
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    /**
     *@param root, start, end: The root of segment tree and 
     *                         an segment / interval
     *@return: The maximum number in the interval [start, end]
     */
    public int query(SegmentTreeNode root, int start, int end) {
        if (start == root.start && root.end == end) {
            return root.max;
        }
        
        int mid = (root.start + root.end) / 2;
        int leftmax = Integer.MIN_VALUE, rightmax = Integer.MIN_VALUE;

        if (start <= mid) {
            leftmax = query(root.left, start, Math.min(mid, end));
        }

        if (mid < end) { 
            rightmax = query(root.right, Math.max(mid + 1, start), end);
        }  

        return Math.max(leftmax, rightmax);
    }
}