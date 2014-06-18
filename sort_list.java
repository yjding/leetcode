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
    public ListNode merge(ListNode h1, ListNode h2){
        ListNode h3=null, t3=null;
        //initial assignment
        if(h1.val<h2.val){
            h3=h1;
            h1=h1.next;
            t3=h3;
        }else{
            h3=h2;
            h2=h2.next;
            t3=h3;
        }
        while(h1!=null&&h2!=null){
            if(h1.val<h2.val){
                t3.next=h1;
                t3=t3.next;
                h1=h1.next;
            }else{
                t3.next=h2;
                t3=t3.next;
                h2=h2.next;
            }
        }
        while(h1!=null){
            t3.next=h1;
            t3=t3.next;
            h1=h1.next;
        }
        while(h2!=null){
            t3.next=h2;
            t3=t3.next;
            h2=h2.next;
        }
        t3.next = null;
        return h3;
    }
    public ListNode sortList(ListNode head) {
        if(head==null) return head;
        if(head.next==null) return head;
        ListNode p1=head, p2=head, p3=head;
        int count = 1;
        while(p2!=null){
            if(count>1){
                p3=p3.next;
            }
            count += 1;
            p1=p1.next;
            p2=p2.next;
            if(p2!=null) p2=p2.next;
        }
        p3.next=null;
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(p1);
        return merge(l1, l2);
    }
}
