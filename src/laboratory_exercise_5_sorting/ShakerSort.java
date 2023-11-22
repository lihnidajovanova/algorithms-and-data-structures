package laboratory_exercise_5_sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ShakerSort {
    static void shakerSort(int a[], int n) {
        for (int i = 0; i < n - i; ++i) {   // 'i < n - i' ensures that the loop doesn't go beyond the center of the array
            boolean change = false;

            // go through the array from right to left
            // smaller element on the right
            // after this, the array is partially sorted with the smallest element at the beginning
            for (int j = n - i - 1; j > i; --j) {
                // Compare adjacent elements and swap if necessary
                if (a[j] < a[j - 1]) {
                    int tmp = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = tmp;
                    change = true;
                }
            }
            // print the array
            printArray(a);

            // go through the array from left to right
            // larger element on the right
            // after this, the array is further sorted with the largest element at the end
            for (int j = i + 1; j < n - i - 1; ++j) {
                // Compare adjacent elements and swap if necessary
                if (a[j] > a[j + 1]) {
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                    change = true;
                }
            }
            // print the array
            printArray(a);

            // if no swapping occurred, the array is sorted
            if (!change)
                break;
        }
    }

    static void printArray(int a[]) {
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        int i;
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String s = stdin.readLine();
        int n = Integer.parseInt(s);

        s = stdin.readLine();
        String[] pom = s.split(" ");
        int[] a = new int[n];
        for (i = 0; i < n; i++)
            a[i] = Integer.parseInt(pom[i]);
        shakerSort(a, n);
    }
}