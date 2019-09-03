/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    int length = 0;
    
    int search(ListNode node, int n) {
        if (node == null)   return 0;
        ++length;
        int count = search(node.next, n);
        if (count == n) {
            node.next = node.next.next;
        }
        return count+1;    
    }
    
    public ListNode removeNthFromEnd(ListNode head, int n) {
        search(head, n);
        if (length == n)    return head.next;
        return head;
    }
}
