# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def recoverFromPreorder(self, S):
        """
        :type S: str
        :rtype: TreeNode
        """
        depth = []
        num = []
        i = 0
        while i < len(S):
            k = 0
            while i < len(S) and S[i] == '-':
                k += 1
                i += 1
            depth.append(k)
            s = ''
            while i < len(S) and S[i] >= '0' and S[i] <= '9':
                s += S[i]
                i += 1
            num.append(int(s))
        
        self.index = 0
        
        def dfs(dep):
            if self.index < len(depth) and depth[self.index] == dep + 1:
                node = TreeNode(num[self.index])
                self.index += 1
                node.left = dfs(dep + 1)
                node.right = dfs(dep + 1)
                return node
            else:
                return None
        
        root = dfs(-1)
        return root
