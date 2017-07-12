public int largestRectangleArea2(int[] height) {
    Deque<Integer> stack = new LinkedList<>();
    int i = 0;
    int maxArea = 0;
    while (i <= height.length) {
        int h = (i == height.length) ? 0 : height[i];
        if (stack.isEmpty() || height[stack.peek()] <= h) {
            stack.push(i++);
        } else {
            int t = stack.pop();
            maxArea = Math.max(maxArea, height[t] * (stack.isEmpty() ? i : i - stack.peek() - 1));
        }
    }
    return maxArea;
}