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
    ListNode reverseKNodes(ListNode head, int k){
        ListNode p=head, q=p.next, r=q.next;
        while(q!=null&&k>1){
            r = q.next;
            q.next = p;
            p = q;
            q = r;
            k--;
        }
        head.next = null;
        return p;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null||k==1) return head;
        ListNode nextHead = head;
        int count = k;
        while(nextHead!=null&&count>0){
            nextHead = nextHead.next;
            count--;
        }
        if(count>0) return head;
        else{
            ListNode newHead = reverseKNodes(head, k);
            head.next = reverseKGroup(nextHead, k);
            return newHead;
        }
    }
}
