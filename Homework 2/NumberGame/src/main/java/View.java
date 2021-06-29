public class View {

    public static final String START_MESSAGE = "Hello user, try to guess the number\n";
    public static final String GREATER_NUMBER = "\nYour number is greater";
    public static final String LESS_NUMBER = "\nYour number is less";
    public static final String GAME_OVER = "\nCongratulations! You won, game over!\n";
    public static final String NUMBER_RANGE = "\nNumber in range: ";
    public static final String ATTEMPTS = "Your attempts: ";

    public void printMessage(String message){
        System.out.print(message);
    }

    public void printMessageAndPhrase(String message, String phrase){
        System.out.println(message + phrase);
    }

    public void show(Integer result) {
        if(result != null) {
            switch (result) {
                case 1:
                    printMessage(GREATER_NUMBER);
                    break;
                case -1:
                    printMessage(LESS_NUMBER);
                    break;
                case 0:
                    printMessage(GAME_OVER);
                    showTotalStatistics();
                    return;
            }
        }
        printMessageAndPhrase(NUMBER_RANGE, Repository.getModel().rangeToString());
        showAttempts();
    }

    public void showTotalStatistics() {
        System.out.println("Your statistics");
        showAttempts();
        System.out.println("Total attempts: " + Repository.get_statistics().getUserNumberStatisticsSet().size());
    }

    public void showAttempts() {
        if(!Repository.get_statistics().getUserNumberStatisticsSet().isEmpty()) {
            printMessage(ATTEMPTS);
            for(Integer userNum : Repository.get_statistics().getUserNumberStatisticsSet()) {
                System.out.print(userNum + " ");
            }
            System.out.println();
        }
    }
}