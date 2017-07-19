public class WordDictionary {
    
    class TrieNode {
        char val;
        Map<Character, TrieNode> nexts;
        boolean isEnd;
        public TrieNode(char val) {
            this.val = val;
            nexts = new HashMap<>();
        }
    }
    
    TrieNode root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode(' ');
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        char[] chs = word.toCharArray();
        TrieNode curr = root;
        for (char c : chs) {
            if (!curr.nexts.containsKey(c)) {
                curr.nexts.put(c, new TrieNode(c));
            }
            curr = curr.nexts.get(c);
        }
        curr.isEnd = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return helper(word.toCharArray(), 0, root);
    }
    
    private boolean helper(char[] chs, int offset, TrieNode node) {
        if (offset == chs.length) 
            return node.isEnd;
        char c = chs[offset];
        if (c != '.' && node.nexts.containsKey(c)) {
            return helper(chs, offset + 1, node.nexts.get(c));
        } else if (c == '.') {
            for (Map.Entry<Character, TrieNode> entry : node.nexts.entrySet()) {
                if (helper(chs, offset + 1, entry.getValue())) 
                    return true;
            }
        }
        return false;
    }
}