package ex2;

public class Main {
    public static void main(String[] args) {
        Simple<String> strings = new SimpleArray<String>();
        strings.add("First");
        strings.add("Second");
        strings.add("Third");
        System.out.println(strings.get(1));
        System.out.println(strings.size());
        strings.update(1, "update");
        strings.delete(1);
        System.out.println(strings.get(1));
        for(String s : strings) {
            System.out.println(s);
        }

    }
}
