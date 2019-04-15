# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def maxAncestorDiff(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        self.ans = -1
        
        def dfs(node, minn, maxx):
            if not minn == 100001:
                self.ans = max(self.ans, abs(node.val - minn))
            if not maxx == -1:
                self.ans = max(self.ans, abs(node.val - maxx))
            if node.left:
                dfs(node.left, min(minn, node.val), max(maxx, node.val))
            if node.right:
                dfs(node.right, min(minn, node.val), max(maxx, node.val))
        
        dfs(root, 100001, -1)
        return self.ans
    
