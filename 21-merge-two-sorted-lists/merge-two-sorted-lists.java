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
 //good question maam ne recursive aprocha batayi use feel ati hai


//  “Har step par chhoti value wala node choose karke uske next ko recursively merge karo, aur wahi node result ka head banta hai.”
class Solution {
    public ListNode mergeTwoLists(ListNode head1, ListNode head2) {
        
        //base case
        //case 1
        if(head1==null||head2==null){
            if(head1==null){
                return head2;
            }else{
                return head1;
            }
        }

        //case1
        if(head1.val<=head2.val){
            head1.next=mergeTwoLists(head1.next,head2);
            return head1;
        }else{//case2
            head2.next=mergeTwoLists(head1,head2.next);
            return head2;
        }
        
    }
}