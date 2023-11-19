package sll_book;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SwapPairs {
    public static void main(String[] args) throws Exception {
        SLL<Integer> lista = new SLL<Integer>();
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(stdin.readLine());

        for (int i = 0; i < n; i++) {
            lista.insertLast(Integer.parseInt(stdin.readLine()));
        }

        SLLNode<Integer> jazol = lista.getFirst();
        while (jazol != null && jazol.succ != null) {
            Integer pom = jazol.element;
            jazol.element = jazol.succ.element;
            jazol.succ.element = pom;
            jazol = jazol.succ.succ;
        }
        System.out.print(lista.toString());
    }
}