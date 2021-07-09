import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import ua.training.controller.Controller;
import ua.training.model.Note;
import ua.training.model.Notebook;
import ua.training.view.View;

public class FormFillTest {

    private static Controller controller;
    private static Notebook notebook;
    private static Note note;

    @BeforeClass
    public static void runT() {
        note = new Note();
        notebook = new Notebook();
        controller = new Controller(notebook, new View());
    }

    @Test
    public void testCheckNumber() {
        note.setSurname("Smith");
        note.setSubscriberName("John");
        String res = note.getShortName();
        String expected = "Smith J.";
        Assert.assertTrue(expected.equals(res));
    }
}
