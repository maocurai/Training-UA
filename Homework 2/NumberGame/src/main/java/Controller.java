import java.util.Scanner;

public class Controller {

    private View view;

    public static boolean isGameOver = false;

    public Controller() {}

    public void startGame(int min, int max) {
        view = new View();
        view.printMessage(view.START_MESSAGE);
        Repository.createModel(min, max);
        Repository.createStatistics();
        view.printMessageAndPhrase(view.NUMBER_RANGE, Repository.getModel().rangeToString());
        do {
            getUserNumber();
            view.show(checkNumber(Repository.getModel().getUserNumber()));
        } while (!isGameOver);
    }

    public Integer checkNumber(Integer userNumber) {
        Integer res = null;
        if(userNumber != null) {
            res = Repository.getModel().compareNumbers(userNumber);
            if (res == 0) {
                isGameOver = true;
            }
        }
        return res;
    }

    public void getUserNumber() {
        Scanner scanner = new Scanner(System.in);
        int userNumber = 0;
        String input;
        boolean isValidInput = false;
        while(!isValidInput){
            System.out.print("Input number: ");
            input = scanner.next();
            try{
                userNumber = Integer.parseInt(input);
                isValidInput = true;
            }catch(Exception e){
                System.out.println("Invalid input. Try again\n");
                isValidInput = false;
            }
        }
        Repository.get_statistics().add(userNumber);
        Repository.getModel().setUserNumber(userNumber);
    }
}
