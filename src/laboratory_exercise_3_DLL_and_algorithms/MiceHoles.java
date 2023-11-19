package laboratory_exercise_3_DLL_and_algorithms;

import java.util.Arrays;
import java.util.Scanner;

public class MiceHoles {

    //TODO: implement function
    public static int minTime(int mice[], int holes[]) {
        // sort the arrays
        Arrays.sort(mice);
        Arrays.sort(holes);

        int minTime = 0;

        // iterate through each mouse and hole pair
        for (int i = 0; i < mice.length; i++) {
            // calculate absolute difference and update the minTime
            int time = Math.abs(mice[i] - holes[i]);
            minTime = Math.max(minTime, time);
        }

        return minTime;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // read the positions of mice
        String line = input.nextLine();
        String parts[] = line.split(" ");
        int mice[] = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            mice[i] = Integer.parseInt(parts[i]);
        }

        // read the positions of holes
        line = input.nextLine();
        parts = line.split(" ");
        int holes[] = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            holes[i] = Integer.parseInt(parts[i]);
        }

        System.out.println(minTime(mice, holes));
    }
}