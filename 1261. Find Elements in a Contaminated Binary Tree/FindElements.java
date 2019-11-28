/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class FindElements {
    
    HashSet<Integer> set = new HashSet();
    
    void dfs(TreeNode node) {
        if (node == null)   return;
        set.add(node.val);
        if (node.left != null)  node.left.val = node.val * 2 + 1;
        if (node.right != null) node.right.val = node.val * 2 + 2;
        dfs(node.left);
        dfs(node.right);
    }

    public FindElements(TreeNode root) {
        root.val = 0;
        set.add(0);
        dfs(root);
    }
    
    public boolean find(int target) {
        return set.contains(target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */
