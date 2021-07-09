package ua.training.controller;

import ua.training.exceptions.LoginExistsException;
import ua.training.model.Note;
import ua.training.model.Notebook;
import ua.training.view.View;

import java.util.Scanner;

import static ua.training.controller.RegexContainer.*;
import static ua.training.view.TextConstant.*;

/**
 * Created by student on 04.07.2021.
 */
public class Controller {

    private Notebook notebook;
    private View view;

    /** input validation correctness field*/
    private boolean isValidInput = false;
//    private boolean isValid = false;


    /**
     * Constructor - creating a new object with specific values
     * @param notebook
     * @param view
     */
    public Controller(Notebook notebook, View view) {
        this.notebook = notebook;
        this.view = view;
    }

    /**
     * Method for filling the fields of the record
     */
    public void addNote() {
        Scanner sc = new Scanner(System.in);
        Note newNote = new Note();
        String loc = (View.bundle.getLocale().getLanguage().equals("ua")) ? "UA" : "LAT";
        String regex = loc.equals("UA") ? REGEX_SURNAME_AND_NAME_UA : REGEX_SURNAME_AND_NAME_LAT;
        newNote.setSurname(enterField(sc, regex, INPUT_STRING_SURNAME));
        newNote.setSurname(enterField(sc, regex, INPUT_STRING_NAME));
        newNote.setNickname(enterField(sc, REGEX_NICKNAME, INPUT_STRING_NICKNAME));
        regex = loc.equals("UA") ? REGEX_PATRONYMIC_UA : REGEX_PATRONYMIC_LAT;
        newNote.setPatronymic(enterField(sc, regex, INPUT_STRING_PATRONYMIC));
        newNote.setMobilePhone(enterField(sc, REGEX_MOBILE_PHONE, INPUT_STRING_MOBILE_PHONE));
        newNote.setEmail(enterField(sc, REGEX_EMAIL, INPUT_STRING_EMAIL));
        boolean isValidLogin = false;
        do {
            try {
                isValidLogin = notebook.add(newNote);
            } catch (LoginExistsException e) {
                e.printStackTrace();
                newNote.setNickname(enterField(sc, REGEX_NICKNAME, INPUT_STRING_NICKNAME));
            }
        } while (!isValidLogin);
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
