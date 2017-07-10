public class Solution {
    /**
     * @param input an abstract file system
     * @return return the length of the longest absolute path to file
     */
    public int lengthLongestPath(String input) {
    	String[] dirs = input.split("\n");
    	int[] lengs = new int[dirs.length + 1];
    	lengs[0] = 0;
    	int longest = 0;

    	for (String s : dirs) {
    		int level = s.lastIndexOf("\t") + 1;
    		int currLen = lengs[level] + s.length() - level + 1;
    		lengs[level + 1] = currLen;
    		if (s.contains(".")) {
    			longest = Math.max(longest, currLen - 1);
    		}
    	}

    	return longest;
    }
}