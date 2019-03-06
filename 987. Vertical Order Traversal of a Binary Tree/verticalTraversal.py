# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def verticalTraversal(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        mapping = [[] for _ in range(2001)]
        
        def dfs(node, x, y):
            if not node: return
            mapping[x].append((node.val, -y))
            dfs(node.left, x-1, y-1)
            dfs(node.right, x+1, y-1)
        
        dfs(root, 1000, 1000)
        ans = []
        for i in range(2001):
            if len(mapping[i]):
                new = sorted(mapping[i], key = lambda x:(x[1], x[0]))
                f = []
                for x in new:
                    f.append(x[0])
                ans.append(f)
        return ans
            
