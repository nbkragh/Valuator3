import java.util.ArrayList;
import java.util.HashMap;


public class Valuator {

    static final char[] hexChars = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private HashMap<Character,Integer> allowedChars;
    static protected volatile int input = 0;
    private int radix;
    protected String name;

    public Valuator(int r) {
        this.radix = r;
        this.name = "Radix "+r;
        this.allowedChars = new HashMap<>();
        for (int i = 0; i < r; i++) {
            this.allowedChars.put(hexChars[i],i );
        }
    }

    public boolean setInputValue(String string){
        int direction = 1;
        if (string.charAt(0) == '-'){
            string = string.substring(1);
            direction = -1;
        }
        string = string.toLowerCase();
        if(string.matches("^[0]++$")){
            this.input = 0;
        }
        char[] numberChars = string.toCharArray();
        char[] validatedNumbers = new char[numberChars.length];

        for (int i = 0; i < numberChars.length; i++) {
            if(allowedChars.containsKey(numberChars[i])){
                validatedNumbers[i] = numberChars[i];
            }else{
                return false;
            }
        }
        int account = 0;
        int factor = 1;
        for (int i = (validatedNumbers.length - 1); i >= 0; i--, factor *= radix) {
            account += direction*(allowedChars.get(validatedNumbers[i])) * factor;

            if ((direction>1 && account < 0)||(direction< 0 && account> 0)){
                return false;
            }
        }
        this.input = account;
        return true;
    }

    public String valueForRadix() {
        if (this.input == 0){
            return "0";
        }

        long value = this.input;
        if (this.input < 0) {
            value *= -1;
        }

        int cifer = 1;
        long log = radix;

        while(value > (log)-1){
            log *= radix;
            cifer++;
        }
        ArrayList<Integer> numbers = new ArrayList<>();

        for (int i = cifer; i > 0; i--){
            log /= radix;
            numbers.add((int)(value/log));
            value %= log;
        }
        String returnString = "";
        for (int i : numbers) {
            returnString += hexChars[i];
        }

        if (this.input < 0){
            returnString = "-"+returnString;
        }
        return returnString;
    }

    public long getInput() {
        return input;
    }
    public HashMap<Character,Integer> getAllowedChars() {
        return allowedChars;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public int getRadix(){
        return this.radix;
    }

}

