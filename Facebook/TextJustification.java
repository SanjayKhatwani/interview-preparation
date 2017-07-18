public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> lines = new ArrayList<>();
    	if (words == null || words.length == 0)
    		return lines;
    	
    	int index = 0;	
    	while (index < words.length) {
    		int count = words[index].length();
    		int last = index + 1;
    		while (last < words.length) {
    			if (count + 1 + words[last].length() > maxWidth)
    				break;
    			count += (1 + words[last].length());
    			last++;
    		}
    		
    		StringBuilder builder = new StringBuilder();
    		builder.append(words[index]);
    		int diff = last - index - 1;
    		
    		//if last line or number of words in the line is 1, left-justify it
    		if (last == words.length  || diff == 0) {
    			for (int i = index+1; i < last; i++) {
    				builder.append(" ");
    				builder.append(words[i]);
    			}
    			for (int i = builder.length(); i < maxWidth; i++)
    				builder.append(" ");
    		} else {
    			//middle justified
    			int spaces = (maxWidth - count) / diff;
    			int residue = (maxWidth - count) % diff;
    			for (int i = index + 1; i < last; i++) {
    				for (int k = 0; k < spaces; k++)
    					builder.append(" ");
    				if (residue > 0) {
    					builder.append(" ");
    					residue--;
    				}
    				builder.append(" ");
    				builder.append(words[i]);
    			}
    		}
    		lines.add(builder.toString());
    		index = last;
    	}
    	return lines;
    }
}