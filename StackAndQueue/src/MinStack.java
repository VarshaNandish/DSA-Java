/*Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
        push() -- Push element x onto stack.
        pop() -- Removes the element on top of the stack.
        top() Get the top element.
        getMin() -- Retrieve the minimum element in the stack.
        Example: obj = MinStack() obj.push(10) obj.push(2) obj.push(5) obj.getMin() // return 2

        Optimized Approach (Two Stacks)
        Algorithm:

        Use two stacks:
        stack — for all elements.
        minStack — for tracking minimums.
        When pushing a value:
        Push onto stack normally.
        Push onto minStack only if:
        It's empty OR
        x <= minStack.peek() (current min)
        When popping:
        If stack.pop() equals minStack.peek(), also pop from minStack.
        getMin() just returns minStack.peek() — always the current minimum.


        Time Complexity: push, pop, top, getMin → all O(1)
        Space Complexity: O(n) — worst case, minStack holds all elements

        Dry Run:

        push(10) → stack: [10], minStack: [10]
        push(2)  → stack: [10, 2], minStack: [10, 2]
        push(5)  → stack: [10, 2, 5], minStack: [10, 2]
        getMin() → minStack.peek() = 2
        pop()    → remove 5 → minStack stays
        pop()    → remove 2 → minStack.pop() too
        getMin() → minStack.peek() = 10  */





import java.util.Stack;

public class MinStack {
    Stack<Integer> stack;     // Normal stack
    Stack<Integer> minStack;  // Stack to track minimums

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    // Push element x onto the stack
    public void push(int x) {
        stack.push(x);
        // Push to minStack if it's empty or x <= current min
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }
    }

    // Removes the top element from the stack
    public void pop() {
        if (stack.isEmpty()) return;
        int removed = stack.pop();
        // If the removed item is also the current min, pop it from minStack
        if (removed == minStack.peek()) {
            minStack.pop();
        }
    }

    // Get the top element
    public int top() {
        return stack.peek();
    }

    // Retrieve the minimum element in the stack
    public int getMin() {
        return minStack.peek();

    }

    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(10);
        obj.push(2);
        obj.push(5);
        System.out.println("Min: " + obj.getMin()); // Output: 2
        obj.pop(); // removes 5
        obj.pop(); // removes 2
        System.out.println("Min: " + obj.getMin()); // Output: 10
    }
}


