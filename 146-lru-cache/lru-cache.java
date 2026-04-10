//apna college
import java.util.*;

class LRUCache {

    public static class Node {
        int key;
        int val;
        Node prev;
        Node next;

        Node(int k, int v) {
            key = k;
            val = v;
            prev = null;
            next = null;
        }
    }

    HashMap<Integer, Node> map = new HashMap<>();
    int limit;
    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);

    public LRUCache(int capacity) {
        limit = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public void addNode(Node newNode) {
        Node oldNext = head.next;

        head.next = newNode;
        oldNext.prev = newNode;

        newNode.next = oldNext;
        newNode.prev = head;
    }

    public void delNode(Node oldNode) {
        Node oldPrev = oldNode.prev;
        Node oldNext = oldNode.next;

        oldPrev.next = oldNext;
        oldNext.prev = oldPrev;
    }

    public int get(int key) {  //o(1)
        if (!map.containsKey(key)) {
            return -1;
        }

        Node ansNode = map.get(key);
        int ans = ansNode.val;
        
        map.remove(key);
        delNode(ansNode);
        
        addNode(ansNode);
        map.put(key,ansNode);

        return ans;
    }

    public void put(int key, int value) {
        //data pehle se exist karta hai to use delete karo and new node ko dalo linked list k start pe 
        if (map.containsKey(key)) {
            Node oldNode = map.get(key);
            delNode(oldNode);
            map.remove(key);
        }



        if (map.size() == limit) {
            Node lru = tail.prev;
            map.remove(lru.key);
            delNode(lru);
        }

        Node newNode = new Node(key, value);
        addNode(newNode);
        map.put(key, newNode);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */