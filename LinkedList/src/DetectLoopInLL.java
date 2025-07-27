

// Java program to detect loop in a linked list
// using Floyd's Cycle-Finding Algorithm (Tortoise & Hare)

class Node1 {
    int data;
    Node1 next;

    // Constructor to initialize node data
    public Node1(int x) {
        this.data = x;
        this.next = null;
    }
}

public class DetectLoopInLL {

    // Method to detect loop in a linked list
    static boolean detectLoop(Node1 head) {
        Node1 slow = head; // moves one step at a time
        Node1 fast = head; // moves two steps at a time

        // Traverse the list
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;           // move slow by 1 node
            fast = fast.next.next;      // move fast by 2 nodes

            // If both meet, loop exists
            if (slow == fast) {
                return true;
            }
        }

        // If we reach here, no loop found
        return false;
    }

    public static void main(String[] args) {

        // Create a linked list: 1 -> 3 -> 4
        Node1 head = new Node1(1);
        head.next = new Node1(3);
        head.next.next = new Node1(4);

        // Creating a loop: last node connects back to node with value 3
        head.next.next.next = head.next;

        // Call detectLoop and print result
        if (detectLoop(head))
            System.out.println("true");  // Output: true
        else
            System.out.println("false");
    }
}
