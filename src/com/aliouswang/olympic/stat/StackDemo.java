package com.aliouswang.olympic.stat;

import java.util.Stack;

public class StackDemo {

    public static void main(String[] args) {
        String symbol = "(1+3)";
        System.out.println("(1 + 3):" + caculate(symbol));
    }

    public static int caculate(String expression) {
        if (expression == null || expression.isEmpty()) {
            throw new IllegalArgumentException("expression can't be null or empty!");
        }
        char[] chars = expression.toCharArray();
        Stack<Integer> numStack = new Stack<>();
        Stack<Character> symbolStack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if (ch == '(') continue;
            if (ch >= '0' && ch <= '9') {
                numStack.push((int) (ch - '0'));
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                symbolStack.push(ch);
            } else if (ch == ')') {
                int b = numStack.pop();
                int a = numStack.pop();
                char symbol = symbolStack.pop();
                int result = symbol(a, b, symbol);
                numStack.push(result);
            }
        }
        return numStack.pop();
    }

    public static int symbol(int a, int b, char symbol) {
        if (symbol == '+') {
            return a + b;
        } else if (symbol == '-') {
            return a - b;
        } else if (symbol == '*') {
            return a * b;
        } else return a / b;
    }

}
