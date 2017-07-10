public class Solution {
    public TreeNode sortedArrayToBST(int[] A) {  
        return buildTree(A, 0, A.length - 1);
    }  
    
    private TreeNode buildTree(int[] A, int start, int end) {
        if (start > end) return null;
        if (start == end) return new TreeNode(A[start]);
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(A[mid]);
        root.left = buildTree(A, start, mid - 1);
        root.right = buildTree(A, mid + 1, end);
        return root;
    }
}