/*
Serialization is performed to store a tree in an array so that it can be later restored and deserialization is reading the tree back from the array.

Given a binary tree, the task is to complete the functions:

    serialize(): stores the tree into an array arr[] and returns the array.
    deSerialize(): deserializes the array to the tree and returns the root of the tree.

Note: Multiple nodes can have the same data and the node values are always positive.


 */

import java.util.*;

class Node15 {
    int val;
    Node15 left, right;

    Node15(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}

public class SerializeDeserialize {

    // Serialize the tree using preorder traversal (DFS)
    public static void serialize(Node15 root, List<Integer> result) {
        if (root == null) {
            result.add(null); // Use null marker for missing children
            return;
        }

        result.add(root.val);          // Visit current node
        serialize(root.left, result);  // Recur on left
        serialize(root.right, result); // Recur on right
    }

    // Helper index tracker (mimics pointer during recursion)
    static class Index {
        int index = 0;
    }

    // Deserialize the list back to tree using preorder traversal (DFS)
    public static Node15 deserialize(List<Integer> data, Index index) {
        if (index.index >= data.size() || data.get(index.index) == null) {
            index.index++;
            return null;
        }

        Node15 root = new Node15(data.get(index.index));
        index.index++;
        root.left = deserialize(data, index);
        root.right = deserialize(data, index);

        return root;
    }

    // Inorder traversal to test correctness
    public static void inorder(Node15 root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    // Main method to test
    public static void main(String[] args) {
        // Build sample tree:
        //         10
        //       /    \
        //     5       15
        //    / \     /
        //   2   7   12

        Node15 root = new Node15(10);
        root.left = new Node15(5);
        root.right = new Node15(15);
        root.left.left = new Node15(2);
        root.left.right = new Node15(7);
        root.right.left = new Node15(12);

        // Serialize
        List<Integer> serialized = new ArrayList<>();
        serialize(root, serialized);
        System.out.println("Serialized (Preorder with nulls): " + serialized);

        // Deserialize
        Index idx = new Index();
        Node15 newRoot = deserialize(serialized, idx);

        // Inorder print to confirm tree is restored
        System.out.print("Inorder of Deserialized Tree: ");
        inorder(newRoot); // Expected: 2 5 7 10 12 15
    }
}
