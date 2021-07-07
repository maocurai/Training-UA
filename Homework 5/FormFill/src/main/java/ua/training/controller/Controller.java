package ua.training.controller;

import ua.training.model.Model;
import ua.training.view.View;

import java.util.Scanner;

import static ua.training.controller.RegexContainer.*;
import static ua.training.view.TextConstant.*;

/**
 * Created by student on 04.07.2021.
 */
public class Controller {

    private Model model;
    private View view;

    /** input validation correctness field*/
    private boolean isValidInput = false;


    /**
     * Constructor - creating a new object with specific values
     * @param model
     * @param view
     */
    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    /**
     * Method for filling the fields of the record
     */
    public void addNote() {
        Scanner sc = new Scanner(System.in);
        String loc = (View.bundle.getLocale().getLanguage().equals("ua")) ? "UA" : "LAT";
        String regex = loc.equals("UA") ? REGEX_SURNAME_AND_NAME_UA : REGEX_SURNAME_AND_NAME_LAT;
        model.setSurname(enterField(sc, regex, INPUT_STRING_SURNAME));
        model.setSurname(enterField(sc, regex, INPUT_STRING_NAME));
        model.setNickname(enterField(sc, REGEX_NICKNAME, INPUT_STRING_NICKNAME));
        regex = loc.equals("UA") ? REGEX_PATRONYMIC_UA : REGEX_PATRONYMIC_LAT;
        model.setPatronymic(enterField(sc, regex, INPUT_STRING_PATRONYMIC));
        model.setMobilePhone(enterField(sc, REGEX_MOBILE_PHONE, INPUT_STRING_MOBILE_PHONE));
        model.setEmail(enterField(sc, REGEX_EMAIL, INPUT_STRING_EMAIL));
    }

    /**
     * Method for getting and validation user's input
     * @param sc Scanner object
     * @param regEx string pattern
     * @param message message for user
     * @return valid string input
     */
    public String enterField(Scanner sc, String regEx, String message) {
        String input = "";
        while (!isValidInput) {
            view.printMessageAndPhrase(INPUT_STRING_ENTER, message);
            input = inputWordsWithScanner(sc);
            isValidInput = checkInput(regEx, input);
            if(!isValidInput) view.printMessage(WRONG_INPUT_DATA);
        }
        isValidInput = false;
        return input;
    }

    /**
     * Method for validation user's input due to pattern
     * @param regEx string pattern
     * @param input user's input
     * @return boolean value
     */
    public boolean checkInput(String regEx, String input) {
        return input.matches(regEx);
    }

    /**
     * Method for entering a string from the console
     * @param sc Scanner object
     * @return user's input
     */
    public String inputWordsWithScanner(Scanner sc) {
        return sc.nextLine();
    }
}
