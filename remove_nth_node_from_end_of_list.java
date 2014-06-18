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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null) return null;
        int m = n + 1;
        ListNode p = head;
        while(p!=null&&m>0){
            m -= 1;
            p = p.next;
        }
        if(m>0) return head.next;
        ListNode q = head;
        while(p!=null){
            q = q.next;
            p = p.next;
        }
        q.next = q.next.next;
        return head;
    }
}
