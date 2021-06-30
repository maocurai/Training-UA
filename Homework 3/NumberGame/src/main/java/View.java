public class View {

    public static final String START_MESSAGE = "Hello user, try to guess the number\n";
    public static final String GREATER_NUMBER = "\nYour number is greater\n";
    public static final String LESS_NUMBER = "\nYour number is less\n";
    public static final String GAME_OVER = "\nCongratulations! You won, game over!\n";
    public static final String NUMBER_RANGE = "\nNumber in range: ";
    public static final String ATTEMPTS = "Your attempts: ";
    public static final String WRONG_INPUT_INT_DATA = "Invalid input. Try again\n";
    public static final String ENTER_INPUT_INT_DATA = "Input number: ";

    public void printMessage (String message){
        System.out.print(message);
    }

    public void printMessageAndPhrase(String message, String phrase){
        System.out.println(message + phrase);
    }

    public void show(int result) {
        switch (result) {
            case 1:
                printMessage(GREATER_NUMBER);
                break;
            case -1:
                printMessage(LESS_NUMBER);
                break;
            case 0:
                printMessage(GAME_OVER);
                return;
        }
    }
}