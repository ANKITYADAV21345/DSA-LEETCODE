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

//apna college 
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        // Step 1: Check if k nodes exist
        int cnt = 0;
        ListNode temp = head;
        
        while (cnt < k) {
            if (temp == null) {
                return head; // Not enough nodes left, return as is
            }
            temp = temp.next;
            cnt++;
        }

        // Step 2: Reverse first k nodes
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        cnt = 0;

        while (cnt < k && curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            cnt++;
        }

        // Step 3: Recurse for the rest of the list
        if (next != null) {
            head.next = reverseKGroup(next, k);
        }

        // 'prev' is the new head of the reversed group
        return prev;
    }
}

// Definition for singly-linked list
// class ListNode {
//     int val;
//     ListNode next;
//     ListNode(int val) {
//         this.val = val;
//         this.next = null;
//     }
// }