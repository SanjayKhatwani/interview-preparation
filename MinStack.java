public class MinStack {
    
    Deque<Integer> stack;
    Deque<Integer> minStack;
    
    public MinStack() {
        // do initialize if necessary
        stack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
    }

    public void push(int number) {
        // write your code here
        stack.push(number);
        if (minStack.isEmpty() || min() >= number) {
            minStack.push(number);
        }
    }

    public int pop() {
        // write your code here
        int top = stack.pop();
        if (min() == top) {
            minStack.pop();
        }
        return top;
    }

    public int min() {
        // write your code here
        return minStack.peek();
    }
    
}