package dll_book;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DLLDivideByParity {
    public static void divideByParity(DLL<Integer> list, DLL<Integer> even, DLL<Integer> odd) {
        DLLNode<Integer> tmp1 = list.getFirst();
        DLLNode<Integer> tmp2 = list.getLast();

        while (tmp1 != tmp2 && tmp2.succ != tmp1) {
            if (tmp1.element % 2 == 0)
                even.insertLast(tmp1.element);
            else
                odd.insertLast(tmp1.element);
            if (tmp2.element % 2 == 0)
                even.insertLast(tmp2.element);
            else
                odd.insertLast(tmp2.element);
            tmp1 = tmp1.succ;
            tmp2 = tmp2.pred;
        }

        if (tmp1 == tmp2) {
            if (tmp1.element % 2 == 0)
                even.insertLast(tmp1.element);
            else
                odd.insertLast(tmp2.element);
            return;
        }
    }

    public static void main(String[] args) throws IOException {
        DLL<Integer> list = new DLL<Integer>(), even = new DLL<Integer>(), odd = new DLL<Integer>();
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String s = stdin.readLine();
        int n = Integer.parseInt(s);
        s = stdin.readLine();
        String[] tmpArray = s.split(" ");
        for (int i = 0; i < n; i++) {
            list.insertLast(Integer.parseInt(tmpArray[i]));
        }

        divideByParity(list, even, odd);

        // print even
        DLLNode<Integer> tmp = even.getFirst();
        while (tmp != null) {
            System.out.print(tmp.element);
            if (tmp.succ != null)
                System.out.print(" ");
            tmp = tmp.succ;
        }
        System.out.println();
        // print odd
        tmp = odd.getFirst();
        while (tmp != null) {
            System.out.print(tmp.element);
            if (tmp.succ != null)
                System.out.print(" ");
            tmp = tmp.succ;
        }
        System.out.println();
    }
}