// DFS is better than BFS 
public class Solution {
    
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> list= new ArrayList<>();
        visit(root,0,list);
        return list;
    }

    private void visit(TreeNode root, int depth,List<Integer> list){
        if (root == null) 
            return;
        int m = root.val;
        if (list.size() <= depth) {
            list.add(m);
        } else {
            list.set(depth, list.get(depth) > m ? list.get(depth) : m);
        }
        visit(root.left, depth + 1, list);
        visit(root.right, depth + 1, list);
    }
    
}