public class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int i = 0, j = 0;
        while (i < word.length() && j < abbr.length()) {
            if (word.charAt(i) == abbr.charAt(j)) {
                i++;
                j++;
            } else {
                if (abbr.charAt(j) <= '0' || abbr.charAt(j) > '9') {  // 注意等于0也应return false， 因为数字不能以0开始
                    return false;
                }
                int start = j;
                while (j < abbr.length() && abbr.charAt(j) >= '0' && abbr.charAt(j) <= '9') {
                    ++j;
                }
                int num = Integer.valueOf(abbr.substring(start, j));
                i += num;
            }
        }
        return i == word.length() && j == abbr.length();
    }
}