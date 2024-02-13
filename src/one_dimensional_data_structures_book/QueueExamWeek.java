package one_dimensional_data_structures_book;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QueueExamWeek {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Читање на бројот на асистенти и нивните имиња
        int numAssistants = Integer.parseInt(br.readLine());
        ArrayQueue<String> assistants = new ArrayQueue<>(numAssistants);
        for (int i = 0; i < numAssistants; i++) {
            assistants.enqueue(br.readLine());
        }

        // Читање на информации за предметите и бројот на асистенти за секој предмет
        int numSubjects = Integer.parseInt(br.readLine());
        String[] subjects = new String[numSubjects];
        int[] assistantsNeeded = new int[numSubjects];
        for (int i = 0; i < numSubjects; i++) {
            String[] input = br.readLine().split(" ");
            subjects[i] = input[0];
            assistantsNeeded[i] = Integer.parseInt(input[1]);
        }

        // Читање на бројот на отсутни асистенти и нивните имиња
        int numAbsent = Integer.parseInt(br.readLine());
        ArrayQueue<String> absentAssistants = new ArrayQueue<>(numAbsent);
        for (int i = 0; i < numAbsent; i++) {
            String assistant = br.readLine();
            // Додади го асистентот во отсутните само ако постои во листата на асистенти
            if (isInQueue(assistants, assistant)) {
                absentAssistants.enqueue(assistant);
            }
        }

        // Доделување на асистенти за чување на предметите
        for (int i = 0; i < numSubjects; i++) {
            String subject = subjects[i];
            int numAssistantsNeeded = assistantsNeeded[i];

            System.out.println(subject);
            System.out.println(numAssistantsNeeded); // Додадено: Број на професори
            for (int j = 0; j < numAssistantsNeeded; j++) {
                // Пребарување на следен асистент кој не е отсутен
                String assistant = "";
                while (!assistants.isEmpty()) {
                    assistant = assistants.dequeue();
                    if (!isInQueue(absentAssistants, assistant)) {
                        break;
                    }
                    assistants.enqueue(assistant); // Поставување на асистентот на крајот од редицата за да може да се користи подоцна
                }

                System.out.println(assistant);
                assistants.enqueue(assistant); // Поставување на асистентот на крајот од редицата за да може да се користи подоцна
            }
        }

        br.close();
    }

    private static boolean isInQueue(ArrayQueue<String> queue, String value) {
        // Проверува дали вредноста е во редицата
        ArrayQueue<String> tempQueue = new ArrayQueue<>(queue.size());
        boolean found = false;

        while (!queue.isEmpty()) {
            String temp = queue.dequeue();
            tempQueue.enqueue(temp);
            if (temp.equals(value)) {
                found = true;
            }
        }

        while (!tempQueue.isEmpty()) {
            queue.enqueue(tempQueue.dequeue());
        }

        return found;
    }
}