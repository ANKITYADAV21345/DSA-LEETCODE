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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode ptr1=list1, ptr2=list1;
        int i=0;
        for(i=1;i<a;i++){
            ptr1=ptr1.next;
            ptr2=ptr2.next;
        }
        for(;i<=b+1;i++)
            ptr2=ptr2.next;

        ptr1.next=list2;

        ListNode tmp=list2;

        while(tmp.next!=null)
            tmp=tmp.next;

        tmp.next=ptr2;

        return list1;
    }
}