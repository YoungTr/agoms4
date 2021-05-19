package com.agoms4.c1.s3;

import edu.princeton.cs.algs4.StdOut;

import java.util.Stack;

public class Ex4 {

    public static void main(String[] args) {
        Ex4 ex4 = new Ex4();

        StdOut.println("Is balanced [()]{}{[()()]()}: " + ex4.isBalanced("[()]{}{[()()]()}"));
        StdOut.println("Is balanced [(]): " + ex4.isBalanced("[(])"));
    }


    private boolean isBalanced(String input) {
        char[] parentheses = input.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (char parenthesis : parentheses) {
            if (parenthesis == '(' || parenthesis == '[' || parenthesis == '{') {
                stack.push(parenthesis);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                Character firstItem = stack.pop();
                if (parenthesis == ')' && firstItem != '('
                        || parenthesis == ']' && firstItem != '['
                        || parenthesis == '}' && firstItem != '{') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
