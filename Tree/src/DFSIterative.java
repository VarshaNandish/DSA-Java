/*Binary tree with Iterative Traversals
Objective
Construct a binary tree and implement:

Inorder Traversal: Left → Root → Right
Preorder Traversal: Root → Left → Right
Postorder Traversal: Left → Right → Root


Iterative Approach (Expected for Interviews)
Preferred in large inputs. Avoids recursion limit, explicit stack
We'll use stacks for this. */


import java.util.Stack;

class TreNode {
    int val;
    TreeNode left, right;

    TreNode(int val) {
        this.val = val;
    }
}

// DFSIterative class contains all 3 iterative traversal methods
public class DFSIterative {
    // Iterative Preorder Traversal: Root → Left → Right
    public void preorderIterative(TreeNode root) {

        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            System.out.print(curr.val + " ");

            // Push right first so left is processed first
            if (curr.right != null) stack.push(curr.right);
            if (curr.left != null) stack.push(curr.left);
        }
    }

    // Iterative Inorder Traversal: Left → Root → Right
    public void inorderIterative(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            // Reach the leftmost node
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            // Visit the node
            curr = stack.pop();
            System.out.print(curr.val + " ");
            // Visit right subtree
            curr = curr.right;
        }
    }

    // Iterative Postorder Traversal: Left → Right → Root (using 2 stacks)
    public void postorderIterative(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);

        while (!stack1.isEmpty()) {
            TreeNode node = stack1.pop();
            stack2.push(node);

            if (node.left != null) stack1.push(node.left);
            if (node.right != null) stack1.push(node.right);
        }

        // stack2 will contain the postorder sequence
        while (!stack2.isEmpty()) {
            System.out.print(stack2.pop().val + " ");
        }
    }

    // Main method to test the iterative traversals
    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        DFSIterative tree = new DFSIterative();

        System.out.print("Iterative Preorder: ");

        tree.preorderIterative(root);   // Output: 1 2 4 5 3 6

        System.out.println();

        System.out.print("Iterative Inorder: ");

        tree.inorderIterative(root);    // Output: 4 2 5 1 3 6

        System.out.println();

        System.out.print("Iterative Postorder: ");

        tree.postorderIterative(root);  // Output: 4 5 2 6 3 1

        System.out.println();

    }
}