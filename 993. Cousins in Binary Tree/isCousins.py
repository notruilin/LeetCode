# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        family = {}
        
        def dfs(node, father):
            if not node: return
            if father:
                family[node.val] = [str(father), family[father.val][1]+1]
            dfs(node.left, node)
            dfs(node.right, node)
        
        family[root.val] = [None, 0]
        dfs(root, None)
        return family[x][1] == family[y][1] and family[x][0] != family[y][0]
