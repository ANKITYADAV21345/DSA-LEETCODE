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


 //code storywithmik
 //iterative
class Solution {
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if(head==null|| head.next==null){
            return head;
        }

        ListNode curNode=head;
        ListNode nextNode=head.next;

        while(nextNode!=null){

            //gcd ki value nikal rahe hai dono node se 
            int a = Math.abs(curNode.val);
            int b = Math.abs(nextNode.val);

            // Euclidean algorithm
            while (b != 0) {
                int temp = b;
                b = a % b;
                a = temp;
            }

            //node bana rahe hai gcd ki
            ListNode temp=new ListNode(a);

            //curr->gcd(cur,temp)->temp
            curNode.next=temp;
            temp.next=nextNode;

            //age badne ham gcd age ki nodes nikalne ke liye
            curNode=nextNode;
            nextNode=nextNode.next;
        }
        return head;
    }
}