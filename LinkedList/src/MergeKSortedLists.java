/*
Given k sorted linked lists of different sizes, the task is to merge them all maintaining their sorted order.

Better/Optimal Approach – Using Min-Heap (Priority Queue)
Idea:

Use a Min Heap to always get the smallest node from the heads of the current k lists.

Insert the first node of all k lists into the heap.

Each time, extract the smallest node, add it to the result list, and insert its next node (if any) into the heap.

Time Complexity:

O(N log k)
(Each of N nodes is pushed/popped from the heap of size k.)

Space Complexity:

O(k) for the priority queue
 */


import java.util.PriorityQueue;
import java.util.Comparator;

// Definition for singly-linked list node
class ListNode3 {
    int val;
    ListNode3 next;

    ListNode3(int val) {
        this.val = val;
    }
}

public class MergeKSortedLists {

    // Function to merge k sorted linked lists
    public static ListNode3 mergeKLists(ListNode3[] lists) {
        // Edge case: if input is empty
        if (lists == null || lists.length == 0) return null;

        // Min-heap to keep track of the smallest node among the k lists
        PriorityQueue<ListNode3> pq = new PriorityQueue<>(
                Comparator.comparingInt(a -> a.val)
        );

        // Step 1: Add the head of each list to the heap
        for (ListNode3 node : lists) {
            if (node != null) {
                pq.add(node);
            }
        }

        // Dummy head to simplify list construction
        ListNode3 dummy = new ListNode3(0);
        ListNode3 tail = dummy;

        // Step 2: Process nodes from the heap
        while (!pq.isEmpty()) {
            // Extract the smallest node
            ListNode3 minNode = pq.poll();

            // Append it to the merged list
            tail.next = minNode;
            tail = tail.next;

            // If this node has a next, add it to the heap
            if (minNode.next != null) {
                pq.add(minNode.next);
            }
        }

        // Return the head of the merged list
        return dummy.next;
    }

    // Helper method to print the linked list
    public static void printList(ListNode3 head) {
        while (head != null) {
            System.out.print(head.val + " → ");
            head = head.next;
        }
        System.out.println("null");
    }

    // Main method to test the merge function
    public static void main(String[] args) {
        // Example input: k = 3 sorted linked lists
        ListNode3 l1 = new ListNode3(1);
        l1.next = new ListNode3(4);
        l1.next.next = new ListNode3(5);

        ListNode3 l2 = new ListNode3(1);
        l2.next = new ListNode3(3);
        l2.next.next = new ListNode3(4);

        ListNode3 l3 = new ListNode3(2);
        l3.next = new ListNode3(6);

        ListNode3[] lists = {l1, l2, l3};

        // Merge all lists
        ListNode3 mergedHead = mergeKLists(lists);

        // Output the merged list
        System.out.println("Merged Linked List:");
        printList(mergedHead);  // Expected: 1 → 1 → 2 → 3 → 4 → 4 → 5 → 6 → null
    }
}
