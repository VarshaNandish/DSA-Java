/*

 */

// Definition of Tree Node
class Node10 {
    int val;
    Node10 left, right;

    Node10(int val) {
        this.val = val;
        left = right = null;
    }
}

public class MaxDepthBinaryTree {

    // Recursive method to find max depth (in terms of edges)
    public static int maxDepth(Node10 root) {
        if (root == null)
            return  -1; // height in terms of edges (return 0 for height in terms of nodes)

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        return 1 + Math.max(leftDepth, rightDepth);
    }

    // Main method to test
    public static void main(String[] args) {
        // Example: Tree from input 1
        Node10 root1 = new Node10(12);
        root1.left = new Node10(8);
        root1.left.left = new Node10(5);

        System.out.println("Max Depth: " + maxDepth(root1));  // Output: 2 (edges)

        // Example: Tree from input 2
        Node10 root2 = new Node10(1);
        root2.left = new Node10(2);
        root2.left.left = new Node10(4);
        root2.left.left.left = new Node10(6);

        System.out.println("Max Depth: " + maxDepth(root2));  // Output: 3 (edges)
    }
}
