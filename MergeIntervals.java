/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
// O(nlogn) time complexity
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
    	List<Interval> res = new ArrayList<>();
        if (intervals == null || intervals.size() == 0)
            return res;
            
        Collections.sort(intervals, (a, b) -> a.start - b.start);
        
        Interval newInterval = intervals.get(0);
        for (Interval curr : intervals) {
            if (curr.start > newInterval.end) {
                res.add(newInterval);
                newInterval = curr;
            } else {
                newInterval.end = Math.max(newInterval.end, curr.end);
            }
        }
        res.add(newInterval);
        return res;
    }
}


// faster solution
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        int n = intervals.size();
        int[] starts = new int[n];
        int[] ends = new int[n];
        for (int i = 0; i < n; i++) {
            starts[i] = intervals.get(i).start;
            ends[i] = intervals.get(i).end;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        List<Interval> res = new ArrayList<>();
        for (int i = 0, j = 0; i < n; i++) { // j is start of interval.
            if (i == n - 1 || starts[i + 1] > ends[i]) {
                res.add(new Interval(starts[j], ends[i]));
                j = i + 1;
            }
        }
        return res;
    }
}