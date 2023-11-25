package dll_book;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DLLMilitary {


    public static void main(String[] args) throws IOException {
        DLL<Integer> lista = new DLL<Integer>();
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String s = stdin.readLine();
        int N = Integer.parseInt(s);
        s = stdin.readLine();
        String[] ids = s.split(" ");
        for (int i = 0; i < N; i++) {
            lista.insertLast(Integer.parseInt(ids[i]));
        }

        s = stdin.readLine();
        String interval[] = s.split(" ");
        int a = Integer.parseInt(interval[0]);
        int b = Integer.parseInt(interval[1]);

        s = stdin.readLine();
        interval = s.split(" ");
        int c = Integer.parseInt(interval[0]);
        int d = Integer.parseInt(interval[1]);


        DLL<Integer> result = military(lista, a, b, c, d);


        DLLNode<Integer> node = result.getFirst();
        System.out.print(node.element);
        node = node.succ;
        while (node != null) {
            System.out.print(" " + node.element);
            node = node.succ;
        }
    }

    private static DLL<Integer> military(DLL<Integer> lista, int a, int b, int c, int d) {

        DLLNode<Integer> firstStart = null;
        DLLNode<Integer> firstEnd = null;
        DLLNode<Integer> secondStart = null;
        DLLNode<Integer> secondEnd = null;

        DLLNode<Integer> steps = lista.getFirst();
        while (steps != null) {
            if (steps.element == a) firstStart = steps;
            if (steps.element == b) firstEnd = steps;
            if (steps.element == c) secondStart = steps;
            if (steps.element == d) secondEnd = steps;
            steps = steps.succ;
        }
        // 10 50 40 25 1
        steps = lista.getLast();
        DLLNode<Integer> tempStart = firstStart.pred;
        DLLNode<Integer> tempEnd = firstEnd.succ;
        if (secondStart.pred != firstEnd) {
            firstStart.pred = secondStart.pred;
            if (firstStart.pred != null)
                firstStart.pred.succ = firstStart;
            firstEnd.succ = secondEnd.succ;
            if (firstEnd.succ != null)
                firstEnd.succ.pred = firstEnd;
            secondStart.pred = tempStart;
            if (secondStart.pred != null)
                secondStart.pred.succ = secondStart;
            secondEnd.succ = tempEnd;
            if (secondEnd.succ != null)
                secondEnd.succ.pred = secondEnd;
        } else {
            firstEnd.succ = secondEnd.succ;
            if (firstEnd.succ != null)
                firstEnd.succ.pred = firstEnd;
            firstStart.pred = secondEnd;
            firstStart.pred.succ = firstStart;
            secondStart.pred = tempStart;
            if (secondStart.pred != null)
                secondStart.pred.succ = secondStart;
        }
        while (steps.pred != null) {
            steps = steps.pred;
        }
        DLL<Integer> newList = new DLL<Integer>();
        newList.insertFirst(steps.element);
        DLLNode<Integer> adder = newList.getFirst();
        while (steps.succ != null) {
            newList.insertAfter(steps.succ.element, adder);
            steps = steps.succ;
            adder = adder.succ;
        }
        return newList;
    }
}