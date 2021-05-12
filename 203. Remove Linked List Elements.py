# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def removeElements(self, head: ListNode, val: int) -> ListNode:
        p=old=head
        while head!=None and head.val==val:
            head=head.next
            p=head
        while p!=None:
            if p.val==val:
                old.next=p.next
                p=p.next
                continue
            old=p
            p=p.next
        return head
