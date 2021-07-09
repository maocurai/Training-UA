package ua.training.view;

import java.util.Locale;
import java.util.ResourceBundle;

import static ua.training.view.TextConstant.INPUT_STRING_ENTER;

public class View {

    static String MESSAGES_BUNDLE_NAME = "messages";
    public static final ResourceBundle bundle =
            ResourceBundle.getBundle(
                    MESSAGES_BUNDLE_NAME,
                    new Locale("ua", "UA"));

    /**
     * Method to print message for user
     * @param message message for user
     */
    public void printMessage(String message){
        System.out.println(bundle.getString(message));
    }

    /**
     * Method to print message and additional phrase for user
     * @param message message for user
     * @param phrase additional phrase for user
     */
    public void printMessageAndPhrase(String message, String phrase){
        System.out.println(bundle.getString(message) + " " + bundle.getString(phrase));
    }

    public void printStringInput(String message) {
        printMessage(bundle.getString(INPUT_STRING_ENTER).concat(bundle.getString(message)));
    }
}

