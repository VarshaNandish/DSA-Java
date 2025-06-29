/* Design a stack that supports push, pop, top, and retrieving the maximum element in constant time.

        push(x) Push element x onto the stack.
        pop() Removes the element on top of the stack.
        top() Get the top element.
        getMax() - Retrieve the maximum element in the stack.
        Example: obj = MaxStack() obj.push(10) obj.push(2) obj.push(5) obj.getMax() // return 10

        Approach : Optimized (Two Stacks)
        Algorithm:
        Use two stacks:
        stack → to store actual values
        maxStack → to store the max element so far
        Push(x):
        Push x to stack
        If maxStack is empty or x >= maxStack.peek(), push x to maxStack
        Pop():
        Pop from stack
        If popped element == maxStack.peek(), pop from maxStack too
        top():
        Return stack.peek()
        getMax():
        Return maxStack.peek() — always current max

        Time Complexity: push, pop, top, getMax → all O(1)
        Space Complexity: O(n)

        Dry Run:

        push(10) → stack: [10], maxStack: [10]
        push(2)  → stack: [10, 2], maxStack: [10]
        push(5)  → stack: [10, 2, 5], maxStack: [10]
        getMax() → maxStack.peek() = 10
        pop()    → pop 5 → maxStack stays
        pop()    → pop 2 → maxStack stays
        getMax() → maxStack.peek() = 10 */



import java.util.Stack;

public class MaxStack {
    Stack<Integer> stack;
    Stack<Integer> maxStack;

    public MaxStack() {
        stack = new Stack<>();
        maxStack = new Stack<>();
    }

    // Push value onto stack
    public void push(int x) {
        stack.push(x);
        // Update maxStack if it's empty or x is >= current max
        if (maxStack.isEmpty() || x >= maxStack.peek()) {
            maxStack.push(x);
        }
    }

    // Remove top element from stack
    public void pop() {
        if (stack.isEmpty()) return;
        int removed = stack.pop();
        // If removed element was the current max, pop from maxStack too
        if (!maxStack.isEmpty() && removed == maxStack.peek()) {
            maxStack.pop();
        }
    }

    // Return top element of stack
    public int top() {
        return stack.peek();
    }

    // Return the maximum element
    public int getMax() {
        return maxStack.peek();
    }

    public static void main(String[] args) {
        MaxStack obj = new MaxStack();
        obj.push(10);
        obj.push(2);
        obj.push(5);
        System.out.println("Max: " + obj.getMax()); // Output: 10
        obj.pop(); // Remove 5
        System.out.println("Top: " + obj.top());    // Output: 2
        System.out.println("Max: " + obj.getMax()); // Output: 10
    }
}


