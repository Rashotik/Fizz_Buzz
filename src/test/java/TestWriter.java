import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

@RunWith(org.junit.runners.JUnit4.class)
public class TestWriter
{
    private final OutputWriter writer = new OutputWriter();
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(output));
    }
    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }

    @Test
    public void testErrorNotNumber() {
        writer.writeErrorNotNumber();
        assertEquals("What you entered is not an integer. Please enter a valid data\nInsert a number: ", output.toString());
    }

    @Test
    public void testWrite()
    {
        writer.write("Fizz!");
        writer.write("Buzz!");
        assertEquals("Fizz!\nInsert a number: Buzz!\nInsert a number: ", output.toString());
    }

    @Test
    public void testWriteWelcome()
    {
        writer.writeWelcome();
        assertEquals("Welcome to FizzBuzz application!\nSubmit a number and get an answer or enter \"/help\" for more information!\nInsert a number: ", output.toString());
    }

    @Test
    public void testWriteInsert()
    {
        writer.writeInsert();
        assertEquals("Insert a number: ", output.toString());
    }

    @Test
    public void testWriteHelp()
    {
        writer.writeHelp();
        assertEquals("This is a FizzBuzz console application. The input should be an integer without spaces. " +
                "Outputs Fizz if a multiple of 3 is passed, Buzz if a multiple of 5, and FizzBuzz if a multiple of both 3 and 5. " +
                "If the number is not a multiple of either 3 or 5, it outputs the number itself. " +
                "You can enter the command \"/quit\" to terminate the application\n" +
                "Insert a number: ", output.toString());
    }

}
