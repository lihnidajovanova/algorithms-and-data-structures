package first_midterm_exercises;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BusTicket {

    public static void main(String[] args) throws Exception {
        int i, j, k;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        br.close();

        // vasiot kod ovde

        // minimum
        k = M / N;
        int min = N * 100;

        if (k > 0)
            min += N * (k - 1) * 100 + (M % N) * 100;

        System.out.println(min);

        // maximum
        int max = N * 100;

        if (M > 0)
            max += (M - 1) * 100;

        System.out.println(max);
    }
}