package dll_book;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DLLFlipList {
    public static void flipList(DLL<Integer> list, DLL<Integer> tmpList) {
        DLLNode<Integer> tmp = list.getLast();

        while (tmp != null) {
            if (tmp.element % 2 == 0) {
                tmpList.insertLast(tmp.element);
                if (tmp == list.getFirst()) {
                    list.deleteFirst();
                } else if (tmp == list.getLast()) {
                    list.deleteLast();
                } else {
                    (tmp.pred).succ = tmp.succ;
                    (tmp.succ).pred = tmp.pred;
                }
            }
            tmp = tmp.pred;
        }

        tmp = list.getLast();
        while (tmp != null) {
            tmpList.insertLast(tmp.element);
            tmp = tmp.pred;
        }
    }

    public static void main(String[] args) throws IOException {
        DLL<Integer> list = new DLL<Integer>(), tmpList = new DLL<Integer>();
        BufferedReader stdin = new BufferedReader(new InputStreamReader(
                System.in));
        String s = stdin.readLine();
        int n = Integer.parseInt(s);
        s = stdin.readLine();
        String[] tmpArray = s.split(" ");
        for (int i = 0; i < n; i++) {
            list.insertLast(Integer.parseInt(tmpArray[i]));
        }

        flipList(list, tmpList);

        // print new list
        DLLNode<Integer> listResult = tmpList.getFirst();
        while (listResult != null) {
            System.out.print(listResult.element);
            if (listResult.succ != null)
                System.out.print(" ");
            listResult = listResult.succ;
        }
        System.out.println();
    }
}