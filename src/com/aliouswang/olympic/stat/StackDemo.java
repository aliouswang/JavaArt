package com.aliouswang.olympic.stat;

public class StackDemo {

    public static void main(String[] args) {

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
                numStack.push((int) ch);
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                symbolStack.push(ch);
            }
        }
        return 0;
    }

}
