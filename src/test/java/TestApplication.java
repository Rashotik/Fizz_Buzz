import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

public class TestApplication {
    String insert = "\nInsert a number: ";
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
    public void testRun(){
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream("".getBytes()));
        FizzBuzzApplication.main(new String[0]);
        System.setIn(stdin);
        Assert.assertEquals(output.toString(), "Welcome to FizzBuzz application!\n" +
                "Submit a number and get an answer or enter \"/help\" for more information!\n" +
                "Insert a number: ");
    }
    @Test
    public void testFizz(){
        String outputText = "Fizz!" + insert;
        FizzBuzzApplication.processText("3");
        Assert.assertEquals(output.toString(), outputText);
        output.reset();
        FizzBuzzApplication.processText("9");
        Assert.assertEquals(output.toString(), outputText);
        output.reset();
        FizzBuzzApplication.processText("12");
        Assert.assertEquals(output.toString(), outputText);
    }
    @Test
    public void testBuzz(){
        String outputText = "Buzz!" + insert;
        FizzBuzzApplication.processText("5");
        Assert.assertEquals(output.toString(), outputText);
        output.reset();
        FizzBuzzApplication.processText("10");
        Assert.assertEquals(output.toString(), outputText);
        output.reset();
        FizzBuzzApplication.processText("50");
        Assert.assertEquals(output.toString(), outputText);
    }
    @Test
    public void testFizzBuzz(){
        String outputText = "FizzBuzz!" + insert;
        FizzBuzzApplication.processText("15");
        Assert.assertEquals(output.toString(), outputText);
        output.reset();
        FizzBuzzApplication.processText("30");
        Assert.assertEquals(output.toString(), outputText);
        output.reset();
        FizzBuzzApplication.processText("15000");
        Assert.assertEquals(output.toString(), outputText);
    }
    @Test
    public void testNotANumber(){
        String outputText = "What you entered is not an integer. Please enter a valid data" + insert;
        FizzBuzzApplication.processText("aw");
        Assert.assertEquals(output.toString(), outputText);
        output.reset();
        FizzBuzzApplication.processText("1 2");
        Assert.assertEquals(output.toString(), outputText);
        output.reset();
        FizzBuzzApplication.processText(" 1");
        Assert.assertEquals(output.toString(), outputText);
        output.reset();
        FizzBuzzApplication.processText(" ");
        Assert.assertEquals(output.toString(), outputText);
        output.reset();
        FizzBuzzApplication.processText("1-2");
        Assert.assertEquals(output.toString(), outputText);
    }
    @Test
    public void testHelp(){
        String outputTextHelp = "This is a FizzBuzz console application. The input should be an integer without spaces. " +
                "Outputs Fizz if a multiple of 3 is passed, Buzz if a multiple of 5, and FizzBuzz if a multiple of both 3 and 5. " +
                "If the number is not a multiple of either 3 or 5, it outputs the number itself. " +
                "You can enter the command \"/quit\" to terminate the application" + insert;
        String outputTextNotANumber = "What you entered is not an integer. Please enter a valid data" + insert;
        FizzBuzzApplication.processText("/help");
        Assert.assertEquals(output.toString(), outputTextHelp);
        output.reset();
        FizzBuzzApplication.processText("/ help");
        Assert.assertEquals(output.toString(), outputTextNotANumber);
        output.reset();
        FizzBuzzApplication.processText(" /help");
        Assert.assertEquals(output.toString(), outputTextNotANumber);
        output.reset();
        FizzBuzzApplication.processText("help");
        Assert.assertEquals(output.toString(), outputTextNotANumber);
        output.reset();
        FizzBuzzApplication.processText("/help ");
        Assert.assertEquals(output.toString(), outputTextNotANumber);
    }
    @Test
    public void testQuit(){
        String outputTextQuit = "Bye bye\n";
        String outputTextNotANumber = "What you entered is not an integer. Please enter a valid data" + insert;
        FizzBuzzApplication.processText("/quit");
        Assert.assertEquals(output.toString(), outputTextQuit);
        output.reset();
        FizzBuzzApplication.processText("/ quit");
        Assert.assertEquals(output.toString(), outputTextNotANumber);
        output.reset();
        FizzBuzzApplication.processText(" /quit");
        Assert.assertEquals(output.toString(), outputTextNotANumber);
        output.reset();
        FizzBuzzApplication.processText("quit");
        Assert.assertEquals(output.toString(), outputTextNotANumber);
        output.reset();
        FizzBuzzApplication.processText("/quit ");
        Assert.assertEquals(output.toString(), outputTextNotANumber);
    }
}