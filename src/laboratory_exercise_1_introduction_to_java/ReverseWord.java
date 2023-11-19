package laboratory_exercise_1_introduction_to_java;

import java.util.Scanner;

public class ReverseWord {
    public static void printReversed(String word) {
        String reversedWord = "";

        for (int i = word.length() - 1; i >= 0; i--) {
            reversedWord += word.charAt(i);
        }
        System.out.println(reversedWord);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfWords = scanner.nextInt();

        for (int i = 0; i < numberOfWords; i++) {
            String word = scanner.next();
            printReversed(word);
        }
        scanner.close();
    }
}
