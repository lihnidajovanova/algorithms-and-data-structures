package dll_book;

import java.util.Scanner;

public class DLLDeleteSublists extends DLL<Integer> {
    public void deleteSublist(DLL<Integer> sublist) {
        if (sublist == null || sublist.length() == 0) {
            return;
        }

        DLLNode<Integer> current = getFirst();
        DLLNode<Integer> sublistNode = sublist.getFirst();

        while (current != null) {
            if (current.element.equals(sublistNode.element)) {
                DLLNode<Integer> temp = current;
                DLLNode<Integer> tempSublist = sublistNode;

                // Check if the sublist is found starting from the current node
                while (temp != null && tempSublist != null && temp.element.equals(tempSublist.element)) {
                    temp = temp.succ;
                    tempSublist = tempSublist.succ;
                }

                // If sublist is fully matched, delete it from the main list
                if (tempSublist == null) {
                    if (current == getFirst()) {
                        setFirst(temp);
                        if (temp != null) {
                            temp.pred = null;
                        } else {
                            setLast(null);
                        }
                    } else if (current == getLast()) {
                        setLast(current.pred);
                        getLast().succ = null;
                    } else {
                        current.pred.succ = temp;
                        temp.pred = current.pred;
                    }
                    current = temp;
                } else {
                    current = current.succ;
                }
            } else {
                current = current.succ;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Прочитај ги елементите на првата листа
        int n1 = scanner.nextInt();
        DLL<Integer> list1 = new DLL<>();
        for (int i = 0; i < n1; i++) {
            list1.insertLast(scanner.nextInt());
        }

        // Прочитај ги елементите на втората листа
        int n2 = scanner.nextInt();
        DLL<Integer> list2 = new DLL<>();
        for (int i = 0; i < n2; i++) {
            list2.insertLast(scanner.nextInt());
        }

        // Избриши ги сите појавувања на втората листа од првата листа
        DLLDeleteSublists deleter = new DLLDeleteSublists();
        deleter.deleteSublist(list2);

        // Испечати ја резултантната листа
        if (list1.getSize() == 0) {
            System.out.println("Prazna lista");
        } else {
            System.out.println(list1.toString());
        }
    }
}
