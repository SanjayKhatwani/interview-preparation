public class NestedIterator implements Iterator<Integer> {

    Deque<NestedInteger> deque = new ArrayDeque<>();

    public NestedIterator(List<NestedInteger> nestedList) {
        for (NestedInteger i : nestedList) {
            deque.offer(i);
        }
    }

    @Override
    public Integer next() {
        return deque.poll().getInteger();
    }

    @Override
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