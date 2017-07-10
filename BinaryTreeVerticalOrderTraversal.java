public class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        
        Map<Integer, List<Integer>> map = new TreeMap<>();
        Queue<TreeNode> nodes = new LinkedList<>();
        Queue<Integer> layers = new LinkedList<>();
        
        nodes.offer(root);
        layers.offer(0);
        while (!nodes.isEmpty()) {
            TreeNode node = nodes.poll();
            int layer = layers.poll();
            if (node.left != null) {
                nodes.offer(node.left);
                layers.offer(layer - 1);
            }
            if (node.right != null) {
                nodes.offer(node.right);
                layers.offer(layer + 1);
            }
            
            if (!map.containsKey(layer)) {
                map.put(layer, new ArrayList<Integer>());
            } 
            map.get(layer).add(node.val);
        }
        
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            res.add(entry.getValue());
        }
        return res;
    }
}