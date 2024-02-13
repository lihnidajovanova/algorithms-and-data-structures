/*
package one_dimensional_data_structures_book;

import java.util.Scanner;

public class BallSortingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // вкупниот број на топчиња
        scanner.nextLine(); // Чистење на новиот ред

        ArrayStack<Character> box1 = new ArrayStack<>(n);
        ArrayStack<Character> box2 = new ArrayStack<>(n);
        ArrayStack<Character> box3 = new ArrayStack<>(n);

        // Читање на топчињата и ставање во првата кутија
        for (int i = 0; i < n; i++) {
            char ball = scanner.nextLine().charAt(0);
            box1.push(ball);
        }

        while (!box1.isEmpty()) {
            char ball = box1.pop();

            // Проверка дали треба да се изврши "бомба"
            if (ball == 'R' && isBomb(box1)) {
                while (!box2.isEmpty() && box2.peek() == 'R') {
                    box2.pop();
                }
            } else {
                box2.push(ball);
            }
        }

        // Преместување на топчињата од box2 во box3
        while (!box2.isEmpty()) {
            box3.push(box2.pop());
        }

        // Печатење на топчињата во третата кутија
        while (!box3.isEmpty()) {
            System.out.print(box3.pop() + " ");
        }
    }

    // Проверка за "бомба"
    private static boolean isBomb(ArrayStack<Character> stack) {
        if (stack.isEmpty() || stack.peek() != 'R') {
            return false;
        }

        char ball1 = stack.pop();
        boolean isBomb = false;

        if (!stack.isEmpty() && stack.peek() == 'R') {
            // If the top ball is 'R', we have a potential bomb
            stack.pop(); // Remove the top 'R' ball
            isBomb = true;
        }

        stack.push(ball1); // Restore the top ball

        return isBomb;
    }
}
*/
