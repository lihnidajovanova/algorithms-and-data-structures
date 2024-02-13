package one_dimensional_data_structures_book;

import java.util.NoSuchElementException;

public class DoubleArrayStack<E> {
    // Стекот е претставен на следниот начин:
    // depth1 е длабочината на првиот стек,
    // depth2 е длабочината на вториот стек,
    // elems[0...depth-1] се елементи на првиот стек,
    // elems[maxDepth-depth2...maxDepth-1] се елементи на вториот стек,
    private E[] elems;
    private int depth1;
    private int depth2;

    @SuppressWarnings("unchecked")
    public DoubleArrayStack(int maxDepth) {
        //Конструкциjа на нов, празен споделен стек.
        elems = (E[]) new Object[maxDepth];
        depth1 = 0;
        depth2 = 0;
    }

    public boolean isEmptyFirst() {
        //Вра´ка true ако и само ако првиот стек е празен.
        return (depth1 == 0);
    }

    public boolean isEmptySecond() {
        //Вра´ка true ако и само ако вториот стек е празен.
        return (depth2 == 0);
    }

    public boolean isFull() {
        //Вра´ка true ако и само ако целата низа е полна.
        return (depth1 + depth2 == elems.length);
    }

    public E peekFirst() {
        //Го вра´ка елементот на врвот оф првиот стек.
        if (depth1 == 0)
            throw new NoSuchElementException();
        return elems[depth1 - 1];
    }

    public E peekSecond() {
        //Го вра´ка елементот на врвот од вториот стек.
        if (depth2 == 0)
            throw new NoSuchElementException();
        return elems[elems.length - depth2];
    }

    public void clearFirst() {
        //Го празни првиот стек.
        for (int i = 0; i < depth1; i++)
            elems[i] = null;
        depth1 = 0;
    }

    public void clearSecond() {
        //Го празни вториот стек.
        for (int i = elems.length - 1; i >= elems.length - depth2; i--)
            elems[i] = null;
        depth2 = 0;
    }

    public void pushFirst(E x) {
        //Го додава x на врвот на првиот стек.
        if (!this.isFull())
            elems[depth1++] = x;
        else
            System.out.println("Error, the array is full");
    }

    public void pushSecond(E x) {
        //Го додава x на врвот на вториот стек.
        if (!this.isFull())
            elems[elems.length - (++depth2)] = x;
        else
            System.out.println("Error, the array is full");
    }

    public E popFirst() {
        //Го отстранува и вра´ка елементот што е на врвот на првиот стек.
        if (depth1 == 0)
            throw new NoSuchElementException();
        E topmost = elems[--depth1];
        elems[depth1] = null;
        return topmost;
    }

    public E popSecond() {
        //Го отстранува и вра´ка елементот што е на врвот на вториот стек.
        if (depth2 == 0)
            throw new NoSuchElementException();
        E topmost = elems[elems.length - depth2];
        elems[depth2--] = null;
        return topmost;
    }

    public String pecatiNizata() {
        StringBuilder ret = new StringBuilder("Elementite se: ");
        for (E elem : elems) ret.append(elem).append(" ");
        return ret.toString();
    }

    public static void main(String[] args) {
        DoubleArrayStack<Integer> d = new DoubleArrayStack<Integer>(6);
        d.pushFirst(1);
        d.pushFirst(2);
        d.pushFirst(3);
        d.pushSecond(-1);
        d.pushSecond(-2);
        d.pushSecond(-3);
        System.out.println("Vrv na prv: " + d.peekFirst() + ", dolzina na prv: " + d.depth1);
        System.out.println("Vrv na vtor: " + d.peekSecond() + ", dolzina na vtor: " + d.depth2);
        d.pushFirst(4);
        d.popFirst();
        d.pushFirst(4);
        System.out.println("Vrv na prv: " + d.peekFirst() + ", dolzina na prv: " + d.depth1);
        d.pecatiNizata();
    }
}
