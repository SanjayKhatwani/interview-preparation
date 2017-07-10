public class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (desiredTotal <= maxChoosableInteger) return true;
        int sum = (1 + maxChoosableInteger) * maxChoosableInteger / 2;
        if (sum < desiredTotal) return false;
        boolean[] used = new boolean[maxChoosableInteger + 1];
        return helper(desiredTotal, used, new HashMap<Integer, Boolean>());
    }
    
    private boolean helper(int desiredTotal, boolean[] used, Map<Integer, Boolean> map) {
        if (desiredTotal <= 0) return false;
        int key = getKey(used);
        if (map.containsKey(key))
            return map.get(key);
        for (int i = 1; i < used.length; i++) {
            if (!used[i]) {
                used[i] = true;
                if (!helper(desiredTotal - i, used, map)) {
                    map.put(key, true);
                    used[i] = false;
                    return true;
                }
                used[i] = false;
            }
        }
        map.put(key, false);
        return false;
    }
    
    private int getKey(boolean[] used) {
        int key = 0;
        for (boolean b : used) {
            key <<= 1;
            key |= (b ? 1 : 0);
        }
        return key;
    }
}