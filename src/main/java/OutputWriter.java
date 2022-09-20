public class OutputWriter {
    public void write(String text){
        System.out.println(text);
        writeInsert();
    }
    public void writeWelcome(){
        System.out.println("Welcome to FizzBuzz application!");
        System.out.println("Submit a number and get an answer or enter \"/help\" for more information!");
        writeInsert();
    }
    public void writeInsert(){
        System.out.print("Insert a number: ");
    }
    public void writeHelp(){
        System.out.println("This is a FizzBuzz console application. The input should be an integer without spaces. " +
                "Outputs Fizz if a multiple of 3 is passed, Buzz if a multiple of 5, and FizzBuzz if a multiple of both 3 and 5. " +
                "If the number is not a multiple of either 3 or 5, it outputs the number itself. " +
                "You can enter the command \"/quit\" to terminate the application");
        writeInsert();
    }
    public void writeGoodbye(){
        System.out.println("Bye bye");
    }
    public void writeErrorNotNumber(){
        System.out.println("What you entered is not an integer. Please enter a valid data");
        writeInsert();
    }
}
