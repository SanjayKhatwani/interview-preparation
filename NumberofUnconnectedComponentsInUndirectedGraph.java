public class Solution {
    public int countComponents(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        for (int[] edge : edges) {
            uf.union(edge[0], edge[1]);
        }
        return uf.count;
    }
}

class UnionFind {
    int[] root;
    int[] rank;
    int count;
    public UnionFind(int n) {
        root = new int[n];
        rank = new int[n];
        count = n;
        for (int i = 0; i < n; i++) {
            root[i] = i;
            rank[i] = 0;
        }
    }
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return;
        if (rank[rootP] == rank[rootQ]) {
            root[rootQ] = root[rootP];
            rank[rootP]++;
        } else if (rank[rootP] < rank[rootQ]) {
            root[rootP] = root[rootQ];
        } else {
            root[rootQ] = root[rootP];
        }
        count--;
    }
    private int find(int p) {
        while (p != root[p]) {
            root[p] = root[root[p]];
            p = root[p];
        }
        return p;
    }
}