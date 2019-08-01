/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue(new ListComparator());
        for (ListNode listNode: lists) {
            if (listNode != null)   queue.add(listNode);
        }
        ListNode ans = null;
        ListNode head = null;
        while (queue.size() > 0) {
            ListNode node = queue.poll();
            if (head == null) {
                ans = new ListNode(node.val);
                head = ans;
            }
            else {
                ans.next = new ListNode(node.val);
                ans = ans.next;
            }
            if (node.next != null)
                queue.add(node.next);
        }
        return head;
    }
}

class ListComparator implements Comparator<ListNode> {
    @Override
    public int compare(ListNode a, ListNode b) {
        return a.val < b.val? -1 : 1;
    }
}
