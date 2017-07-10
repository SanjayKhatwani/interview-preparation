/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */

public class Solution {
    /**
     * Insert newInterval into intervals.
     * @param intervals: Sorted interval list.
     * @param newInterval: A new interval.
     * @return: A new sorted interval list.
     */
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
    	int i = 0;
    	while (i < intervals.size() && intervals.get(i).end < newInterval.start) i++;
    	while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
    		newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
    		newInterval.end = Math.max(newInterval.end, intervals.get(i).end);
    		intervals.remove(i);
    	}
    	intervals.add(i, newInterval);
    	return intervals;
    }
}