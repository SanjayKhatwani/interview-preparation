public class Solution {

    public List<String> removeInvalidParentheses(String s) {
		List<String> res = new ArrayList<>();
	
        char[] par = {'(', ')'};
        dfs(s, res, 0, 0, par);

        return res;
    }

	public void dfs(String s, List<String> res, int last_i, int last_j, char[] par) {
		int stack = 0;
		
		for (int i = last_i; i < s.length(); i++) {
			if (s.charAt(i) == par[0]) stack++;
			if (s.charAt(i) == par[1]) stack--;
			if (stack < 0) {
				for (int j = last_j; j <= i; j++) {
					if (s.charAt(j) == par[1] && (j == last_j || s.charAt(j - 1) != par[1])) {
						//下一次还应该从i和j开始，不是i+1和j+1.因为字符串长度已经减1了
						dfs(s.substring(0, j) + s.substring(j + 1, s.length()), res, i, j, par);
					}
				}
				return; // 很重要， 此处必须return
			}
		}

		//到这里说明上面的for循环里没有return，右括号的问题已经没了，该检查'('
		String reversed = new StringBuilder(s).reverse().toString();//当括号的问题解决完之后，会再次反转，这时候就是对的了
		if (par[0] == '(') {
			//说明右扩号的问题已经解决完毕，开始解决左括号
			char[] par1 = {')', '('};
			dfs(reversed, res, 0, 0, par1);
		} else {
			//说明左括号的问题也解决了
			res.add(reversed);
		}
		
	}

}


// Bfs solution
public class Solution {
    public List<String> removeInvalidParentheses(String s) {
      	List<String> res = new ArrayList<>();
      
      	// sanity check
      	if (s == null) return res;
      
      	Set<String> visited = new HashSet<>();
      	Queue<String> queue = new LinkedList<>();
      
      	// initialize
      	queue.add(s);
      	visited.add(s);
      
      	boolean found = false;
      
      	while (!queue.isEmpty()) {
        	s = queue.poll();
        	if (isValid(s)) {
          		// found an answer, add to the result
          		res.add(s);
          		found = true;
        	}
      
        	if (!found) {
	        	// generate all possible states
	        	for (int i = 0; i < s.length(); i++) {
	          		// we only try to remove left or right paren
	          		if (s.charAt(i) != '(' && s.charAt(i) != ')') continue;
	        
	          		String t = s.substring(0, i) + s.substring(i + 1);
	          		if (! visited.contains(t)) {
	            		// for each state, if it's not visited, add it to the queue
	            		queue.add(t);
	            		visited.add(t);
	          		}
	        	}
	        }
      	}
      
      	return res;
    }
    
    // helper function checks if string s contains valid parantheses
    boolean isValid(String s) {
      	int count = 0;
      	for (int i = 0; i < s.length(); i++) {
        	char c = s.charAt(i);
        	if (c == '(') count++;
        	if (c == ')' && count-- == 0) return false;
      	}  
      	return count == 0;
    }
}