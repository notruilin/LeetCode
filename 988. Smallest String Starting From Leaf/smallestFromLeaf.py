# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def smallestFromLeaf(self, root):
        """
        :type root: TreeNode
        :rtype: str
        """
        
        words = []
        
        def toChar(num):
            return chr(ord('a')+num)
        
        def dfs(node, word):
            if not node:
                return
            word = word + toChar(node.val)
            if not node.left and not node.right:
                words.append("".join(reversed(word)))
                return
            dfs(node.left, word)
            dfs(node.right, word)
        
        dfs(root, "")
        return min(words)
