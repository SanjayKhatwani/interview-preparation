public class Solution {

    public int shortestWordDistance(String[] words, String word1, String word2) {
        int dist = Integer.MAX_VALUE;
        int lastIndex = -1;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1) || words[i].equals(word2)) {
                if (lastIndex >= 0 && (!words[i].equals(words[lastIndex]) || word1.equals(word2))) {
                    dist = Math.min(dist, i - lastIndex);
                }
                lastIndex = i;
            }
        }
        return dist;
    }
    
}