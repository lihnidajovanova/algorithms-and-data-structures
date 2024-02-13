package one_dimensional_data_structures_book;

import java.util.NoSuchElementException;

public class LinkedStack<E> implements Stack<E> {
    // top е линк до првиот jазол од еднострано поврзаната листа коjа ги содржи елементите на стекот.
    private SLLNode<E> top;
    int size;

    public LinkedStack() {
        // Конструкциjа на нов, празен стек.
        top = null;
        size = 0;
    }

    public String toString() {
        // Прави текстуална репрезентациjа на стекот.
        SLLNode<E> current = top;
        StringBuilder s = new StringBuilder();
        while (current != null) {
            s.append(current.element);
            s.append(" ");
            current = current.succ;
        }
        return s.toString();
    }

    public boolean isEmpty() {
        // Враќа true ако и само ако стекот е празен.
        return (top == null);
    }

    public void clear() {
        // Го празни стекот.
        top = null;
        size = 0;
    }

    public E peek() {
        // Го враќа елементот на врвот на стекот.
        if (top == null)
            throw new NoSuchElementException();
        return top.element;
    }

    public void push(E x) {
        // Го додава x на врвот на стекот.
        top = new SLLNode<E>(x, top);
        size++;
    }

    public int size() {
        // Jа вра´ка должината на стекот.
        return size;
    }

    public E pop() {
        // Го отстранува и враќа елементот што е на врвот на стекот.
        if (top == null)
            throw new NoSuchElementException();
        E topElem = top.element;
        size--;
        top = top.succ;
        return topElem;
    }
}
