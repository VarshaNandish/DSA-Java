
/*
Given a linked list. The task is to remove the Nth node from the end of the linked list.

Examples:

Input : LinkedList = 1 ->2 ->3 ->4 ->5 , N = 2
Output : 1 ->2 ->3 ->5
Explanation:  Linked list after deleting the 2nd node from last which is 4, is 1 ->2 ->3 ->5

Input : LinkedList = 7 ->8 ->4 ->3 ->2 , N = 1
Output : 7 ->8 ->4 ->3
Explanation:  Linked list after deleting the 1st node from last which is 2, is 7 ->8 ->4 ->3
 */

// Definition for singly-linked list node
class ListNode4 {
    int val;
    ListNode4 next;

    ListNode4(int val) {
        this.val = val;
    }
}

public class RemoveNthFromEnd {

    public static ListNode4 removeNthFromEnd(ListNode4 head, int n) {
        // Dummy node handles edge cases like removing the head
        ListNode4 dummy = new ListNode4(0);
        dummy.next = head;

        ListNode4 fast = dummy;
        ListNode4 slow = dummy;

        // Step 1: Move fast N+1 steps ahead (including dummy)
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        // Step 2: Move both fast and slow until fast reaches end
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // Step 3: Delete the N-th node from end
        slow.next = slow.next.next;

        // Return head (dummy.next)
        return dummy.next;
    }

    // Helper method to print the list
    public static void printList(ListNode4 head) {
        while (head != null) {
            System.out.print(head.val + " → ");
            head = head.next;
        }
        System.out.println("null");
    }

    // Main method
    public static void main(String[] args) {
        // Example 1: 1 → 2 → 3 → 4 → 5, n = 2
        ListNode4 head1 = new ListNode4(1);
        head1.next = new ListNode4(2);
        head1.next.next = new ListNode4(3);
        head1.next.next.next = new ListNode4(4);
        head1.next.next.next.next = new ListNode4(5);

        ListNode4 result1 = removeNthFromEnd(head1, 2);
        printList(result1); // Expected: 1 → 2 → 3 → 5 → null

        // Example 2: 7 → 8 → 4 → 3 → 2, n = 1
        ListNode4 head2 = new ListNode4(7);
        head2.next = new ListNode4(8);
        head2.next.next = new ListNode4(4);
        head2.next.next.next = new ListNode4(3);
        head2.next.next.next.next = new ListNode4(2);

        ListNode4 result2 = removeNthFromEnd(head2, 1);
        printList(result2); // Expected: 7 → 8 → 4 → 3 → null
    }
}
