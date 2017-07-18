public class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) return 0;

        int h = haystack.length();
        int n = needle.length();

        if (n > h) return -1;
        if (n == 0) return 0;

        int[] next = getNext(needle);
        int i = 0;

        while (i <= h - n) {
            if (needle.charAt(0) != haystack.charAt(i)) {
                i++;
            } else {
                boolean success = true;
                for (int j = 0; j < n; j++) {
                    if (needle.charAt(j) != haystack.charAt(i + j)) {
                        success = false;
                        i += j - next[j - 1];
                        break;
                    }
                }
                if (success)
                return i;
            }
        }

        return -1;
    }

    //calculate KMP array
    public int[] getNext(String s) {
        int[] next = new int[s.length()];

        for (int i = 1; i < s.length(); i++) {
            int index = next[i - 1];
            while (index > 0 && s.charAt(index) != s.charAt(i)) {
                index = next[index - 1];
            }
            if (s.charAt(index) == s.charAt(i)) {
                next[i] = index + 1;
            } else {
                next[i] = 0;
            }
        }

        return next;
    }
}