package first_midterm_exercises;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Bus {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        br.close();

        // Vasiot kod tuka

        int min = 0, max = 0;

        if (M - N > 0) {
            int additionalChildren = M - N;
            int minCostForAdditionalChildren = additionalChildren * 100;
            min = 100 * N + minCostForAdditionalChildren;
        } else {
            min = 100 * N;
        }

        if (M - 1 >= 0) {
            int costForChildren = (M - 1) * 100;
            max = costForChildren + 100 * N;
        } else {
            max = 100 * N;
        }

        // int min = (M - N) > 0 ? 100 * N + 100 * (M - N) : 100 * N;
        // int max = (M - 1) >= 0 ? (M - 1) * 100 + N * 100 : 100 * N;

        System.out.println(min);
        System.out.println(max);
    }
}