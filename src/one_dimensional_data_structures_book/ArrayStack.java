/*
package one_dimensional_data_structures_book;

import java.util.NoSuchElementException;

public class ArrayStack<E> implements Stack<E> {
    private E[] elems; // elems[0...depth-1] се неговите елементи.
    private int depth; // depth е длабочината на стекот.

    @SuppressWarnings("unchecked")
    public ArrayStack(int maxDepth) {
    // Конструкциjа на нов, празен стек.
        elems = (E[]) new Object[maxDepth];
        depth = 0;
    }

    public boolean isEmpty() {
        // Враќа true ако и само ако стекот е празен.
        return (depth == 0);
    }

    public E peek() {
        // Го враќа елементот на врвот од стекот.
        if (depth == 0)
            throw new NoSuchElementException();
        return elems[depth - 1];
    }

    public void clear() {
        // Го празни стекот.
        for (int i = 0; i < depth; i++) elems[i] = null;
        depth = 0;
    }

    public void push(E x) {
        // Го додава x на врвот на стекот.
        elems[depth++] = x;
    }

    public int size() {
        // Jа враќа должината на стекот.
        return depth;
    }

    public E pop() {
        // Го отстранува и враќа елементот што е на врвот на стекот.
        if (depth == 0)
            throw new NoSuchElementException();
        E topmost = elems[--depth];
        elems[depth] = null;
        return topmost;
    }
}*/
