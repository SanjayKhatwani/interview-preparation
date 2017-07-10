public class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<>();
        helper(res, word, 0, "", 0);
        return res;
    }
    
    private void helper(List<String> res, String word, int pos, String curr, int count) {
        if (pos == word.length()) {
            curr += count > 0 ? count : "";
            res.add(curr);
            return;
        }
        helper(res, word, pos + 1, curr, count + 1);
        helper(res, word, pos + 1, curr + (count > 0 ? count : "") + word.charAt(pos), 0);
    }
}