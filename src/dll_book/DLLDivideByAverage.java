package dll_book;

import java.util.Scanner;

public class DLLDivideByAverage extends DLL<Integer> {
    public void divideByAverage() {
        if (getSize() <= 1) {
            System.out.println("Prazna ili ednoelementna lista");
            return;
        }

        // Пресметување на просекот на листата
        double sum = 0;
        int count = 0;

        DLLNode<Integer> current = getLast();
        while (current != null) {
            sum += current.element;
            count++;
            current = current.pred;
        }

        double average = sum / count;

        // Поделба на листата
        DLL<Integer> resultList1 = new DLL<>();
        DLL<Integer> resultList2 = new DLL<>();

        current = getLast();
        while (current != null) {
            if (current.element <= average) {
                resultList1.insertFirst(current.element);
            } else {
                resultList2.insertFirst(current.element);
            }
            current = current.pred;
        }

        // Печатење на резултатите
        System.out.println("Rezultatna lista (broevi pomali ili ednakvi od prosekot):");
        System.out.println(resultList1.toStringR());
        System.out.println("Rezultatna lista (broevi pogolemi od prosekot):");
        System.out.println(resultList2.toStringR());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DLLDivideByAverage dllDivideByAverage = new DLLDivideByAverage();

        // Внес на елементи во листата
        System.out.println("Vnesete go brojot na elementi:");
        int n = scanner.nextInt();

        System.out.println("Vnesete gi elementite:");
        for (int i = 0; i < n; i++) {
            dllDivideByAverage.insertLast(scanner.nextInt());
        }

        // Извршување на divideByAverage методот и печатење на резултатите
        dllDivideByAverage.divideByAverage();
    }
}