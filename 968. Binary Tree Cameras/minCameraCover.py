# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def minCameraCover(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        
        def dfs(node):
            # selfCam, childrenCam, parentCam
            if node == None:
                return [9999, 9999, 9999]
            left = dfs(node.left)
            right = dfs(node.right)
            tmp = [9999, 9999, 9999]
            if node.left != None and node.right != None:
                tmp = [min(left) + min(right) + 1, min(left[0]+min(right[0:2]), right[0]+min(left[0:2])), min(left[0:2])+min(right[0:2])]
            elif node.left == None and node.right != None:
                tmp = [min(right) + 1, right[0], min(right[0:2])]
            elif node.right == None and node.left != None:
                tmp = [min(left) + 1, left[0], min(left[0:2])]
            else:
                tmp = [1, 9999, 0]
            return tmp
        
        ans = dfs(root)
        return min(ans[0],ans[1])            
