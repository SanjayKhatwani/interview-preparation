class PeekingIterator implements Iterator<Integer> {
    
    Integer next;
    Iterator<Integer> iterator;

	public PeekingIterator(Iterator<Integer> iterator) {
	    this.iterator = iterator;
        if (iterator.hasNext())
            next = this.iterator.next();
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return next;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
        if (!hasNext()) return null;
        int nextCopy = next;
        next = iterator.hasNext() ? iterator.next() : null;
	    return nextCopy;
	}

	@Override
	public boolean hasNext() {
	    return next != null;
	}
}