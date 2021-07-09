package ua.training;

import ua.training.controller.Controller;
import ua.training.exceptions.LoginExistsException;
import ua.training.model.Note;
import ua.training.model.Notebook;
import ua.training.view.View;

public class Main {
    public static void main(String[] args) throws LoginExistsException {
        Notebook book = new Notebook();
        Controller controller = new Controller(book, new View());
        Note note1 = new Note();
        note1.setNickname("bigdick2002");
        Note note2 = new Note();
        note2.setNickname("bigdick0220");
        book.add(note1);
        book.add(note2);
        controller.addNote();
    }
}
