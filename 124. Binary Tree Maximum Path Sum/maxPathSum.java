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
    private int ans = Integer.MIN_VALUE;
    
    private int dfs(TreeNode node) {
        if (node == null)   return 0;
        int maxLeft = Math.max(0, dfs(node.left));
        int maxRight = Math.max(0, dfs(node.right));
        ans = Math.max(ans, maxLeft+maxRight+node.val);
        return Math.max(maxLeft, maxRight) + node.val;
    }
    
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return ans;
    }
}
