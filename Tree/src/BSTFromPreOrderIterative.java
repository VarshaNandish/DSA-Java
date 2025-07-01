/*

Problem Statement:
Given an array representing the preorder traversal of a BST, construct the BST.

Approach : Iterative Using Stack (Expected as follow-up)
Core Idea:
Use a stack to keep track of ancestors (like recursion call stack).
The top of the stack is the most recent node.
If the current value is less than stack top, it's a left child.
If the current value is greater than stack top, pop until you find the correct parent, then insert as right child.

Time and Space Complexity:
Time:
O(n)
Space:
O(n) (stack size in worst case)

*/



import java.util.Stack;

class TreeNodeIter {
    int val;
    TreeNode left, right;

    TreeNodeIter(int val) {
        this.val = val;
    }
}

public class BSTFromPreOrderIterative {

    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder.length == 0) return null;

        // Step 1: Create root node
        TreeNode root = new TreeNode(preorder[0]);
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        // Step 2: Iterate through remaining elements
        for (int i = 1; i < preorder.length; i++) {
            TreeNode node = new TreeNode(preorder[i]);
            TreeNode parent = stack.peek();


            // Step 3: Find parent for current node
            // If node value < parent → left child
            if (node.val < parent.val) {
                parent.left = node;
            } else {
                // Find ancestor to attach this node as right child
                while (!stack.isEmpty() && stack.peek().val < node.val) {
                    parent = stack.pop();
                }
                parent.right = node;
            }

            // Step 4: Push current node to stack
            stack.push(node);
        }

        return root;
    }

    // Inorder print for checking correctness
    public void printInorder(TreeNode root) {
        if (root == null) return;
        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }

    public static void main(String[] args) {
        int[] preorder = {8, 5, 1, 7, 10, 12};
        BSTFromPreOrderIterative obj = new BSTFromPreOrderIterative();
        TreeNode root = obj.bstFromPreorder(preorder);
        System.out.print("Inorder Traversal of BST: ");
        obj.printInorder(root);
    }
}
