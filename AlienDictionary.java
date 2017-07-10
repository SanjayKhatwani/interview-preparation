public class Solution {
    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();
        if (words.length == 0) return "";
        for (String word : words) {
            for (char c : word.toCharArray()) {
                indegree.put(c, 0);
            }
        }
        for (int i = 0; i < words.length - 1; i++) {
            char[] prev = words[i].toCharArray();
            char[] next = words[i + 1].toCharArray();
            for (int j = 0; j < prev.length && j < next.length; j++) {
                if (prev[j] != next[j]) {
                    Set<Character> neighbors = new HashSet<>();
                    if (graph.containsKey(prev[j])) {
                        neighbors = graph.get(prev[j]);
                    } else { 
                        graph.put(prev[j], neighbors);
                    }
                    if (!neighbors.contains(next[j])) {
                        neighbors.add(next[j]);
                        indegree.put(next[j], indegree.get(next[j]) + 1);
                    }
                    break;
                }
            }
        }
        StringBuilder builder = new StringBuilder();
        Queue<Character> queue = new LinkedList<>();
        for (Character c : indegree.keySet()) {
            if (indegree.get(c) == 0) {
                queue.offer(c);
            }
        }
        while (!queue.isEmpty()) {
            Character curr = queue.poll();
            builder.append(curr);
            if (graph.containsKey(curr)) {
                for (Character neighbor : graph.get(curr)) {
                    indegree.put(neighbor, indegree.get(neighbor) - 1);
                    if (indegree.get(neighbor) == 0)
                        queue.offer(neighbor);
                }
            }
        }
        if (builder.length() == indegree.size()) 
            return builder.toString();
        return "";
    }
}