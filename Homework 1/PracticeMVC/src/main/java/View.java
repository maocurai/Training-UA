public class View {
    // Text's constants
    public static final String INPUT_STRING_DATA = "Enter word: ";
    public static final String WRONG_INPUT_DATA = "Wrong input! Repeat please! ";
    public static final String OUR_PHRASE = "Phrase:  ";

    public void printMessage(String message){
        System.out.println(message);
    }

    public void printMessageAndPhrase(String message, String phrase){
        System.out.println(message + phrase);
    }

}
