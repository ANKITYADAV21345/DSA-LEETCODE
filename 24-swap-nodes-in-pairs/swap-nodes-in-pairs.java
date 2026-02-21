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
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode point=dummy;
        while(point.next!=null && point.next.next!=null){
            //variable1
            ListNode swap1=point.next;
            //variable2
            ListNode swap2=point.next.next;
            //swap
            swap1.next=swap2.next;
            swap2.next=swap1;
            point.next=swap2;
            point=swap1;
        }
        return dummy.next;
    }
}