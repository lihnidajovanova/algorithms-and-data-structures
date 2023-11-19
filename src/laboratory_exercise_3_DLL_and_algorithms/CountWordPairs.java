package laboratory_exercise_3_DLL_and_algorithms;

import java.util.Scanner;

public class CountWordPairs {
    public static int countWordPairs(String[] words) {
        int[] countLetter = new int[26]; // array to store the count of words for each starting letter (Assuming English alphabet)
        int countPairs = 0; // variable to store the total count of word pairs that start with the same letter

        // iterate through each word in the array
        for (String word : words) {
            char firstLetter = word.toLowerCase().charAt(0); // get the first letter of the word in lowercase
            int index = firstLetter - 'a'; // calculate the index of the letter in the array (Assuming English alphabet)

            // check if there was a previous word with the same starting letter
            countPairs += countLetter[index];

            // increment the count for the current starting letter
            countLetter[index]++;
        }

        // return the total count of word pairs that start with the same letter
        return countPairs;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        input.nextLine();

        String[] words = new String[N];

        for (int i = 0; i < N; i++) {
            words[i] = input.nextLine();
        }

        System.out.println(countWordPairs(words));
    }
}