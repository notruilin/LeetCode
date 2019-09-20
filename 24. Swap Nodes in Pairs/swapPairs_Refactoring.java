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
            ListNode first = node.next;
            ListNode second = node.next.next;
            node.next = second;
            first.next = second.next;
            second.next = first;
            node = node.next.next;
        }
        return newHead.next;
    }
}
