/*
Given two Binary Trees, the task is to check if two trees are mirror of each other or not. For two trees ‘a’ and ‘b’ to be mirror images, the following three conditions must be true:

    Their root node’s key must be same
    Left subtree of root of ‘a’ and right subtree root of ‘b’ are mirror.
    Right subtree of ‘a’ and left subtree of ‘b’ are mirror.

 */
// Definition for Tree Node
class Node11 {
    int val;
    Node11 left, right;

    Node11(int val) {
        this.val = val;
        left = right = null;
    }
}

public class MirrorCheck {

    // Function to check if two trees are mirror images
    public static boolean areMirror(Node11 a, Node11 b) {
        // If both nodes are null, they are mirror (empty trees)
        if (a == null && b == null)
            return true;

        // If only one of them is null, not mirror
        if (a == null || b == null)
            return false;

        // Check current nodes and their subtrees
        return (a.val == b.val) &&
                areMirror(a.left, b.right) &&
                areMirror(a.right, b.left);
    }

    // Main method to test
    public static void main(String[] args) {
        // Tree 1
        Node11 a = new Node11(1);
        a.left = new Node11(2);
        a.right = new Node11(3);
        a.left.left = new Node11(4);
        a.left.right = new Node11(5);

        // Tree 2 (mirror of Tree 1)
        Node11 b = new Node11(1);
        b.left = new Node11(3);
        b.right = new Node11(2);
        b.right.left = new Node11(5);
        b.right.right = new Node11(4);

        System.out.println("Are the two trees mirror images? " + areMirror(a, b)); // true
    }
}
