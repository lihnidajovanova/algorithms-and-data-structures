package sll_book;

import java.util.Scanner;

public class SLLDeleteLast {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        SLL<Integer> lista = new SLL<Integer>();

        for (int i = 0; i < n; i++) {
            int el = sc.nextInt();
            lista.insertLast(el);
        }

        int toDelete = sc.nextInt();

        SLLNode<Integer> node = lista.getFirst();
        SLLNode<Integer> deleteIt = null;

        while (node != null) {
            if (node.element == toDelete) {
                deleteIt = node;
            }
            node = node.succ;
        }
        if (deleteIt != null)
            lista.delete(deleteIt);

        System.out.println(lista.toString());
    }
}