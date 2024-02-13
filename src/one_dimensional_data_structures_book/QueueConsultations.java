package one_dimensional_data_structures_book;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Вметни класа Queue
// Вметни класа ArrayQueue

public class QueueConsultations {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;

        ArrayQueue<String> queueAPS = new ArrayQueue<>(100);
        ArrayQueue<String> queueType = new ArrayQueue<>(100);
        ArrayQueue<String> queueMMS = new ArrayQueue<>(100);

        int i;
        int numStudentsAPS, numStudentsMMS;

        numStudentsAPS = Integer.parseInt(br.readLine());

        for (i = 0; i < numStudentsAPS; i++) {
            input = br.readLine();
            String[] pom = input.split(" ");
            queueAPS.enqueue(pom[0]);
            queueType.enqueue(pom[1]);
        }

        numStudentsMMS = Integer.parseInt(br.readLine());
        for (i = 0; i < numStudentsMMS; i++) {
            input = br.readLine();
            queueMMS.enqueue(input);
        }

        String pom, pomType, type = "";
        if (!queueAPS.isEmpty()) {
            pom = queueAPS.dequeue();
            System.out.println(pom);
            type = queueType.dequeue();
            i++;
        }

        while (!queueAPS.isEmpty()) {
            pom = queueAPS.dequeue();
            pomType = queueType.dequeue();
            if (type.equals(pomType)) {
                queueAPS.enqueue(pom);
                queueType.enqueue(pomType);
                if (!queueMMS.isEmpty()) {
                    pom = queueMMS.dequeue();
                    System.out.println(pom);
                }
            } else {
                System.out.println(pom);
                type = pomType;
            }
        }

        while (!queueMMS.isEmpty()) {
            pom = queueMMS.dequeue();
            System.out.println(pom);
        }
    }
}