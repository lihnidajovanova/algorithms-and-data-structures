package dll_book;

import java.util.Scanner;

public class DLLDeleteSublists extends DLL<Integer> {
    public void deleteSublists(DLL<Integer> sublist) {
        DLLNode<Integer> current = getFirst();

        while (current != null) {
            // Проверка дали почнува подлистата
            if (current.element.equals(sublist.getFirst().element)) {
                DLLNode<Integer> temp = current;
                DLLNode<Integer> sublistNode = sublist.getFirst();

                // Проверка дали целата подлиста почнува од тековниот јазол
                while (temp != null && sublistNode != null && temp.element.equals(sublistNode.element)) {
                    temp = temp.succ;
                    sublistNode = sublistNode.succ;
                }

                // Доколку е целата подлиста, бришење на јазолите
                if (sublistNode == null) {
                    DLLNode<Integer> pred = current.pred;
                    DLLNode<Integer> succ = temp;

                    if (pred != null) {
                        pred.succ = succ;
                    } else {
                        setFirst(succ);
                    }

                    if (succ != null) {
                        succ.pred = pred;
                    } else {
                        setLast(pred);
                    }
                }
            }

            current = current.succ;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Внес на елементи за првата листа
        System.out.println("Vnesete go brojot na elementi za prvata lista:");
        int n1 = scanner.nextInt();

        DLLDeleteSublists list1 = new DLLDeleteSublists();

        System.out.println("Vnesete gi elementite za prvata lista:");
        for (int i = 0; i < n1; i++) {
            list1.insertLast(scanner.nextInt());
        }

        // Внес на елементи за втората листа
        System.out.println("Vnesete go brojot na elementi za vtorata lista:");
        int n2 = scanner.nextInt();

        DLL<Integer> list2 = new DLL<>();
        System.out.println("Vnesete gi elementite za vtorata lista:");
        for (int i = 0; i < n2; i++) {
            list2.insertLast(scanner.nextInt());
        }

        // Извршување на deleteSublists методот и печатење на резултатите
        list1.deleteSublists(list2);
        System.out.println("Rezultatna lista:");
        System.out.println(list1.toString());
    }
}