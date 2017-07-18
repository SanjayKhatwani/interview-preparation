public class Solution {

    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        Arrays.sort(intervals, (a, b) -> a.start - b.start);
        Queue<Integer> heap = new PriorityQueue<>();
        heap.add(intervals[0].end);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start >= heap.peek()) {
                heap.poll();
            } 
            heap.add(intervals[i].end);
        }
        return heap.size();
    }
    
}