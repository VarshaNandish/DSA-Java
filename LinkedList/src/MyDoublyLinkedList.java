/*Design and implement a Doubly Linked List with full CRUD operations and two-directional traversal.

Doubly Linked List that supports:
get(index)
addAtHead(val)
addAtTail(val)
addAtIndex(index, val)
deleteAtIndex(index)
Each node will have:

val: data
prev: reference to the previous node
next: reference to the next node


Approach: Full Functionality with Sentinel Nodes (Dummy Head/Tail)

Idea:
We use sentinel (dummy) head and tail nodes to simplify insertion/deletion at boundaries (head or tail).

Plan:
Node class – with val, prev, and next.
        MyDoublyLinkedList class – with:
head: dummy head node (no value)
tail: dummy tail node (no value)
size: number of actual elements
Methods:
get(index)
addAtHead(val)
addAtTail(val)
addAtIndex(index, val)
deleteAtIndex(index)

Time Complexity: O(1) for addAtHead(val)and addAtTail(val), O(n) for all other methods
Space Complexity: O(1)

Dry Run:
addAtHead(10)       → [10]
addAtTail(20)       → [10, 20]
addAtIndex(1, 15)   → [10, 15, 20]
get(1)              → 15
deleteAtIndex(1)    → [10, 20] */

public class MyDoublyLinkedList {
    // Node class for doubly linked list
    private class Node {
        int val;
        Node prev, next;
        Node(int val) {
            this.val = val;
        }
    }

    private Node head, tail; // dummy head and tail
    private int size;        // number of elements

    // Constructor: initialize empty list with dummy head & tail
    public MyDoublyLinkedList() {
        head = new Node(0); // dummy head
        tail = new Node(0); // dummy tail
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    // Get value at index (0-based)
    public int get(int index) {
        if (index < 0 || index >= size) return -1;
        Node current = head.next; // first real node
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.val;
    }

    // Add at the head
    public void addAtHead(int val) {
        addAtIndex(0, val); // insert right after dummy head
    }

    // Add at the tail
    public void addAtTail(int val) {
        addAtIndex(size, val); // insert right before dummy tail
    }

    // Add at specific index
    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) return;
        // Find prev and next nodes where new node will go
        Node prevNode = head;
        for (int i = 0; i < index; i++) {
            prevNode = prevNode.next;
        }
        Node nextNode = prevNode.next;
        // Create new node
        Node newNode = new Node(val);
        newNode.prev = prevNode;
        newNode.next = nextNode;
        prevNode.next = newNode;
        nextNode.prev = newNode;
        size++;
    }

    // Delete node at index
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) return;
        Node current = head.next;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        Node prevNode = current.prev;
        Node nextNode = current.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
        size--;
    }

    // Optional: print list for debugging
    public void printList() {
        Node current = head.next;
        while (current != tail) {
            System.out.print(current.val + " <-> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // Driver code
    public static void main(String[] args) {
        MyDoublyLinkedList list = new MyDoublyLinkedList();
        list.addAtHead(10);
        list.addAtTail(20);
        list.addAtIndex(1, 15);
        list.printList(); // 10 <-> 15 <-> 20 <-> null
        System.out.println("Get at index 1: " + list.get(1)); // 15
        list.deleteAtIndex(1);
        list.printList(); // 10 <-> 20 <-> null
    }
}

