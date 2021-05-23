package com.agoms4.c1.s3;

import edu.princeton.cs.algs4.StdOut;

import java.util.Stack;

public class Ex9 {

    public static String getInfixExpression(String input) {
        Stack<String> operands = new Stack<>();  // 操作数
        Stack<String> operators = new Stack<>(); // 操作符

        String[] inputValues = input.split("\\s");
        for (String value : inputValues) {
            if (value.equals("(")) {
                // do nothing
            } else if (value.equals("+")
                    || value.equals("-")
                    || value.equals("*")
                    || value.equals("/")) {
                operators.push(value);
            } else if (value.equals(")")) {
                String operate = operators.pop();
                String value2 = operands.pop();
                String value1 = operands.pop();
                String subExpression = "( " + value1 + " " + operate + " " + value2 + " )";
                operands.push(subExpression);
            } else {
                operands.push(value);
            }
        }

        return operands.pop();
    }


    // Parameter example: "1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )"
    public static void main(String[] args) {
        String input = "1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )";
        StdOut.println(getInfixExpression(input));
    }
}
