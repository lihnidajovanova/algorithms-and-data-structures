package one_dimensional_data_structures_book;

import java.util.NoSuchElementException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Вметни класа DLLNode
// Вметни класа Stack


class QuasiStack<E extends Comparable<E>> implements Stack<E> {
    // Stekot e pretstaven na sledniot nacin: top e link do prviot jazol
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

    @Override
    public E peek() {
        return null;
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

public class StackTestQuasiStack {
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
}
