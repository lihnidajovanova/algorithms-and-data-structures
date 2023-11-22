package laboratory_exercise_5_sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OddEvenSort {

    static void oddEvenSort(int a[], int n) {
        // Vasiot kod tuka
        // separate odd and even numbers
        int[] evenNumbers = new int[n];
        int evenCount = 0;
        int[] oddNumbers = new int[n];
        int oddCount = 0;

        for (int i = 0; i < n; i++) {
            if (a[i] % 2 == 0)
                evenNumbers[evenCount++] = a[i];
            else
                oddNumbers[oddCount++] = a[i];
        }

        // sort odd numbers in ascending order
        for (int i = 0; i < oddCount - 1; i++) {
            for (int j = 0; j < oddCount - i - 1; j++) {
                if (oddNumbers[j] > oddNumbers[j + 1]) {
                    // swap
                    int tmp = oddNumbers[j];
                    oddNumbers[j] = oddNumbers[j + 1];
                    oddNumbers[j + 1] = tmp;
                }
            }
        }

        // sort even numbers in descending order
        for (int i = 0; i < evenCount - 1; i++) {
            for (int j = 0; j < evenCount - i - 1; j++) {
                if (evenNumbers[j] < evenNumbers[j + 1]) {
                    // swap
                    int tmp = evenNumbers[j];
                    evenNumbers[j] = evenNumbers[j + 1];
                    evenNumbers[j + 1] = tmp;
                }
            }
        }

        // merge the sorted arrays back into the original array
        int index = 0;
        for (int i = 0; i < oddCount; i++)
            a[index++] = oddNumbers[i];
        for (int i = 0; i < evenCount; i++)
            a[index++] = evenNumbers[i];
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

        oddEvenSort(a, n);

        for (i = 0; i < n - 1; i++)
            System.out.print(a[i] + " ");
        System.out.print(a[i]);
    }
}

/*
public class OddEvenSort {
    static void oddAscending(int arr[], int n) {
        int tmp = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }

    static void evenDescending(int arr[], int n) {
        int tmp = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] < arr[j + 1]) {
                    tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }

    static void oddEvenSort(int a[], int n) {
        // Vasiot kod tuka
        int[] even = new int[n];
        int[] odd = new int[n];
        int evenCount = 0, oddCount = 0;

        for (int i = 0; i < n; i++) {
            if ((a[i] & 1) == 0) {  // ((a[i] & i) == 0) same as ((a[i] % 2) == 0)
                even[evenCount++] = a[i];
            } else {
                odd[oddCount++] = a[i];
            }
        }

        oddAscending(odd, oddCount);
        evenDescending(even, evenCount);

        for (int i = 0; i < oddCount; i++) {
            a[i] = odd[i];
        }
        int j = 0;
        for (int i = oddCount; i < n; i++) {
            a[i] = even[j++];
        }
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
        oddEvenSort(a, n);
        for (i = 0; i < n - 1; i++)
            System.out.print(a[i] + " ");
        System.out.print(a[i]);
    }
}
*/