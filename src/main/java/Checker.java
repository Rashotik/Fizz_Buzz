public class Checker {
    public boolean isNeedHelp(String string){
        return string.equals("/help");
    }
    public boolean isQuit(String string){
        return string.equals("/quit");
    }
    public boolean isInteger(String string){
        try{
            Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e){
            return false;
        }
    }
    public boolean isFizz(int number){
        return number % 3 == 0;
    }
    public boolean isBuzz(int number){
        return number % 5 == 0;
    }
    public boolean isFizzBuzz(int number){
        return isFizz(number) && isBuzz(number);
    }
}
