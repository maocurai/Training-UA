import java.util.*;
import java.util.stream.IntStream;

public class Main {

    public static int [] generateRandomIntArray(int size, int startInclusive, int endExclusive) {
        return new Random()
                .ints(size, startInclusive, endExclusive)
                .toArray();
    }

    public static void printIntArray(int [] arr) {
        Arrays.stream(arr).forEach(x -> System.out.print(x + " "));
        System.out.println();
    }

    public static double getAverage(int [] arr) {
        return Arrays.stream(arr).average().getAsDouble();
    }

    public static int getZeroElementsNumber(int [] arr) {
        return (int)IntStream.of(arr).filter(x -> x == 0).count();
    }

    public static int getPositiveElementsNumber(int [] arr) {
        return (int)Arrays.stream(arr).filter(x -> x > 0).count();
    }

    public static int getMinElementValue(int [] arr) {
//        IntStream.of(arr).min();
        return IntStream.of(arr).sorted().findFirst().getAsInt();
    }

    public static int [] multiplyByNumber(int [] arr, int multiplier) {
        return Arrays.stream(arr).map(x -> x * multiplier).toArray();
    }

    public static void main(String[] args) {
        int [] arr = generateRandomIntArray(5, -10, 10);
        printIntArray(arr);
        System.out.println("Average : " + getAverage(arr));
        System.out.println("Zero elements number: " + getZeroElementsNumber(arr));
        System.out.println("Positive elements number: " + getPositiveElementsNumber(arr));
        System.out.println("Min element: " + getMinElementValue(arr));
        int multiplier = 2;
        System.out.println("Multiplied by " + multiplier);
        printIntArray(multiplyByNumber(arr, multiplier));
//        Arrays.asList(arr).indexOf(IntStream.of(arr).min().getAsInt());
    }
}
