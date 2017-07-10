public class Solution {

    class SegmentTreeNode {
        public int start, end;
        public int count;
        public SegmentTreeNode left, right;
        public SegmentTreeNode(int start, int end, int count) {
              this.start = start;
              this.end = end;
              this.count = count;
        }
    }

    SegmentTreeNode root;

    public SegmentTreeNode build(int start, int end) {
        if (start > end) return null;
        
        SegmentTreeNode root = new SegmentTreeNode(start, end, 0);   
        if (start < end) {
            int mid = (start + end) / 2;
            root.left = build(start, mid);
            root.right = build(mid + 1, end);
        } else {
            root.count =  0;
        }
        return root;
    }

    public int querySegmentTree(SegmentTreeNode root, int start, int end) {
        if (start == root.start && root.end == end) {
            return root.count;
        }     
        int mid = (root.start + root.end) / 2;
        int leftcount = 0, rightcount = 0;
        if (start <= mid) {
            leftcount =  querySegmentTree(root.left, start, Math.min(mid, end));
        }
        if (mid < end) {
            rightcount = querySegmentTree(root.right, Math.max(mid + 1, start), end); 
        }  
        return leftcount + rightcount;
    }

    public void modifySegmentTree(SegmentTreeNode root, int index, int value) {
        if (root.start == index && root.end == index) {
            root.count += value;
            return;
        }
        int mid = (root.start + root.end) / 2;
        if (root.start <= index && index <= mid) {
            modifySegmentTree(root.left, index, value);
        }
        if (mid < index && index <= root.end) {
            modifySegmentTree(root.right, index, value);
        }
        root.count = root.left.count + root.right.count;
    }

    public List<Integer> countOfSmallerNumber(int[] A, int[] queries) {
        root = build(0, 10000);
        List<Integer> ans = new ArrayList<>();
        int res;
        for (int i = 0; i < A.length; i++) {
            modifySegmentTree(root, A[i], 1);
        }
        for (int i = 0; i < queries.length; i++) {
            res = 0;
            if (queries[i] > 0)
                res = querySegmentTree(root, 0, queries[i] - 1);
            ans.add(res);
        }
        return ans;
    }
}