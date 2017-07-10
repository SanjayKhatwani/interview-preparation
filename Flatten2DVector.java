public class Vector2D implements Iterator<Integer> {

    Iterator<List<Integer>> listIterator;
    Iterator<Integer> iterator;
    
    public Vector2D(List<List<Integer>> vec2d) {
        listIterator = vec2d.iterator();
        if (listIterator.hasNext()) {
            iterator = listIterator.next().iterator();
        }
    }

    @Override
    public Integer next() {
        return iterator.next();
    }

    @Override
    public boolean hasNext() {
        if (iterator == null)
            return false;
        if (iterator.hasNext()) 
            return true;
        while (listIterator.hasNext()) {
            List<Integer> list = listIterator.next();
            if (list.size() > 0) {
                iterator = list.iterator();
                return true;
            }
        }
        return false;
    }
}