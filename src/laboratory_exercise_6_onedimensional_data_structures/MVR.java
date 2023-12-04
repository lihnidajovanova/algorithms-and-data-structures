package laboratory_exercise_6_onedimensional_data_structures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;


class Gragjanin {
    public String fullName;
    public int ID, passport, drivingLicence;

    Gragjanin(String fullName, int ID, int passport, int drivingLicence) {
        this.fullName = fullName;
        this.ID = ID;
        this.passport = passport;
        this.drivingLicence = drivingLicence;
    }

    @Override
    public String toString() {
        return fullName;
    }
}

class SLLNode<E> {
    protected E element;
    protected SLLNode<E> succ;

    public SLLNode(E elem, SLLNode<E> succ) {
        this.element = elem;
        this.succ = succ;
    }

    @Override
    public String toString() {
        return element.toString();
    }
}

interface Queue<E> {
    public boolean isEmpty();

    public int size();

    public E peek();

    public void clear();

    public void enqueue(E x);

    public E dequeue();
}

class LinkedQueue<E> implements Queue<E> {
    SLLNode<E> front, rear;
    int length;

    public LinkedQueue() {
        clear();
    }

    public boolean isEmpty() {
        return (length == 0);
    }

    public int size() {
        return length;
    }

    public E peek() {
        if (front == null)
            throw new NoSuchElementException();
        return front.element;
    }

    public void clear() {
        front = rear = null;
        length = 0;
    }

    public void enqueue(E x) {
        SLLNode<E> latest = new SLLNode<E>(x, null);
        if (rear != null) {
            rear.succ = latest;
            rear = latest;
        } else
            front = rear = latest;
        length++;
    }

    public E dequeue() {
        if (front != null) {
            E frontmost = front.element;
            front = front.succ;
            if (front == null) rear = null;
            length--;
            return frontmost;
        } else
            throw new NoSuchElementException();
    }

}

public class MVR {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedQueue<Gragjanin> personalID = new LinkedQueue<>();
        LinkedQueue<Gragjanin> passports = new LinkedQueue<>();
        LinkedQueue<Gragjanin> drivingLicence = new LinkedQueue<>();
        String line = br.readLine();
        int N = Integer.parseInt(line);

        for (int i = 0; i < N; i++) {
            String ime = br.readLine();
            int lKarta = Integer.parseInt(br.readLine());
            int pasos = Integer.parseInt(br.readLine());
            int vozacka = Integer.parseInt(br.readLine());
            Gragjanin licnost = new Gragjanin(ime, lKarta, pasos, vozacka);

            if (lKarta == 1) {
                personalID.enqueue(licnost);
            } else if (pasos == 1) {
                passports.enqueue(licnost);
            } else if (vozacka == 1) {
                drivingLicence.enqueue(licnost);
            }
        }

        while (!personalID.isEmpty()) {
            if (personalID.peek().drivingLicence == 0 && personalID.peek().passport == 0) {
                System.out.println(personalID.dequeue().fullName);
            } else if (personalID.peek().passport == 1) {
                passports.enqueue(personalID.dequeue());
            } else if (personalID.peek().drivingLicence == 1) {
                drivingLicence.enqueue(personalID.dequeue());
            }
        }

        while (!passports.isEmpty()) {
            if (passports.peek().drivingLicence == 0) {
                System.out.println(passports.dequeue().fullName);
            } else {
                drivingLicence.enqueue(passports.dequeue());
            }
        }

        while (!drivingLicence.isEmpty()) {
            System.out.println(drivingLicence.dequeue().fullName);
        }
    }
}