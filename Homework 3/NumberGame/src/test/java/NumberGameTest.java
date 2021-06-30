import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class NumberGameTest {

    private static Model model;

    @BeforeClass
    public static void runT() {
        model = new Model();
        model.setSecretNumber(80);
    }

    @Test
    public void testCheckNumber() {
        double res = model.checkNumber(90);
        Assert.assertEquals(1, res, 0);
    }

    @Test
    public void testCompareNumbers() {
        double res = model.checkNumber(90);
        Assert.assertEquals(1, res, 0);
    }

    @Test
    public void testGetSecretNumber() {
        double res = model.getSecretNumber();
        Assert.assertEquals(80, res, 0);
    }

    @Test
    public void testGetUserNumberStatisticsSet() {
        Assert.assertNotNull(model.getUserNumberStatisticsSet());
    }

    @Test
    public void testIsGameOver() {
        Assert.assertFalse(model.isGameOver());
    }

    @Test
    public void testSetPrimaryBarrier() {
        model.setPrimaryBarrier(80, 90);
        Assert.assertEquals(80, model.getMin());
        Assert.assertEquals(90, model.getMax());
    }
}
