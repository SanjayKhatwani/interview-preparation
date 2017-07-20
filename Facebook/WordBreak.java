public class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        return dfs(s, wordDict, new HashMap<String, List<String>>());
    }
    
    private List<String> dfs(String s, List<String> dict, Map<String, List<String>> memo) {
        if (memo.containsKey(s)) return memo.get(s);
        List<String> list = new ArrayList<>();
        if (s.length() == 0) {
            list.add("");
            return list;
        }
        for (String word : dict) {
            if (s.startsWith(word)) {
                List<String> subList = dfs(s.substring(word.length()), dict, memo);
                for (String sub : subList) {
                    list.add(word + (sub.length() == 0 ? "" : " ") + sub);
                }
            }
        }
        memo.put(s, list);
        return list;
    }
}


public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}