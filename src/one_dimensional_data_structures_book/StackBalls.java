package one_dimensional_data_structures_book;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class StackBalls {
    public static String cancelBalls(List l) {
        ArrayStack<String> red = new ArrayStack<String>(100);
        ArrayStack<String> green = new ArrayStack<String>(100);
        ArrayStack<String> blue = new ArrayStack<String>(100);

        String s;
        String output = new String();
        int n = 0;

        for (int i = 0; i < l.size(); i++) {
            s = (String) l.get(i);

            if (s.charAt(0) == 'R') {
                if (!red.isEmpty())
                    if (red.peek().equals(s))
                        red.push(s);
                    else
                        red.pop();
                else
                    red.push(s);
            }

            if (s.charAt(0) == 'G') {
                if (!green.isEmpty())
                    if (green.peek().equals(s))
                        green.push(s);
                    else
                        green.pop();
                else
                    green.push(s);
            }

            if (s.charAt(0) == 'B') {
                if (!blue.isEmpty())
                    if (blue.peek().equals(s))
                        blue.push(s);
                    else
                        blue.pop();
                else
                    blue.push(s);
            }
        }

        while (!red.isEmpty()) {
            n++;
            if (red.pop().charAt(1) == '+')
                output += "R- ";
            else
                output += "R+ ";
        }

        while (!green.isEmpty()) {
            n++;
            if (green.pop().charAt(1) == '+')
                output += "G- ";
            else
                output += "G+ ";
        }

        while (!blue.isEmpty()) {
            n++;
            if (blue.pop().charAt(1) == '+')
                output += "B- ";
            else
                output += "B+ ";
        }

        System.out.println(n);

        return output;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = new String[100];
        input = br.readLine().split(" ");

        List<String> balls = new LinkedList<String>();
        for (int i = 0; i < input.length; i++)
            balls.add(input[i]);

        System.out.println(cancelBalls(balls));
    }
}