public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
	    List<String> result = new ArrayList<>();
 
    	int len = s.length();
    	if (len < 10) {
    		return result;
    	}
     
    	int[] map = new int[26];
    	// map['A' - 'A'] = 0;
    	map['C'-'A'] = 1;
    	map['G'-'A'] = 2;
    	map['T'-'A'] = 3;
     
    	Set<Integer> temp = new HashSet<>();
    	Set<Integer> added = new HashSet<>();
     
    	int hash = 0;
    	for (int i = 0; i < len; i++) {
    	    hash = (hash << 2) + map[s.charAt(i) - 'A'];
    		if (i >= 9) {
    			//make length of hash to be 20
    			hash = hash & ((1 << 20) - 1); 
    			if (temp.contains(hash) && !added.contains(hash)) {
    				result.add(s.substring(i - 9, i + 1));
    				added.add(hash); //track added
    			} else {
    				temp.add(hash);
    			}
    		}
     
    	}
     
    	return result;
	}
}
