package arrays_book;

import java.util.ArrayList;

public class ChangeArrays<E> {
    public void compareAndChangeArrays(Array<E> arr1, Array<E> arr2) {
        if (arr1.getSize() != arr2.getSize()) {
            System.out.println("The sizes of the arrays are different!");
            return;
        }
        int size = arr1.getSize();
        int i = 0;

        while (i < size) {
            if (arr1.get(i).equals(arr2.get(i))) {
                arr1.delete(i);
                arr2.delete(i);
                size--;
            } else {
                i++;
            }
        }
    }

/*    private void compareAndChangeArrays(ArrayList<E> arr3, ArrayList<E> arr4) {
        if (arr3.getSize() != arr4.getSize()) {
            System.out.println("The sizes of the arrays are different!");
            return;
        }
        int size = arr3.getSize();
        int i = 0;

        while (i < size) {
            if (arr3.get(i).equals(arr4.get(i))) {
                arr3.delete(i);
                arr4.delete(i);
                size--;
            } else {
                i++;
            }
        }
    }*/

    public static void main(String[] args) {
        Array<String> arr1 = new Array<String>(4);
        arr1.insertLast("nb11");
        arr1.insertLast("b1");
        arr1.insertLast("b2");
        arr1.insertLast("nb12");

        Array<String> arr2 = new Array<String>(4);
        arr2.insertLast("nb21");
        arr2.insertLast("b1");
        arr2.insertLast("b2");
        arr2.insertLast("nb22");

        System.out.println("Arrays before using the function: ");
        System.out.println(arr1.toString());
        System.out.println(arr2.toString());

        ChangeArrays<String> pom1 = new ChangeArrays<String>();
        pom1.compareAndChangeArrays(arr1, arr2);

        System.out.println("Arrays after using the function: ");
        System.out.println(arr1.toString());
        System.out.println(arr2.toString());

/*        ArrayList<Integer> arr3 = new ArrayList<Integer>(3);
        arr3.add(10);
        arr3.add(13);
        arr3.add(7);

        ArrayList<Integer> arr4 = new ArrayList<Integer>(3);
        arr4.add(5);
        arr4.add(13);
        arr4.add(3);

        System.out.println("Arrays before using the function");
        System.out.println(arr3.toString());
        System.out.println(arr4.toString());

        ChangeArrays<Integer> pom2 = new ChangeArrays<Integer>();
        pom2.compareAndChangeArrays(arr3, arr4);

        System.out.println("Arrays after using the function: ");
        System.out.println(arr3.toString());
        System.out.println(arr4.toString());*/
    }
}
