import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(org.junit.runners.JUnit4.class)
public class TestChecker
{
    private final Checker checker = new Checker();

    @Test
    public void testBuzz() {
        assertTrue(checker.isBuzz(5));
        assertFalse(checker.isBuzz(3));
    }

    @Test
    public void testFizz() {
        assertTrue(checker.isFizz(3));
        assertFalse(checker.isFizz(5));
    }

    @Test
    public void testFizzBuzz() {
        assertTrue(checker.isFizzBuzz(15));
        assertFalse(checker.isFizzBuzz(3));
    }

    @Test
    public void testIsInteger() {
        assertTrue(checker.isInteger("15"));
        assertFalse(checker.isInteger("3 2"));
        assertFalse(checker.isInteger("3.2"));
        assertFalse(checker.isInteger("3 "));
        assertFalse(checker.isInteger("3 a"));
        assertFalse(checker.isInteger("dwa"));
        assertFalse(checker.isInteger("0x12"));
    }

    @Test
    public void testIsQuit() {
        assertTrue(checker.isQuit("/quit"));
        assertFalse(checker.isQuit("quit"));
    }

    @Test
    public void testIsHelp() {
        assertTrue(checker.isNeedHelp("/help"));
        assertFalse(checker.isNeedHelp("help"));
    }

}
