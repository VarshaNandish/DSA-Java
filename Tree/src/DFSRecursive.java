/* Binary Tree with Recursive Traversals

Objective:
Construct a binary tree and implement:

Inorder Traversal: Left → Root → Right
Preorder Traversal: Root → Left → Right
Postorder Traversal: Left → Right → Root
Naive (recursive) approach — clean and efficient.
Recursive Approach (Naive but Optimal for Clarity) */


class TreeNode {
    int val;
    TreeNode left, right;

    // Constructor to initialize the node value
    TreeNode(int val) {
        this.val = val;
    }
}

// Main class that handles tree construction and traversal
public class DFSRecursive {
    // Recursive Preorder Traversal: Root → Left → Right
    public void preorder(TreeNode root) {
        if (root == null) return;
        // Visit the root node
        System.out.print(root.val + " ");
        // Traverse left subtree
        preorder(root.left);
        // Traverse right subtree
        preorder(root.right);
    }

    // Recursive Inorder Traversal: Left → Root → Right
    public void inorder(TreeNode root) {
        if (root == null) return;
        // Traverse left subtree
        inorder(root.left);
        // Visit the root node
        System.out.print(root.val + " ");
        // Traverse right subtree
        inorder(root.right);
    }

    // Recursive Postorder Traversal: Left → Right → Root
    public void postorder(TreeNode root) {
        if (root == null) return;
        // Traverse left subtree
        postorder(root.left);
        // Traverse right subtree
        postorder(root.right);
        // Visit the root node
        System.out.print(root.val + " ");
    }

    // Main method to construct the tree and perform traversals
    public static void main(String[] args) {

        // Step 1: Create all nodes
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        // Step 2: Create instance of BinaryTreeTraversal
        DFSRecursive tree = new DFSRecursive();

        // Step 3: Perform traversals
        System.out.print("Preorder Traversal: ");
        tree.preorder(root);   // Output: 1 2 4 5 3 6
        System.out.println();
        System.out.print("Inorder Traversal: ");
        tree.inorder(root);    // Output: 4 2 5 1 3 6
        System.out.println();
        System.out.print("Postorder Traversal: ");
        tree.postorder(root); // Output: 4 5 2 6 3 1
        System.out.println();
    }
}