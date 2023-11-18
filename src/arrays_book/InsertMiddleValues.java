package arrays_book;

import java.util.Scanner;

public class InsertMiddleValues {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();    // read the number of elements in the array
        int[] array = new int[n];   // array to store the input values

        // read the elements from the input
        for (int i = 0; i < n; i++) {
            array[i] = input.nextInt();
        }

        input.close();

        // calculate the length og=f the new array using middle values
        int newArrayLength = 2 * n - 1;
        int[] newArray = new int[newArrayLength];

        // insert values into the new array, calculating middle values between adjacent elements
        for (int i = 0; i < n - 1; i++) {
            newArray[i * 2] = array[i]; // copy the original value
            newArray[i * 2 + 1] = (array[i] + array[i + 1] + 1) / 2;    // calculate and insert the middle value
        }

        newArray[newArrayLength - 1] = array[n - 1];    //  copy the last element

        // print the array with inserted middle values
        for (int value : newArray) {
            System.out.print(value + " ");
        }
    }
}