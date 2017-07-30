public class Solution {
    public String removeDuplicateLetters(String s) {
        int[] count = new int[26];
        boolean[] visited = new boolean[26];
        char[] chs = s.toCharArray();
        for (char c : chs) {
            count[c - 'a']++;
        }
        Deque<Character> deque = new LinkedList<>();
        for (char c : chs) { 
            int index = c - 'a';
            count[index]--; 
            if (visited[index]) continue;
            //if current character is smaller than last character in stack which occurs later in the string again
            //it can be removed and  added later e.g stack = bc remaining string abc then a can pop b and then c
            while (!deque.isEmpty() && c < deque.peek() && count[deque.peek() - 'a'] != 0) { 
                visited[deque.pop() - 'a'] = false;
            }
            deque.push(c); //add current character and mark it as visited
            visited[index] = true;
        }

        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            sb.append(deque.pop());
        }
        return sb.reverse().toString();
    }
}