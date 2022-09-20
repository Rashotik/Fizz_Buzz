
import java.util.Scanner;

public class FizzBuzzApplication {
    private static final Checker checker = new Checker();
    private static final OutputWriter writer = new OutputWriter();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        writer.writeWelcome();

        while(scanner.hasNext()) {
            String str = scanner.nextLine();
            if(!processText(str))
                break;
        }

    }
    public static boolean processText(String str){
        if (checker.isNeedHelp(str)) {
            writer.writeHelp();
            return true;
        }
        if (checker.isQuit(str)) {
            writer.writeGoodbye();
            return false;
        }
        if(checker.isInteger(str)){
            int number = Integer.parseInt(str);
            if(checker.isFizzBuzz(number)){
                writer.write("FizzBuzz!");
                return true;
            }
            if(checker.isFizz(number)){
                writer.write("Fizz!");
                return true;
            }
            if(checker.isBuzz(number)){
                writer.write("Buzz!");
                return true;
            }
        } else {
            writer.writeErrorNotNumber();
            return true;
        }
        System.out.println(str);
        System.out.print("Insert a number: ");
        return true;
    }
}
