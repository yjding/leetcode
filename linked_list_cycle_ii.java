/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head, p=null;
        while(fast!=null&&fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                p = fast;
                break;
            }
        }
        if(fast==null||fast.next==null) return null;
        ListNode q = head;
        while(p!=q){
            p = p.next;
            q = q.next;
        }
        return p;
    }
}
