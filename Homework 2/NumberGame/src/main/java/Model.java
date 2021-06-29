public class Model {
    private Integer secretNumber;
    private Integer userNumber;
    private Integer min;
    private Integer max;

    public Model(int min, int max) {
        this.min = min;
        this.max = max;
        this.secretNumber = min + (int)(Math.random()* (max-min) + 1);
    }

    public Integer getSecretNumber() { return secretNumber; }

    public int compareNumbers(Integer userNumber) {
        return userNumber.compareTo(secretNumber);
    }

    public String rangeToString() {
        return "[" + min + "; " + max + "]";
    }

    public Integer getMin() { return min; }

    public void setMin(Integer min) { this.min = min; }

    public Integer getMax() { return max; }

    public void setMax(Integer max) { this.max = max; }

    public Integer getUserNumber() { return userNumber; }

    public void setUserNumber(int userNumber) { this.userNumber = userNumber; }
}
