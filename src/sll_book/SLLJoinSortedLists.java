package sll_book;

public class SLLJoinSortedLists<E extends Comparable<E>> {
    public SLL<E> join(SLL<E> list1, SLL<E> list2) {
        SLL<E> result = new SLL<E>();
        SLLNode<E> node1 = list1.getFirst();
        SLLNode<E> node2 = list2.getFirst();


        while (node1 != null && node2 != null) {
            if (node1.element.compareTo(node2.element) < 0) {    // node1 < node2
                result.insertLast(node1.element);
                node1 = node1.succ;
            } else {
                result.insertLast(node2.element);
                node2 = node2.succ;
            }
        }

        if (node1 != null) {
            while (node1 != null) {
                result.insertLast(node1.element);
                node1 = node1.succ;
            }
        }

        if (node2 != null) {
            while (node2 != null) {
                result.insertLast(node2.element);
                node2 = node2.succ;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        SLL<String> list1 = new SLL<String>();
        list1.insertLast("Ana");
        list1.insertLast("Bojana");
        list1.insertLast("Dejan");

        SLL<String> list2 = new SLL<String>();
        list2.insertLast("Andrijana");
        list2.insertLast("Biljana");
        list2.insertLast("Darko");

        SLLJoinSortedLists<String> js = new SLLJoinSortedLists<String>();
        System.out.println(js.join(list1, list2));
    }
}
