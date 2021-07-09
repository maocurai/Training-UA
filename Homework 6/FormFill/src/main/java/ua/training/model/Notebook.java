package ua.training.model;

import ua.training.exceptions.LoginExistsException;

import java.util.ArrayList;
import java.util.List;

public class Notebook {
    List<Note> allNotes = new ArrayList<Note>();

    public boolean add(Note newNote) throws LoginExistsException {
        for (Note note : allNotes) {
            if (note.getNickname().equals(newNote.getNickname())) {
                throw new LoginExistsException("This login is already taken", newNote);
            }
        }
        allNotes.add(newNote);
        return true;
    }

    public void showAllNotes() {
        for (Note note : allNotes) {
            System.out.println(note.toString());
        }
    }

    public List<Note> getAllNotes() {
        return allNotes;
    }
}

