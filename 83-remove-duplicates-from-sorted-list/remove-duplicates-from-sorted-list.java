/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

//nikhil lohia
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = head;
        ListNode temp = head.next;

        while (temp != null) {
            if (temp.val == prev.val) {
                // skip duplicate
                temp = temp.next;
            } else {
                // link the next unique value
                prev.next = temp;
                prev = temp;
                temp = temp.next;
            }
        }

        // Ensure the last node's next is null
        prev.next = null;

        return head;
    }
}
