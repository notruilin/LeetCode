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
    int count = 0;
    
    private void dfs(TreeNode node) {
        if (node == null)   return;
        ++count;
        dfs(node.left);
        dfs(node.right);
    }
    
    public int countNodes(TreeNode root) {
        dfs(root);
        return count;
    }
}
