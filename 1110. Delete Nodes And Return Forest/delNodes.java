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
class Solution {
    TreeNode nodePointer[] = new TreeNode[1001];
    int parent[] = new int[1001];
    
    private void dfsTree(TreeNode node) {
        if (node == null) {
            return;
        }
        nodePointer[node.val] = node;
        if (node.left != null) {
            parent[node.left.val] = node.val;
            dfsTree(node.left);
        }
        if (node.right != null) {
            parent[node.right.val] = node.val;
            dfsTree(node.right);
        }
    }
    
    private void deleteNode(int x) {
        if (nodePointer[x] == null) return;
        if (parent[x] != -1 && nodePointer[parent[x]] != null) {
            if (nodePointer[parent[x]].left != null && nodePointer[parent[x]].left.val == x) {
                nodePointer[parent[x]].left = null;
            }
            else {
                if (nodePointer[parent[x]].right != null && nodePointer[parent[x]].right.val == x) {
                    nodePointer[parent[x]].right = null;
                }
            }
        }
        for (int i = 1; i < 1001; i++) {
            if (parent[i] == x) {
                parent[i] = -1;
            }
        }
        nodePointer[x] = null;
    }
    
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Arrays.fill(parent, 0);
        Arrays.fill(nodePointer, null);
        parent[root.val] = -1;
        dfsTree(root);
        for (int x: to_delete) {
            deleteNode(x);
        }
        List<TreeNode> ans = new ArrayList<TreeNode>();
        for (int i = 1; i < 1001; i++) {
            if (parent[i] == -1 && nodePointer[i] != null) {
                ans.add(nodePointer[i]);
            }
        }
        return ans;
    }
}
