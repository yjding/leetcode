# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    # @param head, a ListNode
    # @param k, an integer
    # @return a ListNode
    def rotateRight(self, head, k):
        if k == 0 or not head: return head
        p = q = head
        for i in range(k):
            p = p.next if p.next else head
        if p == head: return head
        while p.next:
            p = p.next
            q = q.next
        tail, new_tail = p, q
        new_head = new_tail.next
        new_tail.next = None
        tail.next = head
        return new_head
