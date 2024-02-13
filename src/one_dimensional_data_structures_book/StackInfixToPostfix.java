package one_dimensional_data_structures_book;

public class StackInfixToPostfix {
    public static String infixToPostfix(String infix) {
        StringBuilder postfix = new StringBuilder();
        ArrayStack<Character> operatorStack = new ArrayStack<>(1000);

        for (char c : infix.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                postfix.append(c);  // Ако е операнд, додади го на постфикс изразот
            } else if (c == '(') {
                operatorStack.push(c);  // Ако е (, стави го на стекот на оператори
            } else if (c == ')') {
                // Премести оператори од стекот на оператори на постфикс се додека не наидеш на (
                while (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
                    postfix.append(operatorStack.pop());
                }
                operatorStack.pop();    // Отстрани го ( од стекот на оператори
            } else {
                // Операторите имаат различни приоритети
                // Премести оператори од стекот на оператори на постфикс доколку имаат поголем или ист приоритет
                while (!operatorStack.isEmpty() && precedence(c) <= precedence(operatorStack.peek())) {
                    postfix.append(operatorStack.pop());
                }
                operatorStack.push(c);
            }
        }

        // Премести ги сите преостанати оператори од стекот на оператори на постфикс
        while (!operatorStack.isEmpty()) {
            postfix.append(operatorStack.pop());
        }
        return postfix.toString();
    }

    public static int precedence(char operator) {
        switch (operator) {
            case '^':
                return 3;
            case '*':
            case '/':
                return 2;
            case '+':
            case '-':
                return 1;
            default:
                return 0;
        }
    }

    public static void main(String[] args) {
        String infixExpression = "a+b*(c^d-e)^(f+g*h)-i";
        String postfixExpression = infixToPostfix(infixExpression);
        System.out.println(postfixExpression);
    }
}