public class Solution {

    public List<String> wordBreak(String s, List<String> dict) {
        return DFS(s, dict, new HashMap<>());
    }       
    
    // DFS function returns an array including all substrings derived from s.
    List<String> DFS(String s, List<String> dict, Map<String, List<String>> memo) {
        if (memo.containsKey(s)) 
            return memo.get(s);
        
        List<String> res = new LinkedList<>();     
        if (s.length() == 0) {
            res.add("");
            return res;
        }
        for (String word : dict) {
            if (s.startsWith(word)) {
                List<String> sublist = DFS(s.substring(word.length()), dict, memo);
                for (String sub : sublist) 
                    res.add(word + (sub.isEmpty() ? "" : " ") + sub);               
            }
        }
        memo.put(s, res);
        return res;
    }
    
}