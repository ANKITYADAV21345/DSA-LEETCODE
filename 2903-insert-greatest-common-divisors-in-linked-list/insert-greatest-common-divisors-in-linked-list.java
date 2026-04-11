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

 //codestorywithmik
 //recursive
class Solution {
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }

        ListNode temp=insertGreatestCommonDivisors(head.next);
        ListNode curNode=head;
        ListNode nextNode=head.next;

        //gcd ki value nikal rahe hai dono node se 
        int a = Math.abs(curNode.val);
        int b = Math.abs(nextNode.val);

        // Euclidean algorithm
        while (b != 0) {
            int temp1 = b;
            b = a % b;
            a = temp1;
        }

        //node bana rahe hai gcd ki
        ListNode gcdNode=new ListNode(a);

        gcdNode.next=temp;
        head.next=gcdNode;

        return head;

    }
}