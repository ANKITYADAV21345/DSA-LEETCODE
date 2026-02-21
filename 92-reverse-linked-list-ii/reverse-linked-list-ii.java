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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy=new ListNode(0);
        dummy.next=head;

        ListNode leftpre=dummy;
        ListNode curNode=head;

        for(int i=0;i<left-1;i++){
            leftpre=leftpre.next;
            curNode=curNode.next;
        }
        ListNode subListHead=curNode;
        ListNode preNode=null;
        for(int i=0;i<=right-left;i++){
            ListNode nextNode =curNode.next;
            curNode.next=preNode;
            preNode=curNode;
            curNode=nextNode;
        }
        leftpre.next=preNode;
        subListHead.next=curNode;
        return dummy.next;
    }
}