package laboratory_exercise_4_algorithms;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ArithmeticExpression {

    // Function to find the index of the closing bracket corresponding to the opening bracket at 'start'
    static int findClosingBracket(char c[], int start) {
        int i, numOpened = 1;

        // Loop until we find the closing bracket for the opening bracket at 'start'
        for (i = start + 1; ; i++) {
            if (c[i] == '(') {
                numOpened++;
            } else if (c[i] == ')') {
                numOpened--;
                if (numOpened == 0) {
                    return i;
                }
            }
        }
    }

    // funkcija za presmetuvanje na izrazot pocnuvajki
    // od indeks l, zavrsuvajki vo indeks r
    static int presmetaj(char c[], int l, int r) {
        // Vasiot kod tuka
        // Remove the first and last brackets
        l++;
        r--;

        // Base case: if the expression is a single digit
        if (r - l == 2) {
            char operator = c[l + 1];
            int leftOperand = c[l] - '0';
            int rightOperand = c[r] - '0';

            if (operator == '+') {
                return leftOperand + rightOperand;
            } else {
                return leftOperand - rightOperand;
            }
        }

        // Find the indices of the first and second sub-expressions
        int firstExpressionStart = l;
        int firstExpressionEnd = findClosingBracket(c, firstExpressionStart);

        int secondExpressionStart = firstExpressionEnd + 2;
        int secondExpressionEnd = findClosingBracket(c, secondExpressionStart);

        // Evaluate the sub-expressions and perform the operation
        int leftResult = presmetaj(c, firstExpressionStart, firstExpressionEnd);
        int rightResult = presmetaj(c, secondExpressionStart, secondExpressionEnd);

        char operator = c[firstExpressionEnd + 1];

        if (operator == '+') {
            return leftResult + rightResult;
        } else {
            return leftResult - rightResult;
        }
    }

    public static void main(String[] args) throws Exception {
        int i, j, k;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String expression = br.readLine();
        char exp[] = expression.toCharArray();

        int rez = presmetaj(exp, 0, exp.length - 1);
        System.out.println(rez);

        br.close();
    }
}