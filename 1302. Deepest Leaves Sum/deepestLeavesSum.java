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
    
    int deepest = -1, tryD = -1, sum = 0;
    
    void dfs(TreeNode node, int depth) {
        if (node == null)   return;
        tryD = Math.max(tryD, depth);
        if (depth == deepest)
            sum += node.val;
        dfs(node.left, depth + 1);
        dfs(node.right, depth + 1);
    }
    
    public int deepestLeavesSum(TreeNode root) {
        dfs(root, 0);
        deepest = tryD;
        dfs(root, 0);
        return sum;
    }
}
