package ex1;

import ex3.Linked;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        UnmodifiableDoublyLinkedList<String> list = new UnmodifiableDoublyLinkedList<String>();
        list.addLast("Marina");
        list.addLast("Anna");
        list.addLast("Mila");
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));

        List<String> listWithCopies = new ArrayList<String>();
        listWithCopies.add("a");
        listWithCopies.add("a");
        listWithCopies.add("a");
        listWithCopies.add("b");
        listWithCopies.add("b");
        listWithCopies.add("c");
        Map frequency = CountFrequency.getFrequencyMap(listWithCopies);
        for(Object el : frequency.keySet()) {
            System.out.println(el + " " + frequency.get(el));
        }
    }
}
