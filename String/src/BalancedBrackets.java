/*
Given a string s containing three types of brackets {}, () and []. We have to determine whether the brackets arebalanced. An expression is balanced if each opening bracket has a corresponding closing bracket of the same type, the pairs are properly ordered and no bracket closes before its matching opening bracket.

    Balanced:"[()()]{}" → every opening bracket is closed in the correct order.
    Not balanced:"([{]})" → the ] closes before the matching { is closed, breaking the nesting rule.

Example:

    Input: s = "[{()}]"
    Output: true
    Explanation:  All the brackets are well-formed.

    Input: s = "[()()]{}"
    Output: true
    Explanation: All the brackets are well-formed.

    Input: s = "([]"
    Output: false
    Explanation: The expression is not balanced as there is a missing ')' at the end.

    Input:  s = "([{]})"
    Output: false
    Explanation: The expression is not balanced because there is a closing ']' before the closing '}'.
*/
import java.util.*;

public class BalancedBrackets {
    public static boolean isBalanced(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            // Push opening brackets onto the stack
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }
            // Check closing brackets
            else if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty()) return false; // No matching opening
                char top = stack.pop();
                if ((c == ')' && top != '(') ||
                        (c == '}' && top != '{') ||
                        (c == ']' && top != '[')) {
                    return false; // Mismatch
                }
            }
        }
        // If stack is empty, all brackets were matched
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isBalanced("[{()}]"));     // true
        System.out.println(isBalanced("[()()]{}"));   // true
        System.out.println(isBalanced("([]"));        // false
        System.out.println(isBalanced("([{]})"));     // false
    }
}