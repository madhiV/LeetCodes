# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.temp=None
    def inorderTraversal(self, node):
        if node!=None:
            self.inorderTraversal(node.left)
            node.left=None
            self.temp.right=node
            self.temp=node
            self.inorderTraversal(node.right)
    def increasingBST(self, root: TreeNode) -> TreeNode:
        n=self.temp=TreeNode(None)
        self.inorderTraversal(root)
        return n.right
