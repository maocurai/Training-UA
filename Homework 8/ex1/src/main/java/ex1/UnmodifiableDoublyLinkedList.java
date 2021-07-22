package ex1;

import java.util.*;

public class UnmodifiableDoublyLinkedList<T> extends AbstractList {

    Node<T> tail;
    Node<T> head;
    int size;

    public Node<T> createNode(T data) {
        return new Node<T>(data);
    }

    private void increaseSizeCounter() { size++; }

    public UnmodifiableDoublyLinkedList() {
        tail = head = null;
        size = 0;
    }

    public void add(int index, Object element) {
        if(isEmpty() || index == 0) {
            addFirst(element);
        }
        if(isSuchIndex(index)) {
            Node el = createNode((T) element);
            Node temp = getNodeAt(index);
            temp.previous.next = el;
            el.previous = temp.previous;
            el.next = temp;
            temp.previous = el;
            increaseSizeCounter();
        }
    }

    public void addFirst(Object element) {
        Node newNode = createNode((T)element);
        if(isEmpty()) {
            tail = newNode;
        }
        newNode.next = head;
        head = newNode;
        increaseSizeCounter();
    }

    public void addLast(Object element) {
        if(isEmpty()) {
            addFirst(element);
        } else {
            Node el = createNode((T) element);
            tail.next = el;
            el.previous = tail;
            tail = el;
        }
    }

    private boolean isSuchIndex(int index) {
        if((index <= size-1) && (index >=0)) return true;
        throw new IndexOutOfBoundsException();
    }

    public Object get(int index) {
        return getNodeAt(index).getData();
    }

    private Node getNodeAt(int index) {
        Node temp = head;
        for(int i=0; i<index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public int indexOf(Object o) {
        int index = 0;
        for(Node ptr = head; ptr!=null; ptr = ptr.next) {
            if(ptr.getData() == (T)o) return index;
            index++;
        }
        return -1;
    }

    public int lastIndexOf(Object o) {
        int index = size-1;
        for(Node ptr = tail; ptr!=null; ptr = ptr.previous) {
            if(ptr.getData() == (T)o) return index;
            index--;
        }
        return -1;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public boolean contains(Object o) {
        return (indexOf(o) != -1);
    }

    public Object[] toArray() {
        Object [] arr= new Object[size-1];
        Node temp = head;
        for(int i=0; i<size-1; i++) {
            arr[i] = temp.getData();
            temp = temp.next;
        }
        return arr;
    }

    public Object set(int index, Object element) {
        throw new UnsupportedOperationException();
    }

    public Object remove(int index) {
        throw new UnsupportedOperationException();
    }

    public void clear() {
        throw new UnsupportedOperationException();
    }

    public boolean retainAll(Collection c) {
        throw new UnsupportedOperationException();
    }

    public boolean removeAll(Collection c) {
        throw new UnsupportedOperationException();
    }

    public boolean remove(Object o) {
        throw new UnsupportedOperationException();
    }

    public List subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

}
