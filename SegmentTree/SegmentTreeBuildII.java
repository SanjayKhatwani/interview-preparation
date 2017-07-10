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
     *@param A: a list of integer
     *@return: The root of Segment Tree
     */
    public SegmentTreeNode build(int[] A) {
        if (A == null) return null;
        return buildTree(A, 0, A.length - 1);
    }
    
    private SegmentTreeNode buildTree(int[] A, int start, int end) {
        if (start > end)
            return null;
        if (start == end) 
            return new SegmentTreeNode(start, end, A[start]);
        int mid = start + (end - start) / 2;
        SegmentTreeNode leftNode = buildTree(A, start, mid);
        SegmentTreeNode rightNode = buildTree(A, mid + 1, end);
        SegmentTreeNode root = new SegmentTreeNode(start, end, Math.max(leftNode.max, rightNode.max));
        root.left = leftNode;
        root.right = rightNode;
        return root;
    }
}