/*
Given a Binary Tree, the task is to find its Level Order Traversal. Level Order Traversal technique is a method to traverse a Tree such that all nodes present in the same level are traversed completely before traversing the next level.

Example:

Input:

112

Output: [[5], [12, 13], [7, 14, 2], [17, 23, 27, 3, 8, 11]]
Explanation:  Start with the root → [5]
Level 1: Visit its children → [12, 13]
Level 2: Visit children of 13 and 12 → [7, 14, 2]
Level 3: Visit children of 7,14 and 2→ [17, 23, 27, 3, 8, 11]
 */

import java.util.*;

class Node13 {
    int value;
    Node13 left, right;

    Node13(int value) {
        this.value = value;
        left = right = null;
    }
}

public class LevelOrder {

    public static List<List<Integer>> levelOrderTraversal(Node13 root) {
        List<List<Integer>> levels = new ArrayList<>();

        if (root == null) return levels;

        Queue<Node13> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int nodesAtThisLevel = queue.size();
            List<Integer> currentLevel = new ArrayList<>();

            for (int i = 0; i < nodesAtThisLevel; i++) {
                Node13 currentNode = queue.poll();
                currentLevel.add(currentNode.value);

                if (currentNode.left != null)
                    queue.offer(currentNode.left);

                if (currentNode.right != null)
                    queue.offer(currentNode.right);
            }

            levels.add(currentLevel);
        }

        return levels;
    }

    public static void main(String[] args) {
        // Constructing custom tree:
        //         5
        //       /   \
        //     12     13
        //    /  \   /
        //   7   14 2
        //  / \    \  \ \
        // 17 23   27 3 8
        //                 \
        //                 11

        Node13 root = new Node13(5);
        root.left = new Node13(12);
        root.right = new Node13(13);
        root.left.left = new Node13(7);
        root.left.right = new Node13(14);
        root.right.left = new Node13(2);

        root.left.left.left = new Node13(17);
        root.left.left.right = new Node13(23);
        root.left.right.right = new Node13(27);
        root.right.left.left = new Node13(3);
        root.right.left.right = new Node13(8);
        root.right.left.right.right = new Node13(11);

        List<List<Integer>> result = levelOrderTraversal(root);

        // Print the levels
        for (List<Integer> level : result) {
            System.out.println(level);
        }
    }
}

