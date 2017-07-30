public class Solution {
    public int maxProduct(String[] words) {
        if (words == null || words.length == 0)
            return 0;
        int len = words.length;
        int[] value = new int[len];
        for (int i = 0; i < len; i++) {
            char[] chs = words[i].toCharArray();
            for (int j = 0; j < chs.length; j++) {
                value[i] |= 1 << (chs[j] - 'a');
            }
        }
        int maxProduct = 0;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if ((value[i] & value[j]) == 0)
                    maxProduct = Math.max(maxProduct, words[i].length() * words[j].length());
            }
        }
        return maxProduct;
    }
}