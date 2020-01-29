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
    private int ans = 0;
    
    private int dfs(TreeNode node) {
        if (node == null)   return -1;
        int leftDis = dfs(node.left) + 1;
        int rightDis = dfs(node.right) + 1;
        ans = Math.max(ans, leftDis + rightDis);
        return Math.max(leftDis, rightDis);
    }
    
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return ans;
    }
}
