public class RandomizedCollection {

    List<Integer> List;
    Map<Integer, LinkedHashSet<Integer>> map;
    
    public RandomizedCollection() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        // Add item to map if it doesn't already exist.
        boolean alreadyExists = map.containsKey(val);
        if (!alreadyExists) {
            map.put(val, new LinkedHashSet<Integer>());
        }
        list.add(val);
        map.get(val).add(list.size() - 1);

        return !alreadyExists;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        // Get arbitary index of the ArrayList that contains val
        LinkedHashSet<Integer> valSet = map.get(val);
        int indexToReplace = valSet.iterator().next();
        
        // Obtain the set of the number in the last place of the ArrayList
        int numAtLastPlace = list.get(list.size() - 1);
        LinkedHashSet<Integer> replaceWith = map.get(numAtLastPlace);
        
        // Replace val at arbitary index with very last number
        list.set(indexToReplace, numAtLastPlace);
        
        // Remove appropriate index
        valSet.remove(indexToReplace);
        
        // Don't change set if we were replacing the removed item with the same number
        if (indexToReplace != result.size() - 1) {
            replaceWith.remove(result.size() - 1);
            replaceWith.add(indexToReplace);
        }
        result.remove(result.size() - 1);
        
        // Remove map entry if set is now empty, then return
        if (valSet.isEmpty()) {
            map.remove(val);
        }
        return true;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        // Get linearly random item
        return result.get((int)(Math.random() * result.size()));
    }
}