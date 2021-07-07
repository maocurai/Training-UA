import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import ua.training.controller.Controller;
import ua.training.model.Model;
import ua.training.view.View;

public class FormFillTest {

    private static Controller controller;
    private static Model model;

    @BeforeClass
    public static void runT() {
        model = new Model();
        controller = new Controller(model, new View());
    }

    @Test
    public void testCheckNumber() {
        model.setSurname("Smith");
        model.setSubscriberName("John");
        String res = model.getShortName();
        String expected = "Smith J.";
        Assert.assertTrue(expected.equals(res));
    }
}
