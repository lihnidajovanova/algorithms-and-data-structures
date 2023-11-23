/*
package sll_book;

import java.util.Scanner;

public class SLLMergeAlternating<E> extends SLL<E> {

    public void mergeAlternating(SLL<E> list1, SLL<E> list2) {
        Node<E> current1 = list1.head;
        Node<E> current2 = list2.head;

        while (current1 != null && current2 != null) {
            // Додавање на jазли од првата листа
            addToEnd(current1.data);
            current1 = current1.next;

            if (current1 != null) {
                addToEnd(current1.data);
                current1 = current1.next;
            }

            // Додавање на jазли од втората листа
            addToEnd(current2.data);
            current2 = current2.next;

            if (current2 != null) {
                addToEnd(current2.data);
                current2 = current2.next;
            }
        }

        // Додавање на преостанатите jазли од првата листа
        while (current1 != null) {
            addToEnd(current1.data);
            current1 = current1.next;
        }

        // Додавање на преостанатите jазли од втората листа
        while (current2 != null) {
            addToEnd(current2.data);
            current2 = current2.next;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Читање на бројот на елементи за првата листа
        System.out.println("Vnesete go brojot na elementi za prvata lista:");
        int n1 = scanner.nextInt();

        SLL<Integer> list1 = new SLL<>();

        // Читање на елементите за првата листа
        System.out.println("Vnesete gi elementite za prvata lista:");
        for (int i = 0; i < n1; i++) {
            list1.addToEnd(scanner.nextInt());
        }

        // Читање на бројот на елементи за втората листа
        System.out.println("Vnesete go brojot na elementi za vtorata lista:");
        int n2 = scanner.nextInt();

        SLL<Integer> list2 = new SLL<>();

        // Читање на елементите за втората листа
        System.out.println("Vnesete gi elementite za vtorata lista:");
        for (int i = 0; i < n2; i++) {
            list2.addToEnd(scanner.nextInt());
        }

        // Спојување наизменично на двете листи и печатење на резултатите
        SLLMergeAlternating<Integer> mergedList = new SLLMergeAlternating<>();
        mergedList.mergeAlternating(list1, list2);
        System.out.println("Rezultatna spoina lista:");
        mergedList.printList();
    }
}
*/
