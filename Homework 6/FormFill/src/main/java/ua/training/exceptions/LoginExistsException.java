package ua.training.exceptions;

import ua.training.model.Note;

public class LoginExistsException extends Exception {
    Note incorrectNote;

    public LoginExistsException(String message, Note obj) {
        super(message);
        this.incorrectNote = obj;
    }

}
