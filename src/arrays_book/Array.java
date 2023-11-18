package arrays_book;

public class Array<E> {
    private E data[];
    private int size;

    public Array(int capacity) {
        this.data = (E[]) new Object[capacity];
        this.size = 0;
    }

    // TODO: array methods

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
            ret = "Empty array!";
        }
        return ret;
    }

    public void insertLast(E o) {
        //check if the array has enough capacity, if not - resize
        if (size + 1 > data.length)
            this.resize();
        data[size++] = o;
    }

    public void insert(int position, E o) {
        //check if the position is in a given range
        if (position >= 0 && position <= size) {
            //check if the array has enough capacity, if not - resize
            if (size + 1 > data.length)
                this.resize();
            //copy the data one position to the right
            for (int i = size; i > position; i--) {
                data[i] = data[i - 1];
            }
            data[position] = o;
            size++;
        } else {
            System.out.println("Cannot insert an element at this position.");
        }
    }

    // this method doubles the capacity of the array
    private void resize() {
        //allocate a new memory space twice as large
        E[] newData = (E[]) new Object[size * 2];
        //copy the data into the new space
        for (int i = 0; i < size; i++)
            newData[i] = data[i];
        //replace the old memory space with the new one
        this.data = newData;
    }

    public void delete(int position) {
        //check if the position is in a given range
        if (position >= 0 && position < size) {
            //the data after the given position is copied one place to the left
            for (int i = position + 1; i < size; i++)
                data[i - 1] = data[i];
            size--;
        }
    }

    public E get(int position) {
        if (position >= 0 && position < size)
            return data[position];
        else
            System.out.println("The given position isn't valid.");
        return null;
    }

    public void set(int position, E o) {
        if (position >= 0 && position < size)
            data[position] = o;
        else
            System.out.println("Cannot insert an element at the given position.");
    }

    public int getSize() {
        return size;
    }

    public int find(E o) {
        for (int i = 0; i < size; i++) {
            if (o.equals(data[i]))
                return i;
        }
        return -1;
    }
}
