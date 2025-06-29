/*
Approach 2: Optimized Iterative (Two Pointers)

Idea:
Use two pointers: prev and curr.

Traverse the list while:
Storing the next node
Reversing the curr.next pointer to point to prev
Advancing both pointers

Steps:
Initialize prev = null and curr = head.
While curr != null:
next = curr.next
curr.next = prev
prev = curr
curr = next
Return prev (new head)
Time & Space Complexity:

Time complexity: O(n)
Space complexity: O(1)


Dry run:

Initial: head = 1 → 2 → 3 → null
prev = null, curr = 1
Step 1:
  next = 2
  1.next = null
  prev = 1, curr = 2
Step 2:
  next = 3
  2.next = 1
  prev = 2, curr = 3
Step 3:
  next = null
  3.next = 2
  prev = 3, curr = null
Return prev = 3 → 2 → 1 → null
 */

class Node {
    int val;
    ListNode next;

    Node(int val) {
        this.val = val;
    }
}

public class ReverseLLUsingTwoPointers {

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next; // save next
            curr.next = prev;          // reverse
            prev = curr;               // move prev forward
            curr = next;               // move curr forward
        }
        return prev;
    }

    public static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " → ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(34);
        ListNode n2 = new ListNode(45);
        ListNode n3 = new ListNode(56);
        ListNode n4 = new ListNode(67);
        ListNode n5 = new ListNode(78);
        n1.next = n2; n2.next = n3; n3.next = n4; n4.next = n5;

        ReverseLLUsingTwoPointers obj = new ReverseLLUsingTwoPointers();

        System.out.print("Original List: ");

        printList(n1);

        ListNode reversed = obj.reverseList(n1);

        System.out.print("Reversed List (Iterative): ");

        printList(reversed);
    }
}
