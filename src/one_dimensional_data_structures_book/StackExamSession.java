/*
package one_dimensional_data_structures_book;

import java.util.*;

public class ExamSession {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Читање на влезните податоци
        int M = scanner.nextInt(); // број на книги
        int N = scanner.nextInt(); // број на испити

        // Читање на имињата на книгите
        String[] books = new String[M];
        for (int i = 0; i < M; i++) {
            books[i] = scanner.next();
        }

        // Читање на испитите
        String[] exams = new String[N];
        for (int i = 0; i < N; i++) {
            exams[i] = scanner.next();
        }

        // Пресметување на резултатот
        Map<String, Integer> result = countBookEvents(books, exams);

        // Печатење на резултатот
        for (String book : books) {
            System.out.println(book + " " + result.get(book));
        }
    }

    // Метод за пресметка на бројот на настани за секоја книга
    private static Map<String, Integer> countBookEvents(String[] books, String[] exams) {
        Map<String, Integer> bookEvents = new LinkedHashMap<>();
        ArrayStack<String> stack = new ArrayStack<>(1000000);

        // Пополнување на стекот со книги
        for (String book : books) {
            stack.push(book);
            bookEvents.put(book, 0);
        }

        // Симулација на испитната сесија
        for (String exam : exams) {
            ArrayStack<String> tempStack = new ArrayStack<>(1000000);
            boolean found = false;

            // Извлекување на книгите се додека не се најде испитот
            while (!stack.isEmpty()) {
                String currentBook = stack.pop();
                bookEvents.put(currentBook, bookEvents.get(currentBook) + 1);
                if (currentBook.equals(exam)) {
                    found = true;
                    break;
                }
                tempStack.push(currentBook);
            }

            // Враќање на книгите на стекот, во ист редослед
            while (!tempStack.isEmpty()) {
                stack.push(tempStack.pop());
            }

            // Ако испитот не е најден, стекот останува непроменет
            if (!found) {
                while (!stack.isEmpty()) {
                    tempStack.push(stack.pop());
                }
                while (!tempStack.isEmpty()) {
                    stack.push(tempStack.pop());
                }
            }
        }
        return bookEvents;
    }
}*/
