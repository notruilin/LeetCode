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
    ArrayList<Integer>[] level = new ArrayList[1001];
    int maxLevel = 0;
    private void dfs(TreeNode node, int depth) {
        if (node == null)   return;
        maxLevel = Math.max(maxLevel, depth);
        level[depth].add(node.val);
        dfs(node.left, depth+1);
        dfs(node.right, depth + 1);
    }
    
    public int maxLevelSum(TreeNode root) {
        for (int i = 0; i < 1001; i++) {
            level[i] = new ArrayList<Integer>();
        }
        dfs(root, 0);
        int ansSum = Integer.MIN_VALUE, ans = 0;
        for (int i = 0; i <= maxLevel; i++) {
            int sum = 0;
            for (int j = 0; j < level[i].size(); j++) {
                sum += (Integer)level[i].get(j);
            }
            if (sum > ansSum) {
                ansSum = sum;
                ans = i + 1;
            }
        }
        return ans;
    }
}
