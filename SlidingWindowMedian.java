public class Solution {
    
    Queue<Integer> minHeap = new PriorityQueue<>();
    Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
    
    public double[] medianSlidingWindow(int[] nums, int k) {
        int count = nums.length - k + 1;
        double[] res = new double[count];
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            add(nums[i]);
            if (i >= k) 
                remove(nums[i - k]);
            if (i >= k - 1)
                res[i - k + 1] = getMedian();
        }
        return res;
    }
    
    private void add(int element) {
        if (minHeap.size() == 0) 
            minHeap.offer(element);
        else if (element < minHeap.peek())
            maxHeap.offer(element);
        else 
            minHeap.offer(element);
        
        balance();
    }
    
    private void remove(int element) {
        if (element >= minHeap.peek())
            minHeap.remove(element);
        else if (element <= maxHeap.peek())
            maxHeap.remove(element);
        
        balance();
    }
    
    private void balance() {
        if (minHeap.size() > maxHeap.size() + 1) 
            maxHeap.offer(minHeap.poll());
        if (maxHeap.size() > minHeap.size())
            minHeap.offer(maxHeap.poll());
    }
    
    private double getMedian() {
        if (minHeap.size() == maxHeap.size()) 
            return 0.5 * (minHeap.peek() + maxHeap.peek());
        else 
            return (double) minHeap.peek();
    }
    
}