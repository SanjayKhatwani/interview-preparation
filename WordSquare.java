// Given a set of words (without duplicates), find all word squares you can build from them.

// A sequence of words forms a valid word square if the kth row and column read the exact same string, where 0 ≤ k < max(numRows, numColumns).

// For example, the word sequence ["ball","area","lead","lady"] forms a word square because each word reads the same both horizontally and vertically.

// b a l l
// a r e a
// l e a d
// l a d y

// Note:
// There are at least 1 and at most 1000 words.
// All words will have the exact same length.
// Word length is at least 1 and at most 5.
// Each word contains only lowercase English alphabet a-z.

public class Solution {

    public List<List<String>> wordSquares(String[] words) {

        List<List<String>> res = new ArrayList<>();

        if (words.length == 0 || words[0].length() == 0) {
            return res;
        }

        // Prefixes to words
        Map<String, Set<String>> prefixMap = new HashMap<>();

        // All words have same length
        int squareLen = words[0].length();

        // Create all prefix
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j <= squareLen; j++) {
                // empty string maps to all words
                String prefix = words[i].substring(0, j);
                if (!prefixMap.containsKey(prefix)) {
                    prefixMap.put(prefix, new HashSet<String>());
                }
                prefixMap.get(prefix).add(words[i]);
            }
        }

        helper(res, new ArrayList<String>(), 0, squareLen, prefixMap);

        return res;

    }

    public void helper(List<List<String>> res, List<String> curr, int matched, int total, Map<String, Set<String>> prefixMap){

        if (matched == total) {
            res.add(new ArrayList<String>(curr));
            return;
        }

        // build search string
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < matched; i++) 
            sb.append(curr.get(i).charAt(matched));

        String nextPrefix = sb.toString();

        // backtracking
        Set<String> candidate = prefixMap.get(nextPrefix);

        if (candidate == null) 
            return;

        for (String str : candidate){
            curr.add(str);
            helper(res, curr, matched + 1, total, prefixMap);
            curr.remove(curr.size() - 1);
        }

    }

}