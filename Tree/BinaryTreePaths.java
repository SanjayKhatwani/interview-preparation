public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root == null) 
            return paths;
        if (root.left == null && root.right == null) {
            paths.add("" + root.val);
            return paths;
        }
        
        List<String> leftPaths = binaryTreePaths(root.left);
        List<String> rightPaths = binaryTreePaths(root.right);
        for (String path : leftPaths) {
            paths.add(root.val + "->" + path);
        }
        for (String path : rightPaths) {
            paths.add(root.val + "->" + path);
        }
        
        return paths;
    }
}



public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root == null) return paths;
        helper(paths, "", root);
        return paths;
    }
    
    private void helper(List<String> paths, String currPath, TreeNode node) {
        if (node.left == null && node.right == null) {
            paths.add(currPath + node.val);
            return;
        }
        currPath = currPath + node.val + "->";
        if (node.left != null)
            helper(paths, currPath, node.left);
        if (node.right != null)
            helper(paths, currPath, node.right);
    }
}