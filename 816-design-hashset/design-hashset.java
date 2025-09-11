//megha srivastava
class MyHashSet {

    private static final int BUCKET_SIZE = 769; // Prime number for better distribution
    private final ListNode[] buckets;

    public MyHashSet() {
        buckets = new ListNode[BUCKET_SIZE];
    }

    private int getIndex(int key) {
        return key % BUCKET_SIZE;
    }

    public void add(int key) {
        int index = getIndex(key);
        ListNode head = buckets[index];

        // If the bucket is empty, insert a new node
        if (head == null) {
            buckets[index] = new ListNode(key);
            return;
        }

        ListNode current = head;
        while (true) {
            if (current.key == key) return; // Key already exists
            if (current.next == null) break;
            current = current.next;
        }

        current.next = new ListNode(key); // Append to the list
    }

    public void remove(int key) {
        int index = getIndex(key);
        ListNode head = buckets[index];

        if (head == null) return;

        // Check if the key is at the head
        if (head.key == key) {
            buckets[index] = head.next;
            return;
        }

        ListNode prev = head;
        ListNode current = head.next;
        while (current != null) {
            if (current.key == key) {
                prev.next = current.next; // Remove current
                return;
            }
            prev = current;
            current = current.next;
        }
    }

    public boolean contains(int key) {
        int index = getIndex(key);
        ListNode current = buckets[index];
        while (current != null) {
            if (current.key == key) return true;
            current = current.next;
        }
        return false;
    }

    // Inner class for Linked List Node
    private static class ListNode {
        int key;
        ListNode next;

        ListNode(int key) {
            this.key = key;
        }
    }
}
