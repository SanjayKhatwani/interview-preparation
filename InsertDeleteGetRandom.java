public class RandomizedSet {

    List<Integer> nums;
    Map<Integer, Integer> numToIndex;
    Random random;
    
    public RandomizedSet() {
        nums = new ArrayList<>();
        numToIndex = new HashMap<>();
        random = new Random();
    }
    
    // Inserts a value to the set
    // Returns true if the set did not already contain the specified element or false
    public boolean insert(int val) {
        if (numToIndex.containsKey(val)) return false;
        nums.add(val);
        numToIndex.put(val, nums.size() - 1);
        return true;
    }
    
    // Removes a value from the set
    // Return true if the set contained the specified element or false
    public boolean remove(int val) {
        if (!numToIndex.containsKey(val)) return false;
        int pos = numToIndex.get(val);
        if (pos != nums.size() - 1) {
            int last = nums.get(nums.size() - 1);
            nums.set(pos, last);
            numToIndex.put(last, pos);
        }
        nums.remove(nums.size() - 1);
        numToIndex.remove(val);
        return true;
    }
    
    // Get a random element from the set
    public int getRandom() {
        return nums.get(random.nextInt(nums.size()));
    }
}