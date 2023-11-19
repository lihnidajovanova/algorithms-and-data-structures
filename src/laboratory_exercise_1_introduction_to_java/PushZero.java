package laboratory_exercise_1_introduction_to_java;

import java.util.Scanner;

public class PushZero {
    static void pushZerosToBeginning(int array[], int number) {
        int i, j = number - 1;
        for (i = number - 1; i >= 0; i--)
            if (array[i] != 0)
                array[j--] = array[i];

        while (j >= 0)
            array[j--] = 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int array[] = new int[number];

        for (int i = 0; i < number; i++)
            array[i] = scanner.nextInt();

        pushZerosToBeginning(array, number);

        System.out.println("Transformiranata niza e:");
        for (int i = 0; i < number; i++)
            System.out.print(array[i] + " ");

        scanner.close();
    }
}
