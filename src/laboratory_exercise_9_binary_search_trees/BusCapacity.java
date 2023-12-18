package laboratory_exercise_9_binary_search_trees;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BusCapacity {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read the capacity of the bus
        int capacity = Integer.parseInt(br.readLine());

        // Read the number of passengers
        int N = Integer.parseInt(br.readLine());

        // Create two PriorityQueues to store boarding and departure events
        PriorityQueue<Event> events = new PriorityQueue<>((a, b) -> Integer.compare(a.time, b.time));

        // Read and process boarding and departure times of passengers
        for (int i = 0; i < N; i++) {
            String[] times = br.readLine().split(" ");
            int boardTime = convertToMinutes(times[0]);
            int departTime = convertToMinutes(times[1]);
            events.offer(new Event(boardTime, 1)); // 1 represents boarding
            events.offer(new Event(departTime, -1)); // -1 represents departure
        }

        // Process events to determine if the bus capacity is exceeded at any time
        boolean isFeasible = checkFeasibility(events, capacity);

        // Print the result
        System.out.println(isFeasible);
    }

    // Function to convert time to minutes
    private static int convertToMinutes(String time) {
        String[] parts = time.split(":");
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);
        return hours * 60 + minutes;
    }

    // Function to check if the bus capacity is exceeded at any time
    private static boolean checkFeasibility(PriorityQueue<Event> events, int capacity) {
        int currentPassengers = 0;

        while (!events.isEmpty()) {
            Event event = events.poll();
            currentPassengers += event.type;

            if (currentPassengers > capacity) {
                return false; // BusCapacity exceeded at some point
            }
        }

        return true; // No point in time exceeded the capacity
    }

    // Helper class to represent events (boarding or departure) with associated time
    static class Event {
        int time;
        int type; // 1 for boarding, -1 for departure

        Event(int time, int type) {
            this.time = time;
            this.type = type;
        }
    }
}

/*
public class BusCapacity {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // capacity of the bus
        int capacity = Integer.parseInt(br.readLine());
        // number of passengers
        int N = Integer.parseInt(br.readLine());

        // count of passengers at each time point
        int[] count = new int[24 * 60]; // 24 hours * 60 minutes

        // boarding and departure times of passengers
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int boardTime = convertToMinutes(st.nextToken());
            int departTime = convertToMinutes(st.nextToken());

            // increment count at boarding time and decrement count at departure time
            count[boardTime]++;
            count[departTime]--;
        }

        // check if the bus capacity is exceeded at any time
        boolean isFeasible = checkCapacity(count, capacity);

        // print the result
        System.out.println(isFeasible);
    }

    // convert time to minutes
    private static int convertToMinutes(String time) {
        StringTokenizer st = new StringTokenizer(time, ":");
        int hours = Integer.parseInt(st.nextToken());
        int minutes = Integer.parseInt(st.nextToken());
        return hours * 60 + minutes;
    }

    // check if the bus capacity is exceeded at any time
    private static boolean checkCapacity(int[] count, int capacity) {
        int currentPassengers = 0;

        // Iterate through the count array
        for (int i = 0; i < count.length; i++) {
            currentPassengers += count[i];

            if (currentPassengers > capacity) {
                return false; // capacity exceeded at some point
            }
        }
        return true;
    }
}*/
