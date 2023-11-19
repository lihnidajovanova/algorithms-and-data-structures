package first_midterm_exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// without STACK
public class ExpressionEvaluator {
    public static int evaluateExpression(String expression) {
        int result = 0;

        String[] add = expression.split("\\+");

        for (String s : add) {
            String[] multiply = s.split("\\*");
            int mul = 1;

            for (String string : multiply) {
                mul *= Integer.parseInt(string);
            }

            result += mul;
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(evaluateExpression(input.readLine()));
    }
}