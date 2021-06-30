import java.util.SortedSet;
import java.util.TreeSet;

public class Model {

    private int secretNumber;
    private int min;
    private int max;
    private boolean isGameOver = false;

    private SortedSet<Integer> userNumberStatisticsSet = new TreeSet();

    // [1-99]
    public void setSecretNumber(){
        secretNumber = (int)Math.ceil(Math.random()*
                (max - min - 1) + min);
    }

    public void setSecretNumber(int num){
        secretNumber = num;
    }

    public void setPrimaryBarrier(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public boolean isGameOver() { return isGameOver; }

    public int getMin() { return min; }

    public void setMin(int min) { this.min = min; }

    public int getMax() { return max; }

    public void setMax(int max) { this.max = max; }

    public int compareNumbers(Integer userNumber) {
        return userNumber.compareTo(secretNumber);
    }

    public int checkNumber(int userNumber) {
        userNumberStatisticsSet.add(userNumber);
        int res = compareNumbers(userNumber);
        switch (res) {
            case 1: setMax(userNumber); break;
            case -1: setMin(userNumber); break;
            case 0: isGameOver = true;
        }
        return res;
    }

    public int getSecretNumber() { return secretNumber; }

    public SortedSet<Integer> getUserNumberStatisticsSet() {
        return userNumberStatisticsSet;
    }

    public String rangeToString() {
        return "[" + min + "; " + max + "]";
    }
}