// A scientist has index h if h of his/her N papers have at least h citations each, 
// and the other N − h papers have no more than h citations each.
public class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] buckets = new int[n + 1];
        for (int num : citations) {
            if (num >= n) buckets[n]++;
            else buckets[num]++;
        }
        int count = 0;
        for (int i = n; i >= 0; i--) {
            count += buckets[i];
            if (count >= i)
                return i;
        }
        return 0;
    }
}

// citations is in ascending order
public class Solution {
    public int hIndex(int[] citations) {
        int len = citations.length;
        for (int i = 0; i < len; i++) {
            if (citations[i] >= len - i)
                return len - i;
        }
        return 0;
    }
}