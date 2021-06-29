import org.junit.*;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;

import java.util.concurrent.ExecutionException;

public class TestArithmetics {

    private static Arithmetics a;

    @Rule
    public final ExpectedException exp = ExpectedException.none();

    @Rule
    public Timeout time = new Timeout(1000);

    @Test
    public void testDivException() {
        exp.expect(ArithmeticException.class);
        a.div(10, 0);
    }

    @BeforeClass
    public static void runT() {
        a = new Arithmetics();
    }

    @Test
    public void testAdd() {
        double res = a.add(3,7);
        Assert.assertEquals(10.0, res, 0);
    }

    @Test
    public void testMult() {
        double res = a.mult(3,7);
        Assert.assertEquals(21.0, res, 0);
    }

    @Test
    public void testN() {
        while (true){}
    }

    @Test
    public void testDiv() {
        double res = a.div(10,5);
        Assert.assertEquals(2.0, res, 0);
    }

    @Test(expected = Exception.class)
    public void testDivExeption() {
        a.div(10, 0);
    }

    @Ignore
    @Test
    public void testDeduct() {
        double res = a.deduct(3,7);
        Assert.assertEquals(-4.0, res, 0);
    }
}
