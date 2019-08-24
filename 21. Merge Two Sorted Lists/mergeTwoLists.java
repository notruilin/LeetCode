/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        ListNode node = new ListNode(0);
        ListNode ans = node;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                node.next = l2;
                l2 = l2.next;
            }
            else {
                node.next = l1;
                l1 = l1.next;
            }
            node = node.next;
        }
        if (l1 == null) node.next = l2;
        else node.next = l1;
        return ans.next;
    }
}
