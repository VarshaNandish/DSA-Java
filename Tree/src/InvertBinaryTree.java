/*  Problem Statement: Invert a Binary Tree

Goal: Swap every node’s left and right child to invert the tree.

Original Tree:

        1

       / \

      2   3

     / \   \

    4   5   6

Inverted Tree:

        1

       / \

      3   2

     /   / \

    6   5   4

Approach : Naive (Recursive - DFS) Expected and most used
Idea:
Traverse tree recursively using Depth First Search (DFS).
At each node, swap the left and right child.
Recursively do this for left and right subtrees.

Steps:
If the root is null, return.
Swap left and right children of current node.
Recursively call the same method on the left and right child.

Time & Space Complexity:
Time:
O(n) – every node is visited once
Space:
O(h) – height of the tree (call stack)
Worst Space:
O(n) – skewed tree; Best: O(log n) (balanced tree)
*/



class TreeNodeInverse {
    int val;
    TreeNode left, right;

    TreeNodeInverse(int val) {
        this.val = val;
    }
}



public class InvertBinaryTree {

    // Recursive DFS method to invert the tree
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        // Swap the left and right child
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // Recursively invert left and right subtrees
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    // Helper method to print inorder traversal of tree
    public void inorderPrint(TreeNode root) {
        if (root == null) return;
        inorderPrint(root.left);
        System.out.print(root.val + " ");
        inorderPrint(root.right);
    }


    // Main method to test
    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);

        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);

        root.left.right = new TreeNode(5);

        root.right.right = new TreeNode(6);


        InvertBinaryTree tree = new InvertBinaryTree();


        System.out.print("Inorder Before Inversion: ");

        tree.inorderPrint(root);

        System.out.println();


        tree.invertTree(root);


        System.out.print("Inorder After Inversion: ");

        tree.inorderPrint(root);
    }

}
