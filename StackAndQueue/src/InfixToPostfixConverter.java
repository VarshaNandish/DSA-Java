/*
Write a program to convert an Infix expression to Postfix form.

Infix expression: The expression of the form "a operator b" (a + b) i.e., when an operator is in-between every pair of operands.
Postfix expression: The expression of the form "a b operator" (ab+) i.e., When every pair of operands is followed by an operator.

Examples:

Input: s = "A*(B+C)/D"
Output: ABC+*D/

Input: s = "a+b*(c^d-e)^(f+g*h)-i"
Output: abcd^e-fgh*+^*+i-
 */

import java.util.Stack;

public class InfixToPostfixConverter {

    // Method to define precedence
    static int precedence(char ch) {
        switch (ch) {
            case '^':
                return 3;
            case '*': case '/': case '%':
                return 2;
            case '+': case '-':
                return 1;
        }
        return -1;
    }

    // Method to check if operator is right-associative

    static boolean isRightAssociative(char ch) {
        return ch == '^';
    }

    // Method to convert infix to postfix

    static String infixToPostfix(String exp) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (char ch : exp.toCharArray()) {

            // If operand, add to result
            if (Character.isLetterOrDigit(ch)) {
                result.append(ch);
            }

            // If '(', push to stack
            else if (ch == '(') {
                stack.push(ch);
            }

            // If ')', pop until '('
            else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }

                if (!stack.isEmpty() && stack.peek() == '(')
                    stack.pop(); // remove '('
            }

            // If operator
            else {
                while (!stack.isEmpty() && precedence(stack.peek()) > -1 &&
                        (precedence(ch) < precedence(stack.peek()) ||
                                (precedence(ch) == precedence(stack.peek()) && !isRightAssociative(ch)))) {
                    result.append(stack.pop());
                }
                stack.push(ch);
            }
        }

        // Pop remaining operators
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.toString();
    }

    // Main method to test the converter

    public static void main(String[] args) {

        String exp1 = "A*(B+C)/D";
        String exp2 = "a+b*(c^d-e)^(f+g*h)-i";

        System.out.println("Postfix of '" + exp1 + "' is: " + infixToPostfix(exp1));   // Output: ABC+*D/
        System.out.println("Postfix of '" + exp2 + "' is: " + infixToPostfix(exp2));   // Output: abcd^e-fgh*+^*+i-

    }

}

