/*
package one_dimensional_data_structures_book;

import java.util.*;

public class DanceCouples {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] candidates = input.split(" ");

        HashMap<String, Integer> maleCount = new HashMap<>();
        HashMap<String, Integer> femaleCount = new HashMap<>();

        for (String candidate : candidates) {
            String[] data = candidate.split("");
            String gender = data[1];
            String group = data[0];

            if (gender.equals("M")) {
                maleCount.put(group, maleCount.getOrDefault(group, 0) + 1);
            } else {
                femaleCount.put(group, femaleCount.getOrDefault(group, 0) + 1);
            }
        }

        int couples = 0;
        StringBuilder output = new StringBuilder();

        for (String group : maleCount.keySet()) {
            int male = maleCount.getOrDefault(group, 0);
            int female = femaleCount.getOrDefault(group, 0);
            int minCount = Math.min(male, female);
            couples += minCount;

            for (int i = 0; i < minCount; i++) {
                output.append(group).append(" ");
            }

            maleCount.put(group, male - minCount);
            femaleCount.put(group, female - minCount);
        }

        System.out.println(couples);
        System.out.println(output);
    }
}*/
