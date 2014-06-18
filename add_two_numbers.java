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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p=l1, q=l2, head=null, r=null;
        boolean overflow = false;
        while(p!=null&&q!=null){
            int sum = p.val + q.val + (overflow?1:0);
            overflow = false;
            if(sum>=10){
                overflow = true;
                sum -= 10;
            }
            ListNode resultNode = new ListNode(sum);
            if(head==null){
                head = resultNode;
                r = resultNode;
            }
            else{
                r.next = resultNode;
                r = r.next;
            }
            // increment
            p = p.next;
            q = q.next;
        }
        while(p!=null){
            int sum = p.val + (overflow?1:0);
            overflow = false;
            if(sum>=10){
                overflow = true;
                sum -= 10;
            }
            ListNode resultNode = new ListNode(sum);
            if(head==null){
                head = resultNode;
                r = resultNode;
            }
            else{
                r.next = resultNode;
                r = r.next;
            }
            p = p.next;
        }
        while(q!=null){
            int sum = q.val + (overflow?1:0);
            overflow = false;
            if(sum>=10){
                overflow = true;
                sum -= 10;
            }
            ListNode resultNode = new ListNode(sum);
            if(head==null){
                head = resultNode;
                r = resultNode;
            }
            else{
                r.next = resultNode;
                r = r.next;
            }
            q = q.next;
        }
        if(overflow){
            ListNode resultNode = new ListNode(1);
            r.next = resultNode;
            r = r.next;
            overflow = false;
        }
        return head;
    }
}
