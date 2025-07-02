/*
Program: Circular Linked List

Create a Circular Linked List using singly linked list structure

In a circular linked list, the last node points back to the first node, forming a loop.

Plan:

append(int data) adds a node at the end and links it back to head.
display() uses a do-while loop to print all nodes exactly once.
Works even if list is empty or has only one node.
*/

public class CircularLinkedList {

    // Node class representing each element in the list
    static class Node {
        int data;       // Value stored in the node
        Node next;      // Reference to the next node

        // Constructor to create a new node
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Head of the circular linked list
    Node head = null;

    // Method to add a node at the end of the circular list
    void append(int data) {
        Node newNode = new Node(data); // Create new node

        // If list is empty, point newNode to itself and make it head
        if (head == null) {
            head = newNode;
            newNode.next = head;
            return;
        }

        // Else, traverse to the last node
        Node temp = head;
        while (temp.next != head) {  // Loop until last node (which points to head)
            temp = temp.next;

        }

        // Insert new node at end and point it back to head
        temp.next = newNode;
        newNode.next = head;
    }

    // Method to display the circular linked list
    void display() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node temp = head;
        System.out.print("Circular Linked List: ");

        // Do-while loop ensures we print the head at least once
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head); // Stop when we loop back to the head

        System.out.println();
    }

    // Main method to test the circular linked list
    public static void main(String[] args) {
        CircularLinkedList clist = new CircularLinkedList();

        // Add elements to the circular list
        clist.append(10);
        clist.append(20);
        clist.append(30);
        clist.append(40);

        // Display the list
        clist.display();
    }
}
