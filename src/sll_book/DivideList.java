package sll_book;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DivideList {
    public static void main(String[] args) throws IOException {
        SLL<Integer> lista = new SLL<Integer>();
        SLL<Integer> parni = new SLL<Integer>();
        SLL<Integer> neparni = new SLL<Integer>();

        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));

        String s = stdin.readLine();
        int n = Integer.parseInt(s);
        s = stdin.readLine();

        String[] pomNiza = s.split(" ");

        for (int i = 0; i < n; i++) {
            lista.insertLast(Integer.parseInt(pomNiza[i]));
        }

        SLLNode<Integer> pom = lista.getFirst();

        while (pom != null) {
            while (pom.succ != null && pom.element % 2 == 0 && pom.succ.element % 2 == 0) {
                pom = pom.succ;
            }
            while (pom.succ != null && !(pom.element % 2 == 0) && !(pom.succ.element % 2 == 0)) {
                pom = pom.succ;
            }
            if (pom.element % 2 == 0)
                parni.insertLast(pom.element);
            else
                neparni.insertLast(pom.element);
            pom = pom.succ;
        }

        if (parni.size() == 0)
            System.out.println("Prazna lista");
        else
            System.out.println(parni);

        if (neparni.size() == 0)
            System.out.println("Prazna lista");
        else
            System.out.println(neparni);
    }
}