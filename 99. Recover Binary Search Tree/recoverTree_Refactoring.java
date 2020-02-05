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
    TreeNode x, y, last;
    
    private void dfs(TreeNode node) {
        if (node == null)   return;
        dfs(node.left);
        if (last.val > node.val && x == null) {
            x = last;
            y = node;
        }
        else {
            if (last.val > node.val)    y = node;
        }
        last = node;
        dfs(node.right);
    }
    
    private void swap(TreeNode x, TreeNode y) {
        if (x == null || y == null) return;
        int tmp = x.val;
        x.val = y.val;
        y.val = tmp;
    }
    
    public void recoverTree(TreeNode root) {
        last = new TreeNode(Integer.MIN_VALUE);
        dfs(root);
        swap(x, y);
    }
}
