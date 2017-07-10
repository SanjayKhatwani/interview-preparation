/*
Given a string of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators. The valid operators are +, - and *.


Example 1
Input: "2-1-1".

((2-1)-1) = 0
(2-(1-1)) = 2
Output: [0, 2]


Example 2
Input: "2*3-4*5"

(2*(3-(4*5))) = -34
((2*3)-(4*5)) = -14
((2*(3-4))*5) = -10
(2*((3-4)*5)) = -10
(((2*3)-4)*5) = 10
Output: [-34, -14, -10, -10, 10]
*/

public class Solution {

    public List<Integer> diffWaysToCompute(String input) {
        return helper(input, new HashMap<String, List<Integer>>()); 
    }

    private List<Integer> helper(String s, Map<String, List<Integer>> map){
        if (map.containsKey(s))
            return map.get(s);
        
        List<Integer> result = new ArrayList<Integer>();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> left = helper(s.substring(0, i), map);
                List<Integer> right = helper(s.substring(i + 1), map);
                
                for (int l : left)
                    for (int r : right) {
                        if (c == '+')
                            result.add(l + r);
                        else if (c == '-')
                            result.add(l - r);
                        else
                            result.add(l * r);
                    }
            }
        }
        if (result.size() == 0)
            result.add(Integer.valueOf(s));
        
        map.put(s, result);
        
        return result;
    }
    
}