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
    private static final int N = 1001;
    private List<List<TreeNode>> depthNodes = new ArrayList();
    private List<boolean[]> ancestor = new ArrayList();
    private int maxDepth = 0;
    
    private void dfs(TreeNode node, List<TreeNode> acts, int depth) {
        if (node == null)   return;
        for (TreeNode act: acts)    ancestor.get(node.val)[act.val] = true;
        ancestor.get(node.val)[node.val] = true;
        depthNodes.get(depth).add(node);
        maxDepth = Math.max(maxDepth, depth);
        acts.add(node);
        dfs(node.left, acts, depth + 1);
        dfs(node.right, acts, depth + 1);
        acts.remove(acts.size() - 1);
    }
    
    private boolean checkCommon(TreeNode act) {
        for (TreeNode node: depthNodes.get(maxDepth)) {
            if (!ancestor.get(node.val)[act.val])   return false;
        }
        return true;
    }
    
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        for (int i = 0; i < N; i++) {
            depthNodes.add(new ArrayList<TreeNode>());
            ancestor.add(new boolean[N]);
        }
        dfs(root, new ArrayList<TreeNode>(), 0);
        int depth = maxDepth; 
        while (true) {
            for (TreeNode node: depthNodes.get(depth)) {
                if (checkCommon(node))  return node;
            }
            depth--;
        }
    }
}
