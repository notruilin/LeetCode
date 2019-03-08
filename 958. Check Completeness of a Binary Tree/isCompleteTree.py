# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def isCompleteTree(self, root: TreeNode) -> bool:
        import queue
        noNodeFromNow = False
        q = queue.Queue()
        q.put(root)
        while not q.empty():
            node = q.get()
            
            if node and noNodeFromNow:
                return False
            if not node:
                noNodeFromNow = True
            else:
                q.put(node.left)
                q.put(node.right)
                
        return True
