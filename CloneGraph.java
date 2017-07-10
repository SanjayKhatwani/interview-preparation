/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) 
            return node;
            
        Map<Integer, UndirectedGraphNode> map = new HashMap<>();
        Deque<UndirectedGraphNode> queue = new ArrayDeque<>();
        
        UndirectedGraphNode copyNode = new UndirectedGraphNode(node.label);
        map.put(node.label, copyNode);
        queue.offer(node);
        
        while (!queue.isEmpty()) {
            UndirectedGraphNode currNode = queue.poll();
            for (UndirectedGraphNode neighbor: currNode.neighbors) {
                if (! map.containsKey(neighbor.label)) {
                    UndirectedGraphNode copyNeighbor = new UndirectedGraphNode(neighbor.label);
                    map.put(neighbor.label, copyNeighbor);
                    queue.offer(neighbor);
                } 
                map.get(currNode.label).neighbors.add(map.get(neighbor.label));
            }
        }
        return copyNode;
    }
}


public class Solution {
    Map<Integer, UndirectedGraphNode> map = new HashMap<>();
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        return clone(node);
    }
    
    private UndirectedGraphNode clone(UndirectedGraphNode node) {
        if (node == null) return null;  // return null
        
        UndirectedGraphNode value = map.get(node.label);
        if (value != null) return value;
        
        UndirectedGraphNode cur = new UndirectedGraphNode (node.label);
        map.put(cur.label, cur);
        for (UndirectedGraphNode neighbor : node.neighbors) {  // 不用while 用recuresive把所有点都遍历完
            cur.neighbors.add(clone(neighbor));
        }
        return cur;
    }
}