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
    
    class NewNode {
        TreeNode minNode, maxNode;
        NewNode left, right;
    }
    
    NewNode NULL_NODE, nRoot;
    boolean done = false;
    
    NewNode dfs(TreeNode node) {
        if (node == null)   return NULL_NODE;
        NewNode nNode = new NewNode();
        if (nRoot == null)  nRoot = nNode;
        nNode.left = dfs(node.left);
        nNode.right = dfs(node.right);
        nNode.minNode = nNode.left.minNode.val < nNode.right.minNode.val ? nNode.left.minNode : nNode.right.minNode;
        nNode.minNode = nNode.minNode.val < node.val ? nNode.minNode : node;
        nNode.maxNode = nNode.left.maxNode.val > nNode.right.maxNode.val ? nNode.left.maxNode : nNode.right.maxNode;
        nNode.maxNode = nNode.maxNode.val > node.val ? nNode.maxNode : node;
        return nNode;
    }
    
    void swap(TreeNode node1, TreeNode node2) {
        int tmp = node1.val;
        node1.val = node2.val;
        node2.val = tmp;
        done = true;
    }
    
    void check(TreeNode node, NewNode nNode) {
        if (done)   return;
        if (node == null)   return;
        if (nNode.left != null && nNode.right != null && nNode.left.maxNode.val > nNode.right.minNode.val && nNode.left.maxNode.val > node.val) {
            swap(nNode.left.maxNode, nNode.right.minNode);
            return;
        }
        if (nNode.left != null && nNode.left.maxNode.val > node.val) {
            swap(nNode.left.maxNode, node);
            return;
        }
        if (nNode.right != null && nNode.right.minNode.val < node.val) {
            swap(nNode.right.minNode, node);
            return;
        }
        check(node.left, nNode.left);
        check(node.right, nNode.right);
    }
    
    public void recoverTree(TreeNode root) {
        NULL_NODE = new NewNode();
        NULL_NODE.minNode = new TreeNode(Integer.MAX_VALUE);
        NULL_NODE.maxNode = new TreeNode(Integer.MIN_VALUE);
        
        dfs(root);
        check(root, nRoot);
    }
}
