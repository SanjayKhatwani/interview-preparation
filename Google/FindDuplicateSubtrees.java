/*
Since "subtree" has the more restrictive definition according to the question comments, you can use hashing to do this in linear time with low probability of error. 
The idea is simply to hash every subtree. 
To do this, it must be possible to quickly calculate the hash of a subtree if the hashes of all sub-subtrees are known. 
This can be done by specifying that a subtree's hash is HASH(CONCAT(key, left_hash, right_hash)) or something like that, where HASH is a hash function.

Visit the nodes in postorder. Calculate the hash of each subtree as its root is visited. 
If the current subtree is not a leaf node, insert the node into the hash set. Then it's easy to check for duplicates.

As with other hash-based algorithms, the probability of error decreases exponentially with the length of the hash value.
*/
public class Solution {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
        postTraversal(root, new HashMap<>(), res);
        return res;
    }
    private String postTraversal(TreeNode root, Map<String, Integer> map, List<TreeNode> res) {
        if (root == null) return "#";
        String hash = postTraversal(root.left, map, res) + "," + postTraversal(root.right, map, res) + "," + root.val;
        if (map.getOrDefault(hash, 0) == 1) res.add(root);
        map.put(hash, map.getOrDefault(hash, 0) + 1);
        return hash;
    }
}