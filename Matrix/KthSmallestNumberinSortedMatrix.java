/*
Find the kth smallest number in at row and column sorted matrix.

Example
Given k = 4 and a matrix:

[
  [1 ,5 ,7],
  [3 ,7 ,8],
  [4 ,8 ,9],
]
return 5
*/

public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        PriorityQueue<Tuple> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (int i = 0; i < m; i++) 
            pq.offer(new Tuple(i, 0, matrix[i][0]));
        for (int i = 0; i < k - 1; i++) {
            Tuple curr = pq.poll();
            if (curr.l == n - 1) continue;
            pq.offer(new Tuple(curr.r, curr.l + 1, matrix[curr.r][curr.l + 1]));
        }
        return pq.poll().val;
    }
    
    class Tuple {
        int r, l, val;
        public Tuple(int r, int l, int val) {
            this.r = r;
            this.l = l;
            this.val = val;
        }
    }
}