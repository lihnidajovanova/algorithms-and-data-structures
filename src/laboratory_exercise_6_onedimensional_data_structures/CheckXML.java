package laboratory_exercise_6_onedimensional_data_structures;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;
import java.util.Stack;

public class CheckXML {

    private static boolean isValid(String[] rows) {
        Stack<String> valid = new Stack<>();

        for (String row : rows) {
            if (row.charAt(0) == '[' && row.charAt(row.length() - 1) == ']') {
                if (row.charAt(1) != '/')
                    valid.push(row);
                else {
                    if (valid.pop().substring(1).compareTo(row.substring(2)) != 0)
                        return false;
                }
            }
        }
        if (valid.isEmpty())
            return true;
        else
            return false;
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int n = Integer.parseInt(s);
        String[] redovi = new String[n];

        for (int i = 0; i < n; i++)
            redovi[i] = br.readLine();

        int valid;

        // Vasiot kod tuka
        // Moze da koristite dopolnitelni funkcii ako vi se potrebni
        if (isValid(redovi))
            System.out.println(1);
        else
            System.out.println(0);

        // System.out.println(valid);

        br.close();
    }
}