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
    public ListNode insertionSortList(ListNode head) {
        if(head==null) return head;
        ListNode start=head, end=head, p=end.next;
        while(p!=null){
            ListNode pre_n=null, n=start;
            while(n!=end.next){
                if(p.val<n.val){
                    if(pre_n==null){
                        end.next=p.next;
                        p.next=start;
                        start=p;
                    }else{
                        end.next=p.next;
                        pre_n.next=p;
                        p.next=n;
                    }
                    break;
                }
                pre_n=n;
                n=n.next;
            }
            if(n==end.next){
                end=end.next;
            }
            p=end.next;
        }
        return start;
    }
}
