/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head==null) return head;
        ListNode p = head, q=null, r=null;
        if(head.next==null) return head;
        else head = head.next;
        //swap first pair
        q = p.next;
        if(q==null) return head;
        r = q.next;
        //swap p, q
        q.next = p;
        p.next = swapPairs(r);
        return head;
    }
}
