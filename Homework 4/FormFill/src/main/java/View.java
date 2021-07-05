public class View {
    public static final String INPUT_STRING_SURNAME = "Enter surname: ";
    public static final String INPUT_STRING_NICKNAME = "Enter nickname: ";
    public static final String INPUT_STRING_PATRONYMIC = "Enter patronymic: ";
    public static final String INPUT_STRING_MOBILE_PHONE = "Enter mobile phone: ";
    public static final String WRONG_INPUT_DATA = "Wrong input! Repeat please! ";

    /**
     * Method to print message for user
     * @param message message for user
     */
    public void printMessage(String message){
        System.out.println(message);
    }

    /**
     * Method to print message and additional phrase for user
     * @param message message for user
     * @param phrase additional phrase for user
     */
    public void printMessageAndPhrase(String message, String phrase){
        System.out.println(message + phrase);
    }
}
