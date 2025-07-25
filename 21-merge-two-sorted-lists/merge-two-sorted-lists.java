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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Create a sentinel/dummy node to start
        ListNode returnNode = new ListNode(Integer.MIN_VALUE);

        // Create a copy of this node to iterate while solving the problem
        ListNode headNode = returnNode;

        // Traverse till one of the list reaches the end
        while (list1 != null && list2 != null) {
            // Compare the 2 values of lists
            if (list1.val <= list2.val) {
                returnNode.next = list1;
                list1 = list1.next;
            } else {
                returnNode.next = list2;
                list2 = list2.next;
            }
            returnNode = returnNode.next;
        }

        // Append the remaining list
        if (list1 == null) {
            returnNode.next = list2;
        } else {
            returnNode.next = list1;
        }

        // Return the next node to sentinel node
        return headNode.next;
    }
}
