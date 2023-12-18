package laboratory_exercise_9_binary_search_trees;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Scanner;

public class RankingCompetitors {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read the number of competitors
        int N = Integer.parseInt(br.readLine());

        // Initialize a max-heap (PriorityQueue)
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));

        // Read the scores of each competitor and add them to the heap
        for (int i = 0; i < N; i++) {
            int score = Integer.parseInt(br.readLine());
            maxHeap.offer(score);
        }

        // Read the score M
        int M = Integer.parseInt(br.readLine());

        // Determine the rank of the competitor with score M
        int rank = calculateRank(maxHeap, M);

        // Print the rank
        System.out.println(rank);
    }

    // Function to calculate the rank of the competitor with the given score using a max-heap
    private static int calculateRank(PriorityQueue<Integer> maxHeap, int score) {
        int rank = 1;

        // Pop scores from the heap until finding the competitor with the given score
        while (!maxHeap.isEmpty()) {
            int topScore = maxHeap.poll();
            if (topScore == score) {
                break;
            }
            rank++;
        }

        return rank;
    }
}

/*
public class RankingCompetitors {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        int m = in.nextInt(), p = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] > m) {
                p++;
            }
        }

        System.out.println(p + 1);
    }
}*/
