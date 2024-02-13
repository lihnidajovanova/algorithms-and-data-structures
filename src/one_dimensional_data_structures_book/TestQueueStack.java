/*
package one_dimensional_data_structures_book;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Вметни класа Queue
// Вметни класа Stack
// Вметни класа ArrayQueue
// Вметни класа ArrayStack

interface QueueStack {
    public boolean isEmpty();
    //Враќа true ако и само ако стекот е празен.

    public Character peek();
    //Го Враќа елементот на врвот од структурата

    //Методи за трансформациjа:
    public void clear();
    //Jа празни структурата.

    public void push(Character x);
    //Го додава x на врвот на структурата.

    public Character pop();
    //Го отстранува и Враќа елементот што е на ред за вадење.
};

class ArrayQueueStack implements QueueStack {
    private ArrayQueue<Character> q;
    private ArrayStack<Character> s;
    private int lnQueue, lnStack;

    public ArrayQueueStack(int maxQueue, int maxStack) {
        s = new ArrayStack<Character>(maxStack);
        q = new ArrayQueue<Character>(maxQueue);
        lnStack = maxStack;
        lnQueue = maxStack;
    }

    @Override
    public boolean isEmpty() {
        if (q.isEmpty() && s.isEmpty())
            return true;
        return false;
    }

    @Override
    public Character peek() {
        if (q.isEmpty())
            return s.peek();
        return q.peek();
    }

    @Override
    public void clear() {

    }

    @Override
    public void push(Character x) {
        if (q.isEmpty())
            q.enqueue(x);
        else if (s.isEmpty())
            s.push(x);
        else {
            if (s.size() < lnStack && q.size() < lnQueue) {
                if (s.peek() < q.peek())
                    s.push(x);
                else
                    q.enqueue(x);
            } else if (s.size() < lnStack)
                s.push(x);
            else if (q.size() < lnQueue)
                q.enqueue(x);
            else
                System.out.println("RedoStek is full");
        }
    }

    @Override
    public Character pop() {
        while (!q.isEmpty())
            return q.dequeue();
        while (!s.isEmpty())
            return s.pop();
        return null;
    }
};

public class TestQueueStack {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int maxQueue = Integer.parseInt(br.readLine());
        int maxStack = Integer.parseInt(br.readLine());

        // ArrayStack<Integer> s = new ArrayStack<>(maxStack);
        ArrayQueueStack sq = new ArrayQueueStack(maxQueue, maxStack);

        int numElements = Integer.parseInt(br.readLine());

        for (int i = 0; i < numElements; i++) {
            char x = (char) br.read();
            sq.push(x);
        }

        System.out.println(sq.peek());

        while (!sq.isEmpty())
            System.out.print(sq.pop() + " ");
    }
}
*/
