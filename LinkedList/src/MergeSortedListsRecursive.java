/*
Given two sorted linked lists consisting of n and m nodes respectively. The task is to merge both of the lists and return the head of the merged list.
 */

// Definition for singly-linked list node
class ListNode2 {
    int val;
    ListNode2 next;

    ListNode2(int val) {
        this.val = val;
    }
}

public class MergeSortedListsRecursive {

    // Recursive method to merge two sorted linked lists
    public static ListNode2 mergeTwoLists(ListNode2 list1, ListNode2 list2) {
        // Base cases
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        // Recursive comparison
        if (list1.val <= list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }

    // Helper method to print a linked list
    public static void printList(ListNode2 head) {
        while (head != null) {
            System.out.print(head.val + " → ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Create list1: 1 → 3 → 5
        ListNode2 list1 = new ListNode2(1);
        list1.next = new ListNode2(3);
        list1.next.next = new ListNode2(5);

        // Create list2: 2 → 4 → 6
        ListNode2 list2 = new ListNode2(2);
        list2.next = new ListNode2(4);
        list2.next.next = new ListNode2(6);

        System.out.print("List1: ");
        printList(list1);

        System.out.print("List2: ");
        printList(list2);

        // Merge recursively
        ListNode2 merged = mergeTwoLists(list1, list2);

        System.out.print("Merged List: ");
        printList(merged);  // Output: 1 → 2 → 3 → 4 → 5 → 6 → null
    }
}

