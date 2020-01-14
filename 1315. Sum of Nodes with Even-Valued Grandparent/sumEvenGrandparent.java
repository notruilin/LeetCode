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
    int sum = 0;
    
    void addAllChildren(TreeNode node) {
        if (node == null)  return;
        if (node.left != null)  sum += node.left.val;
        if (node.right != null)  sum += node.right.val;
    }
    
    void dfs(TreeNode node) {
        if (node == null)   return;
        if (node.val % 2 == 0) {
            addAllChildren(node.left);
            addAllChildren(node.right);
        }
        dfs(node.left);
        dfs(node.right);
    }
    
    public int sumEvenGrandparent(TreeNode root) {
        dfs(root);
        return sum;
    }
}
