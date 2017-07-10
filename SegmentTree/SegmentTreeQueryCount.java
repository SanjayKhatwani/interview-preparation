/**
 * Definition of SegmentTreeNode:
 * public class SegmentTreeNode {
 *     public int start, end, count;
 *     public SegmentTreeNode left, right;
 *     public SegmentTreeNode(int start, int end, int count) {
 *         this.start = start;
 *         this.end = end;
 *         this.count = count;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    /**
     *@param root, start, end: The root of segment tree and 
     *                         an segment / interval
     *@return: The count number in the interval [start, end]
     */
    public int query(SegmentTreeNode root, int start, int end) {
        if (start > end || root == null)
            return 0;
        if (root.start >= start && root.end <= end)
            return root.count;
        int mid = root.start + (root.end - root.start) / 2;
        int leftCount = 0, rightCount = 0;
        if (mid >= start) leftCount = query(root.left, start, Math.min(mid, end));
        if (mid < end) rightCount = query(root.right, Math.max(mid + 1, start), end);
        return leftCount + rightCount;
    }
}