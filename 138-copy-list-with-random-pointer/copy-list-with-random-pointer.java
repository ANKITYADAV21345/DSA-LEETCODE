/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/



//apna college
import java.util.*;

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        HashMap<Node, Node> map = new HashMap<>();

        Node newHead = new Node(head.val);
        map.put(head, newHead);   // IMPORTANT

        Node oldTemp = head.next;
        Node newTemp = newHead;

        // Step 1: copy next pointers
        while (oldTemp != null) {
            Node copyNode = new Node(oldTemp.val);
            map.put(oldTemp, copyNode);

            newTemp.next = copyNode;

            oldTemp = oldTemp.next;
            newTemp = newTemp.next;
        }

        // Step 2: set random pointers
        oldTemp = head;
        newTemp = newHead;

        while (oldTemp != null) {
            newTemp.random = map.get(oldTemp.random);
            oldTemp = oldTemp.next;
            newTemp = newTemp.next;
        }

        return newHead;
    }
}