package first_midterm_exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

class ArrayQueue<E> implements Queue<E> {

    // Array:
    // length -> number of elements
    // if length > 0, then the elements of the array are saved in elems[front...rear-1]
    // if rear > front, then in elems[front...maxlength-1] and elems[0...rear-1]
    E[] elems;
    int length, front, rear;

    @SuppressWarnings("unchecked")
    public ArrayQueue(int maxlength) {
        elems = (E[]) new Object[maxlength];
        clear();
    }

    public boolean isEmpty() {
        // returns 'true' if and only if the array is empty
        return (length == 0);
    }

    public int size() {
        // returns the length of the array
        return length;
    }

    public E peek() {
        // returns the element on top (the beginning of the array)
        if (length > 0)
            return elems[front];
        else
            throw new NoSuchElementException();
    }

    public void clear() {
        // empties the array
        length = 0;
        front = rear = 0;  // arbitrary
    }

    public void enqueue(E x) {
        // adds x at the end of the array
        elems[rear++] = x;
        if (rear == elems.length) rear = 0;
        length++;
    }

    public E dequeue() {
        // removes and returns the starting element of the array
        if (length > 0) {
            E frontmost = elems[front];
            elems[front++] = null;
            if (front == elems.length) front = 0;
            length--;
            return frontmost;
        } else
            throw new NoSuchElementException();
    }

    @Override
    public boolean addAll(Collection<? extends E> arg0) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean contains(Object arg0) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> arg0) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean remove(Object arg0) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> arg0) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> arg0) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Object[] toArray() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <T> T[] toArray(T[] arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean add(E arg0) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public E element() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean offer(E arg0) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public E poll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public E remove() {
        // TODO Auto-generated method stub
        return null;
    }
}

public class card_trick {
    public static int count(int N) {
        // Vasiot kod tuka
        ArrayQueue<Integer> deck = new ArrayQueue<>(51);

        for (int i = 0; i < 51; i++) {
            deck.enqueue(i + 1);
        }

        int counter = 0;
        Stack<Integer> stack = new Stack<Integer>();

        while (deck.peek() != N) {
            for (int i = 0; i < 7; i++) stack.push(deck.dequeue());
            for (int i = 0; i < 7; i++) {
                deck.enqueue(stack.pop());
                deck.enqueue(deck.dequeue());
            }
            counter++;
        }
        return counter;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(count(Integer.parseInt(br.readLine())));
    }
}