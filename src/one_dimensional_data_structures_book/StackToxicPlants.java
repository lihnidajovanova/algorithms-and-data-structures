package one_dimensional_data_structures_book;

import java.util.Scanner;

public class StackToxicPlants {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Читање на влезните податоци
        int n = scanner.nextInt(); // број на растенија
        int[] pesticides = new int[n]; // количина на пестициди за секоја растенија
        for (int i = 0; i < n; i++) {
            pesticides[i] = scanner.nextInt();
        }

        // Пресметка на бројот на денови пред да нема повеќе умирање на растенија
        int days = calculateDaysWithoutDeaths(n, pesticides);
        System.out.println(days);
    }

    // Метод за пресметка на бројот на денови пред да нема повеќе умирање на растенија
    private static int calculateDaysWithoutDeaths(int n, int[] pesticides) {
        int days = 0; // број на денови
        boolean allDead = true; // променлива за проверка дали сите растенија се мртви

        do {
            allDead = true; // Претпоставуваме дека сите растенија се мртви за овој ден
            int[] nextDayPesticides = new int[n]; // пестициди за следниот ден

            for (int i = 0; i < n; i++) {
                if (i > 0 && pesticides[i] > pesticides[i - 1]) {
                    allDead = false; // Ако растението е силно, тоа се уништува
                } else {
                    nextDayPesticides[i] = pesticides[i]; // Растението останува живо
                }
            }

            if (!allDead) {
                pesticides = nextDayPesticides; // Ако има живи растенија, ажурираме ги пестицидите за следниот ден
                days++; // Зголемуваме го бројот на денови
            }
        } while (!allDead);

        return days;
    }
}
