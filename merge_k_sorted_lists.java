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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        ListNode head=null, p=null;
        while(l1!=null&&l2!=null){
            if(l1.val<l2.val){
                if(head==null){
                    head = l1;
                }else{
                    p.next = l1;
                }
                p = l1;
                l1 = l1.next;
            }
            else{
                if(head==null){
                    head = l2;
                }else{
                    p.next = l2;
                }
                p = l2;
                l2 = l2.next;
            }
        }
        while(l1!=null){
            if(head==null){
                head = l1;
            }else{
                p.next = l1;
            }
            p = l1;
            l1 = l1.next;
        }
        while(l2!=null){
            if(head==null){
                head = l2;
            }else{
                p.next = l2;
            }
            p = l2;
            l2 = l2.next;
        }
        return head;
    }
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        int k = lists.size();
        if(k==0) return null;
        else if(k==1) return lists.get(0);
        else if(k==2) return mergeTwoLists(lists.get(0), lists.get(1));
        int mid = k/2;
        ArrayList<ListNode> leftHalf = new ArrayList<ListNode>();
        ArrayList<ListNode> rightHalf = new ArrayList<ListNode>();
        for(int i=0;i<mid;i++) leftHalf.add(lists.get(i));
        for(int i=mid;i<k;i++) rightHalf.add(lists.get(i));
        return mergeTwoLists(mergeKLists(leftHalf), mergeKLists(rightHalf));
    }
}
