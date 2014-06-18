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
    public void reorderList(ListNode head) {
        if(head==null) return;
        //cut
        ListNode slow=head, fast=head;
        while(fast!=null&&fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode insertList = slow.next;
        slow.next = null;
        
        if(insertList==null) return;
        
        //reverse
        ListNode p1 = insertList, p2 = insertList.next;
        p1.next = null;
        ListNode q = null;
        while(p2!=null){
            q = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = q;
        }
        insertList = p1;
        
        //insert
        ListNode p = head, tempq = null;
        q = insertList;
        while(q!=null){
            tempq = q.next;
            q.next = p.next;
            p.next = q;
            p = p.next.next;
            q = tempq;
        }
    }
}
