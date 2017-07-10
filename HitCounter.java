// We call move() before hit() and getHits(). move() will take time at most O(N), where N is the length of the array.

public class HitCounter {
    int N;
    int[] count;
    int lastPosition;
    int lastTime;
    int sum;

    /** Initialize your data structure here. */
    public HitCounter() {
        N = 300;
        count = new int[N];
        lastPosition = 0;
        lastTime = 0;
        sum = 0;
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        move(timestamp);
        count[lastPosition]++;
        sum++;
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        move(timestamp);
        return sum;
    }
    
    void move(int timestamp){
        int gap = Math.min(timestamp - lastTime, N);
        for (int i = 0; i < gap; i++){
            lastPosition = (lastPosition + 1) % N;
            sum -= count[lastPosition];
            count[lastPosition] = 0;
        }
        lastTime = timestamp;
    }
}


public class HitCounter {

    Deque<Integer> deque;
    /** Initialize your data structure here. */
    public HitCounter() {
        deque = new LinkedList<>();
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        deque.offer(timestamp);
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        while (!deque.isEmpty() && deque.peek() + 300 <= timestamp) 
            deque.poll();
        return deque.size();
    }
}