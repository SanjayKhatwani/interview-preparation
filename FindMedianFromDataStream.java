public class MedianFinder {

    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        if (minHeap.size() == 0) // first element comes in
            minHeap.add(num);
        else if (num <= minHeap.peek())
            maxHeap.add(num);
        else
            minHeap.add(num);

        if (minHeap.size() - maxHeap.size() > 1)
            maxHeap.add(minHeap.poll());
        else if (maxHeap.size() > minHeap.size())
            minHeap.add(maxHeap.poll());
    }
    
    public double findMedian() {
        if (minHeap.size() == maxHeap.size())
            return 0.5 * (minHeap.peek() + maxHeap.peek());
        else 
            return minHeap.peek();
    }

}