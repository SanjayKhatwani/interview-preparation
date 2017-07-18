/*
"123", 6 -> ["1+2+3", "1*2*3"] 
"232", 8 -> ["2*3+2", "2+3*2"]
"105", 5 -> ["1*0+5","10-5"]
"00", 0 -> ["0+0", "0-0", "0*0"]
"3456237490", 9191 -> []
*/

public class Solution {

    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        if (num == null || num.length() == 0) 
            return res;
        helper(res, "", target, num, 0, 0, 0);
        return res;
    }
    
    private void helper(List<String> res, String path, int target, String num, int offset, long eval, long multVal) {
        if (offset == num.length()) {
            if (eval == target) res.add(path);
            return;
        }
        for (int i = offset; i < num.length(); i++) {
            if (i > offset && num.charAt(offset) == '0') break;
            long currNum = Long.parseLong(num.substring(offset, i + 1));
            if (offset == 0) {
                helper(res, "" + currNum, target, num, i + 1, currNum, currNum);
            } else {
                helper(res, path + "+" + currNum, target, num, i + 1, eval + currNum, currNum);
                helper(res, path + "-" + currNum, target, num, i + 1, eval - currNum, -currNum);
                helper(res, path + "*" + currNum, target, num, i + 1, eval - multVal + multVal * currNum, multVal * currNum);
            }
        }
    }

}