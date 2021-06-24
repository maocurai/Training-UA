import java.util.Scanner;

public class Controller {

    public static final String FIRST_WORD = "Hello";
    public static final String SECOND_WORD = "world";

    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model  = model;
        this.view = view;
    }

    public void processUser(){
        Scanner sc = new Scanner(System.in);
        String firstWord, secondWord;
        do {
            firstWord = inputWordsWithScanner(sc);
            secondWord = inputWordsWithScanner(sc);
            if (firstWord.equals(FIRST_WORD) && secondWord.equals(SECOND_WORD)) {
                model.setPhrase(firstWord);
                model.addWordToPhrase(secondWord);
                view.printMessageAndPhrase(View.OUR_PHRASE, model.getPhrase());
                break;
            } else {
                view.printMessage(View.WRONG_INPUT_DATA);
            }
        } while (true);
    }

    public String inputWordsWithScanner(Scanner sc) {
        view.printMessage(View.INPUT_STRING_DATA);
        return sc.nextLine();
    }
}
