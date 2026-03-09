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




 

//iss question me maine merge sort lagaya hai devide and concour vale se ki pehle puri list ke devide karta gaya fir sort kiya fasion me merge karta gaya slow fast se mid nikala fir head se mid and mid se last tak tod diya 

class Solution {
    public ListNode sortList(ListNode head) {
        if(head==null||head.next==null)  return head;

        ListNode mid=middleNode(head);

        ListNode left= sortList(head);
        ListNode right =sortList(mid);

        return mergeTwoLists(left,right);
    }

    ListNode mergeTwoLists(ListNode list1,ListNode list2){
        ListNode head=new ListNode();
        ListNode dummy=head;

        while(list1 != null && list2 !=null){
            if(list1.val<list2.val){
                head.next=list1;
                list1=list1.next;
            }
            else{
                head.next=list2;
                list2=list2.next;
            }
            head=head.next;
        }

        while(list1!=null){
           head.next=list1;
           list1=list1.next;
           head=head.next;
        }

        while(list2!=null){
            head.next=list2;
            list2=list2.next;
            head=head.next;
        }

        return dummy.next;
    }

    // slow fast pointer se middle find
    ListNode middleNode(ListNode head){

        ListNode slow=head;
        ListNode fast=head;
        ListNode prev=null;

        while(fast!=null && fast.next!=null){
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;
        }

        prev.next=null;   // list split
        return slow;      // mid
    }
}