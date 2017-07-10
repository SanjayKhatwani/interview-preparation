public class Solution {
    private static char[][] map = new char[][] {
            {}, {}, 
            {'a', 'b', 'c'}, 
            {'d', 'e', 'f'}, 
            {'g', 'h', 'i'}, 
            {'j', 'k', 'l'}, 
            {'m', 'n', 'o'},
            {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'},
            {'w', 'x', 'y', 'z'}};
            
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0)
            return res;
        helper(res, digits, new StringBuilder(), 0);
        return res;
    }
    
    private void helper(List<String> res, String digits, StringBuilder builder, int pos) {
        if (pos == digits.length()) {
            res.add(builder.toString());
            return;
        }
        int idx = digits.charAt(pos) - '0';
        for (char c : map[idx]) {
            builder.append(c);
            helper(res, digits, builder, pos + 1);
            builder.deleteCharAt(builder.length() - 1);
        }
    }
}


// Iterative

public List<String> letterCombinations(String digits) {
    LinkedList<String> ans = new LinkedList<String>();
    String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    ans.add("");
    for (int i = 0; i < digits.length(); i++) {
        int x = digits.charAt(i) - '0';
        while (ans.peek().length() == i) {
            String t = ans.remove();
            for (char s : mapping[x].toCharArray())
                ans.add(t + s);
        }
    }
    return ans;
}