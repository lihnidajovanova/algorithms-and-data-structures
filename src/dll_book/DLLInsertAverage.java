package dll_book;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DLLInsertAverage {
    public static void main(String[] args) throws IOException {
        DLL<Integer> list = new DLL<Integer>();
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String s = stdin.readLine();
        int n = Integer.parseInt(s);
        s = stdin.readLine();
        String[] tmpArray = s.split(" ");
        for (int i = 0; i < n; i++) {
            list.insertLast(Integer.parseInt(tmpArray[i]));
        }

        DLLNode<Integer> tmp = list.getFirst();
        DLLNode<Integer> next = tmp.succ;
        while (tmp != null && next != null) {
            float a = tmp.element;
            float b = next.element;
            Integer average = Math.round((a + b) / 2);
            list.insertAfter(average, tmp);
            tmp = next;
            next = tmp.succ;
        }

        tmp = list.getFirst();
        while (tmp != null) {
            System.out.print(tmp.element + " ");
            tmp = tmp.succ;
        }
    }
}
