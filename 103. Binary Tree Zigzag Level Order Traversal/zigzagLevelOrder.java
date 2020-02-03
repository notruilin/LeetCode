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
    List<List<Integer>> lst = new LinkedList();
    
    private void dfs(TreeNode node, int depth) {
        if (node == null)   return;
        if (lst.size() == depth)    lst.add(new LinkedList());
        if (depth % 2 == 0) lst.get(depth).add(node.val);
        else    lst.get(depth).add(0, node.val);
        dfs(node.left, depth + 1);
        dfs(node.right, depth + 1);
    }
    
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        dfs(root, 0);
        return lst;
    }
}
