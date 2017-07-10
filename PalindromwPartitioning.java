public class Solution {

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s == null || s.length() == 0)
            return res;
        
        helper(s, 0, new ArrayList<>(), res);        
        return res;
    }
    
    private void helper(String s, int offset, List<String> partition, List<List<String>> res) {
        if (offset == s.length()) {
            res.add(new ArrayList<>(partition));
            return;
        }
        
        for (int i = offset; i < s.length(); i++) {
            String subString = s.substring(offset, i + 1);
            if (!isPalindrome(subString)) {
                continue;
            }
            partition.add(subString);
            helper(s, i + 1, partition, res);
            partition.remove(partition.size() - 1);
        }
    }
    
    private boolean isPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}

