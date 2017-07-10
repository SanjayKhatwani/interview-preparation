/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 * };
 */

public class Solution {
   
    public List<DirectedGraphNode> topSort(List<DirectedGraphNode> graph) {
        List<DirectedGraphNode> res = new ArrayList<>();
        Map<DirectedGraphNode, Integer> map = new HashMap();
        for (DirectedGraphNode node : graph) {
            for (DirectedGraphNode neighbor : node.neighbors) {
                map.put(neighbor, map.getOrDefault(neighbor) + 1);
            }
        }

        Queue<DirectedGraphNode> q = new LinkedList<>();
        for (DirectedGraphNode node : graph) {
            // if map doesn't contain node, the indegree of this node is 0
            if (! map.containsKey(node)) {
                q.offer(node);
                res.add(node);
            }
        }

        while (! q.isEmpty()) {
            DirectedGraphNode node = q.poll();
            for (DirectedGraphNode n : node.neighbors) {
                map.put(n, map.get(n) - 1);
                if (map.get(n) == 0) {
                    res.add(n);
                    q.offer(n);
                }
            }
        }
        return res;
    }
}