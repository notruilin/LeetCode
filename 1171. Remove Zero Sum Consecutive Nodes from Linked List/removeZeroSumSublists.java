/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        while (true) {
            HashMap<Integer, ListNode> map = new HashMap();
            int sum = 0;
            ListNode node = head;
            while (node != null) {
                sum += node.val;
                if (sum == 0) {
                    head = node.next;
                    break;
                }
                if (map.containsKey(sum)) {
                    map.get(sum).next = node.next;
                    break;
                }
                map.put(sum, node);
                node = node.next;
            }
            if (node == null)   break;
        }
        return head;
    }
}
