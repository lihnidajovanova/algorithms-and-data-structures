package laboratory_exercise_6_onedimensional_data_structures;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;

interface Stack<E> {

    // Elementi na stekot se objekti od proizvolen tip.

    // Metodi za pristap:

    public boolean isEmpty();
    // Vrakja true ako i samo ako stekot e prazen.

    public E peek();
    // Go vrakja elementot na vrvot od stekot.

    // Metodi za transformacija:

    public void clear();
    // Go prazni stekot.

    public void push(E x);
    // Go dodava x na vrvot na stekot.

    public E pop();
    // Go otstranuva i vrakja elementot shto e na vrvot na stekot.
}

class ArrayStack<E> implements Stack<E> {
    private E[] elems;
    private int depth;

    @SuppressWarnings("unchecked")
    public ArrayStack(int maxDepth) {
        // Konstrukcija na nov, prazen stek.
        elems = (E[]) new Object[maxDepth];
        depth = 0;
    }

    public boolean isEmpty() {
        // Vrakja true ako i samo ako stekot e prazen.
        return (depth == 0);
    }

    public E peek() {
        // Go vrakja elementot na vrvot od stekot.
        if (depth == 0)
            throw new NoSuchElementException();
        return elems[depth - 1];
    }

    public void clear() {
        // Go prazni stekot.
        for (int i = 0; i < depth; i++) elems[i] = null;
        depth = 0;
    }

    public void push(E x) {
        // Go dodava x na vrvot na stekot.
        elems[depth++] = x;
    }

    public E pop() {
        // Go otstranuva i vrakja elementot shto e na vrvot na stekot.
        if (depth == 0)
            throw new NoSuchElementException();
        E topmost = elems[--depth];
        elems[depth] = null;
        return topmost;
    }
}

public class PostFixEvaluation {
    static int evaluatePostfix(char[] expression, int n) {
        ArrayStack<Integer> stack = new ArrayStack<>(n);

        // Keep track of the current operand
        StringBuilder operandBuilder = new StringBuilder();

        for (int i = 0; i < n; i++) {
            char c = expression[i];

            if (Character.isDigit(c)) {
                operandBuilder.append(c);
            } else if (Character.isWhitespace(c)) {
                // If the character is whitespace, check if there's a complete operand
                if (operandBuilder.length() > 0) {
                    stack.push(Integer.parseInt(operandBuilder.toString()));
                    operandBuilder.setLength(0); // Reset the operand builder
                }
            } else {
                // If the character is an operator, push the operand and then push the operator
                if (operandBuilder.length() > 0) {
                    stack.push(Integer.parseInt(operandBuilder.toString()));
                    operandBuilder.setLength(0); // Reset the operand builder
                }

                int operand2 = stack.pop();
                int operand1 = stack.pop();

                switch (c) {
                    case '+':
                        stack.push(operand1 + operand2);
                        break;
                    case '-':
                        stack.push(operand1 - operand2);
                        break;
                    case '*':
                        stack.push(operand1 * operand2);
                        break;
                    case '/':
                        stack.push(operand1 / operand2);
                        break;
                }
            }
        }

        // If there's a remaining operand, push it onto the stack
        if (operandBuilder.length() > 0) {
            stack.push(Integer.parseInt(operandBuilder.toString()));
        }

        // The final result should be on the top of the stack
        return stack.pop();
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String expression = br.readLine();
        char exp[] = expression.toCharArray();

        int rez = evaluatePostfix(exp, exp.length);
        System.out.println(rez);

        br.close();
    }
}
/*
    In the context of the provided code, the operandBuilder is a StringBuilder that is used to build the characters of a numeric operand (a number) when parsing the input expression. Here's a more detailed explanation:

        Accumulating Digits:

        When the algorithm encounters a digit in the input expression, it appends that digit to the operandBuilder. This is important for handling multi-digit numbers in the expression.
        Converting to Integer:

        When an operator or whitespace is encountered in the expression, it checks if the operandBuilder has accumulated any digits. If so, it converts the contents of the operandBuilder to an integer and pushes that integer onto the stack.
        Resetting the Builder:

        After pushing the operand onto the stack, the operandBuilder is reset (its length is set to 0) so that it can be used to accumulate the digits of the next operand.
        Here's a simple example to illustrate its use:

// Sample input expression: "28 72 * 13 + 20 67 * +"
        char[] expression = {'2', '8', ' ', '7', '2', ' ', '*', '1', '3', ' ', '+', '2', '0', ' ', '6', '7', ' ', '*', '+'};

// Processing the input expression
        ArrayStack<Integer> stack = new ArrayStack<>(expression.length);

        StringBuilder operandBuilder = new StringBuilder(); // Initialize the operand builder

        for (int i = 0; i < expression.length; i++) {
        char c = expression[i];

        if (Character.isDigit(c)) {
        operandBuilder.append(c); // Append digit to the operand builder
        } else if (Character.isWhitespace(c)) {
        // Do nothing for whitespace
        } else {
        // If an operator is encountered or a non-digit character,
        // convert the contents of the operandBuilder to an integer and push it onto the stack
        if (operandBuilder.length() > 0) {
        stack.push(Integer.parseInt(operandBuilder.toString()));
        operandBuilder.setLength(0); // Reset the operand builder
        }

        // Handle the operator (in this case, push the operator onto the stack)
        // Additional code for operator handling would be added here
        }
        }

// After the loop, check if there's any remaining operand in the operandBuilder
        if (operandBuilder.length() > 0) {
        stack.push(Integer.parseInt(operandBuilder.toString()));
        }

// The final result should be on the top of the stack
        int finalResult = stack.pop();
        System.out.println(finalResult); // Output: 3369
*/