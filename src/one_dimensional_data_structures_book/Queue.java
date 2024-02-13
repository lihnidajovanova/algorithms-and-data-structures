package one_dimensional_data_structures_book;

import java.util.Collection;

public interface Queue<E> {
    //Елементи на редицата се обjекти од произволен тип.
    //Методи за пристап:
    public boolean isEmpty();
    //Враќа true ако и само ако редицата е празна.

    public int size();
    //Jа враќа должината на редицата.

    public E peekFirst();
    //Го враќа елементот од почетокот на редицата.

    public E peekLast();
    //Го враќа елементот од краjот на редицата.

    //Методи за трансформациjа:
    public void clear();
    //Jа празни редицата.

    public void enqueue(E x);
    //Го додава x на краj на редицата.

    public E dequeue();
    //Го отстранува и враќа почетниот елемент на редицата.
}