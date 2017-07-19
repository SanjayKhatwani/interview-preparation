public class Solution {

    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) {
            return false;
        }
        
        int[] ancestor = new int[n]; 
        Arrays.fill(ancestor, -1);
        
        for (int[] edge : edges) {
            int x = getAncestor(ancestor, edge[0]);
            int y = getAncestor(ancestor, edge[1]);
            if (x == y) { // cycle detected
                return false;
            }
            ancestor[x] = y;
        }
        
        return true;
    }
    
    private int getAncestor(int[] ancestor, int k) {
        if (ancestor[k] == -1 || ancestor[k] == k) {
            ancestor[k] = k;
            return k;
        }
        
        ancestor[k] = getAncestor(ancestor, ancestor[k]);
        return ancestor[k];
    }

}