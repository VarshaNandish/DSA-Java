/*Reversing a singly linked list: Given the head of a singly linked list, reverse the list and return the new head.

        Approach 1: Naive (Using a Stack)

        Idea:

        Traverse the list and push all nodes onto a stack.
        Then pop nodes and reconnect their next pointers in reverse.
        Time & Space Complexity:

        Time complexity: O(n)
        Space complexity: O(n) (stack to store nodes)

        Stack after traversal: [1, 2, 3, 4]
        Pop 4 → new head
        Pop 3 → 4.next = 3
        Pop 2 → 3.next = 2
        Pop 1 → 2.next = 1
        Set 1.next = null */



import java.util.Stack;

class ListNode {
    int val;
    ListNode next;


    ListNode(int val) {
        this.val = val;
    }
}

public class ReverseLinkedListWithStack {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        Stack<ListNode> stack = new Stack<>();
        ListNode current = head;

        // Push all nodes onto the stack
        while (current != null) {
            stack.push(current);
            current = current.next;
        }

        // Reconstruct reversed list
        ListNode newHead = stack.pop();
        ListNode temp = newHead;
        while (!stack.isEmpty()) {
            temp.next = stack.pop();
            temp = temp.next;
        }
        temp.next = null;
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
        ReverseLinkedListWithStack obj = new ReverseLinkedListWithStack();
        System.out.print("Original List: ");
        printList(n1);
        ListNode reversed = obj.reverseList(n1);
        System.out.print("Reversed List (Stack): ");
        printList(reversed);
    }
}
