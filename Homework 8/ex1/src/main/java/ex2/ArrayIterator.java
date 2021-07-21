package ex2;

import java.util.Iterator;

public class ArrayIterator<E> implements Iterator {

    private int index = 0;
    private E[] values;

    public ArrayIterator(E[] values) {
        this.values = values;
    }

    public boolean hasNext() {
        return index < values.length;
    }

    public Object next() {
        return values[index++];
    }

    public void remove() {

    }


}
