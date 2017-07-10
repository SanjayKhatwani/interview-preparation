public class Solution {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // edge case check
        if (!wordList.contains(endWord)) return 0; 
        if (beginWord.equals(endWord)) return 1; // what if two words already equal?
        
        int len = 2;
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
	    Set<String> dict = new HashSet<String>(wordList); // has to convert it to set because set use O(1) to contains and remove, but List use O(n). because hashset is like a hashtable. 考点！！！

        beginSet.add(beginWord);
	    endSet.add(endWord);
	    dict.remove(endWord);
	    
	    while (!beginSet.isEmpty() && !endSet.isEmpty()) {
	        
		    if (beginSet.size() > endSet.size()) { // store shorter end to beginSet, and compute it
			    Set<String> set = beginSet;
			    beginSet = endSet;
			    endSet = set;
		    }

		    Set<String> temp = new HashSet<>(); // store value temporarily
		    for (String word : beginSet) {
			    char[] chs = word.toCharArray();

			    for (int i = 0; i < chs.length; i++) {
			        char old = chs[i];
				    for (char c = 'a'; c <= 'z'; c++) {
					    chs[i] = c;
					    String target = String.valueOf(chs);

					    if (endSet.contains(target)) {
						    return len;
					    }
 
					    if (dict.contains(target)) { 
						    temp.add(target);
						    dict.remove(target);
					    }
					    
				    }
				    chs[i] = old;
			    }
		    }

		    beginSet = temp;
		    len++;
	    }
	
	    return 0; // or exception
    }

}