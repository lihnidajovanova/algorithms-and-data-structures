import java.util.Scanner;

class SLLNode<E> {
    E data;
    SLLNode<E> next;

    public SLLNode(E data) {
        this.data = data;
        this.next = null;
    }
}

class SLL<E> {
    SLLNode<E> head;

    public SLL() {
        this.head = null;
    }

    public void insert(E data) {
        SLLNode<E> newNode = new SLLNode<>(data);
        if (head == null) {
            head = newNode;
        } else {
            SLLNode<E> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void rearrange() {
        if (head == null || head.next == null) {
            return;
        }

        SLLNode<E> current = head;
        SLLNode<E> prev = null;
        SLLNode<E> next;

        // Преврти ги јазлите
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        SLLNode<E> firstHalf = head;
        SLLNode<E> secondHalf = prev;

        while (firstHalf != null && secondHalf != null) {
            SLLNode<E> temp1 = firstHalf.next;
            SLLNode<E> temp2 = secondHalf.next;

            firstHalf.next = secondHalf;
            secondHalf.next = temp1;

            firstHalf = temp1;
            secondHalf = temp2;
        }

        // Дополнителна проверка за непарен број на елементи
        if (firstHalf != null) {
            firstHalf.next = null;
        }
    }

    public void printList() {
        SLLNode<E> current = head;
        while (current != null) {
            System.out.print(current.data);
            if (current.next != null) {
                System.out.print("->");
            }
            current = current.next;
        }
        System.out.println();
    }
}

public class Main {
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
