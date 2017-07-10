public class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] match = new boolean[m + 1][n + 1];
        match[0][0] = true;
        
        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == '*') {
                    match[i][j] = (i > 0 && match[i - 1][j]) || match[i][j - 1];
                } else {
                    match[i][j] = i > 0 && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') && match[i - 1][j - 1]; 
                }
            }
        }
        return match[m][n];
    }
}