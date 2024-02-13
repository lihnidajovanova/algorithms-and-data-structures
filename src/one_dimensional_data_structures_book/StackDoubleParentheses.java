/*
package one_dimensional_data_structures_book;

import java.util.Scanner;

public class DoubleParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.nextLine();

        if (checkDuplicateParentheses(expression)) {
            System.out.println("Najdeni se dupli zagradi");
        } else {
            System.out.println("/");
        }
    }

    public static boolean checkDuplicateParentheses(String expression) {
        ArrayStack<Character> stack = new ArrayStack<>(1000);
        boolean singleVariable = false; // Флаг за проверка на случајот кога променливата е сама во заграда
        int nestedCount = 0; // Бројач за вгнездени загради

        for (char c : expression.toCharArray()) {
            if (c == '(') {
                stack.push(c);
                nestedCount++;
            } else if (c == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    return true; // Дупли загради
                } else {
                    stack.pop();
                    nestedCount--;
                }
            }

            if (nestedCount == 0 && !stack.isEmpty()) {
                singleVariable = true;
            }
        }

        return !stack.isEmpty() || singleVariable;
    }
}*/
