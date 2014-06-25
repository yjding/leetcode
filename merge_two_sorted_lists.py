# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    # @param two ListNodes
    # @return a ListNode
    def mergeTwoLists(self, l1, l2):
        head, tail = None, None
        while l1 and l2:
            if l1.val < l2.val:
                t = l1
                l1 = l1.next
            else:
                t = l2
                l2 = l2.next
            if not head:
                head, tail = t, t
                t.next = None
            else:
                tail.next = t
                tail = t
                t.next = None
        if l1:
            if not head:
                head = l1
            else:
                tail.next = l1
        if l2:
            if not head:
                head = l2
            else:
                tail.next = l2
        return head
