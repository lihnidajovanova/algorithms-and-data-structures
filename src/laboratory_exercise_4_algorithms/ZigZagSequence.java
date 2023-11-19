package laboratory_exercise_4_algorithms;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ZigZagSequence {

    static int najdiNajdolgaCikCak(int a[]) {
        // Vasiot kod tuka
        int tmp = 1;
        int counter = 1;
        for (int i = 0; i < a.length - 1; i++) {
            if ((a[i] > 0 && a[i + 1] < 0) || (a[i] < 0 && a[i + 1] > 0))
                counter++;
            else {
                if (counter > tmp)
                    tmp = counter;
                counter = 1;
            }
        }
        if (tmp > counter)
            return tmp;
        else
            return counter;
    }

    public static void main(String[] args) throws Exception {
        int i, j, k;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int a[] = new int[N];
        for (i = 0; i < N; i++)
            a[i] = Integer.parseInt(br.readLine());

        int rez = najdiNajdolgaCikCak(a);
        System.out.println(rez);

        br.close();
    }
}