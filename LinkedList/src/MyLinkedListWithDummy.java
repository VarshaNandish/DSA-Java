/* rewritten version of the Singly Linked List using a dummy/sentinel head node for cleaner insert/delete logic

Adding a dummy (sentinel) head node simplifies operations:
No need to check separately if we are inserting/deleting at the head.
We always have a node before the actual first node. */

public class MyLinkedListWithDummy {
    // Node class for singly linked list
    private class Node {
        int val;
        Node next;
        Node(int val) {
            this.val = val;
        }
    }

    private Node dummyHead;  // Dummy node before real head
    private int size;        // Track the number of actual elements

    // Constructor: initialize list with dummy head
    public MyLinkedListWithDummy() {
        dummyHead = new Node(0); // Dummy node
        size = 0;
    }

    // Get value at given index
    public int get(int index) {
        if (index < 0 || index >= size) return -1;
        Node current = dummyHead.next;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.val;
    }

    // Add at head
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    // Add at tail
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    // Add at specific index
    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) return;
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node newNode = new Node(val);
        newNode.next = prev.next;
        prev.next = newNode;
        size++;
    }

    // Delete node at given index
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) return;
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        prev.next = prev.next.next;
        size--;
    }

    // Optional: print list for debugging
    public void printList() {
        Node current = dummyHead.next;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // Main method for demonstration
    public static void main(String[] args) {
        MyLinkedListWithDummy list = new MyLinkedListWithDummy();
        list.addAtHead(10);           // [10]
        list.addAtTail(20);           // [10, 20]
        list.addAtIndex(1, 15);       // [10, 15, 20]
        list.printList();             // Output: 10 -> 15 -> 20 -> null
        System.out.println(list.get(1)); // Output: 15
        list.deleteAtIndex(1);        // [10, 20]
        list.printList();             // Output: 10 -> 20 -> null
    }
}


