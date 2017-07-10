/**
 * class Point {
 *     int x;
 *     int y;
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {

    class UnionFind {
        Map<Integer, Integer> father = new HashMap<>();

        public UnionFind(int[] array) {
            for (int i : array){
                father.put(i, i);
            }
        }

        public int compressFind(int x){
            int parent = father.get(x);
            while (parent != father.get(parent)) {
                parent = father.get(parent);
            }

            int fa = x;
            while (fa != father.get(fa)){
                int temp = father.get(fa);
                father.put(fa, parent);
                fa = temp;
            }

            return parent;
        }

        public void union(int a, int b){
            int aFather = compressFind(a);
            int bFather = compressFind(b);
            if (aFather != bFather){
                father.put(aFather, bFather);
            }
        }
    }

    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    public List<Integer> numIslands2(int n, int m, Point[] operators) {
        List<Integer> res = new ArrayList<>();
        if (n < 1 || m < 1 || operators == null || operators.length == 0) {
            return res;
        }

        int[] pos = new int[n * m];
        boolean[] isIsland = new boolean[n * m];

        for (int i = 0; i < n; i++) {
            for (int j  = 0; j < m; j++) {
                int index = i * m + j;
                pos[index] = index;
            }
        }

        UnionFind uf = new UnionFind(pos);

        int count = 0;
        for (Point point : operators) {
            int index = point.x * m + point.y;
            isIsland[index] = true;
            count++;
            for (int i = 0; i < 4; i++){
                int nextX = point.x + dx[i];
                int nextY = point.y + dy[i];
                int nextIndex = nextX * m + nextY;
                if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < m && isIsland[nextIndex]){
                    if (uf.compressFind(index) != uf.compressFind(nextIndex)) {
                        uf.union(index, nextIndex);
                        count--;
                    }
                }
            }
            res.add(count);
        }

        return res;
    }
}