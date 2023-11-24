package sll_book;

import java.util.Scanner;

public class SLLRearrange {
    public static void main(String[] args) {
        SLL<Integer> list = new SLL<>();

        // Читање на влезот
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int data = scanner.nextInt();
            list.insert(data);
        }

        // Преуреди ги јазлите
        list.rearrange();

        // Испечати ја преуредената листа
        list.printList();
    }
}
