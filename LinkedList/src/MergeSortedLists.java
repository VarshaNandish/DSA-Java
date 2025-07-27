/*
Given two sorted linked lists consisting of n and m nodes respectively. The task is to merge both of the lists and return the head of the merged list.
 */

// Definition for singly-linked list node
class ListNode1 {
    int val;
    ListNode1 next;

    ListNode1(int val) {
        this.val = val;
    }
}

public class MergeSortedLists {

    // Merge two sorted lists
    public static ListNode1 mergeTwoLists(ListNode1 list1, ListNode1 list2) {
        // Dummy node to simplify edge cases
        ListNode1 dummy = new ListNode1(-1);
        ListNode1 current = dummy;

        // Traverse both lists
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;     // Attach list1 node
                list1 = list1.next;       // Move list1 forward
            } else {
                current.next = list2;     // Attach list2 node
                list2 = list2.next;       // Move list2 forward
            }
            current = current.next;       // Move merged pointer
        }

        // Append remaining nodes of list1 or list2
        if (list1 != null) {
            current.next = list1;
        } else {
            current.next = list2;
        }

        return dummy.next; // Return head of the merged list
    }

    // Helper method to print linked list
    public static void printList(ListNode1 head) {
        while (head != null) {
            System.out.print(head.val + " → ");
            head = head.next;
        }
        System.out.println("null");
    }

    // Main method to test the merge
    public static void main(String[] args) {
        // Create List1: 1 → 3 → 5
        ListNode1 list1 = new ListNode1(1);
        list1.next = new ListNode1(3);
        list1.next.next = new ListNode1(5);

        // Create List2: 2 → 4 → 6
        ListNode1 list2 = new ListNode1(2);
        list2.next = new ListNode1(4);
        list2.next.next = new ListNode1(6);

        System.out.print("List1: ");
        printList(list1);

        System.out.print("List2: ");
        printList(list2);

        // Merge lists
        ListNode1 mergedHead = mergeTwoLists(list1, list2);

        System.out.print("Merged List: ");
        printList(mergedHead);  // Output: 1 → 2 → 3 → 4 → 5 → 6 → null
    }
}

