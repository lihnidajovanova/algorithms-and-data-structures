package one_dimensional_data_structures_book;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;

class Process implements Comparable<Process> {
    private String name;
    private int arrival_time, execution_time;

    public Process(String n, int at, int et) {
        this.name = n;
        this.arrival_time = at;
        this.execution_time = et;
    }

    public void updateTime(int quantum) {
        if (this.execution_time < quantum)
            this.execution_time = 0;
        else
            this.execution_time -= quantum;
    }

    public int get_arrivalTime() {
        return this.arrival_time;
    }

    public int get_executionTime() {
        return this.execution_time;
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        return name;
    }

    @Override
    public int compareTo(Process o) {
        // TODO Auto-generated method stub
        if (this.arrival_time > o.get_arrivalTime())
            return 1;
        else if (this.arrival_time == o.get_arrivalTime()) {
            if (this.execution_time > o.get_executionTime())
                return -1;
            else
                return 1;
        } else
            return -1;
    }
}

public class QueueRoundRobin {
    public static void main(String[] args) throws IOException {
        //TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedList<Process> pList = new LinkedList<Process>();
        Process p = null;

        LinkedQueue<Process> q = new LinkedQueue<Process>();

        int n = Integer.parseInt(br.readLine());
        String input;

        for (int i = 0; i < n; i++) {
            input = br.readLine();
            String[] atrb = input.split(" ");
            int arrivalT = Integer.parseInt(atrb[2]);
            int executionT = Integer.parseInt(atrb[1]);
            p = new Process(atrb[0], arrivalT, executionT);
            pList.add(p);
        }

        int quantum = Integer.parseInt(br.readLine());

        Collections.sort(pList);

        for (int i = 0; i < n; i++) {
            // System.out.println(pList.get(i).getName());
            q.enqueue(pList.get(i));
        }

        while (!q.isEmpty()) {
            p = q.dequeue();
            p.updateTime(quantum);
            if (p.get_executionTime() != 0)
                q.enqueue(p);
            System.out.print(p.toString() + " ");
        }
    }
}