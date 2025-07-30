
/*
Given a singly linked list: A0 →A1 →...→An-2 →An-1 , reorder it to A0 →An-1 →A1 →An-2 →A2 →An-3 →...
For example: Given 1->2->3->4->5 its reorder is 1->5->2->4->3.
 */


// Definition for singly-linked list node
class ListNode5 {
    int val;
    ListNode5 next;

    ListNode5(int val) {
        this.val = val;
    }
}

public class ReorderList {

    public static void reorderList(ListNode5 head) {
        if (head == null || head.next == null) return;

        // Step 1: Find the middle
        ListNode5 slow = head;
        ListNode5 fast = head;
        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse second half
        ListNode5 secondHalf = reverseList(slow.next);
        slow.next = null; // Cut the list into two halves

        // Step 3: Merge two halves
        ListNode5 first = head;
        ListNode5 second = secondHalf;

        while (second != null) {
            ListNode5 temp1 = first.next;
            ListNode5 temp2 = second.next;

            first.next = second;
            second.next = temp1;

            first = temp1;
            second = temp2;
        }
    }

    // Helper to reverse a list
    private static ListNode5 reverseList(ListNode5 head) {
        ListNode5 prev = null;
        while (head != null) {
            ListNode5 nextNode = head.next;
            head.next = prev;
            prev = head;
            head = nextNode;
        }
        return prev;
    }

    // Helper to print the list
    public static void printList(ListNode5 head) {
        while (head != null) {
            System.out.print(head.val + " → ");
            head = head.next;
        }
        System.out.println("null");
    }

    // Main
    public static void main(String[] args) {
        // Example 1: 1 → 2 → 3
        ListNode5 head1 = new ListNode5(1);
        head1.next = new ListNode5(2);
        head1.next.next = new ListNode5(3);
        reorderList(head1);
        printList(head1);

        // Example 2: 1 → 7 → 3 → 4
        ListNode5 head2 = new ListNode5(1);
        head2.next = new ListNode5(7);
        head2.next.next = new ListNode5(3);
        head2.next.next.next = new ListNode5(4);
        reorderList(head2);
        printList(head2); 
    }
}
