public class Solution {
    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0) return false;
        for (int i = 0; i < board.length; i++) 
            for (int j = 0; j < board[0].length; j++)
                if (board[i][j] == word.charAt(0))
                    if (helper(board, word.toCharArray(), i, j, 0))
                        return true;
        return false;
    }
    
    private boolean helper(char[][] board, char[] word, int r, int l, int index) {
        if (index == word.length) return true;
        if (r < 0 || r >= board.length || l < 0 || l >= board[0].length || board[r][l] != word[index]) return false;
        board[r][l] ^= 256;
        boolean res = helper(board, word, r + 1, l, index + 1)
                        || helper(board, word, r - 1, l, index + 1)
                        || helper(board, word, r, l + 1, index + 1)
                        || helper(board, word, r, l - 1, index + 1);
        board[r][l] ^= 256;
        return res;
    }
}