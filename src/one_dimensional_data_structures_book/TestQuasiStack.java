/*
package one_dimensional_data_structures_book;

import java.util.NoSuchElementException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Вметни класа DLLNode
class DLLNode<E> {
    protected E element;
    protected DLLNode<E> pred, succ;

    public DLLNode(E elem, DLLNode<E> pred, DLLNode<E> succ) {
        this.element = elem;
        this.pred = pred;
        this.succ = succ;
    }

    @Override
    public String toString() {
        return element.toString();
    }
}

class DLL<E> {
    private DLLNode<E> first, last;

    public DLL() {
        // Construct an empty SLL
        this.first = null;
        this.last = null;
    }

    public void insertFirst(E o) {
        DLLNode<E> ins = new DLLNode<E>(o, null, first);
        if (first == null)
            last = ins;
        else
            first.pred = ins;
        first = ins;
    }

    public void insertLast(E o) {
        if (first == null)
            insertFirst(o);
        else {
            DLLNode<E> ins = new DLLNode<E>(o, last, null);
            last.succ = ins;
            last = ins;
        }
    }

    public void insertAfter(E o, DLLNode<E> after) {
        if (after == last) {
            insertLast(o);
            return;
        }
        DLLNode<E> ins = new DLLNode<E>(o, after, after.succ);
        after.succ.pred = ins;
        after.succ = ins;
    }

    public void insertBefore(E o, DLLNode<E> before) {
        if (before == first) {
            insertFirst(o);
            return;
        }
        DLLNode<E> ins = new DLLNode<E>(o, before.pred, before);
        before.pred.succ = ins;
        before.pred = ins;
    }

    public E deleteFirst() {
        if (first != null) {
            DLLNode<E> tmp = first;
            first = first.succ;
            if (first != null) first.pred = null;
            if (first == null)
                last = null;
            return tmp.element;
        } else
            return null;
    }

    public E deleteLast() {
        if (first != null) {
            if (first.succ == null)
                return deleteFirst();
            else {
                DLLNode<E> tmp = last;
                last = last.pred;
                last.succ = null;
                return tmp.element;
            }
        } else
            return null;
    }

    public E delete(DLLNode<E> node) {
        if (node == first) {
            return deleteFirst();
        }
        if (node == last) {
            return deleteLast();
        }
        node.pred.succ = node.succ;
        node.succ.pred = node.pred;
        return node.element;

    }

    public DLLNode<E> find(E o) {
        if (first != null) {
            DLLNode<E> tmp = first;
            while (!tmp.element.equals(o) && tmp.succ != null)
                tmp = tmp.succ;
            if (tmp.element.equals(o)) {
                return tmp;
            } else {
                System.out.println("Elementot ne postoi vo listata");
            }
        } else {
            System.out.println("Listata e prazna");
        }
        return null;
    }

    public void deleteList() {
        first = null;
        last = null;
    }

    public int getSize() {
        int listSize = 0;
        DLLNode<E> tmp = first;
        while (tmp != null) {
            listSize++;
            tmp = tmp.succ;
        }
        return listSize;
    }

    @Override
    public String toString() {
        String ret = new String();
        if (first != null) {
            DLLNode<E> tmp = first;
            ret += tmp.toString();
            while (tmp.succ != null) {
                tmp = tmp.succ;
                ret += "<->" + tmp.toString();
            }
        } else
            ret = "Prazna lista!!!";
        return ret;
    }

    public String toStringR() {
        String ret = new String();
        if (last != null) {
            DLLNode<E> tmp = last;
            ret += tmp.toString();
            while (tmp.pred != null) {
                tmp = tmp.pred;
                ret += "<->" + tmp.toString();
            }
        } else
            ret = "Prazna lista!!!";
        return ret;
    }

    public DLLNode<E> getFirst() {
        return first;
    }

    public DLLNode<E> getLast() {
        return last;
    }

    public void mirror() {
        DLLNode<E> tmp = null;
        DLLNode<E> current = first;
        last = first;

        while (current != null) {
            tmp = current.pred;
            current.pred = current.succ;
            current.succ = tmp;
            current = current.pred;
        }

        if (tmp != null && tmp.pred != null) {
            first = tmp.pred;
        }
    }
}

// Вметни класа Stack


class QuasiStack<E extends Comparable<E>> implements Stack<E> {
    //Stekot e pretstaven na sledniot nacin: top e link do prviot jazol
    // na ednostrano-povrzanata lista koja sodrzi gi elementite na stekot .
    private DLLNode<E> top, bottom;

    public QuasiStack() {
        // Konstrukcija na nov, prazen stek.
        top = null;
        bottom = null;
    }

    public boolean isEmpty() {
        // Vrakja true ako i samo ako stekot e prazen.
        return (top == null);
    }

    public E peekTop() {
        // Go vrakja elementot na vrvot od stekot.
        if (top == null)
            throw new NoSuchElementException();
        return top.element;
    }

    public E peekBottom() {
        // Go vrakja elementot na vrvot od stekot.
        if (bottom == null)
            throw new NoSuchElementException();
        return bottom.element;
    }

    public void clear() {
        // Go prazni stekot.
        top = null;
        bottom = null;
    }

    public void push(E x) {
        // Go dodava x na vrvot na stekot.
        DLLNode<E> ins = new DLLNode<E>(x, null, top);
        if (top == null)
            bottom = ins;
        else
            top.pred = ins;
        top = ins;
    }

    public E pop() {
        // Go otstranuva i vrakja pogolemiot element shto e na vrvot i dnotoa stekot.
        if (top == null)
            throw new NoSuchElementException();
        E topElem = top.element;
        E bottomElem = bottom.element;

        if (top == bottom) {
            top = null;
            bottom = null;
            return topElem;
        }

        if (topElem.compareTo(bottomElem) == 1) {
            top = top.succ;
            top.pred = null;
            return topElem;
        } else {
            bottom = bottom.pred;
            bottom.succ = null;
            return bottomElem;
        }
    }
}

public class TestQuasiStack {
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        QuasiStack<Integer> qs = new QuasiStack<Integer>();

        int brElementi = Integer.parseInt(br.readLine());

        for (int i = 0; i < brElementi; i++) {
            int x = Integer.parseInt(br.readLine());
            qs.push(x);
        }

        System.out.println(qs.peekTop());
        System.out.println(qs.peekBottom());

        while (!qs.isEmpty()) {
            System.out.print(qs.pop() + " ");
        }
    }
}*/
