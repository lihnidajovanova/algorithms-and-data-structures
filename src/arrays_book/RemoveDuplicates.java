package arrays_book;

import java.util.Scanner;

public class RemoveDuplicates {

    // method for removing duplicates
    public static int[] removeAdjacentDuplicates(int[] array) {
        int n = array.length;
        int[] result = new int[n];
        int j = 0;

        for (int i = 0; i < n - 1; i++) {
            if (array[i] != array[i + 1]) {
                result[j] = array[i];
                j++;
            }
        }

        result[j] = array[n - 1];   //add the last element

        int[] finalResult = new int[j + 1];

        //copy the results in a new array
        System.arraycopy(result, 0, finalResult, 0, j + 1);

        return finalResult;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt(); //read the number of elements in the array
        int[] array = new int[N];

        // read the elements and fill in the array
        for (int i = 0; i < N; i++) {
            array[i] = scanner.nextInt();
        }

        scanner.close();

        // removed duplicates
        int[] resultArray = removeAdjacentDuplicates(array);

        // printing the array with the removed duplicates
        for (int value : resultArray) {
            System.out.print(value + " ");
        }
    }
}