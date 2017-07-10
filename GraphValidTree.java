public class Solution {

    class UnionFind {
        Map<Integer, Integer> father = new HashMap<>();
        
        UnionFind(int n) {
            for (int i = 0 ; i < n; i++) {
                father.put(i, i); 
            }
        }

        int compressedFind(int x) {
            int parent = father.get(x);
            // find the oldest ancestor
            while (parent != father.get(parent)) {
                parent = father.get(parent);
            }
            int fa = father.get(x);
            // set the oldest ancestor to be the parent of all x's ancestors
            while (fa != father.get(fa)) {
                int temp = father.get(fa);
                father.put(fa, parent) ;
                fa = temp;
            }
            return parent;
        }
        
        void union(int x, int y) {
            int fatherX = compressedFind(x);
            int fatherY = compressedFind(y);
            if (fatherX != fatherY)
                father.put(fatherX, fatherY);
        }
    }

    public boolean validTree(int n, int[][] edges) {
        // tree should have n nodes with n-1 edges
        if (n - 1 != edges.length) {
            return false;
        }
        
        UnionFind uf = new UnionFind(n);
        
        for (int i = 0; i < edges.length; i++) {
            if (uf.compressedFind(edges[i][0]) == uf.compressedFind(edges[i][1])) {
                return false;
            }
            uf.union(edges[i][0], edges[i][1]);
        }

        return true;
    }
}


// BFS
public class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (n == 0 || edges.length != n - 1) return false;
        
        Map<Integer, Set<Integer>> graph = initializeGraph(n, edges);
        
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        
        queue.offer(0);
        visited.add(0);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (Integer neighbor : graph.get(node)) {
                if (visited.contains(neighbor)) {
                    continue;
                }
                visited.add(neighbor);
                queue.offer(neighbor);
            }
        }
        
        return (visited.size() == n);
    }
    
    private Map<Integer, Set<Integer>> initializeGraph(int n, int[][] edges) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new HashSet<>());
        }
        
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        
        return graph;
    }
