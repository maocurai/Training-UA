package ex3;

import java.util.Iterator;

public class LinkedContainer<E> implements Linked<E>, Iterable<E>, DescendingIterator<E>{

    private Node<E> firstNode;
    private Node<E> lastNode;
    private int size = 0;

    public LinkedContainer() {
        firstNode = new Node<E>(null, null, lastNode);
        lastNode = new Node<E>(null, firstNode, null);
    }

    public void addLast(E e) {
        Node<E> prev = lastNode;
        prev.setCurrentElement(e);
        lastNode = new Node<E>(null, prev, null);
        prev.setNextElement(lastNode);
        size++;
    }

    public void addFirst(E e) {
        Node<E> next = firstNode;
        next.setCurrentElement(e);
        firstNode = new Node<E>(null, null, next);
        next.setPrevElement(firstNode);
        size++;
    }

    public int size() {
        return size;
    }

    public E getElementByIndex(int counter) {
        Node<E> target = firstNode.getNextElement();
        for(int i=0; i<counter; i++) {
            target = getNextElement(target);
        }
        return target.getCurrentElement();
    }

    private Node<E> getNextElement(Node<E> current) {
        return current.getNextElement();
    }

    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int counter = 0;
            public boolean hasNext() {
                return counter < size;
            }

            public E next() {
                return getElementByIndex(counter++);
            }

            public void remove() {}
        };
    }

    public Iterator<E> descendingIterator() {
        return new Iterator<E>() {
            int counter = size-1;

            public boolean hasNext() {
                return counter>=0;
            }

            public E next() {
                return getElementByIndex(counter--);
            }

            public void remove() {}
        };
    }


    private class Node<E> {
        private E currentElement;
        private Node<E> nextElement;
        private Node<E> prevElement;

        private Node(E currentElement, Node<E> nextElement, Node<E> prevElement) {
            this.currentElement = currentElement;
            this.nextElement = nextElement;
            this.prevElement = prevElement;
        }

        public E getCurrentElement() {
            return currentElement;
        }

        public void setCurrentElement(E currentElement) {
            this.currentElement = currentElement;
        }

        public Node<E> getNextElement() {
            return nextElement;
        }

        public void setNextElement(Node<E> nextElement) {
            this.nextElement = nextElement;
        }

        public Node<E> getPrevElement() {
            return prevElement;
        }

        public void setPrevElement(Node<E> prevElement) {
            this.prevElement = prevElement;
        }
    }




}
