/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private TreeNode ans = null;
    private int maxDepth = 0;
    
    private int subTreeDepth(TreeNode node, int depth) {
        if (node == null)   return 0;
        maxDepth = Math.max(maxDepth, depth);
        int leftDepth = Math.max(subTreeDepth(node.left, depth + 1), depth);
        int rightDepth = Math.max(subTreeDepth(node.right, depth + 1), depth);
        if (leftDepth == maxDepth && rightDepth == maxDepth)    ans = node;
        return Math.max(leftDepth, rightDepth);
    }
    
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        subTreeDepth(root, 0);
        return ans;
    }
}
