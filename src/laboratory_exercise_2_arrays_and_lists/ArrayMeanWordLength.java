package laboratory_exercise_2_arrays_and_lists;

import java.util.Scanner;


@SuppressWarnings("unchecked")
class Array<E> {
    private E data[]; // declared to be an Object since it would be too
    // complicated with generics
    private int size;

    public Array(int capacity) {
        this.data = (E[]) new Object[capacity];
        this.size = 0;
    }

    public void insertLast(E o) {
        //check if there is enough capacity, and if not - resize
        if (size + 1 > data.length)
            this.resize();
        data[size++] = o;
    }

    public void insert(int position, E o) {
        // before all we check if position is within range
        if (position >= 0 && position <= size) {
            //check if there is enough capacity, and if not - resize
            if (size + 1 > data.length)
                this.resize();
            //copy the data, before doing the insertion
            for (int i = size; i > position; i--) {
                data[i] = data[i - 1];
            }
            data[position] = o;
            size++;
        } else {
            System.out.println("Ne mozhe da se vmetne element na taa pozicija");
        }
    }

    public void set(int position, E o) {
        if (position >= 0 && position < size)
            data[position] = o;
        else
            System.out.println("Ne moze da se vmetne element na dadenata pozicija");
    }

    public E get(int position) {
        if (position >= 0 && position < size)
            return data[position];
        else
            System.out.println("Ne e validna dadenata pozicija");
        return null;
    }

    public int find(E o) {
        for (int i = 0; i < size; i++) {
            if (o.equals(data[i]))
                return i;
        }
        return -1;
    }

    public int getSize() {
        return size;
    }

    public void delete(int position) {
        // before all we check if position is within range
        if (position >= 0 && position < size) {
            // first resize the storage array
            E[] newData = (E[]) new Object[size - 1];
            // copy the data prior to the delition
            for (int i = 0; i < position; i++)
                newData[i] = data[i];
            // move the data after the deletion
            for (int i = position + 1; i < size; i++)
                newData[i - 1] = data[i];
            // replace the storage with the new array
            data = newData;
            size--;
        }
    }

    public void resize() {
        // first resize the storage array
        E[] newData = (E[]) new Object[size * 2];
        // copy the data
        for (int i = 0; i < size; i++)
            newData[i] = data[i];
        // replace the storage with the new array
        this.data = newData;
    }

    @Override
    public String toString() {
        String ret = new String();
        if (size > 0) {
            ret = "{";
            ret += data[0];
            for (int i = 1; i < size; i++) {
                ret += "," + data[i];
            }
            ret += "}";
            return ret;
        } else {
            ret = "Prazna niza!";
        }
        return ret;
    }

}

public class ArrayMeanWordLength {

    //TODO: implement function
    public static String wordClosestToAverageLength(Array<String> arr) {
        // Calculate the total length of all words in the array
        int totalLength = 0;
        for (int i = 0; i < arr.getSize(); i++) {
            totalLength += arr.get(i).length();
        }

        // Calculate the average length of words in the array
        double averageLength = (double) totalLength / arr.getSize();

        // Initialize closestWordToAverage to the first word in the array
        String closestWordToAverage = arr.get(0);

        // Calculate the first difference between the length of the first word and the average length
        double closestWordDifference = Math.abs(closestWordToAverage.length() - averageLength);

        // Iterate through the array to find the word closest to the average length
        for (int i = 0; i < arr.getSize(); i++) {
            String str = arr.get(i);
            // Calculate the difference between the length of the current word and the average length
            double difference = Math.abs(str.length() - averageLength);

            // Check if the current word is closer to the average length than the previously closest word
            if (difference < closestWordDifference || (difference == closestWordDifference && str.length() > closestWordToAverage.length())) {
                // If the current word is closer, update the closest word and its corresponding difference
                closestWordToAverage = str;
                closestWordDifference = difference;
            }
        }

        // Return the word that is closest to the average length in the array
        return closestWordToAverage;
    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int N = input.nextInt();
        Array<String> arr = new Array<>(N);
        input.nextLine();

        for (int i = 0; i < N; i++) {
            arr.insertLast(input.nextLine());
        }

        System.out.println(wordClosestToAverageLength(arr));
    }
}