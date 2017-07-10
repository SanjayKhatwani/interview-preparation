/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public boolean canAttendMeetings(Interval[] intervals) {
        if (intervals.length <= 1)
            return true;
        Arrays.sort(intervals, (a, b) -> a.start - b.start);
        int lastEnd = intervals[0].end;
        for (int i = 1; i < intervals.length; i++) {
            if (lastEnd > intervals[i].start) return false;
            lastEnd = intervals[i].end;
        }
        return true;
    }
}