/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) {
 *         label = x;
 *         neighbors = new ArrayList<DirectedGraphNode>();
 *     }
 * };
 */
public class Solution {
   /**
     * @param graph: A list of Directed graph node
     * @param s: the starting Directed graph node
     * @param t: the terminal Directed graph node
     * @return: a boolean value
     */
    public boolean hasRoute(ArrayList<DirectedGraphNode> graph, 
                            DirectedGraphNode s, DirectedGraphNode t) {
        if (s == t) return true;
        Queue<DirectedGraphNode> qs = new LinkedList<>();
        Set<DirectedGraphNode> visited = new HashSet<>();
        qs.offer(s);
        visited.add(s);
        while (!qs.isEmpty()) {
            DirectedGraphNode curr = qs.poll();
            for (DirectedGraphNode node : curr.neighbors) {
                if (node == t) return true;
                if (!visited.contains(node)) {
                    qs.offer(node);
                    visited.add(node);
                }
            }
        }
        return false;
    }
}