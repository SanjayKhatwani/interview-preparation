public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "null";
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        StringBuilder builder = new StringBuilder();
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            builder.append(curr == null ? "null," : curr.val + ",");
            if (curr != null) {
                q.offer(curr.left);
                q.offer(curr.right);
            }
        }
        return builder.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if ("null".equals(data)) return null;
        String[] vals = data.split(",");
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        q.offer(root);
        for (int i = 1; i < vals.length; i++) {
            TreeNode curr = q.poll();
            if (!vals[i].equals("null")) {
                curr.left = new TreeNode(Integer.parseInt(vals[i]));
                q.offer(curr.left);
            }
            if (!vals[++i].equals("null")) {
                curr.right = new TreeNode(Integer.parseInt(vals[i]));
                q.offer(curr.right);
            }
        }
        return root;
    }
}