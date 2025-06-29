/*
Approach 3: Recursive

Idea:
Use recursion to reverse the rest of the list, then fix the current node's next pointer.

Steps:

Base case: if head == null || head.next == null, return head
Recurse: newHead = reverseList(head.next)
Fix pointers:
head.next.next = head
head.next = null
Return newHead

Time & Space Complexity:
Time complexity: O(n)
Space complexity: O(n) (recursion stack)

Dry run:

Call stack:
reverse(1)
  reverse(2)
    reverse(3)
      return 3
Then:
  2.next.next = 2 → 3 → 2
  2.next = null → 3 → 2 → null
 */

class RecursiveNode {
    int val;
    ListNode next;

    RecursiveNode(int val) {
        this.val = val;
    }
}

public class ReverseLLRecursive {

    public ListNode reverseList(ListNode head) {
        // Base case: end of list
        if (head == null || head.next == null) return head;
        // Recursive call
        ListNode newHead = reverseList(head.next);
        // Reverse pointer
        head.next.next = head;
        head.next = null;
        return newHead;
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



        ReverseLLRecursive obj = new ReverseLLRecursive();



        System.out.print("Original List: ");

        printList(n1);



        ListNode reversed = obj.reverseList(n1);

        System.out.print("Reversed List (Recursive): ");

        printList(reversed);

    }

}

