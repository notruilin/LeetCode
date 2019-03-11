# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def bstFromPreorder(self, preorder: List[int]) -> TreeNode:
        def dfs(lst):
            if not len(lst):    return None
            x = lst[0]
            node = TreeNode(x)
            i = 1
            while i < len(lst) and lst[i] < x:
                i += 1
            node.left = dfs(lst[1:i])
            node.right = dfs(lst[i:len(lst)])
            return node
        
        root = dfs(preorder)
        return root
        
