package dll_book;

import java.util.Scanner;

public class DLLListaOdListi {
    // helper method to calculate the sum of a DLL
//    private static long calculateSum(DLL<Integer> dll) {
//        long sum = 0;
//        DLLNode<Integer> current = dll.getFirst();
//        while (current != null) {
//            sum += current.element;
//            current = current.succ;
//        }
//        return sum;
//    }
//
//    public static long findMagicNumber(DLL<DLL<Integer>> list) {
//        //Vashiot kod tuka...
//        DLLNode<DLL<Integer>> currentList = list.getFirst();
//        long productOfSums = 1;
//
//        while (currentList != null) {
//            // calculate the sum of the current DLL and multiply it with the productOfSums
//            long sum = calculateSum(currentList.element);
//            productOfSums *= sum;
//
//            // move to the next DLL in the outer list
//            currentList = currentList.succ;
//        }
//
//        return productOfSums;
//    }

    public static long findMagicNumber(DLL<DLL<Integer>> list) {
        DLLNode<DLL<Integer>> current = list.getFirst();
        long prod = 1;
        while (true) {
            int sum = 0;
            DLLNode<Integer> current1 = current.element.getFirst();
            while (true) {
                sum += current1.element;
                if (current1 == current.element.getLast()) {
                    break;
                }
                current1 = current1.succ;
            }
            prod *= sum;
            if (current == list.getLast()) {
                break;
            }
            current = current.succ;
        }
        return prod;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        DLL<DLL<Integer>> list = new DLL<DLL<Integer>>();

        for (int i = 0; i < n; i++) {
            DLL<Integer> tmp = new DLL<Integer>();
            for (int j = 0; j < m; j++) {
                tmp.insertLast(in.nextInt());
            }
            list.insertLast(tmp);
        }
        in.close();
        System.out.println(findMagicNumber(list));
    }
}