package arrays_book;

import java.util.Scanner;
import java.lang.Math;

public class ArrayMeanValue {

    public static int elementClosestToMean(Array<Integer> arr) {
        int sum = 0, index = 0;

        for (int i = 0; i < arr.getSize(); i++) {
            sum += arr.get(i);
        }

        int avg = sum / arr.getSize();
        int minDifference = Math.abs((arr.get(0) - avg));

        for (int i = 1; i < arr.getSize(); i++) {
            if (Math.abs(arr.get(i) - avg) < minDifference) {
                minDifference = Math.abs(arr.get(i) - avg);
                index = i;

            }
            if (Math.abs((arr.get(i) - avg)) == minDifference) {
                if (arr.get(i) < arr.get(index)) {
                    index = i;
                }
            }
        }
        return arr.get(index);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        Array<Integer> arr = new Array<>(n);

        for (int i = 0; i < n; i++) {
            arr.insertLast(input.nextInt());
        }
        System.out.println(elementClosestToMean(arr));
    }
}
