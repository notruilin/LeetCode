/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.ArrayList;
import java.util.HashSet;

class Solution {
    Set<Integer> delete = new HashSet();
    List<TreeNode> ans = new ArrayList();
    
    public TreeNode dfs(TreeNode node, boolean isRoot) {
        if (node == null) return node;
        if (!delete.contains(node.val) && isRoot) {
            ans.add(node);
        }
        node.left = dfs(node.left, delete.contains(node.val));
        node.right = dfs(node.right, delete.contains(node.val));
        if (delete.contains(node.val)) return null;
        else return node;
    }
    
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        for (int x: to_delete) {
            delete.add(x);
        }
        dfs(root, true);
        return ans;
    }
}
