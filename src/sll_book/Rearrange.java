package sll_book;

import java.util.Scanner;

public class Rearrange {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        SLL<Integer> list = new SLL<Integer>();

        for (int i = 0; i < n; i++) {
            int el = sc.nextInt();
            list.insertLast(el);
        }

        list.rearrange();
        System.out.println(list.toString());
    }
}
