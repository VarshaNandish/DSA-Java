/*

Given two binary trees, check if the first tree is a subtree of the second one.
A subtree of a tree T(root1) is a tree S(root2) consisting of a node in T and all of its
descendants in T. The subtree corresponding to the root node is the entire tree and the
subtree corresponding to any other node is called a proper subtree.

*/



// Node class renamed to Node17

class Node17 {
    int val;
    Node17 left, right;

    Node17(int val) {
        this.val = val;
    }
}

public class SubtreeChecker {
    // Main function to check if S is a subtree of T
    public boolean isSubtree(Node17 T, Node17 S) {

        // Base case
        if (S == null) return true;         // An empty tree is always a subtree
        if (T == null) return false;        // A non-empty tree cannot be a subtree of an empty tree

        // If the current trees rooted at T and S are identical
        if (isSameTree(T, S)) return true;

        // Otherwise, check the left and right subtrees of T
        return isSubtree(T.left, S) || isSubtree(T.right, S);
    }



    // Helper function to check if two trees are identical
    public boolean isSameTree(Node17 a, Node17 b) {
        // If both nodes are null, trees are identical
        if (a == null && b == null) return true;

        // If one is null and the other is not, trees are not identical
        if (a == null || b == null) return false;

        // Check current node values and recurse on left and right children
        return (a.val == b.val) &&
                isSameTree(a.left, b.left) &&
                isSameTree(a.right, b.right);
    }

    // Test the logic
    public static void main(String[] args) {

        // Construct Tree T
        Node17 T = new Node17(3);
        T.left = new Node17(4);
        T.right = new Node17(5);
        T.left.left = new Node17(1);
        T.left.right = new Node17(2);
        T.left.right.left = new Node17(0);  // This node makes T not match S

        // Construct Tree S
        Node17 S = new Node17(4);
        S.left = new Node17(1);
        S.right = new Node17(2);

        SubtreeChecker checker = new SubtreeChecker();

        boolean result = checker.isSubtree(T, S);

        System.out.println("Is S a subtree of T? " + result);
    }

}
