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
    public boolean flipEquiv(TreeNode node1, TreeNode node2) {
        if (node1 == null || node2 == null) return node1 == node2;
        return node1.val == node2.val && ((flipEquiv(node1.left, node2.left) && flipEquiv(node1.right, node2.right)) 
            || (flipEquiv(node1.left, node2.right) && flipEquiv(node1.right, node2.left)));
    }
}
