/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode node = newHead;
        while (node.next != null && node.next.next != null) {
            ListNode tmp = node.next;
            ListNode tmp2 = node.next.next.next;
            node.next = tmp.next;
            node.next.next = tmp;
            node.next.next.next = tmp2;
            node = node.next.next;
        }
        return newHead.next;
    }
}
