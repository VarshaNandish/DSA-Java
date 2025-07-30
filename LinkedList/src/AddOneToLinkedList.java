/*
Add 1 to a number represented as linked list
Last Updated : 10 Sep, 2024
A number is represented in linked list such that each digit corresponds to a node in linked list. The task is to add 1 to it.

Examples:

Input: head: 4 -> 5 -> 6
Output: head: 4 -> 5 -> 7
Explanation: Adding 1 to number represented by Linked List = 456 + 1 = 457

Input: head: 2 -> 1 -> 6 -> 9
Output: head:  2 -> 1 -> 7 -> 0
Explanation: Adding 1 to number represented by Linked List = 2169 + 1 = 2170


Each digit of the number is stored in a node, most significant digit is at the head.
We reverse the list to simplify addition from least significant digit (which is at the tail).
Perform 1-digit addition with carry.
Reverse the list back to get the final answer.

Steps (Approach):

Reverse the linked list.

Traverse from head:
Add 1 to the first node.
If the result is 10, set it to 0 and carry 1 forward.
Repeat until carry is 0.

If at end of list and carry still 1, add a new node with value 1.

Reverse the list again to restore original order.

 */

// Definition for singly-linked list node
class ListNode6 {
    int val;
    ListNode6 next;

    ListNode6(int val) {
        this.val = val;
    }
}

public class AddOneToLinkedList {

    // Function to reverse the linked list
    private static ListNode6 reverse(ListNode6 head) {
        ListNode6 prev = null, curr = head;

        while (curr != null) {
            ListNode6 nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }

        return prev;
    }

    // Function to add 1 to the number
    public static ListNode6 addOne(ListNode6 head) {
        // Step 1: Reverse the list
        head = reverse(head);

        // Step 2: Add 1 to the first node
        ListNode6 curr = head;
        int carry = 1;

        while (curr != null) {
            int sum = curr.val + carry;
            curr.val = sum % 10;
            carry = sum / 10;

            // If carry is 0, no further changes are needed
            if (carry == 0) break;

            // If we're at the last node and still have a carry, add a new node
            if (curr.next == null && carry != 0) {
                curr.next = new ListNode6(carry);
                carry = 0;
                break;
            }

            curr = curr.next;
        }

        // Step 3: Reverse again to restore original order
        return reverse(head);
    }

    // Helper function to print the linked list
    public static void printList(ListNode6 head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) System.out.print(" → ");
            head = head.next;
        }
        System.out.println();
    }

    // Main method to test the code
    public static void main(String[] args) {
        // Example 1: 4 → 5 → 6
        ListNode6 head1 = new ListNode6(4);
        head1.next = new ListNode6(5);
        head1.next.next = new ListNode6(6);

        System.out.print("Before: ");
        printList(head1);
        ListNode6 result1 = addOne(head1);
        System.out.print("After:  ");
        printList(result1);

        // Example 2: 2 → 1 → 6 → 9
        ListNode6 head2 = new ListNode6(2);
        head2.next = new ListNode6(1);
        head2.next.next = new ListNode6(6);
        head2.next.next.next = new ListNode6(9);

        System.out.print("Before: ");
        printList(head2);
        ListNode6 result2 = addOne(head2);
        System.out.print("After:  ");
        printList(result2);
    }
}
