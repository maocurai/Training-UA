import java.util.Scanner;

public class Controller {
    private Model model;
    private View view;


    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void startGame() {
        view.printMessage(view.START_MESSAGE);
        model.setPrimaryBarrier(GlobalConstants.PRIMARY_MIN_BARRIER,
                GlobalConstants.PRIMARY_MAX_BARRIER);
        model.setSecretNumber();
        Scanner sc = new Scanner(System.in);
        do {
            view.printMessageAndPhrase(view.NUMBER_RANGE, model.rangeToString());
            view.show(model.checkNumber(getUserNumber(sc)));
            view.printMessage(View.ATTEMPTS + String.valueOf(model.getUserNumberStatisticsSet()));
        } while (!model.isGameOver());
    }

    public boolean isInBoundaries(int userNumber) {
        return !(userNumber > model.getMax() || userNumber < model.getMin());
    }

    private int getUserNumber(Scanner sc) {
        int userNumber = 0;
        String input;
        boolean isValidInput = false;
        while(!isValidInput){
            view.printMessage(View.ENTER_INPUT_INT_DATA);
            input = sc.next();
            try{
                userNumber = Integer.parseInt(input);
                if(isInBoundaries(userNumber)) isValidInput = true;
            }catch(Exception e){
                view.printMessage(View.WRONG_INPUT_INT_DATA);
                isValidInput = false;
            }
        }
        return userNumber;
    }
}