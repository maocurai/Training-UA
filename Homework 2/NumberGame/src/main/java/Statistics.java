import java.util.SortedSet;
import java.util.TreeSet;

public class Statistics {
    SortedSet<Integer> userNumberStatisticsSet;

    public Statistics() {
        this.userNumberStatisticsSet = new TreeSet();
    }

    public SortedSet<Integer> getUserNumberStatisticsSet() {
        return userNumberStatisticsSet;
    }

    public void add(Integer userNumber) {
        userNumberStatisticsSet.add(userNumber);
    }
}