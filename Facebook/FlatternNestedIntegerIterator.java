public class NestedIterator implements Iterator<Integer> {

    Deque<NestedInteger> deque = new LinkedList<>();

    public NestedIterator(List<NestedInteger> nestedList) {
        deque.addAll(nestedList);
    }

    public Integer next() {
        return deque.pop().getInteger();
    }
    
    public boolean hasNext() {
        while (!deque.isEmpty()) {
            NestedInteger curr = deque.peek();
            if (curr.isInteger()) {
                return true;
            }
            deque.pop();
            for (int i = curr.getList().size() - 1; i >= 0; i--) {
                deque.push(curr.getList().get(i));
            }
        }
        return false;
    }
}