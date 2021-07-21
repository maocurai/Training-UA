package ex3;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        LinkedContainer<String> stringLinked = new LinkedContainer<String>();
        stringLinked.addLast("abc");
        stringLinked.addLast("abc");
        stringLinked.addLast("abc");
        stringLinked.addLast("abc");
        System.out.println(stringLinked.size());
        System.out.println(stringLinked.getElementByIndex(0));
        for(String s : stringLinked) {
            System.out.println(s);
        }

        Iterator iterator = stringLinked.descendingIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
