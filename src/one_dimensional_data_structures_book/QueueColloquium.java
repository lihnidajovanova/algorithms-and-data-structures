package one_dimensional_data_structures_book;

import java.util.NoSuchElementException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// Вметни класа Queue
// Вметни класа ArrayQueue
public class QueueColloquium {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;

        ArrayQueue<String> queueMath = new ArrayQueue<String>(100);
        ArrayQueue<String> queueRest = new ArrayQueue<String>(100);
        LinkedList<String> listRealMath = new LinkedList<String>();

        int i;
        int numStudentsTerm, numStudentsMath, numRest, numRealMath;

        numStudentsTerm = Integer.parseInt(br.readLine());

        numStudentsMath = Integer.parseInt(br.readLine());
        for (i = 0; i < numStudentsMath; i++) {
            input = br.readLine();
            queueMath.enqueue(input);
        }

        numRest = Integer.parseInt(br.readLine());
        for (i = 0; i < numRest; i++) {
            input = br.readLine();
            queueRest.enqueue(input);
        }

        numRealMath = Integer.parseInt(br.readLine());
        for (i = 0; i < numRealMath; i++) {
            input = br.readLine();
            listRealMath.add(input);
        }

        String elem;
        int t = 1;

        while (!queueMath.isEmpty()) {
            System.out.println(t);
            for (i = 0; i < numStudentsTerm; ) {
                if (!queueMath.isEmpty()) {
                    elem = queueMath.peek();
                    if (!listRealMath.contains(elem))
                        queueRest.enqueue(queueMath.dequeue());
                    else {
                        elem = queueMath.dequeue();
                        i++;
                        System.out.println(elem);
                    }
                } else if (!queueRest.isEmpty()) {
                    elem = queueRest.dequeue();
                    i++;
                    System.out.println(elem);
                } else break;
            }
            t++;
            if (queueMath.isEmpty())
                break;
        }
        if (queueMath.isEmpty()) {
            while (!queueRest.isEmpty()) {
                System.out.println(t);
                for (i = 0; i < numStudentsTerm; ) {
                    if (!queueRest.isEmpty()) {
                        elem = queueRest.dequeue();
                        i++;
                        System.out.println(elem);
                    } else break;
                }
                t++;
            }
        }
    }
}