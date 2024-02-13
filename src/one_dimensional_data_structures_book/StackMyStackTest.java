/*
package one_dimensional_data_structures_book;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Вметни класа Queue
// Вметни класа ArrayQueue

class MyStack<E> implements Stack<E> {
    ArrayQueue<E> q1, q2;
    int size;

    public MyStack() {
        q1 = new ArrayQueue<E>(1000);
        q2 = new ArrayQueue<E>(1000);
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        if (q1.isEmpty() && q2.isEmpty())
            return true;
        else
            return false;
    }

    @Override
    public E peek() {
        if (q1.isEmpty())
            return null;
        return q1.peek();
    }

    public int getSize() {
        return size;
    }

    @Override
    public void clear() {

    }

    @Override
    public void push(E x) {
        size++;

        //Push x прво во празната q2
        q2.enqueue(x);

        //Push на сите останати
        //елементи од q1 во q2.
        while (!q1.isEmpty()) {
            q2.enqueue(q1.peek());
            q1.dequeue();
        }

        //промена на двете редици
        ArrayQueue<E> q = q1;
        q1 = q2;
    }

    @Override
    public E pop() {
        //ако нема елементи во q1
        if (q1.isEmpty())
            return null;
        E tmp = q1.dequeue();
        size--;
        return tmp;
    }
}

public class StackMyStackTest {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        MyStack ob = new MyStack();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            ob.push(x);
        }

        // System.out.println(ob.toString());
        String str = br.readLine();
        while (!str.equals("KRAJ")) {
            int x = Integer.parseInt(str);
            if (x == 1) {
                if (ob.peek() == null) System.out.println("Empty Stack");
                else System.out.println(ob.pop());
            }

            if (x == 2) {
                str = br.readLine();
                x = Integer.parseInt(str);
                ob.push(x);
            }
            str = br.readLine();
        }
        System.out.println("The length of the stack is: " + ob.getSize());
    }
}*/
