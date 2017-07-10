public class Solution {
    public List<String> findStrobogrammatic(int n) {
        return helper(n, n);
    }

    private List<String> helper(int currLen, int targetLen) {
        if (currLen == 0) return new ArrayList<String>(Arrays.asList(""));
        if (currLen == 1) return new ArrayList<String>(Arrays.asList("0", "1", "8"));

        List<String> res = new ArrayList<>();
        List<String> list = helper(currLen - 2, targetLen);
        for (String s : list) {
            if (currLen != targetLen) 
                res.add("0" + s + "0");
            res.add("1" + s + "1");
            res.add("6" + s + "9");
            res.add("8" + s + "8");
            res.add("9" + s + "6");
        }
        return res;
    }
}