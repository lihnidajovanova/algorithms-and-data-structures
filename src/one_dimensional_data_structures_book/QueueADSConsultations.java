/*
package one_dimensional_data_structures_book;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Scanner;

public class QueueADSConsultations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numShortQuestions = scanner.nextInt();
        LinkedList<String> shortQuestionsQueue = new LinkedList<>();
        for (int i = 0; i < numShortQuestions; i++) {
            shortQuestionsQueue.offer(scanner.next());
        }

        int numExplanations = scanner.nextInt();
        LinkedList<String> explanationsQueue = new LinkedList<>();
        for (int i = 0; i < numExplanations; i++) {
            explanationsQueue.offer(scanner.next());
        }

        int numBoth = scanner.nextInt();
        LinkedList<String> bothQueue = new LinkedList<>();
        for (int i = 0; i < numBoth; i++) {
            bothQueue.offer(scanner.next());
        }

        LinkedList<String> consultationOrder = new LinkedList<>();

        while (!shortQuestionsQueue.isEmpty() || !explanationsQueue.isEmpty() || !bothQueue.isEmpty()) {
            if (!shortQuestionsQueue.isEmpty()) {
                consultationOrder.offer(shortQuestionsQueue.poll());
            }
            if (!bothQueue.isEmpty()) {
                consultationOrder.offer(bothQueue.poll());
            }
            if (!explanationsQueue.isEmpty()) {
                consultationOrder.offer(explanationsQueue.poll());
            }
        }

        while (!consultationOrder.isEmpty()) {
            System.out.println(consultationOrder.poll());
        }

        scanner.close();
    }
}*/
