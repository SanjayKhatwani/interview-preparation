public class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        helper(res, s, 0, 0, new char[]{'(', ')'});
        return res;
    }
    
    private void helper(List<String> res, String s, int lasti, int lastj, char[] par) {
        int count = 0;
        for (int i = lasti; i < s.length(); i++) {
            if (s.charAt(i) == par[0]) count++;
            if (s.charAt(i) == par[1]) count--;
            if (count < 0) {
                for (int j = lastj; j <= i; j++) {
                    if (s.charAt(j) == par[1] && (j == lastj || s.charAt(j - 1) != par[1])) {
                        helper(res, s.substring(0, j) + s.substring(j + 1), i, j, par);
                    }
                }
                return;
            }
        }
        String rs = new StringBuilder(s).reverse().toString();
        if (par[0] == '(') {
            helper(res, rs, 0, 0, new char[]{')', '('});
        } else {
            res.add(rs);
        }
    }
}