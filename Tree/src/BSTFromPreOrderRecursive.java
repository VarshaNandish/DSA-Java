/* Problem Statement:

Given an array representing the preorder traversal of a BST, construct the BST.

Approach : Optimized Recursive Using Bounds (Best & Expected)
Key Idea:
We use preorder traversal rules + BST property to build the tree using a single pass through the array.

We maintain:

A currentIndex pointer (as a class/global variable)
A value boundary (min, max) to validate whether the current value fits in the BST range
Time Complexity: O(n)
Each element is visited exactly once
Space Complexity: O(h) (height of tree)
Due to recursion stack
*/



class TreeNodeRecur {
    int val;
    TreeNode left, right;

    TreeNodeRecur(int val) {
        this.val = val;
    }
}



public class BSTFromPreOrderRecursive {

    private int index = 0; // current index in preorder array

    public TreeNode bstFromPreorder(int[] preorder) {
        return helper(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    // Recursive helper function with lower and upper bounds
    private TreeNode helper(int[] preorder, int lower, int upper) {
        if (index >= preorder.length)
            return null;
        int val = preorder[index];

        // Value must be within [lower, upper] to fit BST rules
        if (val < lower || val > upper)
            return null;

        // Valid value → create node and advance index
        TreeNode root = new TreeNode(val);
        index++;

        // Recursively build left and right subtrees
        root.left = helper(preorder, lower, val);    // Left subtree must be < current value
        root.right = helper(preorder, val, upper);   // Right subtree must be > current value

        return root;
    }


    // Inorder print (for checking correctness)
    public void printInorder(TreeNode root) {
        if (root == null) return;
        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }

    public static void main(String[] args) {
        int[] preorder = {8, 5, 1, 7, 10, 12};

        BSTFromPreOrderRecursive builder = new BSTFromPreOrderRecursive();

        TreeNode root = builder.bstFromPreorder(preorder);

        System.out.print("Inorder traversal of constructed BST: ");

        builder.printInorder(root);  // Output should be sorted: 1 5 7 8 10 12

    }
}

