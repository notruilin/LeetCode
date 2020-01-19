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
    private TreeNode dfs(TreeNode node, int target) {
        if (node == null)   return null;
        node.left = dfs(node.left, target);
        node.right = dfs(node.right, target);
        if (node.left == null && node.right == null)
            if (node.val == target)
                return null;
        return node;
    }
    
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        root = dfs(root, target);
        return root;
    }
}
