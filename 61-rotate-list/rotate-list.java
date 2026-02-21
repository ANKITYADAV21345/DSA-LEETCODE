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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null){
            return head;
        }
        int len=1;
        ListNode newHead,tail;
        newHead=tail=head;
        while(tail.next!=null){
            tail=tail.next;
            len++;
        }
        tail.next=head;
        //5+3 =8%5=2->  3 4 5 1 2     
        k=k%len;
        for(int i=0;i<len-k;i++){
            tail=tail.next;
        }
        newHead=tail.next;
        tail.next=null;
        return newHead;
    }
}