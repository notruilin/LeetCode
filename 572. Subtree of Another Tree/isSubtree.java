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
    boolean exist = false;
    
    boolean check(TreeNode node1, TreeNode node2) {
        if (node1 == node2) return true;
        if (node1 == null || node2 == null) return false;
        return node1.val == node2.val && check(node1.left, node2.left) && check(node1.right, node2.right);
    }
    
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (check(s, t))    return true;
        if (s == null)  return false;
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }
}
