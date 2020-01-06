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
    List<Integer> lst1 = new ArrayList();
    List<Integer> lst2 = new ArrayList();
    List<Integer> ans = new ArrayList();
    
    void dfs(TreeNode node, List<Integer> lst) {
        if (node == null)   return;
        dfs(node.left, lst);
        lst.add(node.val);
        dfs(node.right, lst);
    }
    
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        dfs(root1, lst1);
        dfs(root2, lst2);
        int a = 0, b = 0;
        while (a < lst1.size() || b < lst2.size()) {
            if (b == lst2.size() || (a < lst1.size() && lst1.get(a) < lst2.get(b))) {
                ans.add(lst1.get(a));
                ++a;
            }
            else {
                ans.add(lst2.get(b));
                ++b;
            }
        }
        return ans;
    }
}
