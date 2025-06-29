/*Design your implementation of the linked list. You can choose to use a singly linked list. In a singly linked list a node should have two attributes: val and next.
val is the value of the current node, next is a pointer/reference to the next node in the linked list.
Example: obj = MyLinkedList() obj.addAtHead() obj.addAtTail() obj.addAtIndex() obj.deleteAtIndex() obj.get(0)


Approach: Naive but Fully Functional
Idea:
We implement our own Node class and manage the head of the list.

Plan:
Node class – with val and next.
MyLinkedList class – with:
head node (can be null if list is empty)
size to track length (helpful for bounds checking)
Methods:
get(index) – Traverse from head to index.
addAtHead(val) – Insert at start.
addAtTail(val) – Traverse to end and insert.
addAtIndex(index, val) – Insert before index node.
deleteAtIndex(index) – Remove node at index.


Time Complexity: O(1) for addAtHead(val), O(n) for all other methods
Space Complexity: O(1)

Dry Run
MyLinkedList list = new MyLinkedList();
list.addAtHead(10);        // [10]
list.addAtTail(20);        // [10, 20]
list.addAtIndex(1, 15);    // [10, 15, 20]
list.get(1);               // returns 15
list.deleteAtIndex(1);     // [10, 20] */

public class MyLinkedList {

    // Node class for singly linked list
    private class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    private Node head;  // points to first node

    private int size;   // tracks number of elements

    // Constructor: initialize empty list
    public MyLinkedList() {
        head = null;
        size = 0;
    }

    // Get value at specific index
    public int get(int index) {
        if (index < 0 || index >= size) return -1;
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.val;
    }

    // Add new node at the beginning
    public void addAtHead(int val) {
        Node newNode = new Node(val);
        newNode.next = head; // link new node to current head
        head = newNode;      // move head to new node
        size++;
    }

    // Add new node at the end
    public void addAtTail(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode; // if list is empty
        } else {
            Node current = head;

            // Traverse to the end of list
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    // Add node before the index-th node
    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) return;
        if (index == 0) {
            addAtHead(val);
            return;
        }
        Node newNode = new Node(val);
        Node current = head;
        // Traverse to node before the target index
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        newNode.next = current.next;
        current.next = newNode;
        size++;
    }

    // Delete node at specific index
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) return;
        if (index == 0) {
            head = head.next; // remove head
        } else {
            Node current = head;

            // Traverse to node before the one to delete
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
        }
        size--;
    }

    // Optional: print list (for debugging)
    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // Driver Code (main method)
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.addAtHead(10);
        list.addAtTail(20);
        list.addAtIndex(1, 15);
        list.printList(); // 10 -> 15 -> 20 -> null
        System.out.println("Value at index 1: " + list.get(1)); // 15
        list.deleteAtIndex(1);
        list.printList(); // 10 -> 20 -> null
    }
}


