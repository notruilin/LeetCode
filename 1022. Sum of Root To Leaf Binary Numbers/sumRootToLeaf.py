# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def sumRootToLeaf(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        
        num = []
        
        def dfs(node, strB):
            if not node.left and not node.right:
                num.append(int(strB,2))
                return
            if node.left:
                dfs(node.left, strB + str(node.left.val))
            if node.right:
                dfs(node.right, strB + str(node.right.val))
            
        dfs(root, str(root.val))
        ans = 0
        for i in range(len(num)):
            ans = (ans + num[i]) % (10 ** 9 + 7)
        return ans
    
