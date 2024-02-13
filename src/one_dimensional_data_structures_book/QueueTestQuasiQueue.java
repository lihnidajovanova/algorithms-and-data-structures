package one_dimensional_data_structures_book;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;

//Вметни класа Queue

class QuasiQueue<E extends Comparable<E>> implements Queue<E> {
    //Редицата е претставена на следниот начин:
    //length го содржи броjот на елементи.
    //Ако length > 0, тогаш елементите на редицата се зачувани во elems[front...rear-1]
    //Ако rear > front, тогаш во elems[front...maxlength-1] и elems[0...rear-1]
    E[] elems;
    int length, front, rear, maxlength;

    @SuppressWarnings("unchecked")
    public QuasiQueue(int maxlength) {
        elems = (E[]) new Comparable[maxlength];
        this.maxlength = maxlength;
        clear();
    }

    public boolean isEmpty() {
        //Враќа true ако и само ако редицата е празна.
        return (length == 0);
    }

    public int size() {
        //Jа враќа должината на редицата.
        return length;
    }

    public E peekFirst() {
        //Го враќа елементот од почетокот на редицата.
        if (length > 0)
            return elems[front];
        else
            throw new NoSuchElementException();
    }

    public E peekLast() {
        //Го вра´ка елементот од краjот на редицата.
        if (length > 0)
            return elems[rear - 1];
        else
            throw new NoSuchElementException();
    }

    public void clear() {
        //Jа празни редицата.
        length = 0;
        front = rear = 0; //произволно
    }

    public void enqueue(E x) {
        //Го додава x на краj од редицата.
        //elems[rear++] = x;
        if (rear == maxlength)
            elems[0] = x;
        else {
            elems[rear++] = x;
            length++;
        }
    }

    public E dequeue() {
        //Го отстранува и враќа помалиот од почетниот и краjниот елемент на редицата.
        if (length > 0) {
            E frontmost = elems[front];
            E rearmost = elems[rear - 1];
            if (front == rear) {
                front = 0;
                rear = 0;
                elems[front] = null;
                length--;
                return frontmost;
            }

            if (frontmost.compareTo(rearmost) == -1 ||
                    frontmost.compareTo(rearmost) == 0) {
                elems[front++] = null;
                length--;
                return frontmost;
            } else {
                elems[rear - 1] = null;
                rear--;
                length--;
                return rearmost;
            }
        } else
            throw new NoSuchElementException();
    }

}

public class QueueTestQuasiQueue {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int maxElementi = Integer.parseInt(br.readLine());
        //System.out.println(maxElementi);

        QuasiQueue<Integer> qq = new QuasiQueue<Integer>(maxElementi);
        int brElementi = Integer.parseInt(br.readLine());

        for (int i = 0; i < brElementi; i++) {
            int x = Integer.parseInt(br.readLine());
            qq.enqueue(x);
            //System.out.println(qq.peekFirst());
        }

        System.out.println(qq.peekFirst());
        System.out.println(qq.peekLast());

        while (!qq.isEmpty()) {
            System.out.print(qq.dequeue() + " ");
        }
    }
}