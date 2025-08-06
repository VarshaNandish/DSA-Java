/*

Given in-order and pre-order traversals of a Binary Tree, the task is to construct the
Binary Tree and return its root.

Example:
   Input: inorder[] = [3, 1, 4, 0, 5, 2], preorder[] = [0, 1, 3, 4, 2, 5]
   Output: [0, 1, 2, 3, 4, 5]

*/



import java.util.*;

// Define the binary tree node class
class Node18 {
    int val;
    Node18 left, right;

    Node18(int val) {
        this.val = val;
    }
}

public class BuildTreeFromTraversal {

    // Map to store inorder index for fast lookup
    private Map<Integer, Integer> inorderIndexMap;private int preIndex = 0;

    public Node18 buildTree(int[] preorder, int[] inorder) {
        inorderIndexMap = new HashMap<>();

        // Build hashmap of inorder values to their indices
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        return build(preorder, 0, inorder.length - 1);
    }



    private Node18 build(int[] preorder, int inStart, int inEnd) {
        // Base case: no elements to construct
        if (inStart > inEnd) return null;

        // Root from preorder
        int rootVal = preorder[preIndex++];
        Node18 root = new Node18(rootVal);

        // Only one node
        if (inStart == inEnd) return root;

        // Find index of root in inorder
        int rootIndex = inorderIndexMap.get(rootVal);

        // Recurse for left and right subtree
        root.left = build(preorder, inStart, rootIndex - 1);
        root.right = build(preorder, rootIndex + 1, inEnd);
        return root;
    }

    // Optional: print tree in level-order

    public List<Integer> levelOrderTraversal(Node18 root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Queue<Node18> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {

            Node18 current = queue.poll();
            result.add(current.val);

            if (current.left != null) queue.offer(current.left);
            if (current.right != null) queue.offer(current.right);
        }
        return result;
    }

    // Main test

    public static void main(String[] args) {
        int[] inorder = {3, 1, 4, 0, 5, 2};
        int[] preorder = {0, 1, 3, 4, 2, 5};

        BuildTreeFromTraversal builder = new BuildTreeFromTraversal();
        Node18 root = builder.buildTree(preorder, inorder);

        System.out.println("Level order traversal of constructed tree: " +
                builder.levelOrderTraversal(root)); // Output: [0, 1, 2, 3, 4, 5]

    }
}
