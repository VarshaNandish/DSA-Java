/*

Java program for deleting a node in a Binary Search Tree (BST) and displaying the tree via inorder traversal.

Time & Space Complexity:

Insert/Delete
Time:O(h)
Space:O(h) stack (recursive)

Inorder
Time:O(n)
Space:O(h) stack

Approach: standard and expected approach for deleting a node in a Binary Search Tree (BST) in Java. It:

Correctly handles all deletion cases (0, 1, and 2 children).
Recursively updates links to preserve tree structure.
Maintains the BST properties after deletion.
Uses inorder traversal to confirm correctness.

*/

// Node class to represent each node of the tree
class Node {
    int data;
    Node left, right;

    // Constructor to initialize the node with data
    Node(int value) {
        data = value;
        left = right = null;
    }
}

// BSTree class containing delete and inorder display operations
public class BSTDelete {
    Node root; // Root of the BST

    // Insert nodes into the BST (used to build tree for testing)
    public void insert(int value) {
        root = insertNode(root, value);
    }

    private Node insertNode(Node node, int value) {
        if (node == null) return new Node(value);

        if (value < node.data)
            node.left = insertNode(node.left, value);
        else if (value > node.data)
            node.right = insertNode(node.right, value);

        // Ignore duplicates
        return node;

    }

    // DELETE METHOD: deletes a node with the given value (key)

    public Node deleteNode(Node node, int key) {
        if (node == null) return null;
        if (key < node.data) {
            node.left = deleteNode(node.left, key); // Go left
        } else if (key > node.data) {
            node.right = deleteNode(node.right, key); // Go right
        } else {

            // Node found

            // Case 1: Leaf node
            if (node.left == null && node.right == null) {
                return null;
            }

            // Case 2: One child (right)
            else if (node.left == null) {
                return node.right;
            }

            // Case 3: One child (left)
            else if (node.right == null) {
                return node.left;
            }

            // Case 4: Two children
            else {
                Node successor = findMin(node.right); // Find smallest in right subtree
                node.data = successor.data;           // Replace with successor's data
                node.right = deleteNode(node.right, successor.data); // Delete successor
            }
        }

        return node;
    }

    // Helper to find the minimum node in a subtree
    private Node findMin(Node node) {
        while (node.left != null) {
            node = node.left;

        }
        return node;
    }

    // Inorder traversal to display tree elements (Left → Root → Right)
    public void displayInorder(Node node) {
        if (node != null) {
            displayInorder(node.left);
            System.out.print(node.data + " ");
            displayInorder(node.right);
        }
    }

    // Main method to test delete and display operations
    public static void main(String[] args) {

        BSTDelete bst = new BSTDelete();

        // Inserting nodes

        bst.insert(50);

        bst.insert(30);

        bst.insert(70);

        bst.insert(20);

        bst.insert(40);

        bst.insert(60);

        bst.insert(80);

        System.out.println("Inorder before deletion:");

        bst.displayInorder(bst.root);  // Expected: 20 30 40 50 60 70 80

        System.out.println();

        // Deleting a node

        System.out.println("Deleting node 30...");

        bst.root = bst.deleteNode(bst.root, 30);

        System.out.println("Inorder after deletion:");

        bst.displayInorder(bst.root);  // Expected: 20 40 50 60 70 80

    }

}
