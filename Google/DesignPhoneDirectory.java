public class PhoneDirectory {
    
    Set<Integer> used = new HashSet<>();
    Queue<Integer> available = new LinkedList<>();
    int max;
    
    public PhoneDirectory(int maxNumbers) {
        max = maxNumbers;
        for (int i = 0; i < maxNumbers; i++) {
            available.offer(i);
        }
    }
    
    public int get() {
        if (available.isEmpty()) {
            return -1;
        }
        int res = available.poll();
        used.add(res);
        return res;
    }
    
    public boolean check(int number) {
        if (number >= max || number < 0) {
            return false;
        }
        return !used.contains(number);
    }
    
    public void release(int number) {
        if (used.remove(number)) {
            available.offer(number);
        }
    }
    
}