/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0), node = new ListNode(0), last = node;
        head.next = node;
        while (l1 != null || l2 != null) {
            node.val += (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val);
            node.next = new ListNode(node.val/10);
            node.val %= 10;
            last = node;
            node = node.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (node.val == 0)  last.next = null;
        return head.next;
    }
}
