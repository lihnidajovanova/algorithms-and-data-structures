package laboratory_exercise_1_introduction_to_java;

import java.util.Scanner;

class QuarterlySales {

    private int numOfSales;
    private int[] revenues;
    private int quarterNo;

    public QuarterlySales(int numOfSales, int[] revenues, int quarterNo) {
        this.numOfSales = numOfSales;
        this.revenues = revenues;
        this.quarterNo = quarterNo;
    }

    public int getNumOfSales() {
        return numOfSales;
    }

    public int[] getRevenues() {
        return revenues;
    }

    public int getQuarterNo() {
        return quarterNo;
    }

    @Override
    public String toString() {
        String result = "Quarter " + quarterNo + ": ";
        for (int i = 0; i < numOfSales; i++) {
            result += revenues[i];
            if (i < numOfSales - 1) {
                result += ", ";
            }
        }
        return result;
    }

}

class SalesPerson {

    private String name;
    private QuarterlySales[] quarters;

    public SalesPerson(String name, QuarterlySales[] quarters) {
        this.name = name;
        this.quarters = quarters;
    }

    public String getName() {
        return name;
    }

    public QuarterlySales[] getQuarters() {
        return quarters;
    }

    @Override
    public String toString() {
        return name;
    }

}

public class Main {

    public static int sumSales(SalesPerson sp) {
        int totalRevenue = 0;
        for (QuarterlySales quarter : sp.getQuarters()) {
            totalRevenue += sumArray(quarter.getRevenues());
        }
        return totalRevenue;
    }

    public static SalesPerson salesChampion(SalesPerson[] arr) {
        SalesPerson champion = null;
        int maxRavenue = 0;
        for (SalesPerson sp : arr) {
            int totalRevenue = sumSales(sp);
            if (totalRevenue > maxRavenue) {
                maxRavenue = totalRevenue;
                champion = sp;
            }
        }
        return champion;
    }

    public static void table(SalesPerson[] arr) {
        System.out.print("SP");

        for (int i = 1; i <= 4; i++) {
            System.out.print(String.format("   %d", i));
        }
        System.out.println("   Total");

        for (SalesPerson sp : arr) {
            System.out.print(sp.getName());

            int totalRevenue = 0;
            for (QuarterlySales quarter : sp.getQuarters()) {
                int quarterRevenue = sumArray(quarter.getRevenues());
                totalRevenue += quarterRevenue;
                System.out.print(String.format("   %d", quarterRevenue));
            }
            System.out.println(String.format("   %d", totalRevenue));
        }
    }

    public static int sumArray(int[] arr) {
        int sum = 0;
        for (int value : arr) {
            sum += value;
        }
        return sum;
    }

    public static void main(String[] args) {

        int n;
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        SalesPerson[] arr = new SalesPerson[n];
        for (int i = 0; i < n; i++) {
            //your code goes here
            String name = input.next();
            QuarterlySales[] quarters = new QuarterlySales[4];
            for (int j = 0; j < 4; j++) {
                int numOfSales = input.nextInt();
                int[] revenues = new int[numOfSales];
                for (int k = 0; k < numOfSales; k++) {
                    revenues[k] = input.nextInt();
                }
                quarters[j] = new QuarterlySales(numOfSales, revenues, j + 1);
            }
            arr[i] = new SalesPerson(name, quarters);
        }
        table(arr);
        System.out.println();
        System.out.println("SALES CHAMPION: " + salesChampion(arr).getName());
    }
}