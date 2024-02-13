package one_dimensional_data_structures_book;
// Вметни класа Queue
// Вметни класа ArrayQueue

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QueueExamOrganization {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;

        ArrayQueue<String> queueETest = new ArrayQueue<String>(100);
        ArrayQueue<String> queueProblems = new ArrayQueue<String>(100);
        ArrayQueue<String> queueETestProblems = new ArrayQueue<String>(100);

        int i;
        int numStudentsETest, numStudentsProblems, numStudentsETestProblems;

        numStudentsETest = Integer.parseInt(br.readLine());
        for (i = 0; i < numStudentsETest; i++) {
            input = br.readLine();
            queueETest.enqueue(input);
        }

        numStudentsProblems = Integer.parseInt(br.readLine());
        for (i = 0; i < numStudentsProblems; i++) {
            input = br.readLine();
            queueProblems.enqueue(input);
        }

        numStudentsETestProblems = Integer.parseInt(br.readLine());
        for (i = 0; i < numStudentsETestProblems; i++) {
            input = br.readLine();
            queueETestProblems.enqueue(input);
        }

        String elem;
        int t = 1;
        System.out.println("Polagaat e-test:");
        while (!queueETest.isEmpty()) {
            System.out.println("termin " + t);
            for (i = 0; i < 20; ) {
                if (!queueETest.isEmpty()) {
                    // elem = queueETest.peek();
                    elem = queueETest.dequeue();
                    i++;
                    System.out.println(elem);
                } else if (!queueETestProblems.isEmpty()) {
                    elem = queueETestProblems.dequeue();
                    i++;
                    System.out.println(elem);
                    queueProblems.enqueue(elem);
                } else break;
            }
            t++;
            if (queueETest.isEmpty())
                break;
        }
        if (queueETest.isEmpty()) {
            while (!queueETestProblems.isEmpty()) {
                System.out.println("termin " + t);
                for (i = 0; i < 20; ) {
                    if (!queueETestProblems.isEmpty()) {
                        elem = queueETestProblems.dequeue();
                        i++;
                        System.out.println(elem);
                        queueProblems.enqueue(elem);
                    } else break;
                }
                t++;
            }
        }
        t = 1;
        System.out.println("Polagaat zadaci:");
        if (queueETestProblems.isEmpty())
            while (!queueProblems.isEmpty()) {
                System.out.println("termin " + t);
                for (i = 0; i < 20; ) {
                    if (!queueProblems.isEmpty()) {
                        elem = queueProblems.dequeue();
                        i++;
                        System.out.println(elem);
                    } else break;
                }
                t++;
            }
    }
}