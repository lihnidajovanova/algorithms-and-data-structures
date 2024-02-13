package one_dimensional_data_structures_book;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Вметни класа Stack
// Вметни класа ArrayStack
// Вметни класа Queue
// Вметни класа ArrayQueue
public class QueueTrains {

    public static String reallocate(String[] input) {
        int n = input.length;
        ArrayStack<Integer> oldTrain = new ArrayStack<Integer>(n);
        ArrayStack<Integer> newTrain = new ArrayStack<Integer>(n);
        ArrayQueue<Integer> rail = new ArrayQueue<Integer>(n);
        int top;
        String out = new String("");

        for (int i = 0; i < n; i++)
            oldTrain.push(Integer.parseInt(input[i]));

        while (true) {
            if (!oldTrain.isEmpty() && oldTrain.peek() != 0)
                newTrain.push(oldTrain.pop());
            else {
                while (!oldTrain.isEmpty() && oldTrain.peek() == 0)
                    oldTrain.pop();
                if (oldTrain.isEmpty())
                    out += "Site vagoni se rasipani";
                else
                    newTrain.push(oldTrain.pop());
            }

            while (!oldTrain.isEmpty()) {
                while (!oldTrain.isEmpty() && oldTrain.peek() == 0)
                    oldTrain.pop();

                if (oldTrain.isEmpty())
                    break;
                else {
                    top = oldTrain.pop();
                    if (newTrain.peek() < top) {
                        rail.enqueue(newTrain.pop());
                        newTrain.push(top);
                    } else
                        rail.enqueue(top);
                }
            }

            if (!rail.isEmpty())
                newTrain.push(rail.dequeue());
            while (!rail.isEmpty()) {
                top = rail.dequeue();
                if (newTrain.peek() < top) {
                    oldTrain.push(newTrain.pop());
                    newTrain.push(top);
                } else
                    oldTrain.push(top);
            }
            if (oldTrain.isEmpty() && rail.isEmpty())
                break;
        }
        while (!newTrain.isEmpty())
            out += newTrain.pop() + " ";

        return out;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int n = Integer.parseInt(s);
        String[] input = new String[n];

        for (int i = 0; i < n; i++) {
            input[i] = br.readLine();
        }

        System.out.println(reallocate(input));
        br.close();
    }
}