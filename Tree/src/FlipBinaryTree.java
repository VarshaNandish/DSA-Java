/*
Given a binary tree, the task is to flip the binary tree towards the right direction that is clockwise.
Explanation: In the flip operation, the leftmost node becomes the root of the flipped tree and its parent becomes its right child and the right sibling
becomes its left child and the same should be done for all leftmost nodes recursively.
 */
// Definition of Tree Node
class Node12 {
    int val;
    Node12 left, right;

    Node12(int val) {
        this.val = val;
        left = right = null;
    }
}

public class FlipBinaryTree {

    // Function to flip the binary tree clockwise (recursively)
    public static Node12 flipTree(Node12 root) {
        // Base case: if root is null or has no left child
        if (root == null || root.left == null)
            return root;

        // Recursively flip the left subtree
        Node12 newRoot = flipTree(root.left);

        // Reassign pointers
        root.left.left = root.right; // former right child becomes new left child
        root.left.right = root;      // current node becomes new right child

        // Disconnect current node from its children
        root.left = null;
        root.right = null;

        return newRoot; // return new root of flipped tree
    }

    // Utility: Inorder traversal for visualization
    public static void inorder(Node12 root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    // Main
    public static void main(String[] args) {
        // Original Tree
        Node12 root = new Node12(1);
        root.left = new Node12(2);
        root.right = new Node12(3);
        root.left.left = new Node12(4);
        root.left.right = new Node12(5);

        System.out.print("Inorder Before Flip: ");
        inorder(root);
        System.out.println();

        Node12 flippedRoot = flipTree(root);

        System.out.print("Inorder After Flip: ");
        inorder(flippedRoot);
    }
}

