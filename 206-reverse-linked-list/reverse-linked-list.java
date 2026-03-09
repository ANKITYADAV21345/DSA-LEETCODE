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

 //apna colage notes
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode tail=head;
        ListNode next;

        while (curr != null) {
            next = curr.next;  // store next node
            curr.next = prev;  // reverse current node's pointer
            prev = curr;       // move prev and curr one step forward
            curr = next;
        }
        head=prev;

        return prev; // new head of the reversed list
    }
}
