import java.util.Scanner;

/**
 * Created by student on 04.07.2021.
 */
public class Controller {

    private Model model;
    private View view;

    /** input validation correctness field*/
    private boolean isValidInput = false;

    private String surnameCheckRegEx = "[A-Z]([a-z]+([-][A-Z]([a-z])+)?)";
    private String nicknameCheckRegEx = "[a-zA-Z0-9_.]{1,30}";
    private String patronymicCheckRegEx = "[A-Z][a-z]+";
    private String mobilePhoneCheckRegEx = "^\\+\\d{2}\\(\\d{3}\\)\\d{3}-\\d{2}-\\d{2}$";
    private String emailCheckRegEx = "^([a-z0-9_-]+\\.)*[a-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*\\.[a-z]{2,6}$";

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
        model.setSurname(enterField(sc, surnameCheckRegEx, view.INPUT_STRING_SURNAME));
        model.setNickname(enterField(sc, nicknameCheckRegEx, view.INPUT_STRING_NICKNAME));
        model.setPatronymic(enterField(sc, patronymicCheckRegEx, view.INPUT_STRING_PATRONYMIC));
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
            view.printMessage(message);
            input = inputWordsWithScanner(sc);
            isValidInput = checkInput(regEx, input);
            if(!isValidInput) view.printMessage(view.WRONG_INPUT_DATA);
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
