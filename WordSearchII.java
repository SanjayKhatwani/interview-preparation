public class Solution {

    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        TrieNode root = buildTrie(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs (board, i, j, root, res);
            }
        }
        return res;
    }
    
    public void dfs(char[][] board, int i, int j, TrieNode root, List<String> res) {
        char c = board[i][j];
        if (c >= 256 || root.next[c - 'a'] == null) return;
        root = root.next[c - 'a'];
        if (root.word != null) {   // found one
            res.add(root.word);
            root.word = null;     // de-duplicate
        }
    
        board[i][j] ^= 256;
        if (i > 0) dfs(board, i - 1, j ,root, res); 
        if (j > 0) dfs(board, i, j - 1, root, res);
        if (i < board.length - 1) dfs(board, i + 1, j, root, res); 
        if (j < board[0].length - 1) dfs(board, i, j + 1, root, res); 
        board[i][j] ^= 256;
    }
    
    public TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String w : words) {
            TrieNode p = root;
            for (char c : w.toCharArray()) {
                int i = c - 'a';
                if (p.next[i] == null) p.next[i] = new TrieNode();
                p = p.next[i];
           }
           p.word = w;
        }
        return root;
    }
    
    class TrieNode {
        TrieNode[] next = new TrieNode[26];
        String word;
    }

}