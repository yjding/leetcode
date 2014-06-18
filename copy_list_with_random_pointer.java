/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
import java.util.Hashtable;
public class Solution {
    private Hashtable<RandomListNode, RandomListNode> dict = new Hashtable<RandomListNode, RandomListNode>();
    
    RandomListNode copyList(RandomListNode head){
        if(head==null) return null;
        RandomListNode copyNode = new RandomListNode(head.label);
        copyNode.next = copyList(head.next);
        dict.put(head, copyNode);
        return copyNode;
    }
    
    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode copy = copyList(head), p = head, q = copy;
        while(p!=null){
            if(p.random==null)
                q.random = null;
            else
                q.random = dict.get(p.random);
            p = p.next;
            q = q.next;
        }
        return copy;
    }
}
