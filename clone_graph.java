/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
import java.util.HashSet;
import java.util.Hashtable;
import java.util.ArrayDeque;

public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node==null) return null;
        HashSet<UndirectedGraphNode> handled = new HashSet<UndirectedGraphNode>();
        Hashtable<UndirectedGraphNode, UndirectedGraphNode> map = new Hashtable<UndirectedGraphNode, UndirectedGraphNode>();
        ArrayDeque<UndirectedGraphNode> queue = new ArrayDeque<UndirectedGraphNode>();
        
        queue.add(node);
        while(!queue.isEmpty())
        {
            UndirectedGraphNode currNode = queue.remove();
            if(handled.contains(currNode)) continue;
            UndirectedGraphNode copyNode;
            if(!map.containsKey(currNode)){
                copyNode = new UndirectedGraphNode(currNode.label);
                map.put(currNode, copyNode);
            }else{
                copyNode = map.get(currNode);
            }
            for(int i=0;i<currNode.neighbors.size();i++){
                UndirectedGraphNode neighbor = currNode.neighbors.get(i);
                if(!map.containsKey(neighbor)){
                    map.put(neighbor, new UndirectedGraphNode(neighbor.label));
                }
                copyNode.neighbors.add(map.get(neighbor));
                if(!handled.contains(neighbor))
                    queue.add(neighbor);
            }
            handled.add(currNode);
        }
        return map.get(node);
    }
}
