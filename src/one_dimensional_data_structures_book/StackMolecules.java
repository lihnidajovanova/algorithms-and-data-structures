package one_dimensional_data_structures_book;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StackMolecules {

    public static String createMolecule(ArrayQueue<String> l) {
        ArrayStack<String> hydrogen = new ArrayStack<String>(1000);
        ArrayStack<String> oxygen = new ArrayStack<String>(1000);
        String s;
        String output = new String();
        int n = 0;

        while (!l.isEmpty()) {
            s = (String) l.dequeue();
            if (s.equals("H"))
                hydrogen.push(s);
            else
                oxygen.push(s);
        }

        while (!oxygen.isEmpty()) {
            if (!hydrogen.isEmpty()) {
                hydrogen.pop();
                if (!hydrogen.isEmpty()) {
                    hydrogen.pop();
                    oxygen.pop();
                    n++;
                } else {
                    hydrogen.push("H");
                    break;
                }
            } else
                break;
        }

        while (!hydrogen.isEmpty()) {
            hydrogen.pop();
            output += "H\n";
        }

        while (!oxygen.isEmpty()) {
            oxygen.pop();
            output += "O\n";
        }

        System.out.println(n);

        return output;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = new String[1000];
        input = br.readLine().split(" ");

        ArrayQueue<String> atoms = new ArrayQueue<String>(1000);
        for (int i = 0; i < input.length; i++)
            atoms.enqueue(input[i]);

        System.out.println(createMolecule(atoms));
    }
}